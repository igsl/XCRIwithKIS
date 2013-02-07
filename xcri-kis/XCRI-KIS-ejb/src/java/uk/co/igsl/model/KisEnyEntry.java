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
@Table(name = "KIS_ENY_ENTRY")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisEnyEntry.findAll", query = "SELECT k FROM KisEnyEntry k")})
public class KisEnyEntry implements Serializable {
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
  @Column(name = "ACCESS_COURSE")
  private Short accessCourse;
  @Column(name = "ALEVEL")
  private Short alevel;
  @Column(name = "BACC")
  private Short bacc;
  @Column(name = "DEGREE")
  private Short degree;
  @Column(name = "DIPLOMA")
  private Short diploma;
  @Column(name = "FOUNDATION")
  private Short foundation;
  @Column(name = "NOQUALS")
  private Short noquals;
  @Column(name = "OTHER")
  private Short other;
  @Column(name = "OTHERHE")
  private Short otherhe;
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

  public KisEnyEntry() {
  }

  public KisEnyEntry(Long id) {
    this.id = id;
  }

  public KisEnyEntry(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Short getAccessCourse() {
    return accessCourse;
  }

  public void setAccessCourse(Short accessCourse) {
    this.accessCourse = accessCourse;
  }

  public Short getAlevel() {
    return alevel;
  }

  public void setAlevel(Short alevel) {
    this.alevel = alevel;
  }

  public Short getBacc() {
    return bacc;
  }

  public void setBacc(Short bacc) {
    this.bacc = bacc;
  }

  public Short getDegree() {
    return degree;
  }

  public void setDegree(Short degree) {
    this.degree = degree;
  }

  public Short getDiploma() {
    return diploma;
  }

  public void setDiploma(Short diploma) {
    this.diploma = diploma;
  }

  public Short getFoundation() {
    return foundation;
  }

  public void setFoundation(Short foundation) {
    this.foundation = foundation;
  }

  public Short getNoquals() {
    return noquals;
  }

  public void setNoquals(Short noquals) {
    this.noquals = noquals;
  }

  public Short getOther() {
    return other;
  }

  public void setOther(Short other) {
    this.other = other;
  }

  public Short getOtherhe() {
    return otherhe;
  }

  public void setOtherhe(Short otherhe) {
    this.otherhe = otherhe;
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
    if (!(object instanceof KisEnyEntry)) {
      return false;
    }
    KisEnyEntry other = (KisEnyEntry) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisEnyEntry[ id=" + id + " ]";
  }
  
}
