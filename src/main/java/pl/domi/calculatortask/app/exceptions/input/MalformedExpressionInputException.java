package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@RequiredArgsConstructor
public class MalformedExpressionInputException extends CalculatorBaseInputException {

  private final String expression;

  @Override
  public String getMessage() {
    return "Provided expression is malformed: '%s'".formatted(expression);
  }
}
