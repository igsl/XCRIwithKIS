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
@Table(name = "KIS_CSE_COURSESTAGE")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisCseCoursestage.findAll", query = "SELECT k FROM KisCseCoursestage k")})
public class KisCseCoursestage implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Column(name = "STAGE")
  private Short stage;
  @Size(max = 1)
  @Column(name = "ASSACT")
  private String assact;
  @Column(name = "COURSEWORK")
  private Short coursework;
  @Column(name = "WRITTEN")
  private Short written;
  @Column(name = "PRACTICAL")
  private Short practical;
  @Size(max = 1)
  @Column(name = "LTACT")
  private String ltact;
  @Column(name = "INDEPENDENT")
  private Short independent;
  @Column(name = "PLACEMENT")
  private Short placement;
  @Column(name = "SCHEDULED")
  private Short scheduled;
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

  public KisCseCoursestage() {
  }

  public KisCseCoursestage(Long id) {
    this.id = id;
  }

  public KisCseCoursestage(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Short getStage() {
    return stage;
  }

  public void setStage(Short stage) {
    this.stage = stage;
  }

  public String getAssact() {
    return assact;
  }

  public void setAssact(String assact) {
    this.assact = assact;
  }

  public Short getCoursework() {
    return coursework;
  }

  public void setCoursework(Short coursework) {
    this.coursework = coursework;
  }

  public Short getWritten() {
    return written;
  }

  public void setWritten(Short written) {
    this.written = written;
  }

  public Short getPractical() {
    return practical;
  }

  public void setPractical(Short practical) {
    this.practical = practical;
  }

  public String getLtact() {
    return ltact;
  }

  public void setLtact(String ltact) {
    this.ltact = ltact;
  }

  public Short getIndependent() {
    return independent;
  }

  public void setIndependent(Short independent) {
    this.independent = independent;
  }

  public Short getPlacement() {
    return placement;
  }

  public void setPlacement(Short placement) {
    this.placement = placement;
  }

  public Short getScheduled() {
    return scheduled;
  }

  public void setScheduled(Short scheduled) {
    this.scheduled = scheduled;
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
    if (!(object instanceof KisCseCoursestage)) {
      return false;
    }
    KisCseCoursestage other = (KisCseCoursestage) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisCseCoursestage[ id=" + id + " ]";
  }
  
}
