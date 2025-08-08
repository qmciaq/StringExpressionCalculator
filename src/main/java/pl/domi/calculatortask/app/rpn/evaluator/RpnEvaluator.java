package pl.domi.calculatortask.app.rpn.evaluator;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import pl.domi.calculatortask.app.arithmetic.Arithmetic;
import pl.domi.calculatortask.app.arithmetic.IntArithmetic;
import pl.domi.calculatortask.app.exceptions.MalformedRpnException;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;
import pl.domi.calculatortask.app.tokenizer.kind.NumericToken;
import pl.domi.calculatortask.app.tokenizer.kind.OperationToken;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

public class RpnEvaluator {

  static final Arithmetic<Integer> ARITHMETIC_STRATEGY = new IntArithmetic();

  public static Number evaluateRpn(List<Token> rpn) {
    Deque<Number> output = evaluateRpnTokens(rpn);
    if (output.size() != 1) {
      throw new MalformedRpnException(rpn.toString());
    }
    return output.pop();
  }

  private static Deque<Number> evaluateRpnTokens(List<Token> rpn) {
    Deque<Number> output = new ArrayDeque<>();
    rpn.forEach(token -> {
      switch (token) {
        case NumericToken numericToken -> output.push(numericToken.value());
        case OperationToken operationToken -> {
          Number right = output.pop(), left = output.pop();
          output.push(evaluate(operationToken.operator(), left, right));
        }
      }
    });
    return output;
  }

  private static Number evaluate(OperatorKind operator, Number left, Number right) {
    return switch (operator) {
      case ADDITION -> ARITHMETIC_STRATEGY.add(left, right);
      case SUBTRACTION -> ARITHMETIC_STRATEGY.sub(left, right);
      case DIVISION -> ARITHMETIC_STRATEGY.div(left, right);
      case MULTIPLY -> ARITHMETIC_STRATEGY.mul(left, right);
    };
  }
}
