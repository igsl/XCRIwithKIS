/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.igsl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tony
 */
@Entity
@Table(name = "KIS_PRR_PROVIDER")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisPrrProvider.findAll", query = "SELECT k FROM KisPrrProvider k")})
public class KisPrrProvider implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Size(max = 256)
  @Column(name = "ACCOMURL")
  private String accomurl;
  @Size(max = 256)
  @Column(name = "ACCOMURLW")
  private String accomurlw;
  @Column(name = "INSTBEDS")
  private Integer instbeds;
  @Column(name = "INSTLOWER")
  private Integer instlower;
  @Column(name = "INSTUPPER")
  private Integer instupper;
  @Column(name = "PRIVATELOWER")
  private Integer privatelower;
  @Column(name = "PRIVATEUPPER")
  private Integer privateupper;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "COUNTRY")
  private String country;
  @Size(max = 2)
  @Column(name = "NSP")
  private String nsp;
  @Column(name = "Q24")
  private Integer q24;
  @Column(name = "Q24POP")
  private Integer q24pop;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "prrId")
  private List<KisCoeKiscourse> kisCoeKiscourseList;

  public KisPrrProvider() {
  }

  public KisPrrProvider(Long id) {
    this.id = id;
  }

  public KisPrrProvider(Long id, String country, Date lastUpdated, String lastUpdatedBy, long version) {
    this.id = id;
    this.country = country;
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

  public String getAccomurl() {
    return accomurl;
  }

  public void setAccomurl(String accomurl) {
    this.accomurl = accomurl;
  }

  public String getAccomurlw() {
    return accomurlw;
  }

  public void setAccomurlw(String accomurlw) {
    this.accomurlw = accomurlw;
  }

  public Integer getInstbeds() {
    return instbeds;
  }

  public void setInstbeds(Integer instbeds) {
    this.instbeds = instbeds;
  }

  public Integer getInstlower() {
    return instlower;
  }

  public void setInstlower(Integer instlower) {
    this.instlower = instlower;
  }

  public Integer getInstupper() {
    return instupper;
  }

  public void setInstupper(Integer instupper) {
    this.instupper = instupper;
  }

  public Integer getPrivatelower() {
    return privatelower;
  }

  public void setPrivatelower(Integer privatelower) {
    this.privatelower = privatelower;
  }

  public Integer getPrivateupper() {
    return privateupper;
  }

  public void setPrivateupper(Integer privateupper) {
    this.privateupper = privateupper;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getNsp() {
    return nsp;
  }

  public void setNsp(String nsp) {
    this.nsp = nsp;
  }

  public Integer getQ24() {
    return q24;
  }

  public void setQ24(Integer q24) {
    this.q24 = q24;
  }

  public Integer getQ24pop() {
    return q24pop;
  }

  public void setQ24pop(Integer q24pop) {
    this.q24pop = q24pop;
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

  @XmlTransient
  public List<KisCoeKiscourse> getKisCoeKiscourseList() {
    return kisCoeKiscourseList;
  }

  public void setKisCoeKiscourseList(List<KisCoeKiscourse> kisCoeKiscourseList) {
    this.kisCoeKiscourseList = kisCoeKiscourseList;
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
    if (!(object instanceof KisPrrProvider)) {
      return false;
    }
    KisPrrProvider other = (KisPrrProvider) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisPrrProvider[ id=" + id + " ]";
  }
  
}
