package pl.domi.calculatortask.app.arithmetic;

public interface Arithmetic<T extends Number> {
  T coerce(Number value);
  T add(Number left, Number right);
  T sub(Number left, Number right);
  T mul(Number left, Number right);
  T div(Number left, Number right);
}
