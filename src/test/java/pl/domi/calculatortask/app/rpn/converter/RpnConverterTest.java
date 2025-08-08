package pl.domi.calculatortask.app.rpn.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

class RpnConverterTest {

  @ParameterizedTest
  @MethodSource("pl.domi.calculatortask.test.utilities.TestRpnConverterCasesUtility#rpnConverterCases")
  void shouldConvertInfixToPostfixForRpn(List<Token> infix, List<Token> expectedPostfix) {
    List<Token> snapshot = new ArrayList<>(infix);

    List<Token> actual = RpnConverter.toPostfix(infix);

    assertEquals(expectedPostfix, actual, "RPN mismatch");
    assertEquals(snapshot, infix, "Converter should not mutate input list");
  }
}
