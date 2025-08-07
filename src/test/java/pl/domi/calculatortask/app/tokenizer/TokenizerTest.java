package pl.domi.calculatortask.app.tokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TokenizerTest {

  @ParameterizedTest
  @MethodSource("provideLengthCheckCases")
  void shouldHaveProperLengthForTokenLists(String expression, int numberListLength, int operatorListLength) {
    TokenizationResult result = Tokenizer.tokenize(expression);
    assertEquals(numberListLength, result.numbers().size());
    assertEquals(operatorListLength, result.operators().size());

  }

  private static Stream<Arguments> provideLengthCheckCases() {
    return Stream.of(Arguments.of("5 - 3", 2, 1), Arguments.of("16 + 3", 2, 1), Arguments.of("5 / 3 + 1", 3, 2));
  }
}