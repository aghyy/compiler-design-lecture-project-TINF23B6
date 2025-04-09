package com.auberer.compilerdesignlectureproject.lexer;

public enum TokenType {
  TOK_INVALID,
  TOK_STRING_LIT,

  TOK_IDENTIFIER,
  TOK_INTEGER_LIT,
  TOK_DOUBLE_LIT,
  TOK_KEYWORD,

  TOK_EOF,
}
