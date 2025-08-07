package pl.domi.calculatortask.utilities;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TestTaskStaticExamplesUtility {

  private static final String EXAMPLE_1 = "2 + 3";
  private static final String EXAMPLE_2 = "3 * 2 + 1";
  private static final String EXAMPLE_3 = "3 * -2 + 6";

  public static Stream<Arguments> provideStaticExamplesForTest() {
    return Stream.of(Arguments.of(EXAMPLE_1, 5), Arguments.of(EXAMPLE_2, 7), Arguments.of(EXAMPLE_3, 0));
  }
}
