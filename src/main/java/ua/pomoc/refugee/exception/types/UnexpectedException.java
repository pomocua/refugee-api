package ua.pomoc.refugee.exception.types;

public class UnexpectedException extends RuntimeException {

  public UnexpectedException(Throwable cause) {
    super(cause);
  }

  public UnexpectedException(String message) {
    super(message);
  }
}
