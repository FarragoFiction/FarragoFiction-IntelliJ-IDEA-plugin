package com.farragofiction.ideaplugin.wordlist;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.farragofiction.ideaplugin.wordlist.psi.WordListTypes;
import com.intellij.psi.TokenType;

%%

%class WordListLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

HEADER="TextEngine Word List"
CRLF=\R
INCLUDE=@
DEFAULT=\?
WHITE_SPACE=[\ \n\t\f]

END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=\:\ ?

KEY_START_CHARACTER = [^@\?:\n\t\f\\\/]
KEY_CHARACTER=[^:\n\t\f\\\/]
KEY_CHARACTER_NOSPACE=[^\ :\n\t\f\\\/]

NUMBER=\d+(\.\d+)?

LISTNAME = [^\ @\?:\n\t\f\\\/]+
INDENT=(\ ){4}
NOTINDENT=(\ ){0,3}

KEY = {KEY_START_CHARACTER}{KEY_CHARACTER}+
KEY_NOSPACE = {KEY_START_CHARACTER}{KEY_CHARACTER_NOSPACE}+

%state BODY

%state BODY_VALUE
%state LISTBODY_VALUE
%state SUBLISTBODY_VALUE

%state INCLUDE
%state DEFAULT
%state LISTINCLUDE
%state LISTDEFAULT

%state LISTBODY
%state LISTITEM

%state SUBLISTBODY
%state SUBLIST

%%

<YYINITIAL> {HEADER}                                        {yybegin(BODY); return WordListTypes.HEADER;}

<BODY> {
    {END_OF_LINE_COMMENT}                                   { yybegin(BODY); return WordListTypes.COMMENT; }
    {INCLUDE}                                               { yybegin(INCLUDE); return WordListTypes.INCLUDE; }
    {DEFAULT}                                               { yybegin(DEFAULT); return WordListTypes.DEFAULT; }
}

<INCLUDE> {
    {KEY}                                                   { yybegin(BODY); return WordListTypes.FILENAME; }
}

<DEFAULT> {
    {KEY}                                                   { yybegin(DEFAULT); return WordListTypes.KEY; }
    {SEPARATOR}                                             { yybegin(BODY_VALUE); return WordListTypes.SEPARATOR; }
}

<LISTINCLUDE> {
    {LISTNAME}                                              { yybegin(LISTINCLUDE); return WordListTypes.LISTNAME; }
    {SEPARATOR}                                             { yybegin(LISTBODY_VALUE); return WordListTypes.SEPARATOR; }
    {CRLF}+                                                 { yybegin(LISTBODY); return TokenType.WHITE_SPACE; }
}

<LISTDEFAULT> {
    {KEY}                                                   { yybegin(LISTDEFAULT); return WordListTypes.KEY; }
    {SEPARATOR}                                             { yybegin(LISTBODY_VALUE); return WordListTypes.SEPARATOR; }
}

<BODY, LISTBODY, SUBLISTBODY> {LISTNAME}                    { yybegin(LISTBODY); return WordListTypes.LISTNAME; }

<LISTBODY, LISTITEM> {END_OF_LINE_COMMENT}                  { yybegin(LISTBODY); return WordListTypes.COMMENT; }

<LISTBODY> {
    {INDENT}                                                { yybegin(LISTITEM); return WordListTypes.INDENT; }
    {CRLF}+                                                 { yybegin(LISTBODY); return TokenType.WHITE_SPACE; }
}

<LISTITEM> {
    {INCLUDE}                                               { yybegin(LISTINCLUDE); return WordListTypes.INCLUDE;}
    {DEFAULT}                                               { yybegin(LISTDEFAULT); return WordListTypes.DEFAULT;}
    {KEY}                                                   { yybegin(LISTITEM); return WordListTypes.KEY; }
    {SEPARATOR}                                             { yybegin(LISTBODY_VALUE); return WordListTypes.SEPARATOR; }
    {CRLF}+                                                 { yybegin(LISTBODY); return TokenType.WHITE_SPACE; }
}

<BODY_VALUE> {
    {CRLF}({CRLF}|{WHITE_SPACE})+                           { yybegin(BODY); return TokenType.WHITE_SPACE; }
    {WHITE_SPACE}+                                          { yybegin(BODY_VALUE); return TokenType.WHITE_SPACE; }
    {KEY_START_CHARACTER}{KEY_CHARACTER}*                   { yybegin(BODY); return WordListTypes.VALUE; }
    {CRLF}+                                                 { yybegin(BODY); return TokenType.WHITE_SPACE; }
}

<LISTBODY_VALUE> {
    {CRLF}({CRLF}|{WHITE_SPACE})+                           { yybegin(LISTBODY); return TokenType.WHITE_SPACE; }
    {WHITE_SPACE}+                                          { yybegin(LISTBODY_VALUE); return TokenType.WHITE_SPACE; }
    {KEY_START_CHARACTER}{KEY_CHARACTER}*                   { yybegin(LISTBODY); return WordListTypes.VALUE; }
    {CRLF}+                                                 { yybegin(LISTBODY); return TokenType.WHITE_SPACE; }
}

<SUBLISTBODY_VALUE> {
    {CRLF}({CRLF}|{WHITE_SPACE})+                           { yybegin(SUBLISTBODY); return TokenType.WHITE_SPACE; }
    {WHITE_SPACE}+                                          { yybegin(SUBLISTBODY_VALUE); return TokenType.WHITE_SPACE; }
    {KEY_START_CHARACTER}{KEY_CHARACTER}*                   { yybegin(SUBLISTBODY); return WordListTypes.VALUE; }
    {CRLF}+                                                 { yybegin(SUBLISTBODY); return TokenType.WHITE_SPACE; }
}

<BODY> ({CRLF}|{WHITE_SPACE})+                              { yybegin(BODY); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }