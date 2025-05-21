package com.auberer.compilerdesignlectureproject.ast;

import com.auberer.compilerdesignlectureproject.lexer.TokenType;
import com.auberer.compilerdesignlectureproject.sema.SymbolTableEntry;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ASTSwitchCaseStmtNode extends ASTNode {

    private SymbolTableEntry currentSymbol;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitSwitchCaseStmt(this);
    }

    public static Set<TokenType> getSelectionSet() {
        Set<TokenType> selectionSet = new HashSet<>();
        selectionSet.add(TokenType.TOK_SWITCH);
        return selectionSet;
    }

    public ASTTernaryExprNode getCondition() {
        return getChild(ASTTernaryExprNode.class, 0);
    }

    public List<ASTCaseStmtNode> getCaseBlocks() {
        return getChildren(ASTCaseStmtNode.class);
    }

    public ASTDefaultStmtNode getDefaultBlock() {
        return getChild(ASTDefaultStmtNode.class, 0);
    }

    public ASTTernaryExprNode getRhs() {
        return getChild(ASTTernaryExprNode.class, 0);
    }
}
