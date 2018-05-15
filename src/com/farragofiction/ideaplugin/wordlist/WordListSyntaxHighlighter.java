package com.farragofiction.ideaplugin.wordlist;

import com.farragofiction.ideaplugin.wordlist.psi.WordListTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class WordListSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    // SYMBOLS #################################################
    
    // separators
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("WORDLIST_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    // include
    public static final TextAttributesKey INCLUDE = createTextAttributesKey("WORDLIST_INCLUDE", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] INCLUDE_KEYS = new TextAttributesKey[]{INCLUDE};
    // default
    public static final TextAttributesKey DEFAULT = createTextAttributesKey("WORDLIST_DEFAULT", DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);
    private static final TextAttributesKey[] DEFAULT_KEYS = new TextAttributesKey[]{DEFAULT};

    // HEADERS #################################################

    // header
    public static final TextAttributesKey HEADER = createTextAttributesKey("WORDLIST_HEADER", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] HEADER_KEYS = new TextAttributesKey[]{HEADER};
    // list names
    public static final TextAttributesKey LISTNAME = createTextAttributesKey("WORDLIST_LISTNAME", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] LISTNAME_KEYS = new TextAttributesKey[]{LISTNAME};

    // OTHER #################################################

    // text value
    public static final TextAttributesKey TEXTVALUE = createTextAttributesKey("WORDLIST_TEXTVALUE", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey[] TEXTVALUE_KEYS = new TextAttributesKey[]{TEXTVALUE};

    // comment
    public static final TextAttributesKey COMMENT = createTextAttributesKey("WORDLIST_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};

    // bad character
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("WORDLIST_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new WordListLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(WordListTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(WordListTypes.INCLUDE)) {
            return INCLUDE_KEYS;
        } else if (tokenType.equals(WordListTypes.DEFAULT)) {
            return DEFAULT_KEYS;

        } else if (tokenType.equals(WordListTypes.HEADER)) {
            return HEADER_KEYS;
        } else if (tokenType.equals(WordListTypes.LISTNAME)) {
            return LISTNAME_KEYS;

        } else if (tokenType.equals(WordListTypes.KEY)) {
            return TEXTVALUE_KEYS;
        } else if (tokenType.equals(WordListTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;

        } else {
            return EMPTY_KEYS;
        }
    }
}
