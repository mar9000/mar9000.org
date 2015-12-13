title:A grammar for projectional editor
url:a-grammar-for-projectional-editor.html
date:2015-12-13 14:00
tags:DSL, MPS, projectional editor
abstract:Describing a language editor can be repetitive, for instance when you have to define expressions.
`expression '+' expression` and `expression '*' expression` is a typical example.
From the grammar file that describes the language structure it's possible to recognize repetitive
rule structures and build an editor in a consistent way.

The [PE](https://github.com/mar9000/pe "PE project") project defines a grammar and generates AST in a way not related
to any projectional editor. [PE4MPS](https://github.com/mar9000/pe4mps "PE4MPS project") project imports the
generated ASTs into [MPS](http://www.jetbrains.com/mps "MPS project") generating for example from this rule:

    Graph:
      strict=STRICT? type=GraphType name=string?
      statementList<indentList('{', '}')>=Statement*
    ;

this MPS editor:

![Graph editor example](/images/graph-editor-example.png)
...
content:
The defined list of indented statement can be utilized also in:

    Subgraph:
      (SUBGRAPH label=Id?)?
      statementList<indentList('{', '}')>=Statement*
    ;

giving:

![Subgraph editor example](/images/subgraph-editor-example.png)

The last example for this small introduction are optional group of elements like:

    NodeId:
      id=Id (':' first=Id (':' second=Id)?)?
    ;

translated in MPS into two intentions:

![NodeId editor example](/images/nodeid-editor-example.png)

The two mentioned project are still at their very first version and many features are still missing,
probably the most important one is scopes handling.
...
