/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import uk.co.igsl.common.AppMessages;
import uk.co.igsl.common.XXPException;

/**
 *
 * @author Tony
 */
public class SuperServlet extends HttpServlet {

  private static final String ERROR_PAGE = "error.jsp";

  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods. (subclasses should over-ride this method).
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, Exception {
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  /**
   * Exception handling method Redirects the browser to the error page, which displays an appropriate message
   *
   * @param e the Exception to handle
   * @param servletObject the servlet in which the Exception was caught
   * @param request the request object
   * @param response the response object
   */
  protected void handleException(
          Exception e,
          HttpServlet servletObject,
          HttpServletRequest request,
          HttpServletResponse response) {
    PageContext pageContext = JspFactory.getDefaultFactory().
            getPageContext(servletObject,
            request,
            response,
            "KIS_ERROR_PAGE",
            true, 8192, true);
    request.setAttribute("javax.servlet.jsp.jspException", e);

    try {
      pageContext.forward(ERROR_PAGE);
    } catch (Exception ex) {
      System.err.println("Exception [" + ex + "] while redirecting to errorpage!");
      ex.printStackTrace(System.err);
      // take no further action - not possible to inform user
    }
  }

  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (Exception e) {
      handleException(e, this, request, response);
    }
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (Exception e) {
      handleException(e, this, request, response);
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "KIS web application - by IGSL";
  }

  /**
   * Create HashMap of parameters from the servlet request. NOTE: All parameters are TRIMMED before being placed in the
   * Map. IF you require an untrimmed copy of the value, you will have to retrieve it MANUALLY from the Servlet request
   * object.
   *
   * @param request The Servlet request containing some parameters
   */
  protected Map<String, String> getParameters(HttpServletRequest request) {
    HashMap hmParams = new HashMap<String, String>();
    String paramName;
    String paramValue;

    // Get all available intialization parameters
    java.util.Enumeration e1 = getServletConfig().getInitParameterNames();
    for (; e1.hasMoreElements();) {
      // Get the name of the init parameter
      paramName = (String) e1.nextElement();

      // Get the value of the init parameter
      paramValue = getServletConfig().getInitParameter(paramName).trim();
      hmParams.put(paramName, paramValue);
    }


    //get all the parameters
    for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
      paramName = (String) e.nextElement();

      //THE TRIM AT THE END OF THIS LINE IS MANDATORY - DO NOT REMOVE !!!
      paramValue = request.getParameter(paramName).trim();
      hmParams.put(paramName, paramValue);
    }
    return hmParams;
  }

  /**
   * Obtains the context for the application server which is hosting the EJBs. Will change if webserver and application
   * server are separated.
   *
   * @return the application server context
   */
  protected Context getAppServerContext() throws NamingException {
    Context ctxt = new InitialContext();
    return ctxt;
  }

  /**
   * Forwards a client request to a given URL (this has been changed to redirect until forwarding has been tested
   * further)
   *
   * @param request Original request object
   * @param response Original response object
   * @param sURL Relative or absolute URL
   * @throws IOException
   * @throws ServletException
   * @throws XXPException
   */
  protected void forward(HttpServletRequest request, HttpServletResponse response, String sURL)
          throws XXPException {

    RequestDispatcher dispatcher = request.getRequestDispatcher(sURL);
    try {
      if (dispatcher != null) {
        dispatcher.forward(request, response);
      } else {
        throw new XXPException(AppMessages.E9001,
                "Request dispatcher could not be found, forward to " + sURL + " could not be performed");
      }
    } catch (Exception e) {
      throw new XXPException(AppMessages.E9001, e.getMessage());
    }
  }
}
