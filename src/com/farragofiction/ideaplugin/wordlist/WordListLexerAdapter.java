package com.farragofiction.ideaplugin.wordlist;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class WordListLexerAdapter extends FlexAdapter {
    public WordListLexerAdapter() {
        super(new WordListLexer((Reader) null));
    }
}
