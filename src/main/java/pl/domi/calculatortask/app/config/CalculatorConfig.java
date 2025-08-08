package pl.domi.calculatortask.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.domi.calculatortask.app.StringExpressionCalculator;
import pl.domi.calculatortask.app.arithmetic.IntArithmetic;

@Configuration
public class CalculatorConfig {

  @Bean
  public StringExpressionCalculator<Integer> intCalculator() {
    return new StringExpressionCalculator<>(IntArithmetic.INSTANCE);
  }
}
