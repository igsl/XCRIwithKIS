<%-- 
    Document   : error
    Created on : 16-Dec-2012, 21:07:08
    Author     : Tony
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"
         isThreadSafe="false"
         language="java"
         isErrorPage="true"
         import="java.io.*,
         uk.co.igsl.common.*,
         java.util.Iterator,
         java.util.Collection,
         javax.persistence.OptimisticLockException"
         %>
<%!  // Make sure this variable is set to the page ID
  //String sPageID = AppConstants.SCREEN_WELCOME;
  // determine whether logging is switched on or off
  static final boolean bLogging;

  static {
    bLogging = true;
  }

  private void printException(Throwable e, JspWriter out) throws IOException {
    ByteArrayOutputStream ostr = new ByteArrayOutputStream();
    e.printStackTrace(new PrintStream(ostr));
    String sFullStackTrace = ostr.toString();

    if (bLogging) {
      out.print(sFullStackTrace);
    } else {
      // print out to second occurrence of "at ", so that the method 
      // in which the exception occurred is reported
      int iEndPoint = sFullStackTrace.indexOf("at ");
      iEndPoint = sFullStackTrace.indexOf("at ", iEndPoint + 1);
      if (iEndPoint < 0) {
        iEndPoint = sFullStackTrace.length();
      }
      out.print(sFullStackTrace.substring(0, iEndPoint));
    }
  }
%>
<%
  try {
    String strErrorMessage;

    if (exception == null) {
      strErrorMessage = "Error Page was called with a null exception";
    } else if (exception instanceof XXPException) {
      strErrorMessage = ((XXPException) exception).getMessage();
      Collection coll = ((XXPException) exception).getAddedExceptions();
      if (coll != null) {
        Iterator colIter = coll.iterator();
        while (colIter.hasNext()) {
          Exception ex = (Exception) colIter.next();
          if ((null != ex) && (ex.getMessage().contains("OptimisticLockException"))) {
            strErrorMessage = "OptimisticLockException";
            break;
          }
        }
      }
    } else // e.g. exception occurs in servlet
    {
      //TreeMap tmAdditional = AppJspUtil.loadAdditionalProperties( application );
      strErrorMessage = "use message tag";
    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" type="image/ico" href="http://www.igsl.co.uk/favicon.ico"/>
    <link href="css/xxp.css" media="all" rel="stylesheet" type="text/css" />
    <link href="css/xxp-menu.css" media="all" rel="stylesheet" type="text/css" />
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print" />
    <script type="text/javascript" charset="utf-8" language="javascript" src="js/jquery.js"></script>
    <title>XCRI eXchange Platform XXP</title>
    <script type="text/javascript">
      jQuery(document).ready(function() {
        $('#errorDetails').click(function() {
          $('.errorMessageBody').slideToggle('slow', function() {
            // Animation complete.
          });
        });
      });
      // Function that closes the window if we are in a popup, or returns to the previous screen
      function backButton() {
        if (history.length < 1) {
          window.close();
        }
        else {
          history.back();
        }
      }
    </script>
  </head>
  <body>
    <div id="logo-container">
      <p id="logo">
        <a href="http://www.igsl.co.uk/" title="InGenius Solutions Limited"><img src="images/logo2.gif" alt="igsl-logo" height="55" width="52" /></a> </p>
      <p id=header>Error</p>
    </div>
    <div id="main-content-container">
      <div id="main-content-container-2">
        <!--Main content start here -->
        <div id="content-container">
          <div id="content-container-2">
            <p class="header1">XXP exception</p>
            <!-- Start: Error Message-->
            <!-- This is displayed in all errors -->
            <div class="errorMessageHeader">
              <%
                if (strErrorMessage == "use message tag") {
              %>error pages text
              <%} else {%> 
              <%=  strErrorMessage%>
              <%}%>
            </div>
            <!-- End: Error Message -->
            <!-- Start: Error Body-->
            <!-- This is only displayed when full details are requested. -->
            <%
              if (exception != null) {
                if (exception instanceof XXPException) {
                  Collection coll = ((XXPException) exception).getAddedExceptions();
                  if (coll != null) {
                    Iterator colIter = coll.iterator();
                    while (colIter.hasNext()) {
                      Exception ex = (Exception) colIter.next();
                      if (ex != null) {
            %>
            <a href="#" id="errorDetails">Technical Details</a><br/>
            <div class="errorMessageBody" style="display:none;">
              <textarea cols="60" rows="25">
                <%
                  printException(ex, out);
                %>
              </textarea>
            </div>                  
            <%
                  }
                }
              }
            } else // Not an XXPException
            {
            %>
            <a href="#" id="errorDetails">Technical Details</a><br/>          
            <div class="errorMessageBody" style="display:none;">
              <textarea cols="60" rows="25">
                <%
                  printException(exception, out);
                %>
              </textarea>
            </div>                  
            <%
                }
              }
            %>
            <!-- End: Error Body -->
            <br/>
            <input type="button" name="Back" value="Go Back" onclick="backButton();"/>
          </div>
        </div>
        <!--End Main content start here-->

        <!--end of side-menu-->
      </div>
    </div>
  </body>
</html>
<%
} catch (Exception e) {
%>Unknown Exception<%  }
%>
