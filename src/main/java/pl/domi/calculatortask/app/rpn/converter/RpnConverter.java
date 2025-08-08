package pl.domi.calculatortask.app.rpn.converter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;
import pl.domi.calculatortask.app.tokenizer.kind.NumericToken;
import pl.domi.calculatortask.app.tokenizer.kind.OperationToken;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

public class RpnConverter {

  public static List<Token> toPostfix(List<Token> tokens) {
    List<Token> output = new ArrayList<>();
    Deque<OperatorKind> operations = new ArrayDeque<>();

    processTokens(tokens, output, operations);
    while (!operations.isEmpty()) {
      output.add(new OperationToken(operations.pop()));
    }
    return output;
  }

  private static void processTokens(List<Token> tokens, List<Token> output, Deque<OperatorKind> operations) {
    tokens.forEach(t -> {
      switch (t) {
        case NumericToken nt -> output.add(nt);
        case OperationToken ot -> {
          OperatorKind in = ot.operator();
          while (!operations.isEmpty() && shouldPop(operations.peek(), in)) {
            output.add(new OperationToken(operations.pop()));
          }
          operations.push(in);
        }
      }
    });
  }

  private static boolean shouldPop(OperatorKind top, OperatorKind incoming) {
    return incoming.isRightAssociative()
        ? top.precedence() > incoming.precedence()
        : top.precedence() >= incoming.precedence();
  }
}
