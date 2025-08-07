package pl.domi.calculatortask.utilities;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import pl.domi.calculatortask.app.exceptions.input.DivisionByZeroException;
import pl.domi.calculatortask.app.exceptions.input.MalformedExpressionException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberException;
import pl.domi.calculatortask.app.exceptions.input.NotSupportedArithmeticOperatorException;

public class TestExceptionGeneratingExamplesUtility {

  public static Stream<Arguments> provideStaticExamplesForTest() {
    return Stream.of(Arguments.of("5 / 0", DivisionByZeroException.class),
        Arguments.of("5,3 + 2", NotIntegerNumberException.class),
        Arguments.of(NotSupportedArithmeticOperatorException.class, "4 % 2"),
        Arguments.of(NotSupportedArithmeticOperatorException.class, "6 ^ 3"),
        Arguments.of(NotSupportedArithmeticOperatorException.class, "1 t 2"),
        Arguments.of(MalformedExpressionException.class, "12 *"));
  }
}
