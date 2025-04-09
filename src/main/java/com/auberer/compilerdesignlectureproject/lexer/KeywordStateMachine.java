package com.auberer.compilerdesignlectureproject.lexer;

import com.auberer.compilerdesignlectureproject.lexer.statemachine.StateMachine;

public class KeywordStateMachine extends StateMachine {
  private TokenType tokenType;

  public KeywordStateMachine(String keyword, TokenType tokenType) {

  }

  @Override
  public void init() {

  }

  @Override
  public TokenType getTokenType() {
    return tokenType;
  }
}
