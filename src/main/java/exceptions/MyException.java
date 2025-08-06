package exceptions;

import java.io.IOException;

public class MyException extends RuntimeException {
  public MyException(String message, Exception e) {
    super(message, e);
  }
}
