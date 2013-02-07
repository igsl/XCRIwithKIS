/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Tony
 */
public class XXPException extends Exception {

  public static final int UNKNOWN = 1;
  public static final int ERROR = 2;
  public static final int QUERY = 3;
  public static final int INFO = 4;
  public static final int WARNING = 5;
  public static final int FATAL = 6;
  protected String _strErrorCode;
  protected Object _aobjParams[];
  protected Collection _addedExceptions = new ArrayList();

  /**
   * Creates a new instance of
   * <code>XXPException</code> without detail message. should not be used
   */
  public XXPException() {
    this(AppMessages.E9999, (String[]) null);
  }

  /**
   * Constructs an instance of
   * <code>XXPException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public XXPException(final String strErrorCode) {
    this(strErrorCode, (String[]) null);
  }

  /**
   * Creates an Exception for a supplied error code with one parameter.
   *
   * @param strErrorCode the error code
   * @param strParam1 error parameter
   * @see AppMessages
   */
  public XXPException(final String strErrorCode, final String strParam1) {
    this(strErrorCode, new Object[]{strParam1});
  }

  /**
   * Creates a TopazException based on the error code supplied and exception.
   *
   * @param strErrorCode The symbolic error code. This is taken from AppMessages.
   * @param cause The exception that caused this exception to be thrown.
   * @see XXPException
   */
  public XXPException(final String strErrorCode, final Exception cause) {
    this(strErrorCode, new Object[]{}, cause);
  }

  /**
   * Creates an Exception for a supplied error code with am array of parameters
   *
   * @param strErrorCode the error code
   * @param aobjParams array of error parameters
   * @see AppMessages
   */
  public XXPException(final String strErrorCode, final Object[] aobjParams) {
    _strErrorCode = strErrorCode;
    _aobjParams = aobjParams;
  }

  /**
   * Creates a XXPException based on the error code supplied and exception.
   *
   * @param strErrorCode The symbolic error code. This is taken from AppMessages.
   * @param cause The exception that caused this exception to be thrown.
   * @see XXPException
   */
  public XXPException(final String strErrorCode, final Object[] aobjParams, final Exception cause) {
    this(strErrorCode);

    // Get parameter
    String message = cause.getMessage();
    if (message == null) {
      message = cause.getClass().getName();
    }

    // Add extra parameter
    Object[] params = new Object[aobjParams.length + 1];
    System.arraycopy(aobjParams, 0, params, 0, aobjParams.length);
    params[params.length - 1] = message;
    _aobjParams = params;

    // Add Exception
    this.addException(cause);
  }

  /**
   * Adds an Exception to this exception
   *
   * @param newException Exception to be added
   */
  public void addException(Exception newException) {
    _addedExceptions.add(newException);
    try {
      this.initCause(newException);
    } catch (Exception e) {
      // There is nothing we can do about this - the chain will use the
      // previously added exception.
    }
  }

  /**
   * Returns the Exceptions added to this exception
   *
   * @return Vector of added Exceptions
   */
  public Collection getAddedExceptions() {
    return _addedExceptions;
  }
}
