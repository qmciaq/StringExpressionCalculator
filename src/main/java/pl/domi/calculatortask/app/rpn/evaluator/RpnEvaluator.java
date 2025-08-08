package pl.domi.calculatortask.app.rpn.evaluator;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import pl.domi.calculatortask.app.arithmetic.Arithmetic;
import pl.domi.calculatortask.app.exceptions.MalformedRpnException;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;
import pl.domi.calculatortask.app.tokenizer.kind.NumericToken;
import pl.domi.calculatortask.app.tokenizer.kind.OperationToken;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

public class RpnEvaluator<T extends Number> {
  private final Arithmetic<T> arithmeticStrategy;

  public RpnEvaluator(Arithmetic<T> arithmetic) {
    this.arithmeticStrategy = java.util.Objects.requireNonNull(arithmetic);
  }

  public T evaluateRpn(List<Token> rpn) {
    Deque<T> output = evaluateRpnTokens(rpn);
    if (output.size() != 1) {
      throw new MalformedRpnException(rpn.toString());
    }
    return output.pop();
  }

  private Deque<T> evaluateRpnTokens(List<Token> rpn) {
    Deque<T> output = new ArrayDeque<>();
    rpn.forEach(token -> {
      switch (token) {
        case NumericToken numericToken -> output.push(arithmeticStrategy.coerce(numericToken.value()));
        case OperationToken operationToken -> {
          T right = output.pop(), left = output.pop();
          output.push(evaluate(operationToken.operator(), left, right));
        }
      }
    });
    return output;
  }

  private T evaluate(OperatorKind operator, T left, T right) {
    return switch (operator) {
      case ADDITION -> this.arithmeticStrategy.add(left, right);
      case SUBTRACTION -> this.arithmeticStrategy.sub(left, right);
      case DIVISION -> this.arithmeticStrategy.div(left, right);
      case MULTIPLY -> this.arithmeticStrategy.mul(left, right);
    };
  }
}
