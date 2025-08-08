package pl.domi.calculatortask.app.arithmetic;

import pl.domi.calculatortask.app.exceptions.input.DivisionByZeroInputException;

public class IntArithmetic implements Arithmetic<Integer> {

  private static int intValue(Number n) {
    return n.intValue();
  }

  public Integer add(Number a, Number b) {
    return Math.addExact(intValue(a), intValue(b));
  }

  public Integer sub(Number a, Number b) {
    return Math.subtractExact(intValue(a), intValue(b));
  }

  public Integer mul(Number a, Number b) {
    return Math.multiplyExact(intValue(a), intValue(b));
  }

  public Integer div(Number left, Number right) {
    int rightValue = intValue(right);
    if (rightValue == 0) {
      throw new DivisionByZeroInputException();
    }
    return intValue(left) / rightValue;
  }
}
