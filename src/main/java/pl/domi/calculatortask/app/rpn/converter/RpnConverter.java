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
    List<Token> out = new ArrayList<>();
    Deque<OperatorKind> ops = new ArrayDeque<>();

    tokens.forEach(t -> {
      switch (t) {
        case NumericToken nt -> out.add(nt);
        case OperationToken ot -> {
          OperatorKind in = ot.operator();
          while (!ops.isEmpty() && shouldPop(ops.peek(), in)) {
            out.add(new OperationToken(ops.pop()));
          }
          ops.push(in);
        }
      }
    });
    while (!ops.isEmpty()) {
      out.add(new OperationToken(ops.pop()));
    }
    return out;
  }

  private static boolean shouldPop(OperatorKind top, OperatorKind in) {
    return in.isRightAssociative()
        ? top.precedence() > in.precedence()
        : top.precedence() >= in.precedence();
  }
}
