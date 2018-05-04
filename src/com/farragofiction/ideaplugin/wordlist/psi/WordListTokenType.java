package com.farragofiction.ideaplugin.wordlist.psi;

import com.farragofiction.ideaplugin.wordlist.WordListLanguage;
import com.intellij.psi.tree.IElementType;

public class WordListTokenType extends IElementType {
    public WordListTokenType(String debugName) {
        super(debugName, WordListLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "WordListTokenType." + super.toString();
    }
}
