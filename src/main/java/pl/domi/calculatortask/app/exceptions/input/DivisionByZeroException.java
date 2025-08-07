package pl.domi.calculatortask.app.exceptions.input;

import lombok.RequiredArgsConstructor;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseException;

@RequiredArgsConstructor
public class DivisionByZeroException extends CalculatorBaseException {

  @Override
  public String getMessage() {
    return "Division by zero";
  }
}
