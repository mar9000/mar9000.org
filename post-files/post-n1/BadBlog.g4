grammar BadBlog;
post: title url date tags content;

title: 'title:' LINE;
url: 'url:' LINE;
date: 'date:' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT NL;
tags: 'tags:' WORDS? (',' WORDS)? '\n';
content: 'content:' .*;

DIGIT: [0-9];
WORDS: ([a-zA-Z0-9] | ' ')+;
LINE: ~[\r\n]* NL;
NL: '\r'? '\n';
