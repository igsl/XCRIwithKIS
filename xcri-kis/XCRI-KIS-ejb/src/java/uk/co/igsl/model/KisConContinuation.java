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
@Table(name = "KIS_CON_CONTINUATION")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisConContinuation.findAll", query = "SELECT k FROM KisConContinuation k")})
public class KisConContinuation implements Serializable {
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
  @Column(name = "UCONT")
  private Short ucont;
  @Column(name = "UDORMANT")
  private Short udormant;
  @Column(name = "UGAINED")
  private Short ugained;
  @Column(name = "ULEFT")
  private Short uleft;
  @Column(name = "ULOWER")
  private Short ulower;
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

  public KisConContinuation() {
  }

  public KisConContinuation(Long id) {
    this.id = id;
  }

  public KisConContinuation(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Short getUcont() {
    return ucont;
  }

  public void setUcont(Short ucont) {
    this.ucont = ucont;
  }

  public Short getUdormant() {
    return udormant;
  }

  public void setUdormant(Short udormant) {
    this.udormant = udormant;
  }

  public Short getUgained() {
    return ugained;
  }

  public void setUgained(Short ugained) {
    this.ugained = ugained;
  }

  public Short getUleft() {
    return uleft;
  }

  public void setUleft(Short uleft) {
    this.uleft = uleft;
  }

  public Short getUlower() {
    return ulower;
  }

  public void setUlower(Short ulower) {
    this.ulower = ulower;
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
    if (!(object instanceof KisConContinuation)) {
      return false;
    }
    KisConContinuation other = (KisConContinuation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisConContinuation[ id=" + id + " ]";
  }
  
}
