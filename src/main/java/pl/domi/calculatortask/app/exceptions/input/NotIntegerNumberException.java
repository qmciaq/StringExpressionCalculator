package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseException;

@RequiredArgsConstructor
public class NotIntegerNumberException extends CalculatorBaseException {

  private final String rawNumber;

  @Override
  public String getMessage() {
    return "Provided number is not an integer: '%s'".formatted(rawNumber);
  }
}
