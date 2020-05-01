/**
 * This file is part of mar9000's blog.
 * 
 * mar9000's blog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * mar9000's blog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with mar9000's blog.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2011-2014 Marco LOMBARDO.
 */
 
lexer grammar BlogLexer;

TITLE: 'title:' -> mode(ONE_LINE);
URL: 'url:' -> mode(ONE_LINE);
DATE: 'date:' -> mode(ONE_LINE);
TAGS: 'tags:';
ABSTRACT: 'abstract:' -> mode(MORE_LINES);
CONTENT: 'content:' -> mode(MORE_LINES);
WORDS: ([a-zA-Z0-9] | ' ')+;
COMMA: ',';
NL: '\r'? '\n';

mode ONE_LINE;
END_ONE_LINE: NL -> mode(DEFAULT_MODE);
LINE: ~[\n\r]+ ;

mode MORE_LINES;
END_MORE_LINES: NL '...' NL -> mode(DEFAULT_MODE);
CH: . ;
