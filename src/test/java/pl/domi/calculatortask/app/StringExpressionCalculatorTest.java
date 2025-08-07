package pl.domi.calculatortask.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseException;

class StringExpressionCalculatorTest {

  private int testCompute(String expression) {
    return StringExpressionCalculator.calculate(expression);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.utilities.TestTaskStaticExamplesUtility#provideStaticExamplesForTest")
  void shouldProperlyCalculateStaticExamples(String expression, int result) {
    assertEquals(testCompute(expression), result, "Computed value is not equal to result");
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.utilities.TestExceptionGeneratingExamplesUtility#provideStaticExamplesForTest")
  void shouldThrowExpectedException(String expression, Class<? extends CalculatorBaseException> exceptionType) {
    assertThrows(exceptionType, () -> testCompute(expression), "For expression '%s' the exception did not match".formatted(expression));
  }
}