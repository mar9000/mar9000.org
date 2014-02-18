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

parser grammar BlogParser;
options { tokenVocab=BlogLexer; }

/* A post will have these fields in this order.   */
post: title url date tags dex content;

title: TITLE LINE END_ONE_LINE;
url: URL LINE END_ONE_LINE;
date: DATE LINE END_ONE_LINE;
tags: TAGS WORDS (COMMA WORDS)* NL;
dex: ABSTRACT chars END_MORE_LINES;
content: CONTENT chars END_MORE_LINES;
chars: CH*;
