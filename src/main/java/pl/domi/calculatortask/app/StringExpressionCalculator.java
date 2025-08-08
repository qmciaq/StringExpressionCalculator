package pl.domi.calculatortask.app;

import java.util.List;
import pl.domi.calculatortask.app.rpn.converter.RpnConverter;
import pl.domi.calculatortask.app.rpn.evaluator.RpnEvaluator;
import pl.domi.calculatortask.app.tokenizer.Tokenizer;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

public final class StringExpressionCalculator {

  public static Number calculate(String expression) {
    if (expression.isBlank()) {
      return 0;
    }

    List<Token> tokens = Tokenizer.tokenize(expression);
    List<Token> postFixRpn = RpnConverter.toPostfix(tokens);
    Number result = RpnEvaluator.evaluateRpn(postFixRpn);
    return result;
  }

}
