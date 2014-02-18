grammar FirstBlog;

post: TITLE URL DATE TAGS CONTENT;

TITLE: 'title:' .*? NL;
URL: 'url:' .*? NL;
DATE: 'date:' .*? NL;
TAGS: 'tags:' .*? NL;
CONTENT: 'content:' .*? NL '...' NL;

NL : '\r'? '\n';
