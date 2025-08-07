package pl.domi.calculatortask.app.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NumberIsNotAnOperatorException extends IllegalArgumentException {

  @Override
  public String getMessage() {
    return "Number was provided into operators list. Should've not happened.";
  }
}
