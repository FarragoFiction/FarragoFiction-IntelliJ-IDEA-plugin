package com.farragofiction.ideaplugin.wordlist.psi;

import com.farragofiction.ideaplugin.wordlist.WordListLanguage;
import com.intellij.psi.tree.IElementType;

public class WordListElementType extends IElementType {
    public WordListElementType(String debugName) {
        super(debugName, WordListLanguage.INSTANCE);
    }
}
