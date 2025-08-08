package pl.domi.calculatortask.test.utilities;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import pl.domi.calculatortask.app.exceptions.input.DivisionByZeroInputException;
import pl.domi.calculatortask.app.exceptions.input.MalformedExpressionInputException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberInputException;
import pl.domi.calculatortask.app.exceptions.input.NotSupportedArithmeticOperatorInputException;

public class TestExceptionGeneratingExamplesUtility {

  public static Stream<Arguments> provideStaticExamplesForTest() {
    return Stream.of(Arguments.of("5 / 0", DivisionByZeroInputException.class),
        Arguments.of("5,3 + 2", NotIntegerNumberInputException.class),
        Arguments.of("5.3 + 2", NotIntegerNumberInputException.class),
        Arguments.of("4 % 2", NotSupportedArithmeticOperatorInputException.class),
        Arguments.of("6 ^ 3", NotSupportedArithmeticOperatorInputException.class),
        Arguments.of("1 t 2", NotSupportedArithmeticOperatorInputException.class),
        Arguments.of("12 *", MalformedExpressionInputException.class),
        Arguments.of("/ 12", MalformedExpressionInputException.class));
  }
}
