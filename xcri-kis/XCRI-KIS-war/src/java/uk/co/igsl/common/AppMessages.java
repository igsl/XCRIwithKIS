/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.common;

/**
 *
 * @author Tony
 */
import java.util.ListResourceBundle;

public class AppMessages extends ListResourceBundle {

  public static final String I0001 = "I0001";
  public static final String I0030 = "I0030";
  public static final String E9001 = "E9001";
  public static final String E9999 = "E9999";

  public AppMessages() {
    super();
  }

  public Object[][] getContents() {
    return contents_en;
  }
  /**
   * Array of error identifiers and the corresponding message text Add to this list as required. Do not remove anything
   * from it. Some error message numbers are used for client-side validation and are not available for server-side error
   * messages; these are indicated by comments in the list below.
   */
  static final Object[][] contents_en = {
    {I0001, "(I0001) The search has found no matches."},
    {I0030, "(I0030) An email has been sent to \"{1}\" to verify the email address."},
    {E9001, "(E9001) An XXP system error has occurred:\n{1}" },
    {E9999, "(E9999) Unspecified Error !! {1} {2} {3}" }
  };
}
