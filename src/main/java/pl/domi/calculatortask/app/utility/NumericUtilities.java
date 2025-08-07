package pl.domi.calculatortask.app.utility;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.math.NumberUtils;
import pl.domi.calculatortask.app.exceptions.input.InvalidNumberLiteralInputException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberInputException;

@UtilityClass
public class NumericUtilities {

  private final int LEADING_CHARACTER_INDEX = 0;
  private final char DECIMAL_COMA = ',';
  private final char DECIMAL_POINT = '.';

  public boolean isNumeric(String rawValue) {
    if (rawValue == null) {
      return false;
    }
    String normalizedValue = normalize(rawValue).replace(DECIMAL_COMA, DECIMAL_POINT);
    return NumberUtils.isParsable(normalizedValue);
  }

  public int parseRequiredInt(String value) {
    assertNotBlank(value);
    String trimmedValue = normalize(value);
    try {
      return Integer.parseInt(trimmedValue);
    } catch (NumberFormatException ex) {
      if (isNumeric(trimmedValue)) {
        throw new NotIntegerNumberInputException(value);
      }
      throw new InvalidNumberLiteralInputException(value);
    }
  }

  private void assertNotBlank(String value) {
    if (value.isBlank()) {
      throw new InvalidNumberLiteralInputException(value);
    }
  }

  private String normalize(String value) {
    if (value.isBlank()) {
      return value;
    }
    String trimmedValue = value.trim();
    return normalizePotentialLeadingSign(trimmedValue);
  }

  private String normalizePotentialLeadingSign(String trimmedValue) {
    char firstChar = trimmedValue.charAt(LEADING_CHARACTER_INDEX);
    char normalizedFirstChar = OperatorUtilities.normalizeLeadingSign(firstChar);
    if (normalizedFirstChar == OperatorUtilities.PLUS) {
      return dropLeadingSign(trimmedValue);
    }
    return (normalizedFirstChar == firstChar) ? trimmedValue : normalizedFirstChar + trimmedValue.substring(1);
  }

  private String dropLeadingSign(String trimmedValue) {
    return (trimmedValue.length() == 1) ? "" : trimmedValue.substring(1);
  }
}
