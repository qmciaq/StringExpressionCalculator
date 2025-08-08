package pl.domi.calculatortask.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

class StringExpressionCalculatorTest {

  private Number testCompute(String expression) {
    return StringExpressionCalculator.intCalculator().calculate(expression);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestTaskStaticExamplesUtility#provideStaticExamplesForTest")
  void shouldProperlyCalculateStaticExamples(String expression, int result) {
    assertEquals(testCompute(expression), result, "Computed value is not equal to result");
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestTaskStaticExamplesUtility#provideDivisionCases")
  void shouldProperlyCalculateDivisions(String expression, int result) {
    assertEquals(testCompute(expression), result, "Computed value is not equal to result");
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestExceptionGeneratingExamplesUtility#provideStaticExamplesForTest")
  void shouldThrowExpectedException(String expression, Class<? extends CalculatorBaseInputException> exceptionType) {
    assertThrows(exceptionType, () -> testCompute(expression), "For expression '%s' the exception did not match".formatted(expression));
  }
}