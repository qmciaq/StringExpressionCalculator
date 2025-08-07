package pl.domi.calculatortask.app.utility;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OperatorUtilities {

  final char PLUS = '+';
  final char MINUS = '-';

  private final char UNICODE_MINUS = '\u2212';
  private final char FULLWIDTH_PLUS = '\uFF0B';
  private final char FULLWIDTH_MINUS = '\uFF0D';
  private final char SMALL_PLUS = '\uFE62';
  private final char SMALL_MINUS = '\uFE63';

  public char normalizeLeadingSign(char potentialSign) {
    return switch (potentialSign) {
      case UNICODE_MINUS, FULLWIDTH_MINUS, SMALL_MINUS -> MINUS;
      case FULLWIDTH_PLUS, SMALL_PLUS -> PLUS;
      default -> potentialSign;
    };
  }
}
