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
@Table(name = "KIS_NNS_NHSNSS")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisNnsNhsnss.findAll", query = "SELECT k FROM KisNnsNhsnss k")})
public class KisNnsNhsnss implements Serializable {
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
  @Column(name = "NHSQ1")
  private Short nhsq1;
  @Column(name = "NHSQ2")
  private Short nhsq2;
  @Column(name = "NHSQ3")
  private Short nhsq3;
  @Column(name = "NHSQ4")
  private Short nhsq4;
  @Column(name = "NHSQ5")
  private Short nhsq5;
  @Column(name = "NHSQ6")
  private Short nhsq6;
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

  public KisNnsNhsnss() {
  }

  public KisNnsNhsnss(Long id) {
    this.id = id;
  }

  public KisNnsNhsnss(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Short getNhsq1() {
    return nhsq1;
  }

  public void setNhsq1(Short nhsq1) {
    this.nhsq1 = nhsq1;
  }

  public Short getNhsq2() {
    return nhsq2;
  }

  public void setNhsq2(Short nhsq2) {
    this.nhsq2 = nhsq2;
  }

  public Short getNhsq3() {
    return nhsq3;
  }

  public void setNhsq3(Short nhsq3) {
    this.nhsq3 = nhsq3;
  }

  public Short getNhsq4() {
    return nhsq4;
  }

  public void setNhsq4(Short nhsq4) {
    this.nhsq4 = nhsq4;
  }

  public Short getNhsq5() {
    return nhsq5;
  }

  public void setNhsq5(Short nhsq5) {
    this.nhsq5 = nhsq5;
  }

  public Short getNhsq6() {
    return nhsq6;
  }

  public void setNhsq6(Short nhsq6) {
    this.nhsq6 = nhsq6;
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
    if (!(object instanceof KisNnsNhsnss)) {
      return false;
    }
    KisNnsNhsnss other = (KisNnsNhsnss) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisNnsNhsnss[ id=" + id + " ]";
  }
  
}
