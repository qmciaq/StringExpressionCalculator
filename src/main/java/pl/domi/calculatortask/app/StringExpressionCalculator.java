package pl.domi.calculatortask.app;

import pl.domi.calculatortask.app.tokenizer.TokenizationResult;
import pl.domi.calculatortask.app.tokenizer.Tokenizer;

public final class StringExpressionCalculator {

  public static int calculate(String expression) {
    if (expression.isBlank()) {
      return 0;
    }

    TokenizationResult tokens = Tokenizer.tokenize(expression);
    return -1;
  }

}
