/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tony
 */
@Entity
@Table(name = "KIS_NSS_NSS")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisNssNss.findAll", query = "SELECT k FROM KisNssNss k")})
public class KisNssNss implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Column(name = "POP")
  private Integer pop;
  @Size(max = 2)
  @Column(name = "AGG")
  private String agg;
  @Size(max = 3)
  @Column(name = "SBJ")
  private String sbj;
  @Column(name = "Q1")
  private Short q1;
  @Column(name = "Q2")
  private Short q2;
  @Column(name = "Q3")
  private Short q3;
  @Column(name = "Q4")
  private Short q4;
  @Column(name = "Q5")
  private Short q5;
  @Column(name = "Q6")
  private Short q6;
  @Column(name = "Q7")
  private Short q7;
  @Column(name = "Q8")
  private Short q8;
  @Column(name = "Q9")
  private Short q9;
  @Column(name = "Q10")
  private Short q10;
  @Column(name = "Q11")
  private Short q11;
  @Column(name = "Q12")
  private Short q12;
  @Column(name = "Q13")
  private Short q13;
  @Column(name = "Q14")
  private Short q14;
  @Column(name = "Q15")
  private Short q15;
  @Column(name = "Q16")
  private Short q16;
  @Column(name = "Q17")
  private Short q17;
  @Column(name = "Q18")
  private Short q18;
  @Column(name = "Q19")
  private Short q19;
  @Column(name = "Q20")
  private Short q20;
  @Column(name = "Q21")
  private Short q21;
  @Column(name = "Q22")
  private Short q22;
  @Basic(optional = false)
  @NotNull
  @Column(name = "LAST_UPDATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdated;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 64)
  @Column(name = "LAST_UPDATED_BY")
  private String lastUpdatedBy;
  @Basic(optional = false)
  @NotNull
  @Column(name = "VERSION")
  private long version;
  @JoinColumn(name = "COE_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false)
  private KisCoeKiscourse coeId;

  public KisNssNss() {
  }

  public KisNssNss(Long id) {
    this.id = id;
  }

  public KisNssNss(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
    this.id = id;
    this.lastUpdated = lastUpdated;
    this.lastUpdatedBy = lastUpdatedBy;
    this.version = version;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPop() {
    return pop;
  }

  public void setPop(Integer pop) {
    this.pop = pop;
  }

  public String getAgg() {
    return agg;
  }

  public void setAgg(String agg) {
    this.agg = agg;
  }

  public String getSbj() {
    return sbj;
  }

  public void setSbj(String sbj) {
    this.sbj = sbj;
  }

  public Short getQ1() {
    return q1;
  }

  public void setQ1(Short q1) {
    this.q1 = q1;
  }

  public Short getQ2() {
    return q2;
  }

  public void setQ2(Short q2) {
    this.q2 = q2;
  }

  public Short getQ3() {
    return q3;
  }

  public void setQ3(Short q3) {
    this.q3 = q3;
  }

  public Short getQ4() {
    return q4;
  }

  public void setQ4(Short q4) {
    this.q4 = q4;
  }

  public Short getQ5() {
    return q5;
  }

  public void setQ5(Short q5) {
    this.q5 = q5;
  }

  public Short getQ6() {
    return q6;
  }

  public void setQ6(Short q6) {
    this.q6 = q6;
  }

  public Short getQ7() {
    return q7;
  }

  public void setQ7(Short q7) {
    this.q7 = q7;
  }

  public Short getQ8() {
    return q8;
  }

  public void setQ8(Short q8) {
    this.q8 = q8;
  }

  public Short getQ9() {
    return q9;
  }

  public void setQ9(Short q9) {
    this.q9 = q9;
  }

  public Short getQ10() {
    return q10;
  }

  public void setQ10(Short q10) {
    this.q10 = q10;
  }

  public Short getQ11() {
    return q11;
  }

  public void setQ11(Short q11) {
    this.q11 = q11;
  }

  public Short getQ12() {
    return q12;
  }

  public void setQ12(Short q12) {
    this.q12 = q12;
  }

  public Short getQ13() {
    return q13;
  }

  public void setQ13(Short q13) {
    this.q13 = q13;
  }

  public Short getQ14() {
    return q14;
  }

  public void setQ14(Short q14) {
    this.q14 = q14;
  }

  public Short getQ15() {
    return q15;
  }

  public void setQ15(Short q15) {
    this.q15 = q15;
  }

  public Short getQ16() {
    return q16;
  }

  public void setQ16(Short q16) {
    this.q16 = q16;
  }

  public Short getQ17() {
    return q17;
  }

  public void setQ17(Short q17) {
    this.q17 = q17;
  }

  public Short getQ18() {
    return q18;
  }

  public void setQ18(Short q18) {
    this.q18 = q18;
  }

  public Short getQ19() {
    return q19;
  }

  public void setQ19(Short q19) {
    this.q19 = q19;
  }

  public Short getQ20() {
    return q20;
  }

  public void setQ20(Short q20) {
    this.q20 = q20;
  }

  public Short getQ21() {
    return q21;
  }

  public void setQ21(Short q21) {
    this.q21 = q21;
  }

  public Short getQ22() {
    return q22;
  }

  public void setQ22(Short q22) {
    this.q22 = q22;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  public KisCoeKiscourse getCoeId() {
    return coeId;
  }

  public void setCoeId(KisCoeKiscourse coeId) {
    this.coeId = coeId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof KisNssNss)) {
      return false;
    }
    KisNssNss other = (KisNssNss) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisNssNss[ id=" + id + " ]";
  }
  
}
