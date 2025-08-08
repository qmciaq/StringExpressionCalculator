package pl.domi.calculatortask.test.utilities;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import pl.domi.calculatortask.app.rpn.operator.kind.OperatorKind;
import pl.domi.calculatortask.app.tokenizer.kind.NumericToken;
import pl.domi.calculatortask.app.tokenizer.kind.OperationToken;

public class TestRpnConverterCasesUtility {
  private static NumericToken number(int value) {
    return new NumericToken(value);
  }

  private static OperationToken plus() {
    return new OperationToken(OperatorKind.ADDITION);
  }

  private static OperationToken minus() {
    return new OperationToken(OperatorKind.SUBTRACTION);
  }

  private static OperationToken mul() {
    return new OperationToken(OperatorKind.MULTIPLY);
  }

  private static OperationToken div() {
    return new OperationToken(OperatorKind.DIVISION);
  }

  static Stream<Arguments> rpnConverterCases() {
    return Stream.of(
        Arguments.of(List.of(number(2), plus(), number(3)),
            List.of(number(2), number(3), plus())),
        Arguments.of(List.of(number(2), plus(), number(3), mul(), number(4)),
            List.of(number(2), number(3), number(4), mul(), plus())),
        Arguments.of(List.of(number(2), mul(), number(3), plus(), number(4)),
            List.of(number(2), number(3), mul(), number(4), plus())),
        Arguments.of(List.of(number(8), minus(), number(3), minus(), number(2)),
            List.of(number(8), number(3), minus(), number(2), minus())),
        Arguments.of(List.of(number(8), div(), number(4), div(), number(1)),
            List.of(number(8), number(4), div(), number(1), div())),
        Arguments.of(List.of(number(5), minus(), number(2), mul(), number(3), plus(), number(1)),
            List.of(number(5), number(2), number(3), mul(), minus(), number(1), plus()))
    );
  }

}
