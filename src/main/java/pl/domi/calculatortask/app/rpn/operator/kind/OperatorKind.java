package pl.domi.calculatortask.app.rpn.operator.kind;

import pl.domi.calculatortask.app.rpn.precedence.Precedence;

public enum OperatorKind implements Precedence {
  ADDITION {
    public int precedence() {
      return LOWEST_PRECEDENCE;
    }
  },
  SUBTRACTION {
    public int precedence() {
      return LOWEST_PRECEDENCE;
    }
  },
  MULTIPLY {
    public int precedence() {
      return MULTIPLY_DIVIDE_PRECEDENCE;
    }
  },
  DIVISION {
    public int precedence() {
      return MULTIPLY_DIVIDE_PRECEDENCE;
    }
  };
  private static final int MULTIPLY_DIVIDE_PRECEDENCE = 2;
  private static final int LOWEST_PRECEDENCE = 1;
}
