package pl.domi.calculatortask;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.domi.calculatortask.app.StringExpressionCalculator;
import pl.domi.calculatortask.app.exceptions.base.CalculatorBaseInputException;

@SpringBootApplication
public class CalculatorTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(CalculatorTaskApplication.class, args);
  }
}
