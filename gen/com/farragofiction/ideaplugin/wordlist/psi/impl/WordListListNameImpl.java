// This is a generated file. Not intended for manual editing.
package com.farragofiction.ideaplugin.wordlist.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.farragofiction.ideaplugin.wordlist.psi.WordListTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.farragofiction.ideaplugin.wordlist.psi.*;

public class WordListListNameImpl extends ASTWrapperPsiElement implements WordListListName {

  public WordListListNameImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WordListVisitor visitor) {
    visitor.visitListName(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WordListVisitor) accept((WordListVisitor)visitor);
    else super.accept(visitor);
  }

}
