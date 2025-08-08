package pl.domi.calculatortask.app.rpn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.exceptions.NumberIsNotAnOperatorException;
import pl.domi.calculatortask.app.exceptions.input.NotSupportedArithmeticOperatorInputException;
import pl.domi.calculatortask.app.rpn.operator.OperatorMatcher;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;

class OperatorMatcherTest {

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestOperatorCasesUtility#acceptedOperators")
  void shouldMatchOperatorWithExpectedKind(String operator, OperatorKind expectedKind) {
    assertEquals(expectedKind, OperatorMatcher.matchOperator(operator), "For operator: '%s'".formatted(operator));
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestOperatorCasesUtility#throwableOperators")
  void shouldThrowForNotAcceptedOperators(String operator) {
    assertThrows(NotSupportedArithmeticOperatorInputException.class, () -> OperatorMatcher.matchOperator(operator),
        "For operator: '%s'".formatted(operator));
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestOperatorCasesUtility#throwableNumberInsteadOfOperator")
  void shouldThrowForAstrayNumber(String value) {
    assertThrows(NumberIsNotAnOperatorException.class, () -> OperatorMatcher.matchOperator(value), "For value: '%s'".formatted(value));
  }
}