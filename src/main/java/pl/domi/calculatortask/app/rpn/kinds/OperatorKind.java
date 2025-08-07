package pl.domi.calculatortask.app.rpn.kinds;

import pl.domi.calculatortask.app.rpn.precedence.Precedence;

public enum OperatorKind implements Precedence {
    ADDITION { public int precedence() { return LOWEST_PRECEDENCE; } },
    SUBTRACTION { public int precedence() { return LOWEST_PRECEDENCE; } },
    MULTIPLY { public int precedence() { return 2; } },
    DIVISION { public int precedence() { return 2; } },
    UNARY_MINUS { public int precedence() { return 3; } public boolean isRightAssociative() { return true; } };

  private static final int LOWEST_PRECEDENCE = 1;
}
