package pl.domi.calculatortask.app.tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import pl.domi.calculatortask.app.exceptions.input.MalformedExpressionInputException;
import pl.domi.calculatortask.app.rpn.operator.OperatorMatcher;
import pl.domi.calculatortask.app.tokenizer.kind.NumericToken;
import pl.domi.calculatortask.app.tokenizer.kind.OperationToken;
import pl.domi.calculatortask.app.tokenizer.kind.Token;
import pl.domi.calculatortask.app.utility.NumericUtilities;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tokenizer {

  static final String EXPRESSION_SEPARATOR = " ";

  public static List<Token> tokenize(String expression) {
    String[] rawTokens = splitIntoTokens(expression);
    return tryToTokenize(rawTokens);
  }

  static List<Token> tryToTokenize(String[] rawTokens) {
    List<Token> tokens = new ArrayList<>(rawTokens.length);
    Arrays.stream(rawTokens).forEachOrdered(token -> {
      if (NumericUtilities.isNumeric(token)) {
        tokens.add(NumericToken.number(NumericUtilities.parseRequiredInt(token)));
      } else {
        tokens.add(OperationToken.operator(OperatorMatcher.matchOperator(token)));
      }
    });
    assertIsNotAnOperatorAtLastPlace(tokens);
    return tokens;
  }

  static void assertIsNotAnOperatorAtLastPlace(List<Token> tokens) {
    if (!tokens.isEmpty() && tokens.getLast().isOperator()) {
      throw new MalformedExpressionInputException("Expression cannot end with an operator");
    }
  }

  static String[] splitIntoTokens(String arithmeticExpression) {
    return arithmeticExpression.split(EXPRESSION_SEPARATOR);
  }
}
