package pl.domi.calculatortask.app;

import java.util.List;
import pl.domi.calculatortask.app.arithmetic.Arithmetic;
import pl.domi.calculatortask.app.arithmetic.IntArithmetic;
import pl.domi.calculatortask.app.exceptions.input.DivisionByZeroInputException;
import pl.domi.calculatortask.app.exceptions.input.InvalidNumberLiteralInputException;
import pl.domi.calculatortask.app.exceptions.input.MalformedExpressionInputException;
import pl.domi.calculatortask.app.exceptions.input.NotIntegerNumberInputException;
import pl.domi.calculatortask.app.exceptions.input.NotSupportedArithmeticOperatorInputException;
import pl.domi.calculatortask.app.rpn.converter.RpnConverter;
import pl.domi.calculatortask.app.rpn.evaluator.RpnEvaluator;
import pl.domi.calculatortask.app.tokenizer.Tokenizer;
import pl.domi.calculatortask.app.tokenizer.kind.Token;

/**
 * Evaluates simple arithmetic expressions given as space-separated infix strings.
 * <p>
 * Pipeline:
 * <ol>
 *   <li><b>Tokenize</b> the input (numbers and operators),</li>
 *   <li>convert infix to <b>RPN</b> (postfix) via shunting-yard,</li>
 *   <li><b>evaluate</b> RPN with the injected {@link Arithmetic} strategy.</li>
 * </ol>
 *
 * <h2>Supported syntax</h2>
 * <ul>
 *   <li>Operators: {@code + - * /} (left-associative; standard precedence)</li>
 *   <li>Signed integer literals: e.g. {@code 42}, {@code -2}, {@code +7}</li>
 *   <li>Tokens must be <b>space-separated</b>, e.g. {@code "3 * -2 + 6"}</li>
 * </ul>
 * (Parentheses and decimals are intentionally out of scope for now.)
 *
 * <h2>Semantics</h2>
 * Semantics are defined by the provided {@link Arithmetic} implementation:
 * <ul>
 *   <li>With {@code IntArithmetic}: integer math, division truncates toward zero,
 *       overflow checked via {@code Math.*Exact}.</li>
 *   <li>Other implementations (e.g., double/BigDecimal) can be injected without
 *       changing parser/evaluator code.</li>
 * </ul>
 *
 * <h2>Exceptions</h2>
 * User input errors are signaled via your calculator exceptions, for example:
 * <ul>
 *   <li>{@link InvalidNumberLiteralInputException} – not a valid integer literal or overflow</li>
 *   <li>{@link NotIntegerNumberInputException} – numeric but not an integer (e.g., {@code 8.5}, {@code 8,5})</li>
 *   <li>{@link NotSupportedArithmeticOperatorInputException} – operator not in {@code + - * /}</li>
 *   <li>{@link MalformedExpressionInputException} – structural issues (e.g., ends with an operator)</li>
 *   <li>{@link DivisionByZeroInputException} – division by zero at evaluation time</li>
 * </ul>
 *
 * <h2>Examples</h2>
 * <pre>{@code
 * // Integer semantics (default)
 * var calc = StringExpressionCalculator.intCalc();
 * int r1 = calc.calculate("3 * -2 + 6");   // 0
 * }</pre>
 *
 * @param <T> numeric result type produced by the {@link Arithmetic} strategy
 */
public final class StringExpressionCalculator<T extends Number> {

  private final Arithmetic<T> arithmetic;
  private final RpnEvaluator<T> evaluator;

  public StringExpressionCalculator(Arithmetic<T> arithmetic) {
    this.arithmetic = java.util.Objects.requireNonNull(arithmetic);
    this.evaluator = new RpnEvaluator<>(arithmetic);
  }

  /**
   * Convenience factory for integer semantics (uses {@link IntArithmetic}).
   *
   * @return a calculator that evaluates to {@code Integer}
   */
  public static StringExpressionCalculator<Integer> intCalculator() {
    return new StringExpressionCalculator<>(IntArithmetic.INSTANCE);
  }

  /**
   * Parses and evaluates the given expression.
   *
   * @param expression space-separated infix expression, e.g. {@code "6 + 3 * -2"}
   * @return the computed result in the strategy’s numeric type
   *
   * @throws InvalidNumberLiteralInputException
   *         if a token is not a valid integer literal (or overflows for the current strategy)
   * @throws NotIntegerNumberInputException
   *         if a numeric token is not an integer (e.g., {@code 8.5}, {@code 8,5}) and the strategy expects integers
   * @throws NotSupportedArithmeticOperatorInputException
   *         if an operator other than {@code + - * /} is encountered
   * @throws MalformedExpressionInputException
   *         if the token sequence is structurally invalid (e.g., ends with an operator)
   * @throws DivisionByZeroInputException
   *         if a division by zero occurs during evaluation
   */
  public T calculate(String expression) {
    if (expression.isBlank()) {
      return arithmetic.coerce(0);
    }

    List<Token> tokens = Tokenizer.tokenize(expression);
    List<Token> postfixRpn = RpnConverter.toPostfix(tokens);
    return evaluator.evaluateRpn(postfixRpn);
  }
}
