package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@RequiredArgsConstructor
public class NotSupportedArithmeticOperatorInputException extends CalculatorBaseInputException {

  private final String operator;

  @Override
  public String getMessage() {
    return "Unsupported operator: '%s'".formatted(operator);
  }
}
