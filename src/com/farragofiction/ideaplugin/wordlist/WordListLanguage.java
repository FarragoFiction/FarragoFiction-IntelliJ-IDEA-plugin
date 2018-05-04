package com.farragofiction.ideaplugin.wordlist;

import com.intellij.lang.Language;

public class WordListLanguage extends Language {
    public static final WordListLanguage INSTANCE = new WordListLanguage();

    private WordListLanguage() {
        super("TextEngineWordList");
    }
}
