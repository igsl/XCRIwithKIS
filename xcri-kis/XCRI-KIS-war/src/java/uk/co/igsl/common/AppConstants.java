/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.common;

import java.io.File;

/**
 *
 * @author Tony
 */
public class AppConstants {

  /** Object in session parameter constants */
 // public static final String SEC_USER = "sec_user";
  public static final String SEC_KIS = "sec_kis_course";
  public static final String SEC_XXP = "sec_xxp_course";
  //public static final String SEC_KIS_REC = "sec_kis_recorders";
  public static final String SEC_XXP_REC = "sec_xxp_recorders";
  //public static final String SEC_OU_REC = "sec_ou_recorders";
  
   /** List of all Session Keys */
  // SEC_LANGUAGE is omitted as we wish to retain it even if user logs off
//  public static final String[] SEC_ALL =
//  { SEC_KIS, SEC_KIS_REC, SEC_OU_REC};
  
  public static final String FORM_COE_ID = "coe_id";
  public static final String FORM_COURSE_ID = "course_id";
  public static final String FORM_COURSE_WORK_CONDITION = "course_work_percent";
  public static final String FORM_WORK_STUDY_CONDITION = "work_study_percent";
  
  
  public static final String FORWARD = "/";
  public static final String CONTEXT_ROOT = "";

  public static final String REDIRECTION_WELCOME_PAGE = CONTEXT_ROOT + "search.jsp";
  
  public static final String PATH_ROOT = "";
  public static final String PATH_SEARCH  = PATH_ROOT + "search";  
  
  public static final String FORM_EQUAL = "=";
  public static final String FORM_AND = "&";
  public static final String JSP_PARAM_FUNCTION = "fn";
  public static final String PATH_FUNCTIONNAME = "?"+JSP_PARAM_FUNCTION+FORM_EQUAL;
  
  public static final String SUBMIT_SEARCH_ADVANCE = "search_advance";
  public static final String SUBMIT_VIEW_COE = "view_coe";
  public static final String SUBMIT_VIEW_XXP_COE = "view_xxp_coe";
  
  public static final String PATH_VIEW_COE   = PATH_SEARCH + PATH_FUNCTIONNAME + SUBMIT_VIEW_COE;
  public static final String PATH_VIEW_XXP_COE   = PATH_SEARCH + PATH_FUNCTIONNAME + SUBMIT_VIEW_XXP_COE;
  
}
