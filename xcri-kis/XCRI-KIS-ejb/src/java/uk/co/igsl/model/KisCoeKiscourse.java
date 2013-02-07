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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "KIS_COE_KISCOURSE")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KisCoeKiscourse.findAll", query = "SELECT k FROM KisCoeKiscourse k")})
public class KisCoeKiscourse implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "KISCOURSEID")
  private String kiscourseid;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "KISTYPE")
  private String kistype;
  @Size(max = 92)
  @Column(name = "RELATEDKIS_LS")
  private String relatedkisLs;
  @Size(max = 1024)
  @Column(name = "UKPRNAPPLY_LS")
  private String ukprnapplyLs;
  @Size(max = 38)
  @Column(name = "LDCS_LS")
  private String ldcsLs;
  @Size(max = 14)
  @Column(name = "JACS_LS")
  private String jacsLs;
  @Size(max = 255)
  @Column(name = "TITLE")
  private String title;
  @Size(max = 255)
  @Column(name = "TITLEW")
  private String titlew;
  @Size(max = 255)
  @Column(name = "CRSEURL")
  private String crseurl;
  @Size(max = 255)
  @Column(name = "CRSEURLW")
  private String crseurlw;
  @Size(max = 255)
  @Column(name = "SUPPORTURL")
  private String supporturl;
  @Size(max = 255)
  @Column(name = "SUPPORTURLW")
  private String supporturlw;
  @Size(max = 255)
  @Column(name = "EMPLOYURL")
  private String employurl;
  @Size(max = 255)
  @Column(name = "EMPLOYURLW")
  private String employurlw;
  @Size(max = 1)
  @Column(name = "NONCREDITASS")
  private String noncreditass;
  @Size(max = 255)
  @Column(name = "LTURL")
  private String lturl;
  @Size(max = 255)
  @Column(name = "LTURLW")
  private String lturlw;
  @Size(max = 255)
  @Column(name = "ASSURL")
  private String assurl;
  @Size(max = 255)
  @Column(name = "ASSURLW")
  private String assurlw;
  @Column(name = "KISKEY")
  private Integer kiskey;
  @Size(max = 4)
  @Column(name = "UCASCOURSEID")
  private String ucascourseid;
  @Size(max = 2)
  @Column(name = "VARFEE")
  private String varfee;
  @Size(max = 1)
  @Column(name = "FEETBC")
  private String feetbc;
  @Size(max = 1)
  @Column(name = "WAIVER")
  private String waiver;
  @Size(max = 1)
  @Column(name = "MEANSSUP")
  private String meanssup;
  @Size(max = 1)
  @Column(name = "OTHSUP")
  private String othsup;
  @Column(name = "ENGFEE")
  private Integer engfee;
  @Column(name = "NIFEE")
  private Integer nifee;
  @Column(name = "SCOTFEE")
  private Integer scotfee;
  @Column(name = "WAFEE")
  private Integer wafee;
  @Column(name = "WELSH")
  private Short welsh;
  @Size(max = 1)
  @Column(name = "COE_MODE")
  private String coeMode;
  @Size(max = 1)
  @Column(name = "COE_LEVEL")
  private String coeLevel;
  @Size(max = 11)
  @Column(name = "SBJ_LS")
  private String sbjLs;
  @Column(name = "AVGWRITTEN")
  private Short avgwritten;
  @Column(name = "AVGCOURSEWORK")
  private Short avgcoursework;
  @Column(name = "AVGSCHEDULED")
  private Short avgscheduled;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisComCommon> kisComCommonList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisTafTariff> kisTafTariffList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisConContinuation> kisConContinuationList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisAcnAccreditation> kisAcnAccreditationList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisSaySalary> kisSaySalaryList;
  @OneToMany(mappedBy = "kcoeId")
  private List<XxpCoeCourse> xxpCoeCourseList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisCseCoursestage> kisCseCoursestageList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisEnyEntry> kisEnyEntryList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisNssNss> kisNssNssList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisJteJobtype> kisJteJobtypeList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisNnsNhsnss> kisNnsNhsnssList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisEmtEmployment> kisEmtEmploymentList;
  @JoinColumn(name = "PRR_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false)
  private KisPrrProvider prrId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coeId")
  private List<KisDcsDegreeclass> kisDcsDegreeclassList;

  public KisCoeKiscourse() {
  }

  public KisCoeKiscourse(Long id) {
    this.id = id;
  }

  public KisCoeKiscourse(Long id, String kiscourseid, String kistype, Date lastUpdated, String lastUpdatedBy, long version) {
    this.id = id;
    this.kiscourseid = kiscourseid;
    this.kistype = kistype;
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

  public String getKiscourseid() {
    return kiscourseid;
  }

  public void setKiscourseid(String kiscourseid) {
    this.kiscourseid = kiscourseid;
  }

  public String getKistype() {
    return kistype;
  }

  public void setKistype(String kistype) {
    this.kistype = kistype;
  }

  public String getRelatedkisLs() {
    return relatedkisLs;
  }

  public void setRelatedkisLs(String relatedkisLs) {
    this.relatedkisLs = relatedkisLs;
  }

  public String getUkprnapplyLs() {
    return ukprnapplyLs;
  }

  public void setUkprnapplyLs(String ukprnapplyLs) {
    this.ukprnapplyLs = ukprnapplyLs;
  }

  public String getLdcsLs() {
    return ldcsLs;
  }

  public void setLdcsLs(String ldcsLs) {
    this.ldcsLs = ldcsLs;
  }

  public String getJacsLs() {
    return jacsLs;
  }

  public void setJacsLs(String jacsLs) {
    this.jacsLs = jacsLs;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitlew() {
    return titlew;
  }

  public void setTitlew(String titlew) {
    this.titlew = titlew;
  }

  public String getCrseurl() {
    return crseurl;
  }

  public void setCrseurl(String crseurl) {
    this.crseurl = crseurl;
  }

  public String getCrseurlw() {
    return crseurlw;
  }

  public void setCrseurlw(String crseurlw) {
    this.crseurlw = crseurlw;
  }

  public String getSupporturl() {
    return supporturl;
  }

  public void setSupporturl(String supporturl) {
    this.supporturl = supporturl;
  }

  public String getSupporturlw() {
    return supporturlw;
  }

  public void setSupporturlw(String supporturlw) {
    this.supporturlw = supporturlw;
  }

  public String getEmployurl() {
    return employurl;
  }

  public void setEmployurl(String employurl) {
    this.employurl = employurl;
  }

  public String getEmployurlw() {
    return employurlw;
  }

  public void setEmployurlw(String employurlw) {
    this.employurlw = employurlw;
  }

  public String getNoncreditass() {
    return noncreditass;
  }

  public void setNoncreditass(String noncreditass) {
    this.noncreditass = noncreditass;
  }

  public String getLturl() {
    return lturl;
  }

  public void setLturl(String lturl) {
    this.lturl = lturl;
  }

  public String getLturlw() {
    return lturlw;
  }

  public void setLturlw(String lturlw) {
    this.lturlw = lturlw;
  }

  public String getAssurl() {
    return assurl;
  }

  public void setAssurl(String assurl) {
    this.assurl = assurl;
  }

  public String getAssurlw() {
    return assurlw;
  }

  public void setAssurlw(String assurlw) {
    this.assurlw = assurlw;
  }

  public Integer getKiskey() {
    return kiskey;
  }

  public void setKiskey(Integer kiskey) {
    this.kiskey = kiskey;
  }

  public String getUcascourseid() {
    return ucascourseid;
  }

  public void setUcascourseid(String ucascourseid) {
    this.ucascourseid = ucascourseid;
  }

  public String getVarfee() {
    return varfee;
  }

  public void setVarfee(String varfee) {
    this.varfee = varfee;
  }

  public String getFeetbc() {
    return feetbc;
  }

  public void setFeetbc(String feetbc) {
    this.feetbc = feetbc;
  }

  public String getWaiver() {
    return waiver;
  }

  public void setWaiver(String waiver) {
    this.waiver = waiver;
  }

  public String getMeanssup() {
    return meanssup;
  }

  public void setMeanssup(String meanssup) {
    this.meanssup = meanssup;
  }

  public String getOthsup() {
    return othsup;
  }

  public void setOthsup(String othsup) {
    this.othsup = othsup;
  }

  public Integer getEngfee() {
    return engfee;
  }

  public void setEngfee(Integer engfee) {
    this.engfee = engfee;
  }

  public Integer getNifee() {
    return nifee;
  }

  public void setNifee(Integer nifee) {
    this.nifee = nifee;
  }

  public Integer getScotfee() {
    return scotfee;
  }

  public void setScotfee(Integer scotfee) {
    this.scotfee = scotfee;
  }

  public Integer getWafee() {
    return wafee;
  }

  public void setWafee(Integer wafee) {
    this.wafee = wafee;
  }

  public Short getWelsh() {
    return welsh;
  }

  public void setWelsh(Short welsh) {
    this.welsh = welsh;
  }

  public String getCoeMode() {
    return coeMode;
  }

  public void setCoeMode(String coeMode) {
    this.coeMode = coeMode;
  }

  public String getCoeLevel() {
    return coeLevel;
  }

  public void setCoeLevel(String coeLevel) {
    this.coeLevel = coeLevel;
  }

  public String getSbjLs() {
    return sbjLs;
  }

  public void setSbjLs(String sbjLs) {
    this.sbjLs = sbjLs;
  }

  public Short getAvgwritten() {
    return avgwritten;
  }

  public void setAvgwritten(Short avgwritten) {
    this.avgwritten = avgwritten;
  }

  public Short getAvgcoursework() {
    return avgcoursework;
  }

  public void setAvgcoursework(Short avgcoursework) {
    this.avgcoursework = avgcoursework;
  }

  public Short getAvgscheduled() {
    return avgscheduled;
  }

  public void setAvgscheduled(Short avgscheduled) {
    this.avgscheduled = avgscheduled;
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
  public List<KisComCommon> getKisComCommonList() {
    return kisComCommonList;
  }

  public void setKisComCommonList(List<KisComCommon> kisComCommonList) {
    this.kisComCommonList = kisComCommonList;
  }

  @XmlTransient
  public List<KisTafTariff> getKisTafTariffList() {
    return kisTafTariffList;
  }

  public void setKisTafTariffList(List<KisTafTariff> kisTafTariffList) {
    this.kisTafTariffList = kisTafTariffList;
  }

  @XmlTransient
  public List<KisConContinuation> getKisConContinuationList() {
    return kisConContinuationList;
  }

  public void setKisConContinuationList(List<KisConContinuation> kisConContinuationList) {
    this.kisConContinuationList = kisConContinuationList;
  }

  @XmlTransient
  public List<KisAcnAccreditation> getKisAcnAccreditationList() {
    return kisAcnAccreditationList;
  }

  public void setKisAcnAccreditationList(List<KisAcnAccreditation> kisAcnAccreditationList) {
    this.kisAcnAccreditationList = kisAcnAccreditationList;
  }

  @XmlTransient
  public List<KisSaySalary> getKisSaySalaryList() {
    return kisSaySalaryList;
  }

  public void setKisSaySalaryList(List<KisSaySalary> kisSaySalaryList) {
    this.kisSaySalaryList = kisSaySalaryList;
  }

  @XmlTransient
  public List<XxpCoeCourse> getXxpCoeCourseList() {
    return xxpCoeCourseList;
  }

  public void setXxpCoeCourseList(List<XxpCoeCourse> xxpCoeCourseList) {
    this.xxpCoeCourseList = xxpCoeCourseList;
  }

  @XmlTransient
  public List<KisCseCoursestage> getKisCseCoursestageList() {
    return kisCseCoursestageList;
  }

  public void setKisCseCoursestageList(List<KisCseCoursestage> kisCseCoursestageList) {
    this.kisCseCoursestageList = kisCseCoursestageList;
  }

  @XmlTransient
  public List<KisEnyEntry> getKisEnyEntryList() {
    return kisEnyEntryList;
  }

  public void setKisEnyEntryList(List<KisEnyEntry> kisEnyEntryList) {
    this.kisEnyEntryList = kisEnyEntryList;
  }

  @XmlTransient
  public List<KisNssNss> getKisNssNssList() {
    return kisNssNssList;
  }

  public void setKisNssNssList(List<KisNssNss> kisNssNssList) {
    this.kisNssNssList = kisNssNssList;
  }

  @XmlTransient
  public List<KisJteJobtype> getKisJteJobtypeList() {
    return kisJteJobtypeList;
  }

  public void setKisJteJobtypeList(List<KisJteJobtype> kisJteJobtypeList) {
    this.kisJteJobtypeList = kisJteJobtypeList;
  }

  @XmlTransient
  public List<KisNnsNhsnss> getKisNnsNhsnssList() {
    return kisNnsNhsnssList;
  }

  public void setKisNnsNhsnssList(List<KisNnsNhsnss> kisNnsNhsnssList) {
    this.kisNnsNhsnssList = kisNnsNhsnssList;
  }

  @XmlTransient
  public List<KisEmtEmployment> getKisEmtEmploymentList() {
    return kisEmtEmploymentList;
  }

  public void setKisEmtEmploymentList(List<KisEmtEmployment> kisEmtEmploymentList) {
    this.kisEmtEmploymentList = kisEmtEmploymentList;
  }

  public KisPrrProvider getPrrId() {
    return prrId;
  }

  public void setPrrId(KisPrrProvider prrId) {
    this.prrId = prrId;
  }

  @XmlTransient
  public List<KisDcsDegreeclass> getKisDcsDegreeclassList() {
    return kisDcsDegreeclassList;
  }

  public void setKisDcsDegreeclassList(List<KisDcsDegreeclass> kisDcsDegreeclassList) {
    this.kisDcsDegreeclassList = kisDcsDegreeclassList;
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
    if (!(object instanceof KisCoeKiscourse)) {
      return false;
    }
    KisCoeKiscourse other = (KisCoeKiscourse) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.KisCoeKiscourse[ id=" + id + " ]";
  }
  
}
