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
@Table(name = "KIS_SAY_SALARY")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisSaySalary.findAll", query = "SELECT k FROM KisSaySalary k")})
public class KisSaySalary implements Serializable {
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
  @Column(name = "LDLQ")
  private Integer ldlq;
  @Column(name = "LDMED")
  private Integer ldmed;
  @Column(name = "LDUQ")
  private Integer lduq;
  @Column(name = "LQ")
  private Integer lq;
  @Column(name = "MED")
  private Integer med;
  @Column(name = "UQ")
  private Integer uq;
  @Column(name = "INSTLQ")
  private Integer instlq;
  @Column(name = "INSTMED")
  private Integer instmed;
  @Column(name = "INSTUQ")
  private Integer instuq;
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

  public KisSaySalary() {
  }

  public KisSaySalary(Long id) {
    this.id = id;
  }

  public KisSaySalary(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Integer getLdlq() {
    return ldlq;
  }

  public void setLdlq(Integer ldlq) {
    this.ldlq = ldlq;
  }

  public Integer getLdmed() {
    return ldmed;
  }

  public void setLdmed(Integer ldmed) {
    this.ldmed = ldmed;
  }

  public Integer getLduq() {
    return lduq;
  }

  public void setLduq(Integer lduq) {
    this.lduq = lduq;
  }

  public Integer getLq() {
    return lq;
  }

  public void setLq(Integer lq) {
    this.lq = lq;
  }

  public Integer getMed() {
    return med;
  }

  public void setMed(Integer med) {
    this.med = med;
  }

  public Integer getUq() {
    return uq;
  }

  public void setUq(Integer uq) {
    this.uq = uq;
  }

  public Integer getInstlq() {
    return instlq;
  }

  public void setInstlq(Integer instlq) {
    this.instlq = instlq;
  }

  public Integer getInstmed() {
    return instmed;
  }

  public void setInstmed(Integer instmed) {
    this.instmed = instmed;
  }

  public Integer getInstuq() {
    return instuq;
  }

  public void setInstuq(Integer instuq) {
    this.instuq = instuq;
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
    if (!(object instanceof KisSaySalary)) {
      return false;
    }
    KisSaySalary other = (KisSaySalary) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisSaySalary[ id=" + id + " ]";
  }
  
}
