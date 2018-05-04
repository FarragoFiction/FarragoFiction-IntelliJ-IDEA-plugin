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

CRLF=\R
INCLUDE="@"
DEFAULT="?"
WHITE_SPACE=[\ \n\t\f]
VALUE_CHARACTER=[^\n\f]
END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=\:\ ?
KEY_START_CHARACTER = [^@\?:\n\t\f\\]
KEY_CHARACTER=[^:\n\t\f\\]
//INDENT=\ {4}

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return WordListTypes.COMMENT; }

<YYINITIAL> {INCLUDE}                                       { yybegin(YYINITIAL); return WordListTypes.INCLUDE; }

<YYINITIAL> {DEFAULT}                                       { yybegin(YYINITIAL); return WordListTypes.DEFAULT; }

<YYINITIAL> {KEY_START_CHARACTER}{KEY_CHARACTER}*           { yybegin(YYINITIAL); return WordListTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return WordListTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {VALUE_CHARACTER}+                          { yybegin(YYINITIAL); return WordListTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }