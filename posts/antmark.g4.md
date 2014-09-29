title:ANTLR4 grammar for Markdown
url:antmark.g4.html
date:2014-09-01 00:00
tags:antlr, markdown, peg
abstract:[Markdown](http://daringfireball.net/projects/markdown/) is today used in several place including this blog.  
[ANTLR](http://www.antlr.org) is also used, almost, everywhere where you need a parser.  
So to learn ANTLR I have chosen to try teach ANTLR how to parse Markdown syntax. This task has been much more hard then I expected.
...
content:
The result has been published as the [ANTMark](https://github.com/mar9000/antmark/) project.

The main problem is that everything is context sensitive, including newlines.

The hardest thing to parse were ordered and unordered lists. Here there is another problem: there is not reference syntax definition
for Markdown a different implementations parse nested ordered or unordered list differently.

To force ANTLR to parse Markdown the result as not as fast as I expected, I mean it's pretty slow and I had to break long test cases
in smaller one otherwise the parsing never ends.

State of the art
----------------

Under `tests` you can find 143 tests that can be executed with the `MarkdownTest` class.  
There are some homemade tests, almost all the Markdown default tests (version 1.0.2), and all tests of the [markdown-testsuite](https://github.com/karlcow/markdown-testsuite/).  
Due to the problem highlighted below the project is at the moment only an exercise of style.

Main problems
-------------

I don't know with other parsing engines, but with ANTLR4 I spent lot of time parsing lists. The main problem
with ANTLR4 is probably that one would have a stopping rule for rules such as ``(...)*?`` that forces the parser
to stop to consume tokens.  
ANTLR4 stops to consume token depending on what follow the example rule above, but this in my grammar was not enough.

So I used semantic predicates, but the parser **is very very slow**, it's not able to parse a file that contains
more than 2 lists, I also tried to inspect the generated DSA but it was for me out of reach.  
Adding more lists causes that the parsing never ends. I hope this will have some interest for the ANTLR gurus.

Use cases
---------

After you have cloned the project, import it into eclipse, than you can:

  * compile the `MarkdownLexer.g4` grammar with *compile-lexer* run/debug configuration.
  * compile the `MarkdownParser.g4` grammar with *compile-parser* run/debug configuration.
  * open the class `MarkdownTest` and *Run As -> JUnit Test* from the right click menu.

Future directions
-----------------

**Use a *scanner less* gramar**: unfortunately almost at the end of my work I realized that the lexer was not doing that much so a *scanner less* grammar could be probably adopted easily. In addition the semantic predicates I wrote all of them act inspecting the token stream. In a *scanner less* scenario should be easier to inspect a `CharStream`.

**Parser modularization**: in case no global solution exists to build a real parser for the whole language, one could try to
first build a parser for the block structure of Markdown, for example identifying first lists, verbatim, heading..., than parse each block content to parser emph, strong, links and all the other span elements.  
I already used this approach for blockquotes: here on each line the starting tokens `> ` are removed and the result is passed to
an new instance of the parser. Probably some fixes are required in case of presence of *reference links* into the blockquote.

Support/discussions
-------------------

Because the project is just started I think a generic group for discussions and comments is enough: <https://groups.google.com/forum/#!forum/antmark-discussion>.
...
