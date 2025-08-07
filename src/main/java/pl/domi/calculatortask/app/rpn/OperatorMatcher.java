package pl.domi.calculatortask.app.rpn;

import pl.domi.calculatortask.app.exceptions.NumberIsNotAnOperatorException;
import pl.domi.calculatortask.app.exceptions.input.NotSupportedArithmeticOperatorInputException;
import pl.domi.calculatortask.app.rpn.kinds.OperatorKind;
import pl.domi.calculatortask.app.utility.NumericUtilities;

public class OperatorMatcher {

  public static OperatorKind matchOperator(String rawOperator) {
    if (NumericUtilities.isNumeric(rawOperator)) {
      throw new NumberIsNotAnOperatorException();
    }
    return switch (rawOperator) {
      case "+" -> OperatorKind.ADDITION;
      case "-" -> OperatorKind.SUBTRACTION;
      case "/" -> OperatorKind.DIVISION;
      case "*" -> OperatorKind.MULTIPLY;
      default -> throw new NotSupportedArithmeticOperatorInputException(rawOperator);
    };
  }
}
