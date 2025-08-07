package pl.domi.calculatortask.test.utilities;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TestNumericUtilitiesCasesUtility {

  private static final String UMINUS_42 = "\u2212" + "42";

  static Stream<Arguments> isNumericTrueCases() {
    return Stream.of(
        Arguments.of("123"),
        Arguments.of("-7"),
        Arguments.of("  0  "),
        Arguments.of(UMINUS_42),
        Arguments.of("8.5"),
        Arguments.of("8,5")
    );
  }

  static Stream<Arguments> isNumericFailingCases() {
    return Stream.of(
        Arguments.of(""),
        Arguments.of("   "),
        Arguments.of("foo"),
        Arguments.of("+"),
        Arguments.of("-"),
        Arguments.of("NaN"),
        Arguments.of("Infinity"),
        Arguments.of("-Infinity")
    );
  }

  static Stream<Arguments> parseProperCases() {
    return Stream.of(
        Arguments.of("123", 123),
        Arguments.of("-7", -7),
        Arguments.of("+3", 3),
        Arguments.of("  0  ", 0),
        Arguments.of(UMINUS_42, -42)
    );
  }

  static Stream<Arguments> parseNumericNonIntegerCases() {
    return Stream.of(
        Arguments.of("8.5"),
        Arguments.of("8,5"),
        Arguments.of("  -1.0 "),
        Arguments.of("+2,0"),
        Arguments.of("999999999999999999")
    );
  }

  static Stream<Arguments> parseFailingCases() {
    return Stream.of(
        Arguments.of(""),
        Arguments.of("   "),
        Arguments.of("foo"),
        Arguments.of("+"),
        Arguments.of("-"),
        Arguments.of("1e3")
    );
  }
}
