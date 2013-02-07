/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.co.igsl.common.AppConstants;
import uk.co.igsl.common.AppMessages;
import uk.co.igsl.common.XXPException;
import uk.co.igsl.model.XxpCoeCourse;
import uk.co.igsl.model.XxpCoeCourseFacade;

/**
 *
 * @author Tony
 */
public class SearchServlet extends SuperServlet {

  @EJB
  private XxpCoeCourseFacade xxpCoeSB;
  private static final String REDIRECTION_XXP_SEARCH_RESULT_PAGE = AppConstants.CONTEXT_ROOT + "xxpcourselist.jsp";
  private static final String REDIRECTION_SEARCH_PAGE = AppConstants.CONTEXT_ROOT + "search.jsp"; 
  private static final String REDIRECTION_VIEW_XXP_COURSE = AppConstants.CONTEXT_ROOT + "xxpcourse.jsf";
  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void processRequest(HttpServletRequest request,
          HttpServletResponse response) throws XXPException {
    Map<String, String> hmParams;
    String sNextPage;
    
    // Establish the Session
    HttpSession session = request.getSession(true);

    // Get all the parameters (uses superclass method)
    hmParams = getParameters(request);

    sNextPage = processKisRequest(hmParams, request, session);

    if (sNextPage == null) {
      throw new XXPException(AppMessages.E9001, "Page/Function not recognised in Search Servlet. "
              + (String) hmParams.get(AppConstants.JSP_PARAM_FUNCTION));
    }

    this.forward(request, response, sNextPage);
  }

  private String processKisRequest(Map<String, String> hmParams, HttpServletRequest request,
          HttpSession session) throws XXPException {

    String sNextPage;
    //Retrieve parameter representing required function.
    String sFunction = (String) hmParams.get(AppConstants.JSP_PARAM_FUNCTION);
    if (sFunction == null) {
      sNextPage = null;
    } else if (sFunction.equals(AppConstants.SUBMIT_SEARCH_ADVANCE)) {
      sNextPage = processAdvSearchCoe(hmParams, session);
    } else if (sFunction.equals(AppConstants.SUBMIT_VIEW_XXP_COE)) {
      sNextPage = processViewXxp(hmParams, session);
    } else {
      sNextPage = AppConstants.REDIRECTION_WELCOME_PAGE;
    }

    return sNextPage;
  }
  
   private String processAdvSearchCoe(Map<String, String> hmParams, HttpSession session) throws XXPException {
    try {
      String course_id = hmParams.get(AppConstants.FORM_COURSE_ID);
      if (null == course_id) {
        course_id = "";
      }
      String cse_s = hmParams.get(AppConstants.FORM_COURSE_WORK_CONDITION);
      String emp_s = hmParams.get(AppConstants.FORM_WORK_STUDY_CONDITION);
      int cse = Short.parseShort(cse_s);
      int emp = Short.parseShort(emp_s);
      List<XxpCoeCourse> o;
      o = xxpCoeSB.searchByAdvanced(course_id, cse, emp);
      session.setAttribute(AppConstants.SEC_XXP_REC, o);
      return REDIRECTION_XXP_SEARCH_RESULT_PAGE;
    } catch (EJBException ee) {
      throw new XXPException(AppMessages.E9001, ee);
    } catch (Exception e) {
      throw new XXPException(AppMessages.E9999, e);
    }
  }  

  private String processViewXxp(Map<String, String> hmParams, HttpSession session) throws XXPException {
    try {
      String course_id = hmParams.get(AppConstants.FORM_COE_ID);
      Long id;
      if (null == course_id) {
        return REDIRECTION_SEARCH_PAGE;
      } else {
        id = Long.parseLong(course_id);
      }
      List<XxpCoeCourse> o = (List<XxpCoeCourse>)session.getAttribute(AppConstants.SEC_XXP_REC);
      XxpCoeCourse selected = null;
      for (XxpCoeCourse coe: o) {
        if (coe.getId().longValue() == id.longValue()) {
          selected = coe;
          break;
        }
      }
      if (null == selected) {
        return REDIRECTION_SEARCH_PAGE;
      }
      session.setAttribute(AppConstants.SEC_XXP, selected);
      return REDIRECTION_VIEW_XXP_COURSE;
    } catch (EJBException ee) {
      throw new XXPException(AppMessages.E9001, ee);
    } catch (Exception e) {
      throw new XXPException(AppMessages.E9999, e);
    }
  }  
}
