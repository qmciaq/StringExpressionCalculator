package pl.domi.calculatortask.app.cli;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.domi.calculatortask.app.StringExpressionCalculator;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@ConditionalOnProperty(prefix = "app.cli.integer", name = "enabled",
    havingValue = "true", matchIfMissing = true)
@Component
public class CalculatorIntegerCliRunner implements CommandLineRunner {

  private final StringExpressionCalculator<Integer> calc;

  public CalculatorIntegerCliRunner(StringExpressionCalculator<Integer> calc) {
    this.calc = calc;
  }

  @Override
  public void run(String... args) {
    System.out.println("Calc ready (integer only edition). Type an expression (or 'exit'):");
    Scanner sc = new Scanner(System.in);
    processInputs(sc);
    System.out.println("Thank you, goodbye.");
  }

  private void processInputs(Scanner sc) {
    while (true) {
      String line = processNextLine(sc);
      if (line == null) {
        break;
      }
      if (line.isBlank()) {
        System.out.println("= 0");
        continue;
      }
      calculate(line);
    }
  }

  private static String processNextLine(Scanner sc) {
    System.out.print("calc> ");
    if (!sc.hasNextLine()) {
      return null;
    }
    String line = sc.nextLine().trim();
    if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("q")) {
      return null;
    }
    return line;
  }

  private void calculate(String line) {
    try {
      var result = calc.calculate(line);
      System.out.println("= " + result);
    } catch (CalculatorBaseInputException e) {
      System.out.println("error: " + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println("internal error: " + e.getMessage());
    }
  }
}
