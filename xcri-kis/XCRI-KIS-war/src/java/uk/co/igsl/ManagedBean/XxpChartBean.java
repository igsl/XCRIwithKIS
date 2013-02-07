/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.ManagedBean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import uk.co.igsl.common.AppConstants;
import uk.co.igsl.model.KisCoeKiscourse;
import uk.co.igsl.model.KisCseCoursestage;
import uk.co.igsl.model.KisEmtEmployment;
import uk.co.igsl.model.KisEnyEntry;
import uk.co.igsl.model.XxpCoeCourse;

/**
 *
 * @author Tony
 */
@Named(value = "xxpChartBean")
@RequestScoped
public class XxpChartBean {

  FacesContext context = null;
  HttpSession session = null;
  private CartesianChartModel courseStageModel;
  private PieChartModel empModel, enyModel;
  private XxpCoeCourse coe;

  /**
   * Creates a new instance of ChartBean
   */
  public XxpChartBean() {
    context = FacesContext.getCurrentInstance();
    session = (HttpSession) context.getExternalContext().getSession(false);
    coe = (XxpCoeCourse) session.getAttribute(AppConstants.SEC_XXP);
    createCategoryModel(coe.getKcoeId().getKisCseCoursestageList());
    // Need to check for empty list or more than one?
    createEmploymentModel(coe.getKcoeId().getKisEmtEmploymentList());
    createEntryModel(coe.getKcoeId().getKisEnyEntryList()); 
  }

  public XxpCoeCourse getCoe() {
    return coe;
  }

  public KisCoeKiscourse getKisCoe() {
    return coe.getKcoeId();
  }

  public CartesianChartModel getCourseStageModel() {
    return courseStageModel;
  }
  
  final static String year = "Year ";

  private void createCategoryModel(List<KisCseCoursestage> cseLs) {
    courseStageModel = new CartesianChartModel();
    if (cseLs.isEmpty()) {
      return;
    }
    // Set the 3 Category
    ChartSeries written = new ChartSeries();
    written.setLabel("% written exams");
    ChartSeries coursework = new ChartSeries();
    coursework.setLabel("% coursework");
    ChartSeries practical = new ChartSeries();
    practical.setLabel("% practical exams");

    int i = 1;//cseLs.size();
    for (KisCseCoursestage cse : cseLs) {
      written.set(year + i, cse.getWritten());
      coursework.set(year + i, cse.getCoursework());
      practical.set(year + i, cse.getPractical());
      i++;
    }
    courseStageModel.addSeries(practical);
    courseStageModel.addSeries(coursework);
    courseStageModel.addSeries(written);
  }
  final static String EMP_WORK6 = "Now working";
  final static String EMP_STUDY = "Doing further study";
  final static String EMP_BOTHWORKSTUDY = "Studying and working";
  final static String EMP_ASSUNEMP = "Unemployed";
  final static String EMP_NOAVAIL = "Other";

  private void createEmploymentModel(List<KisEmtEmployment> empLs) {

    empModel = new PieChartModel();
    KisEmtEmployment emp;
    if (empLs.isEmpty()) {
      return;
    } else {
      emp = empLs.get(0);
    }
    getEmpModel().set(EMP_WORK6, emp.getWork6());
    getEmpModel().set(EMP_STUDY, emp.getStudy());
    getEmpModel().set(EMP_BOTHWORKSTUDY, emp.getBothWorkstudy());
    getEmpModel().set(EMP_ASSUNEMP, emp.getAssunemp());
    getEmpModel().set(EMP_NOAVAIL, emp.getNoavail());
  }
  
  final static String ENY_ACCESS = "Completed Access Course";
  final static String ENY_ALEVEL = "A Levels/Scottish Advanced Highers";
  final static String ENY_BACC = "Baccalaureate";
  final static String ENY_DEGREE = "Degree or higher qualification";
  final static String ENY_DIPLOMA = "Diploma";
  final static String ENY_FOUNDATION = "Foundation course";
  final static String ENY_NOQUALS = "No prior qualifications";
  final static String ENY_OTHER = "BTEC National or equivalent qualification";
  final static String ENY_OTHERHE = "Different higher education qualification";

  private void createEntryModel(List<KisEnyEntry> enyLs) {
    enyModel = new PieChartModel();
    KisEnyEntry eny;
    if (enyLs.isEmpty()) {
      return;
    } else {
      eny = enyLs.get(0);
    }
    if (eny.getAccessCourse() > 0) {
      getEnyModel().set(ENY_ACCESS, eny.getAccessCourse());
    }
    if (eny.getAlevel() > 0) {
      getEnyModel().set(ENY_ALEVEL, eny.getAlevel());
    }
    if (eny.getBacc() > 0) {
      getEnyModel().set(ENY_BACC, eny.getBacc());
    }
    if (eny.getDegree() > 0) {
      getEnyModel().set(ENY_DEGREE, eny.getDegree());
    }
    if (eny.getDiploma() > 0) {
      getEnyModel().set(ENY_DIPLOMA, eny.getDiploma());
    }
    if (eny.getFoundation() > 0) {
      getEnyModel().set(ENY_FOUNDATION, eny.getFoundation());
    }
    if (eny.getNoquals() > 0) {
      getEnyModel().set(ENY_NOQUALS, eny.getNoquals());
    }
    if (eny.getOther() > 0) {
      getEnyModel().set(ENY_OTHER, eny.getOther());
    }
    if (eny.getOtherhe() > 0) {
      getEnyModel().set(ENY_OTHERHE, eny.getOtherhe());
    }
  }

  public String getDatatipFormat() {
    return "<span>Year&nbsp;%s</span>-<span style=\"padding:2px;\">%d%%</span>";
  }

  /**
   * @return the empModel
   */
  public PieChartModel getEmpModel() {
    return empModel;
  }

  /**
   * @return the empModel
   */
  public PieChartModel getEnyModel() {
    return enyModel;
  }

  public Short getEmpAvg() {
    if (coe.getKcoeId().getKisEmtEmploymentList().isEmpty()) {
      return 0;
    }
    return coe.getKcoeId().getKisEmtEmploymentList().get(0).getWorkstudy();
  }

  public Integer getEmpPop() {
    if (coe.getKcoeId().getKisEmtEmploymentList().isEmpty()) {
      return 0;
    }
    return coe.getKcoeId().getKisEmtEmploymentList().get(0).getPop();
  }

  public Integer getEnyPop() {
    if (coe.getKcoeId().getKisEnyEntryList().isEmpty()) {
      return 0;
    }
    return coe.getKcoeId().getKisEnyEntryList().get(0).getPop();
  }
  
}
