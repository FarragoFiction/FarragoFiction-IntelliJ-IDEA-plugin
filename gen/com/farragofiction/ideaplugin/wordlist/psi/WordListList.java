// This is a generated file. Not intended for manual editing.
package com.farragofiction.ideaplugin.wordlist.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WordListList extends PsiElement {

  @NotNull
  List<WordListListDefault> getListDefaultList();

  @NotNull
  List<WordListListEntry> getListEntryList();

  @NotNull
  List<WordListListInclude> getListIncludeList();

  @NotNull
  WordListListName getListName();

}
