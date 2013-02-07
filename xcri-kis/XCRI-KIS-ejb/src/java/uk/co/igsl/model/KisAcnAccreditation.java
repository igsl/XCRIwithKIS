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
@Table(name = "KIS_ACN_ACCREDITATION")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisAcnAccreditation.findAll", query = "SELECT k FROM KisAcnAccreditation k")})
public class KisAcnAccreditation implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Size(max = 80)
  @Column(name = "ACCTYPE")
  private String acctype;
  @Size(max = 3)
  @Column(name = "ACCBODYID")
  private String accbodyid;
  @Size(max = 255)
  @Column(name = "ACCURL")
  private String accurl;
  @Size(max = 1)
  @Column(name = "ACCDEPEND")
  private String accdepend;
  @Size(max = 255)
  @Column(name = "ACCDEPENDURL")
  private String accdependurl;
  @Size(max = 255)
  @Column(name = "ACCDEPENDURLW")
  private String accdependurlw;
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

  public KisAcnAccreditation() {
  }

  public KisAcnAccreditation(Long id) {
    this.id = id;
  }

  public KisAcnAccreditation(Long id, Date lastUpdated, String lastUpdatedBy, long version) {
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

  public String getAcctype() {
    return acctype;
  }

  public void setAcctype(String acctype) {
    this.acctype = acctype;
  }

  public String getAccbodyid() {
    return accbodyid;
  }

  public void setAccbodyid(String accbodyid) {
    this.accbodyid = accbodyid;
  }

  public String getAccurl() {
    return accurl;
  }

  public void setAccurl(String accurl) {
    this.accurl = accurl;
  }

  public String getAccdepend() {
    return accdepend;
  }

  public void setAccdepend(String accdepend) {
    this.accdepend = accdepend;
  }

  public String getAccdependurl() {
    return accdependurl;
  }

  public void setAccdependurl(String accdependurl) {
    this.accdependurl = accdependurl;
  }

  public String getAccdependurlw() {
    return accdependurlw;
  }

  public void setAccdependurlw(String accdependurlw) {
    this.accdependurlw = accdependurlw;
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
    if (!(object instanceof KisAcnAccreditation)) {
      return false;
    }
    KisAcnAccreditation other = (KisAcnAccreditation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisAcnAccreditation[ id=" + id + " ]";
  }
  
}
