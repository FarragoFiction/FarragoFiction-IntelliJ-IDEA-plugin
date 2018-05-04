package com.farragofiction.ideaplugin.wordlist;

import com.farragofiction.ideaplugin.PluginIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WordListFileType extends LanguageFileType {
    public static final WordListFileType INSTANCE = new WordListFileType();

    private WordListFileType() {
        super(WordListLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "TextEngine Word List";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Source word list for the FarragoFiction TextEngine";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "words";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PluginIcons.WORDLIST;
    }
}
