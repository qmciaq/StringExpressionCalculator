package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@RequiredArgsConstructor
public class DivisionByZeroInputException extends CalculatorBaseInputException {

  @Override
  public String getMessage() {
    return "Division by zero";
  }
}
