package pl.domi.calculatortask.app.tokenizer.kind;

public sealed interface Token permits NumericToken, OperationToken {

  TokenKind kind();

  default boolean isNumber() {
    return kind() == TokenKind.NUMBER;
  }

  default boolean isOperator() {
    return kind() == TokenKind.OPERATOR;
  }

}
