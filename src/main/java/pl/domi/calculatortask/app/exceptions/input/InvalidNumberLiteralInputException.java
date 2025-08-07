package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@RequiredArgsConstructor
public class InvalidNumberLiteralInputException extends CalculatorBaseInputException {

  private final String rawNumber;

  @Override
  public String getMessage() {
    return "Provided number literal is invalid: '%s'".formatted(rawNumber);
  }
}
