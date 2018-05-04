// This is a generated file. Not intended for manual editing.
package com.farragofiction.ideaplugin.wordlist.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WordListListEntry extends PsiElement {

  @NotNull
  WordListIndent getIndent();

  @NotNull
  WordListListEntryTitle getListEntryTitle();

  @NotNull
  List<WordListVariant> getVariantList();

}
