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
import javax.persistence.Lob;
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
@Table(name = "XXP_COE_COURSE")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "XxpCoeCourse.findAll", query = "SELECT x FROM XxpCoeCourse x"),
  @NamedQuery(name = "XxpCoeCourse.findByAdvance", query = "SELECT x FROM KisEmtEmployment e JOIN e.coeId c JOIN c.xxpCoeCourseList x WHERE UPPER(x.title) LIKE :title AND c.avgcoursework > :avgcoursework AND e.workstudy > :avgEmp"),
  @NamedQuery(name = "XxpCoeCourse.findLikeTitle", query = "SELECT x FROM XxpCoeCourse x WHERE x.kcoeId is not null AND UPPER(x.title) LIKE :title"),
  @NamedQuery(name = "XxpCoeCourse.findLikeTitleAvgcse", query = "SELECT x FROM KisCoeKiscourse c JOIN c.xxpCoeCourseList x WHERE x.kcoeId is not null AND UPPER(x.title) LIKE :title AND c.avgcoursework >= :avgcoursework"),
  @NamedQuery(name = "XxpCoeCourse.findLikeTitleEmp", query = "SELECT x FROM KisEmtEmployment e JOIN e.coeId c JOIN c.xxpCoeCourseList x WHERE x.kcoeId is not null AND UPPER(x.title) LIKE :title AND e.workstudy > :avgEmp")
})
public class XxpCoeCourse implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 128)
  @Column(name = "TITLE")
  private String title;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 128)
  @Column(name = "IDENTIFIER")
  private String identifier;
  @Size(max = 256)
  @Column(name = "URL")
  private String url;
  @Size(max = 256)
  @Column(name = "BOOKING_URL")
  private String bookingUrl;
  @Size(max = 128)
  @Column(name = "STUDY_HOURS")
  private String studyHours;
  @Size(max = 4000)
  @Column(name = "SUBJECT_KEYWORDS")
  private String subjectKeywords;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "STATUS")
  private String status;
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
  @Size(max = 64)
  @Column(name = "LAD_ID")
  private String ladId;
  @Size(max = 2048)
  @Column(name = "ASSESSMENT_STRATEGY")
  private String assessmentStrategy;
  @Size(max = 4000)
  @Column(name = "REQUIRED_RESOURCE")
  private String requiredResource;
  @Size(max = 4000)
  @Column(name = "OBJECTIVE")
  private String objective;
  @Size(max = 2048)
  @Column(name = "UCAS_TARIFF")
  private String ucasTariff;
  @Lob
  @Column(name = "XCRICAP")
  private String xcricap;
  @Size(max = 4000)
  @Column(name = "DESCRIPTION")
  private String description;
  @Size(max = 4000)
  @Column(name = "APPLICATION_PROCEDURE")
  private String applicationProcedure;
  @Size(max = 4000)
  @Column(name = "LEARNING_OUTCOME")
  private String learningOutcome;
  @Size(max = 256)
  @Column(name = "ABSTRACT")
  private String abstract1;
  @Size(max = 256)
  @Column(name = "CONTRIBUTOR")
  private String contributor;
  @Size(max = 8)
  @Column(name = "UCAS_COURSE_CODE")
  private String ucasCourseCode;
  @Size(max = 8)
  @Column(name = "UCAS_INSTITUTION_CODE")
  private String ucasInstitutionCode;
  @Size(max = 256)
  @Column(name = "JACS3")
  private String jacs3;
  @Size(max = 256)
  @Column(name = "LDCS")
  private String ldcs;
  @Size(max = 256)
  @Column(name = "SSAC")
  private String ssac;
  @Size(max = 64)
  @Column(name = "COURSE_TYPE")
  private String courseType;
  @Size(max = 4000)
  @Column(name = "DELIVERER")
  private String deliverer;
  @Size(max = 64)
  @Column(name = "INTERNAL_ID")
  private String internalId;
  @Size(max = 4000)
  @Column(name = "TARGET_AUDIENCE")
  private String targetAudience;
  @Size(max = 4000)
  @Column(name = "TOPIC")
  private String topic;
  @Size(max = 4000)
  @Column(name = "META_DATA")
  private String metaData;
  @Size(max = 4000)
  @Column(name = "BENEFIT")
  private String benefit;
  @Size(max = 4000)
  @Column(name = "REGULATIONS")
  private String regulations;
  @Size(max = 4000)
  @Column(name = "ACCREDITATION")
  private String accreditation;
  @Size(max = 4000)
  @Column(name = "PREREQUISITES")
  private String prerequisites;
  @Size(max = 4000)
  @Column(name = "SUMMARY")
  private String summary;
  @JoinColumn(name = "KCOE_ID", referencedColumnName = "ID")
  @ManyToOne
  private KisCoeKiscourse kcoeId;

  public XxpCoeCourse() {
  }

  public XxpCoeCourse(Long id) {
    this.id = id;
  }

  public XxpCoeCourse(Long id, String title, String identifier, String status, Date lastUpdated, String lastUpdatedBy, long version) {
    this.id = id;
    this.title = title;
    this.identifier = identifier;
    this.status = status;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBookingUrl() {
    return bookingUrl;
  }

  public void setBookingUrl(String bookingUrl) {
    this.bookingUrl = bookingUrl;
  }

  public String getStudyHours() {
    return studyHours;
  }

  public void setStudyHours(String studyHours) {
    this.studyHours = studyHours;
  }

  public String getSubjectKeywords() {
    return subjectKeywords;
  }

  public void setSubjectKeywords(String subjectKeywords) {
    this.subjectKeywords = subjectKeywords;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getLadId() {
    return ladId;
  }

  public void setLadId(String ladId) {
    this.ladId = ladId;
  }

  public String getAssessmentStrategy() {
    return assessmentStrategy;
  }

  public void setAssessmentStrategy(String assessmentStrategy) {
    this.assessmentStrategy = assessmentStrategy;
  }

  public String getRequiredResource() {
    return requiredResource;
  }

  public void setRequiredResource(String requiredResource) {
    this.requiredResource = requiredResource;
  }

  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public String getUcasTariff() {
    return ucasTariff;
  }

  public void setUcasTariff(String ucasTariff) {
    this.ucasTariff = ucasTariff;
  }

  public String getXcricap() {
    return xcricap;
  }

  public void setXcricap(String xcricap) {
    this.xcricap = xcricap;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getApplicationProcedure() {
    return applicationProcedure;
  }

  public void setApplicationProcedure(String applicationProcedure) {
    this.applicationProcedure = applicationProcedure;
  }

  public String getLearningOutcome() {
    return learningOutcome;
  }

  public void setLearningOutcome(String learningOutcome) {
    this.learningOutcome = learningOutcome;
  }

  public String getAbstract1() {
    return abstract1;
  }

  public void setAbstract1(String abstract1) {
    this.abstract1 = abstract1;
  }

  public String getContributor() {
    return contributor;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
  }

  public String getUcasCourseCode() {
    return ucasCourseCode;
  }

  public void setUcasCourseCode(String ucasCourseCode) {
    this.ucasCourseCode = ucasCourseCode;
  }

  public String getUcasInstitutionCode() {
    return ucasInstitutionCode;
  }

  public void setUcasInstitutionCode(String ucasInstitutionCode) {
    this.ucasInstitutionCode = ucasInstitutionCode;
  }

  public String getJacs3() {
    return jacs3;
  }

  public void setJacs3(String jacs3) {
    this.jacs3 = jacs3;
  }

  public String getLdcs() {
    return ldcs;
  }

  public void setLdcs(String ldcs) {
    this.ldcs = ldcs;
  }

  public String getSsac() {
    return ssac;
  }

  public void setSsac(String ssac) {
    this.ssac = ssac;
  }

  public String getCourseType() {
    return courseType;
  }

  public void setCourseType(String courseType) {
    this.courseType = courseType;
  }

  public String getDeliverer() {
    return deliverer;
  }

  public void setDeliverer(String deliverer) {
    this.deliverer = deliverer;
  }

  public String getInternalId() {
    return internalId;
  }

  public void setInternalId(String internalId) {
    this.internalId = internalId;
  }

  public String getTargetAudience() {
    return targetAudience;
  }

  public void setTargetAudience(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getMetaData() {
    return metaData;
  }

  public void setMetaData(String metaData) {
    this.metaData = metaData;
  }

  public String getBenefit() {
    return benefit;
  }

  public void setBenefit(String benefit) {
    this.benefit = benefit;
  }

  public String getRegulations() {
    return regulations;
  }

  public void setRegulations(String regulations) {
    this.regulations = regulations;
  }

  public String getAccreditation() {
    return accreditation;
  }

  public void setAccreditation(String accreditation) {
    this.accreditation = accreditation;
  }

  public String getPrerequisites() {
    return prerequisites;
  }

  public void setPrerequisites(String prerequisites) {
    this.prerequisites = prerequisites;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public KisCoeKiscourse getKcoeId() {
    return kcoeId;
  }

  public void setKcoeId(KisCoeKiscourse kcoeId) {
    this.kcoeId = kcoeId;
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
    if (!(object instanceof XxpCoeCourse)) {
      return false;
    }
    XxpCoeCourse other = (XxpCoeCourse) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "uk.co.igsl.model.XxpCoeCourse[ id=" + id + " ]";
  }
  
}
