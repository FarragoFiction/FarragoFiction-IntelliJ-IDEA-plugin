package com.farragofiction.ideaplugin.wordlist.psi;

import com.farragofiction.ideaplugin.wordlist.WordListFileType;
import com.farragofiction.ideaplugin.wordlist.WordListLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WordListFile extends PsiFileBase {
    public WordListFile(FileViewProvider viewProvider) {
        super(viewProvider, WordListLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return WordListFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "TextEngine WordList File";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
