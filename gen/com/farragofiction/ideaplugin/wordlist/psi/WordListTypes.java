// This is a generated file. Not intended for manual editing.
package com.farragofiction.ideaplugin.wordlist.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.farragofiction.ideaplugin.wordlist.psi.impl.*;

public interface WordListTypes {

  IElementType FILE_DEFAULT = new WordListElementType("FILE_DEFAULT");
  IElementType FILE_INCLUDE = new WordListElementType("FILE_INCLUDE");
  IElementType HEADER = new WordListElementType("HEADER");
  IElementType INDENT = new WordListElementType("INDENT");
  IElementType LIST = new WordListElementType("LIST");
  IElementType LIST_DEFAULT = new WordListElementType("LIST_DEFAULT");
  IElementType LIST_ENTRY = new WordListElementType("LIST_ENTRY");
  IElementType LIST_ENTRY_TITLE = new WordListElementType("LIST_ENTRY_TITLE");
  IElementType LIST_INCLUDE = new WordListElementType("LIST_INCLUDE");
  IElementType LIST_NAME = new WordListElementType("LIST_NAME");
  IElementType PROPERTY = new WordListElementType("PROPERTY");
  IElementType VARIANT = new WordListElementType("VARIANT");

  IElementType COMMENT = new WordListTokenType("COMMENT");
  IElementType CRLF = new WordListTokenType("CRLF");
  IElementType DEFAULT = new WordListTokenType("DEFAULT");
  IElementType INCLUDE = new WordListTokenType("INCLUDE");
  IElementType KEY = new WordListTokenType("KEY");
  IElementType SEPARATOR = new WordListTokenType("SEPARATOR");
  IElementType VALUE = new WordListTokenType("value");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == FILE_DEFAULT) {
        return new WordListFileDefaultImpl(node);
      }
      else if (type == FILE_INCLUDE) {
        return new WordListFileIncludeImpl(node);
      }
      else if (type == HEADER) {
        return new WordListHeaderImpl(node);
      }
      else if (type == INDENT) {
        return new WordListIndentImpl(node);
      }
      else if (type == LIST) {
        return new WordListListImpl(node);
      }
      else if (type == LIST_DEFAULT) {
        return new WordListListDefaultImpl(node);
      }
      else if (type == LIST_ENTRY) {
        return new WordListListEntryImpl(node);
      }
      else if (type == LIST_ENTRY_TITLE) {
        return new WordListListEntryTitleImpl(node);
      }
      else if (type == LIST_INCLUDE) {
        return new WordListListIncludeImpl(node);
      }
      else if (type == LIST_NAME) {
        return new WordListListNameImpl(node);
      }
      else if (type == PROPERTY) {
        return new WordListPropertyImpl(node);
      }
      else if (type == VARIANT) {
        return new WordListVariantImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
