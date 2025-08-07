package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseException;

@RequiredArgsConstructor
public class NotSupportedArithmeticOperatorException extends CalculatorBaseException {

  private final String operator;

  @Override
  public String getMessage() {
    return "Unsupported operator: '%s'".formatted(operator);
  }
}
