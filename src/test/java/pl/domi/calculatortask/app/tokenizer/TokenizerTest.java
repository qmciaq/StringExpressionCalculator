package pl.domi.calculatortask.app.tokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

class TokenizerTest {

  @ParameterizedTest
  @MethodSource("provideLengthCheckCases")
  void shouldHaveProperLengthForTokenLists(String expression, int numberListLength, int operatorListLength) {
    List<Token> result = Tokenizer.tokenize(expression);
    assertEquals(numberListLength, result.stream().filter((Token::isNumber)).count());
    assertEquals(operatorListLength, result.stream().filter((Token::isOperator)).count());
  }

  private static Stream<Arguments> provideLengthCheckCases() {
    return Stream.of(Arguments.of("5 - 3", 2, 1), Arguments.of("16 + 3", 2, 1), Arguments.of("5 / 3 + 1", 3, 2));
  }
}