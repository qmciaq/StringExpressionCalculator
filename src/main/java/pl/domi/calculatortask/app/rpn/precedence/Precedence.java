package pl.domi.calculatortask.app.rpn.precedence;

public interface Precedence {
  int precedence();
  default boolean isRightAssociative() { return false; }
}
