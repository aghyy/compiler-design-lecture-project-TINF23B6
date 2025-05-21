package com.auberer.compilerdesignlectureproject.ast;

import com.auberer.compilerdesignlectureproject.lexer.TokenType;
import com.auberer.compilerdesignlectureproject.sema.SymbolTableEntry;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ASTCaseStmtNode extends ASTNode {

  private SymbolTableEntry currentSymbol;

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visitCaseStmt(this);
  }

  public static Set<TokenType> getSelectionSet() {
    Set<TokenType> selectionSet = new HashSet<>();
    selectionSet.add(TokenType.TOK_CASE);
    return selectionSet;
  }

  public ASTCaseStmtNode getBody() {
    return getChild(ASTCaseStmtNode.class, 0);
  }

  public ASTTernaryExprNode getRhs() {
    return getChild(ASTTernaryExprNode.class, 0);
  }
}
