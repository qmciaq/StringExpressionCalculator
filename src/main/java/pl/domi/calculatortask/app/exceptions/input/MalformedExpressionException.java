package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseException;

@RequiredArgsConstructor
public class MalformedExpressionException extends CalculatorBaseException {

  private final String expression;

  @Override
  public String getMessage() {
    return "Provided expression is malformed: '%s'".formatted(expression);
  }
}
