package pl.domi.calculatortask.app.tokenizer;

import java.util.stream.IntStream;
import pl.domi.calculatortask.app.exceptions.input.MalformedExpressionInputException;
import pl.domi.calculatortask.app.rpn.OperatorMatcher;
import pl.domi.calculatortask.app.utility.NumericUtilities;

public class Tokenizer {

  private static final String EXPRESSION_SEPARATOR = " ";

  public static TokenizationResult tokenize(String expression) {
    String[] rawTokens = splitIntoTokens(expression);
    return createTokens(rawTokens);
  }

  private static TokenizationResult createTokens(String[] rawTokens) {
    TokenizationAccumulator tokenizationAccumulator = new TokenizationAccumulator();
    tryToTokenize(rawTokens, tokenizationAccumulator);
    return tokenizationAccumulator.toResult();
  }

  private static void tryToTokenize(String[] rawTokens, TokenizationAccumulator tokenizationAccumulator) {
    IntStream.range(0, rawTokens.length).forEachOrdered(tokenIdx -> {
      String currentToken = rawTokens[tokenIdx];
      if (NumericUtilities.isNumeric(currentToken)) {
        tokenizationAccumulator.addNumber(NumericUtilities.parseRequiredInt(currentToken));
      } else {
        assertIsNotAnOperatorAtLastPlace(rawTokens, tokenIdx, currentToken);
        tokenizationAccumulator.pushOperator(OperatorMatcher.matchOperator(currentToken));
      }
    });
  }

  private static void assertIsNotAnOperatorAtLastPlace(String[] rawTokens, int tokenIdx, String currentToken) {
    if (tokenIdx == rawTokens.length - 1) {
      throw new MalformedExpressionInputException(currentToken);
    }
  }

  private static String[] splitIntoTokens(String arithmeticExpression) {
    return arithmeticExpression.split(EXPRESSION_SEPARATOR);
  }
}
