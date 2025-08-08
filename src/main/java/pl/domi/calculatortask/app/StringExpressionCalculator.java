package pl.domi.calculatortask.app;

import java.util.List;
import pl.domi.calculatortask.app.arithmetic.Arithmetic;
import pl.domi.calculatortask.app.arithmetic.IntArithmetic;
import pl.domi.calculatortask.app.rpn.converter.RpnConverter;
import pl.domi.calculatortask.app.rpn.evaluator.RpnEvaluator;
import pl.domi.calculatortask.app.tokenizer.Tokenizer;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

public final class StringExpressionCalculator<T extends Number> {

  private final Arithmetic<T> arithmetic;
  private final RpnEvaluator<T> evaluator;

  public StringExpressionCalculator(Arithmetic<T> arithmetic) {
    this.arithmetic = java.util.Objects.requireNonNull(arithmetic);
    this.evaluator = new RpnEvaluator<>(arithmetic);
  }

  public static StringExpressionCalculator<Integer> intCalculator() {
    return new StringExpressionCalculator<>(IntArithmetic.INSTANCE);
  }

  public T calculate(String expression) {
    if (expression.isBlank()) {
      return arithmetic.coerce(0);
    }

    List<Token> tokens = Tokenizer.tokenize(expression);
    List<Token> postfixRpn = RpnConverter.toPostfix(tokens);
    return evaluator.evaluateRpn(postfixRpn);
  }
}
