title:New ECMAScript4MPS project
url:ecma-script-4-mps.html
date:2015-02-12 14:00
tags:MPS,ECMA Script,javascript
abstract:There are several strategies for code generation. The one used by [MPS](https://www.jetbrains.com/mps/)
could be called *no code generation* strategy. In fact the suggested implementation for code generation
is first to transform models in your language to models in the target language, or if you prefer first to transform
AST representation of your program into AST representation of target language. Then models from a real language,
for example Java, are translated to text. This means that only construct, like *if-then-else*, of language
that one can compile or execute, like Java, have a place where one say how to translate them to text,
in MPS called *TextGen* aspect.

MPS gives you for free a language called *baseLanguge* that transform seamlessly to Java.
Whereas one of my target languages is Javascript, so I created this new MPS language.
The new project is hosted on [github](https://github.com/mar9000/ecmascript4mps).
...
content:
I plan to write some more documentation in the future, but I want highlight few points here.

At first I started from the *grammar-like* specifications one can find on the [www.ecma-international.org](http://www.ecma-international.org/ecma-262/5.1/) site.
Probably it will be useful in the future to implement all lexer rules, still missing in this very first version.
But with MPS you implement AST models while grammars are more focused on parsing strategies.

Then I came to the [Mozilla Parser API](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/SpiderMonkey/Parser_API)
that in addition has real parser implementations like [Esprima](http://esprima.org/).
This was quite useful, in fact ECMAScript4MPS fully respect the AST documented by the Mozilla
documentation with few exceptions.

Many editing features are still missing and editing is at the moment more an *AST editing* than *text editing*.
However my goal is javascript generation so ECMAScript4MPS will be used for template definition,
here editing with *intentions* and less automatic *side transform* I think it's acceptable.
Said than lot of intentions and side transforms are still missing, stay tuned for next release.

Writing a developer's guide that could help other developers understanding MPS is also one of my goals.
...
