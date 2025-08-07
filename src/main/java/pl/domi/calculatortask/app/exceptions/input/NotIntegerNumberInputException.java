package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@RequiredArgsConstructor
public class NotIntegerNumberInputException extends CalculatorBaseInputException {

  private final String rawNumber;

  @Override
  public String getMessage() {
    return "Provided number is not an integer: '%s'".formatted(rawNumber);
  }
}
