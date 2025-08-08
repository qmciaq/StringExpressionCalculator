package pl.domi.calculatortask.app.tokenizer.kind;

public record NumericToken(Number value) implements Token {

  public static NumericToken number(Number value) {
    return new NumericToken(value);
  }

  @Override
  public TokenKind kind() {
    return TokenKind.NUMBER;
  }
}
