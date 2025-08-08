package pl.domi.calculatortask.app.tokenizer.kind;

import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;

public record OperationToken(OperatorKind operator) implements Token {
  public static OperationToken operator(OperatorKind operator) {
    return new OperationToken(operator);
  }

  @Override
  public TokenKind kind() {
    return TokenKind.OPERATOR;
  }
}
