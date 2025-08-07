package pl.domi.calculatortask.app.tokenizer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import pl.domi.calculatortask.app.rpn.kinds.OperatorKind;

final class TokenizationAccumulator {
  private final List<Integer> numbers = new ArrayList<>();
  private final List<OperatorKind> operatorsInOrder = new ArrayList<>();
  private final Deque<OperatorKind> operatorStack = new ArrayDeque<>();

  public void addNumber(int n) { numbers.add(n); }
  public void pushOperator(OperatorKind op) { operatorStack.push(op); operatorsInOrder.add(op); }
  public OperatorKind popOperator() { return operatorStack.pop(); }

  public TokenizationResult toResult() {
    return new TokenizationResult(
        List.copyOf(numbers),
        List.copyOf(operatorsInOrder)
    );
  }
}
