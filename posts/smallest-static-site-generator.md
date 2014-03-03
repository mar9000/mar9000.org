title:The smallest static site generator
url:smallest-static-site-generator.html
date:2014-03-03 22:00
tags:code generation,RSS
abstract:Now that I can write posts in HTML and in Markdown what is missing to create the smallest
static web generator we can imagine?
...
content:
In fact this is only the first list of *missing features*, for example [Octopress](http://octopress.org) has
a beautiful syntax highlight, anyway... I asked to myself the minimum to be able to publish and organize
content and let people follow my blog if interesting. So:

  - my index page is almost empty, I'll publish here last posts abstract to drive the reader.
  - already with the index page I could write posts and readers find posts on the index. However minimum
    search capabilities can be implemented with tags even if they will become useful only with several posts.
  - Atom feed is the minimum to *keep in touch* with readers.

### Abstract on the index page

This will require for sure to order posts with respect to their date to publish only some of last published ones.
To do this I will collect posts metadata during posts processing. As you can imagine this will be used also
when we will implement the tags pages. The bootstrap construct used is the *description lists*.
I already had an index template I modified it and added a new composite attribute to the StringTemplate instance
used.

### Tags pages

While processing posts I collect data about posts into a `ArrayList` used by `Blog.createTagsPages()`.
A main page with all tags together with a page for each tag get created by the above method.

### Atom feed

Atom feed is created from the same data used for the main index page. When I searched for a library to
generate an `atom` file from Java the surprise was that there are not so much alternatives. Finally I have chosen
[ROME](https://github.com/rometools/rome) to do not chose the Apache alternative Abdera that seemed to me to have
more dependencies. The documentation is not that big nevertheless I found the example I was looking for.

At this point I also added [Font Awesome](http://fortawesome.github.io/Font-Awesome/) to add the feed symbol
on the navigation bar.

As a final note I have chosen to implement Atom instead of RSS because it's a newer format.
...
