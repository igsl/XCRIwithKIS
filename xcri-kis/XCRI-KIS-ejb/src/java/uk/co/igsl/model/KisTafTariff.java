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
@Table(name = "KIS_TAF_TARIFF")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisTafTariff.findAll", query = "SELECT k FROM KisTafTariff k")})
public class KisTafTariff implements Serializable {
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
  @Column(name = "T1")
  private Short t1;
  @Column(name = "T120")
  private Short t120;
  @Column(name = "T160")
  private Short t160;
  @Column(name = "T200")
  private Short t200;
  @Column(name = "T240")
  private Short t240;
  @Column(name = "T280")
  private Short t280;
  @Column(name = "T320")
  private Short t320;
  @Column(name = "T360")
  private Short t360;
  @Column(name = "T400")
  private Short t400;
  @Column(name = "T440")
  private Short t440;
  @Column(name = "T480")
  private Short t480;
  @Column(name = "T520")
  private Short t520;
  @Column(name = "T560")
  private Short t560;
  @Column(name = "T600")
  private Short t600;
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

  public KisTafTariff() {
  }

  public KisTafTariff(Long id) {
    this.id = id;
  }

  public KisTafTariff(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public Short getT1() {
    return t1;
  }

  public void setT1(Short t1) {
    this.t1 = t1;
  }

  public Short getT120() {
    return t120;
  }

  public void setT120(Short t120) {
    this.t120 = t120;
  }

  public Short getT160() {
    return t160;
  }

  public void setT160(Short t160) {
    this.t160 = t160;
  }

  public Short getT200() {
    return t200;
  }

  public void setT200(Short t200) {
    this.t200 = t200;
  }

  public Short getT240() {
    return t240;
  }

  public void setT240(Short t240) {
    this.t240 = t240;
  }

  public Short getT280() {
    return t280;
  }

  public void setT280(Short t280) {
    this.t280 = t280;
  }

  public Short getT320() {
    return t320;
  }

  public void setT320(Short t320) {
    this.t320 = t320;
  }

  public Short getT360() {
    return t360;
  }

  public void setT360(Short t360) {
    this.t360 = t360;
  }

  public Short getT400() {
    return t400;
  }

  public void setT400(Short t400) {
    this.t400 = t400;
  }

  public Short getT440() {
    return t440;
  }

  public void setT440(Short t440) {
    this.t440 = t440;
  }

  public Short getT480() {
    return t480;
  }

  public void setT480(Short t480) {
    this.t480 = t480;
  }

  public Short getT520() {
    return t520;
  }

  public void setT520(Short t520) {
    this.t520 = t520;
  }

  public Short getT560() {
    return t560;
  }

  public void setT560(Short t560) {
    this.t560 = t560;
  }

  public Short getT600() {
    return t600;
  }

  public void setT600(Short t600) {
    this.t600 = t600;
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
    if (!(object instanceof KisTafTariff)) {
      return false;
    }
    KisTafTariff other = (KisTafTariff) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisTafTariff[ id=" + id + " ]";
  }
  
}
