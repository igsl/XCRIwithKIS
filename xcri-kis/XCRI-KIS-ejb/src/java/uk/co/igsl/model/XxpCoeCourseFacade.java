/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tony
 */
@Stateless
public class XxpCoeCourseFacade extends AbstractFacade<XxpCoeCourse> {

  @PersistenceContext(unitName = "XCRI-KIS-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public XxpCoeCourseFacade() {
    super(XxpCoeCourse.class);
  }

  public List<XxpCoeCourse> searchByAdvanced(String id, int cse, int emp) {
    if ((id.isEmpty()) && (cse <= 0) && (emp <= 0)) {
      return new ArrayList<XxpCoeCourse>();
    }

    if (id.isEmpty()) {
      id = "%%";
    } else {
      id = "%" + id.toUpperCase() + "%";
    }

    if ((cse <= 0) && (emp <= 0)) {
      return getXxpCoeCourseFindLikeTitle(id);
    } else if (cse <= 0) {
      return getXxpCoeCourseFindLikeTitleEmp(id, emp);
    } else if (emp <= 0) {
      return getXxpCoeCourseFindLikeTitleAvgcse(id, cse);
    } else {
      return getXxpCoeCourseFindByAdvance(id, cse, emp);
    }
  }

  private List<XxpCoeCourse> getXxpCoeCourseFindLikeTitle(String keyword) {
    return em.createNamedQuery("XxpCoeCourse.findLikeTitle").setParameter("title", keyword).getResultList();
  }

  private List<XxpCoeCourse> getXxpCoeCourseFindLikeTitleAvgcse(String keyword, int avgcoursework) {
    List<XxpCoeCourse> tmpLs = em.createNamedQuery("XxpCoeCourse.findLikeTitleAvgcse").setParameter("title", keyword).setParameter("avgcoursework", avgcoursework).getResultList();
    return tmpLs;
  }

  private List<XxpCoeCourse> getXxpCoeCourseFindLikeTitleEmp(String keyword, int avgEmp) {
    List<XxpCoeCourse> tmpLs = em.createNamedQuery("XxpCoeCourse.findLikeTitleEmp").setParameter("title", keyword).setParameter("avgEmp", avgEmp).getResultList();
    return tmpLs;
  }

  private List<XxpCoeCourse> getXxpCoeCourseFindByAdvance(String keyword, int avgcoursework, int avgEmp) {
    List<XxpCoeCourse> tmpLs = em.createNamedQuery("XxpCoeCourse.findByAdvance").setParameter("title", keyword).setParameter("avgcoursework", avgcoursework).setParameter("avgEmp", avgEmp).getResultList();
    return tmpLs;
  }

}
