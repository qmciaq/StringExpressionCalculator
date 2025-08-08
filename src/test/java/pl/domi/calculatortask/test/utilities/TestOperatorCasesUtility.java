package pl.domi.calculatortask.test.utilities;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;

public class TestOperatorCasesUtility {

  static Stream<Arguments> acceptedOperators() {
    return Stream.of(
        Arguments.of("+", OperatorKind.ADDITION),
        Arguments.of("-", OperatorKind.SUBTRACTION),
        Arguments.of("*", OperatorKind.MULTIPLY),
        Arguments.of("/", OperatorKind.DIVISION)
    );
  }

  static Stream<Arguments> throwableOperators() {
    return Stream.of(
        Arguments.of("("),
        Arguments.of(")"),
        Arguments.of("^"),
        Arguments.of("%")
    );
  }

  static Stream<Arguments> throwableNumberInsteadOfOperator() {
    return Stream.of(
        Arguments.of("2"),
        Arguments.of("15"),
        Arguments.of("3.5"),
        Arguments.of("14,7")
    );
  }
}
