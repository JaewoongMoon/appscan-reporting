/**
 * @ Issue.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.model;

/**
 * <pre>
 * com.jwmoon.appscan.model
 * Issue.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
public class Issue {

    private String entityName; 
    private String fileId; 
    private String remediationTypeId; 
    private String entityType; 
    private String entityId; 
    private String issueTypeId; 
    private String severity; 
    private String state; 
    private String isManual; 
    private String defaultIp; 
    private String cvssAccessVector; 
    private String cvssAcessComplexity; 
    private String cvssAuthentication; 
    private String cvssConfidentialityImpact; 
    private String cvssIntegrityImpact; 
    private String cvssAvailabilityImpact; 
    private String cvssExploitability; 
    private String cvssRemediationLevel; 
    private String cvssReportConfidence; 
    private String cvssCollateralDamagePotential; 
    private String cvssTargetDistribution; 
    private String cvssConfidentialityRequirement; 
    private String cvssIntegrityRequirement; 
    private String cvssAvailabilityRequirement; 
    private String cvssIsManual;

    /**
     * Gets the value of entityName
     *
     * @return the value of entityName
     */
    public final String getEntityName() {
        return this.entityName;
    }

    /**
     * Sets the value of entityName
     *
     * @param argEntityName Value to assign to this.entityName
     */
    public final void setEntityName(final String argEntityName) {
        this.entityName = argEntityName;
    }

    /**
     * Gets the value of fileId
     *
     * @return the value of fileId
     */
    public final String getFileId() {
        return this.fileId;
    }

    /**
     * Sets the value of fileId
     *
     * @param argFileId Value to assign to this.fileId
     */
    public final void setFileId(final String argFileId) {
        this.fileId = argFileId;
    }

    /**
     * Gets the value of remediationTypeId
     *
     * @return the value of remediationTypeId
     */
    public final String getRemediationTypeId() {
        return this.remediationTypeId;
    }

    /**
     * Sets the value of remediationTypeId
     *
     * @param argRemediationTypeId Value to assign to this.remediationTypeId
     */
    public final void setRemediationTypeId(final String argRemediationTypeId) {
        this.remediationTypeId = argRemediationTypeId;
    }

    /**
     * Gets the value of entityType
     *
     * @return the value of entityType
     */
    public final String getEntityType() {
        return this.entityType;
    }

    /**
     * Sets the value of entityType
     *
     * @param argEntityType Value to assign to this.entityType
     */
    public final void setEntityType(final String argEntityType) {
        this.entityType = argEntityType;
    }

    /**
     * Gets the value of entityId
     *
     * @return the value of entityId
     */
    public final String getEntityId() {
        return this.entityId;
    }

    /**
     * Sets the value of entityId
     *
     * @param argEntityId Value to assign to this.entityId
     */
    public final void setEntityId(final String argEntityId) {
        this.entityId = argEntityId;
    }

    /**
     * Gets the value of issueTypeId
     *
     * @return the value of issueTypeId
     */
    public final String getIssueTypeId() {
        return this.issueTypeId;
    }

    /**
     * Sets the value of issueTypeId
     *
     * @param argIssueTypeId Value to assign to this.issueTypeId
     */
    public final void setIssueTypeId(final String argIssueTypeId) {
        this.issueTypeId = argIssueTypeId;
    }

    /**
     * Gets the value of severity
     *
     * @return the value of severity
     */
    public final String getSeverity() {
        return this.severity;
    }

    /**
     * Sets the value of severity
     *
     * @param argSeverity Value to assign to this.severity
     */
    public final void setSeverity(final String argSeverity) {
        this.severity = argSeverity;
    }

    /**
     * Gets the value of state
     *
     * @return the value of state
     */
    public final String getState() {
        return this.state;
    }

    /**
     * Sets the value of state
     *
     * @param argState Value to assign to this.state
     */
    public final void setState(final String argState) {
        this.state = argState;
    }

    /**
     * Gets the value of isManual
     *
     * @return the value of isManual
     */
    public final String getIsManual() {
        return this.isManual;
    }

    /**
     * Sets the value of isManual
     *
     * @param argIsManual Value to assign to this.isManual
     */
    public final void setIsManual(final String argIsManual) {
        this.isManual = argIsManual;
    }

    /**
     * Gets the value of defaultIp
     *
     * @return the value of defaultIp
     */
    public final String getDefaultIp() {
        return this.defaultIp;
    }

    /**
     * Sets the value of defaultIp
     *
     * @param argDefaultIp Value to assign to this.defaultIp
     */
    public final void setDefaultIp(final String argDefaultIp) {
        this.defaultIp = argDefaultIp;
    }

    /**
     * Gets the value of cvssAccessVector
     *
     * @return the value of cvssAccessVector
     */
    public final String getCvssAccessVector() {
        return this.cvssAccessVector;
    }

    /**
     * Sets the value of cvssAccessVector
     *
     * @param argCvssAccessVector Value to assign to this.cvssAccessVector
     */
    public final void setCvssAccessVector(final String argCvssAccessVector) {
        this.cvssAccessVector = argCvssAccessVector;
    }

    /**
     * Gets the value of cvssAcessComplexity
     *
     * @return the value of cvssAcessComplexity
     */
    public final String getCvssAcessComplexity() {
        return this.cvssAcessComplexity;
    }

    /**
     * Sets the value of cvssAcessComplexity
     *
     * @param argCvssAcessComplexity Value to assign to this.cvssAcessComplexity
     */
    public final void setCvssAcessComplexity(final String argCvssAcessComplexity) {
        this.cvssAcessComplexity = argCvssAcessComplexity;
    }

    /**
     * Gets the value of cvssAuthentication
     *
     * @return the value of cvssAuthentication
     */
    public final String getCvssAuthentication() {
        return this.cvssAuthentication;
    }

    /**
     * Sets the value of cvssAuthentication
     *
     * @param argCvssAuthentication Value to assign to this.cvssAuthentication
     */
    public final void setCvssAuthentication(final String argCvssAuthentication) {
        this.cvssAuthentication = argCvssAuthentication;
    }

    /**
     * Gets the value of cvssConfidentialityImpact
     *
     * @return the value of cvssConfidentialityImpact
     */
    public final String getCvssConfidentialityImpact() {
        return this.cvssConfidentialityImpact;
    }

    /**
     * Sets the value of cvssConfidentialityImpact
     *
     * @param argCvssConfidentialityImpact Value to assign to this.cvssConfidentialityImpact
     */
    public final void setCvssConfidentialityImpact(final String argCvssConfidentialityImpact) {
        this.cvssConfidentialityImpact = argCvssConfidentialityImpact;
    }

    /**
     * Gets the value of cvssIntegrityImpact
     *
     * @return the value of cvssIntegrityImpact
     */
    public final String getCvssIntegrityImpact() {
        return this.cvssIntegrityImpact;
    }

    /**
     * Sets the value of cvssIntegrityImpact
     *
     * @param argCvssIntegrityImpact Value to assign to this.cvssIntegrityImpact
     */
    public final void setCvssIntegrityImpact(final String argCvssIntegrityImpact) {
        this.cvssIntegrityImpact = argCvssIntegrityImpact;
    }

    /**
     * Gets the value of cvssAvailabilityImpact
     *
     * @return the value of cvssAvailabilityImpact
     */
    public final String getCvssAvailabilityImpact() {
        return this.cvssAvailabilityImpact;
    }

    /**
     * Sets the value of cvssAvailabilityImpact
     *
     * @param argCvssAvailabilityImpact Value to assign to this.cvssAvailabilityImpact
     */
    public final void setCvssAvailabilityImpact(final String argCvssAvailabilityImpact) {
        this.cvssAvailabilityImpact = argCvssAvailabilityImpact;
    }

    /**
     * Gets the value of cvssExploitability
     *
     * @return the value of cvssExploitability
     */
    public final String getCvssExploitability() {
        return this.cvssExploitability;
    }

    /**
     * Sets the value of cvssExploitability
     *
     * @param argCvssExploitability Value to assign to this.cvssExploitability
     */
    public final void setCvssExploitability(final String argCvssExploitability) {
        this.cvssExploitability = argCvssExploitability;
    }

    /**
     * Gets the value of cvssRemediationLevel
     *
     * @return the value of cvssRemediationLevel
     */
    public final String getCvssRemediationLevel() {
        return this.cvssRemediationLevel;
    }

    /**
     * Sets the value of cvssRemediationLevel
     *
     * @param argCvssRemediationLevel Value to assign to this.cvssRemediationLevel
     */
    public final void setCvssRemediationLevel(final String argCvssRemediationLevel) {
        this.cvssRemediationLevel = argCvssRemediationLevel;
    }

    /**
     * Gets the value of cvssReportConfidence
     *
     * @return the value of cvssReportConfidence
     */
    public final String getCvssReportConfidence() {
        return this.cvssReportConfidence;
    }

    /**
     * Sets the value of cvssReportConfidence
     *
     * @param argCvssReportConfidence Value to assign to this.cvssReportConfidence
     */
    public final void setCvssReportConfidence(final String argCvssReportConfidence) {
        this.cvssReportConfidence = argCvssReportConfidence;
    }

    /**
     * Gets the value of cvssCollateralDamagePotential
     *
     * @return the value of cvssCollateralDamagePotential
     */
    public final String getCvssCollateralDamagePotential() {
        return this.cvssCollateralDamagePotential;
    }

    /**
     * Sets the value of cvssCollateralDamagePotential
     *
     * @param argCvssCollateralDamagePotential Value to assign to this.cvssCollateralDamagePotential
     */
    public final void setCvssCollateralDamagePotential(final String argCvssCollateralDamagePotential) {
        this.cvssCollateralDamagePotential = argCvssCollateralDamagePotential;
    }

    /**
     * Gets the value of cvssTargetDistribution
     *
     * @return the value of cvssTargetDistribution
     */
    public final String getCvssTargetDistribution() {
        return this.cvssTargetDistribution;
    }

    /**
     * Sets the value of cvssTargetDistribution
     *
     * @param argCvssTargetDistribution Value to assign to this.cvssTargetDistribution
     */
    public final void setCvssTargetDistribution(final String argCvssTargetDistribution) {
        this.cvssTargetDistribution = argCvssTargetDistribution;
    }

    /**
     * Gets the value of cvssConfidentialityRequirement
     *
     * @return the value of cvssConfidentialityRequirement
     */
    public final String getCvssConfidentialityRequirement() {
        return this.cvssConfidentialityRequirement;
    }

    /**
     * Sets the value of cvssConfidentialityRequirement
     *
     * @param argCvssConfidentialityRequirement Value to assign to this.cvssConfidentialityRequirement
     */
    public final void setCvssConfidentialityRequirement(final String argCvssConfidentialityRequirement) {
        this.cvssConfidentialityRequirement = argCvssConfidentialityRequirement;
    }

    /**
     * Gets the value of cvssIntegrityRequirement
     *
     * @return the value of cvssIntegrityRequirement
     */
    public final String getCvssIntegrityRequirement() {
        return this.cvssIntegrityRequirement;
    }

    /**
     * Sets the value of cvssIntegrityRequirement
     *
     * @param argCvssIntegrityRequirement Value to assign to this.cvssIntegrityRequirement
     */
    public final void setCvssIntegrityRequirement(final String argCvssIntegrityRequirement) {
        this.cvssIntegrityRequirement = argCvssIntegrityRequirement;
    }

    /**
     * Gets the value of cvssAvailabilityRequirement
     *
     * @return the value of cvssAvailabilityRequirement
     */
    public final String getCvssAvailabilityRequirement() {
        return this.cvssAvailabilityRequirement;
    }

    /**
     * Sets the value of cvssAvailabilityRequirement
     *
     * @param argCvssAvailabilityRequirement Value to assign to this.cvssAvailabilityRequirement
     */
    public final void setCvssAvailabilityRequirement(final String argCvssAvailabilityRequirement) {
        this.cvssAvailabilityRequirement = argCvssAvailabilityRequirement;
    }

    /**
     * Gets the value of cvssIsManual
     *
     * @return the value of cvssIsManual
     */
    public final String getCvssIsManual() {
        return this.cvssIsManual;
    }

    /**
     * Sets the value of cvssIsManual
     *
     * @param argCvssIsManual Value to assign to this.cvssIsManual
     */
    public final void setCvssIsManual(final String argCvssIsManual) {
        this.cvssIsManual = argCvssIsManual;
    }
    
}
