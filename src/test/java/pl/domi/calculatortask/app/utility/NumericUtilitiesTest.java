package pl.domi.calculatortask.app.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.exceptions.input.InvalidNumberLiteralInputException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberInputException;

class NumericUtilitiesTest {

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestNumericUtilitiesCasesUtility#isNumericTrueCases")
  void shouldReturnTrueForIsNumeric(String value) {
    assertTrue(NumericUtilities.isNumeric(value), "Expected numeric: " + value);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestNumericUtilitiesCasesUtility#isNumericFailingCases")
  void shouldReturnFalseForIsNumeric(String value) {
    assertFalse(NumericUtilities.isNumeric(value), "Expected non-numeric: " + value);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestNumericUtilitiesCasesUtility#parseProperCases")
  void shouldParseValid(String value, int expected) {
    assertEquals(expected, NumericUtilities.parseRequiredInt(value), "Failing value is: " + value);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestNumericUtilitiesCasesUtility#parseNumericNonIntegerCases")
  void shouldThrowOnNumericNonInteger(String value) {
    assertThrows(NotIntegerNumberInputException.class,
        () -> NumericUtilities.parseRequiredInt(value),
        "Expected decimal to be rejected as non-integer: " + value);
  }

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestNumericUtilitiesCasesUtility#parseFailingCases")
  void shouldThrowOnInvalidNumberLiteral(String value) {
    assertThrows(InvalidNumberLiteralInputException.class,
        () -> NumericUtilities.parseRequiredInt(value),
        "Expected invalid integer literal: " + value);
  }
}