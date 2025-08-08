package pl.domi.calculatortask.app.arithmetic;

public interface Arithmetic<T extends Number> {
  T add(Number a, Number b);
  T sub(Number a, Number b);
  T mul(Number a, Number b);
  T div(Number a, Number b);
}
