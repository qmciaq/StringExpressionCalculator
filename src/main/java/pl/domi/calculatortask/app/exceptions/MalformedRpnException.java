package pl.domi.calculatortask.app.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MalformedRpnException extends IllegalArgumentException {

  private final String expression;

  @Override
  public String getMessage() {
    return "Provided expression yielded wrong RPN: '%s'".formatted(expression);
  }
}
