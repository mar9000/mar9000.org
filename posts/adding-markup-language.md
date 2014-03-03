title:Adding a markup language
url:adding-a-markup-language.html
date:2014-03-02 00:00
tags:markup, markdown, jekyll, pelican
abstract:The previous post introduces a small language to define post files and in this
project you can find some java classes to transform them into a small blog, based on bootstrap.
The first improvement I see that was missing it's a markup language to speed up writing of posts.
I decide to investigate a bit on
*static site generators* like for example [Jekyll](http://jekyllrb.com), actually the one used by github.
...
content:
I started searching for *static site generator* or *static web framework* and I found among others:
[Jekyll](http://jekyllrb.com), [Pelican](http://blog.getpelican.com),
[Octopress](http://octopress.org), [Assemble](http://assemble.io/),
[Nanos](http://nanoc.ws),
[Wintersmith](http://wintersmith.io),
[Phrozn](http://phrozn.info/en/), [Cactus](https://github.com/koenbok/Cactus/),
[Hexo](http://zespia.tw/hexo/), [Genit](http://lkdjiin.github.io/genit/).  
One based on java is [JBake](http://jbake.org).  
There is a comprehensive list [here](http://staticgen.com/).

At this point I asked to myself what I would like to do in the future:
use a fully featured static site generator or continue to use my code. I decided for the ladder because
the blog itself is not my first goal, instead I would also to experiment with grammars and code generation.
So I looked at the above projects more as examples of files organization than projects to use in practice.
I will add feature one by one as soon as I will need something not yet implemented.

Write directly in HTML is time consuming, so the first thing to implement is the possibility to use
[Markdown](http://daringfireball.net/projects/markdown/) instead of plain HTML,
a list of implementations is maintained
[here](http://www.w3.org/community/markdown/wiki/MarkdownImplementations).

Between others [MarkdownPapers](http://markdown.tautua.org/index.html) use JavaCC,
and [PegDown](https://github.com/sirthias/pegdown) is derived from a PEG grammar.
I chose the ladder because of better documentation.

After adding some jars I was able to write my posts using *markdown*.
Now post files with extension `.md` are parsed as post but *abstract* and *content* are transformed with PegDown.  
This post is the first of this kind, check out `adding-markup-language.md` .  
This extension has also the side effect that posts written in markdown can be edited with syntax highlight
if opened with a specialized editor.

The java part had very few modifications, for example to process the *content* I just needed,
see the [Blog](https://github.com/mar9000/mar9000.org/blob/master/src/org/mar9000/blog/Blog.java) class:

    if (post.getName().endsWith(MARKDOWN)) {
        content = new PegDownProcessor().markdownToHtml(content);
    }
...
