package pl.domi.calculatortask.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class StringExpressionCalculatorTest {

  private int testCompute(String expression) {
    return StringExpressionCalculator.calculate(expression);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.utilities.TestTaskStaticExamplesUtility#provideStaticExamplesForTest")
  void shouldProperlyCalculateStaticExamples(String expression, int result) {
    assertEquals(testCompute(expression), result, "Computed value is not equal to result.");
  }
}