title:Efficient DTOs
url:efficient-DTOs.html
date:2020-10-08 00:00
tags:DDD, UI, GraphQL
abstract:When we need to return data to be displayed on the UI as [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)s
we are going to read from multiple repositories unless for trivial UI. For example forum posts can have author (a user) and comments.
Comments can have author too.

    {
      posts: [{
        title: "Efficent DTO",
        author: {
          name: "Marco"
        },
        comments: [{
          author: {
            ...
    }

In this context, no matter the technology we are going to use, the N+1 problem will pop up. For instance with:

  * ReST API: we execute a request for the list of posts then N requests for the User resources.
  * ReST API + hint, like `/posts?with=user`: now we have only one ReST request but probably on the server users
  are loaded one by one from their repository.
  * GraphQL: without data loaders you still have the same problem, the user of a post is resolved for each post.

The last example is not accidentally: when I faced this problem I thought at first to resort to GraphQL and this is why my idea comes from it.
However I did not have dynamic queries but static ones, read "several endpoints that return always the same JSON", hence I did not want to adopt en engine to parse, for a given endpoint, the same query over and over again.

I found that what I needed were batched loaders and *data loaders*, something that every GraphQL implementation have as associated library. In our example for every post DTO resolution the load of the user is delayed until
we have the complete list of the users to load (same for comments and users of comments) so we can batch load users.  
Other sulutions, illustrated below, do not scale, at least in my use cases.  
The library that implements the above algorithm, without GraphQL, is [graph-loader](https://github.com/mar9000/graph-loader).
...
content:
Context
-------

So we have implemented boundary, repositories, application and domain services and we have to return data to display the UI.
Unless for trivial UI the ReST paradigm won't work. We will have to request posts then users, them probably comments, etc:

    /posts
    /posts/1/user
    /posts/2/user
    ...

Let's try ReST plus some hints like `with=users,comments` to extend our response content. Now how are we going to implement this request on the backend?
We load a list of posts then for each post we load its user?  
This will yield the N+1 problem right?
No problem we can collect the list of the users for all posts and load them in a batch, same algoritm used by GraphLoder (GL) but implemented manually. So far so good.

Problem
-------

What about loading also comment users or user's country to show a flag icon? Once you have loaded all users you have to collect, manually, all countries of all users to
batch the load of countries. So far we have only named three repositories but for rich UI it's common the case to load from ten different repositories, 
an optimized loading logic become quickly cumbersome.

One of my assumptions is that my queries are static, one endpoint should
resolve a small set of DTO shapes but a query language is not required.
The solution, batch loads, is one of the possibile solutions and actually the one that we are going to explore. But doing it manually would be a nightmare.

At this point I evaluated GraphQL. I liked its typed API but AFAIK (I've deeply explored its source code) the entry point to execute the resolvers and data loaders one has configured, is only by a GraphQL query. Indeed one endpoint, binded to a given GraphQL query, would execute the same query over and over again to compose its response.

Trying to avoid this overhead, while at the same time construct a typed API, led me to GraphLoader.

Solution
--------

For the solution space the scheme of our API is as follows:

  * we have a type used as key, one of them indicated generically as `K`.  
  Every lader has its own key so if needed we can have a set of types `K`.  
  I have one and its `Integer`.
  * a certain `Repository<V>` of a type `V` can batch loads a list a `V` given a list of keys of type `K`.  
  For example a repository that load a set of `Integer` into a set of `Post`.
  * our response is composed out of a set of types, each one having one or more assembler, for example an `Assembler<V,D>` to transform a value `V` into a DTO `D`.  
  These assmble for example `Post` into `PostDTO` another into `DetailedPostDTO`.
  * assemblers can queue more loads once they receive their own value `V` using its properties as key values.

For instance:

    loadPosts
      - for each post
        - queue the load of its author
        - queue the load of its comments
      while (there are pending loads)
      - execute pending loads
        (this pass each loaded V to the assembler
           -> assembler eventually queues other loads)

![resolution flow](/images/resolution-flow.png)

A call to `GraphLoader.resolve()` looks like:

    GlResult<PostResource> result = graphLoader.resolve(1L, "postLoader", new PostResourceAssembler());

The first phase *load* is not mandatory, when we have a value with an associated assembler we can execute only the transformation of `V` into `D`. For this reason GL has *resolve* methods for keys and for values, take a looke at `resolve()` and `resolveValue()` as starting point. When we have already a Post for example:

    GlResult<PostResource> result = graphLoader.resolveValue(post, new PostResourceAssembler());

There are also 2 methods to work with lists of keys or lists of values, see `resolveMany(List<K> keys, ...)` and `resolveValues(List<V> values, ...)`.

Implementation
--------------

The key point is that loaders method `load()` does not return values `V` but instead accepts a consumer of `V` to handle the result once a given key gets loaded and the resulting `V` is ready.

Consider for instance the resolution of post's author presents into the `PostResourceAssembler`:

    PostResource resource = new PostResource();
    authorLoader.load(post.authorId,
                      user -> resource.author =
                          authorAssembler.assemble(user, context));

Performance
-----------

The benchmark is very simple at the moment, but data are promising:

    Benchmark                                       Mode  Cnt      Score   Units
    GLBenchmark.glAvgTime                           avgt   3       1.212   us/op
    GLBenchmark.glAvgTime:·gc.alloc.rate.norm       avgt   3    2728.000   B/op
    GraphQLJava.graphqlAvgTime                      avgt   3      94.926   us/op
    GraphQLJava.graphqlAvgTime:·gc.alloc.rate.norm  avgt   3  162968.507   B/op

Said that, I'll do a much more complex graph resolution/query as soon as possible, I mean a query that returns 100 rows and uses 10 repositories.

Additional considerations
-------------------------

Only in case we have SQL repositories (as the ones I had) is tempting to try:

**More complex query**: for instance specialized repository for Post that joins also the table for author. One-to-one associations are reletively simple to load this way, nevertheless how many tables are we going to join when the UI gets richer? Moreover load associations with a *many* end, for instance comments, quickly become complicated. Not to mention loading associations of associations.

**JPA entity graph**: if it's always an option, read "they are reachable from the same aggregate", e.g. from `Post` you can reach author (`User`) and `Comments` and comment's author, it probably means you have defined too big aggregates.

The algoritm used by GL is in my opinion the best trade-off in case of static *DTO queries* that suggests to do not use GraphQL. Moreover if one decides to migrate to GraphQL later on, most of the classes defined to work with GL can be reused. Repositories and batch loaders can be used almost without modifications.

Conclusion
----------

GraphQL and `java-dataloader` are great projects when you don't know the queries your clients are going to send.
GitHub for instance move to GraphQL with version 4 of the their API. `graphql-java` supports CompletableFuture and is highly configurable.
But if you have only one front-end speaking with your back-end I think that graph-loader, or at least the idea behind `graph-loader`, 
is simpler, smaller, faster and one can be up and running with a small effort.
...
