package pl.domi.calculatortask.app.utility;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.math.NumberUtils;
import pl.domi.calculatortask.app.exceptions.input.InvalidNumberLiteralInputException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberInputException;

@UtilityClass
public class NumericUtilities {

  private static final char UNICODE_MINUS_SIGN = '\u2212';

  public boolean isNumeric(String rawValue) {
    if (rawValue == null) return false;
    String normalizedValue = normalize(rawValue).replace(',', '.');
    return NumberUtils.isParsable(normalizedValue);
  }

  public int parseRequiredInt(String value) {
    assertNotBlank(value, value);
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

  private static void assertNotBlank(String value, String s) {
    if (s.isBlank()) {
      throw new InvalidNumberLiteralInputException(value);
    }
  }

  private String normalize(String s) {
    s = s.trim();
    if (!s.isEmpty() && s.charAt(0) == UNICODE_MINUS_SIGN) s = '-' + s.substring(1);
    return s;
  }
}
