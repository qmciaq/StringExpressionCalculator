package pl.domi.calculatortask.app.arithmetic;

import pl.domi.calculatortask.app.exceptions.input.DivisionByZeroInputException;

public class IntArithmetic implements Arithmetic<Integer> {

  public static final IntArithmetic INSTANCE = new IntArithmetic();

  private IntArithmetic() {
  }

  private static int intValue(Number value) {
    return value.intValue();
  }

  @Override
  public Integer coerce(Number value) {
    return intValue(value);
  }

  @Override
  public Integer add(Number left, Number right) {
    return Math.addExact(intValue(left), intValue(right));
  }

  @Override
  public Integer sub(Number left, Number right) {
    return Math.subtractExact(intValue(left), intValue(right));
  }

  @Override
  public Integer mul(Number left, Number right) {
    return Math.multiplyExact(intValue(left), intValue(right));
  }

  @Override
  public Integer div(Number left, Number right) {
    int rightValue = intValue(right);
    if (rightValue == 0) {
      throw new DivisionByZeroInputException();
    }
    return intValue(left) / rightValue;
  }
}
