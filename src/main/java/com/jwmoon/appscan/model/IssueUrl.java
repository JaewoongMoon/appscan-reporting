/**
 * @ IssueUrl.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.model;

/**
 * <pre>
 * com.jwmoon.appscan.model
 * IssueUrl.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 8.
 */
public class IssueUrl {
    private String id;
    private String fileName;
    private String parentId;
    private String nIssues; 
    private String nRemediations;
    private String nVariants;
    private String viewType;
    private String nVisitedLinks; 
    private String nFailedRequests;
    private String fullPath;

    /**
     * Gets the value of id
     *
     * @return the value of id
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Sets the value of id
     *
     * @param argId Value to assign to this.id
     */
    public final void setId(final String argId) {
        this.id = argId;
    }

    /**
     * Gets the value of fileName
     *
     * @return the value of fileName
     */
    public final String getFileName() {
        return this.fileName;
    }

    /**
     * Sets the value of fileName
     *
     * @param argFileName Value to assign to this.fileName
     */
    public final void setFileName(final String argFileName) {
        this.fileName = argFileName;
    }

    /**
     * Gets the value of parentId
     *
     * @return the value of parentId
     */
    public final String getParentId() {
        return this.parentId;
    }

    /**
     * Sets the value of parentId
     *
     * @param argParentId Value to assign to this.parentId
     */
    public final void setParentId(final String argParentId) {
        this.parentId = argParentId;
    }

    /**
     * Gets the value of nIssues
     *
     * @return the value of nIssues
     */
    public final String getNIssues() {
        return this.nIssues;
    }

    /**
     * Sets the value of nIssues
     *
     * @param argNIssues Value to assign to this.nIssues
     */
    public final void setNIssues(final String argNIssues) {
        this.nIssues = argNIssues;
    }

    /**
     * Gets the value of nRemediations
     *
     * @return the value of nRemediations
     */
    public final String getNRemediations() {
        return this.nRemediations;
    }

    /**
     * Sets the value of nRemediations
     *
     * @param argNRemediations Value to assign to this.nRemediations
     */
    public final void setNRemediations(final String argNRemediations) {
        this.nRemediations = argNRemediations;
    }

    /**
     * Gets the value of nVariants
     *
     * @return the value of nVariants
     */
    public final String getNVariants() {
        return this.nVariants;
    }

    /**
     * Sets the value of nVariants
     *
     * @param argNVariants Value to assign to this.nVariants
     */
    public final void setNVariants(final String argNVariants) {
        this.nVariants = argNVariants;
    }

    /**
     * Gets the value of viewType
     *
     * @return the value of viewType
     */
    public final String getViewType() {
        return this.viewType;
    }

    /**
     * Sets the value of viewType
     *
     * @param argViewType Value to assign to this.viewType
     */
    public final void setViewType(final String argViewType) {
        this.viewType = argViewType;
    }

    /**
     * Gets the value of nVisitedLinks
     *
     * @return the value of nVisitedLinks
     */
    public final String getNVisitedLinks() {
        return this.nVisitedLinks;
    }

    /**
     * Sets the value of nVisitedLinks
     *
     * @param argNVisitedLinks Value to assign to this.nVisitedLinks
     */
    public final void setNVisitedLinks(final String argNVisitedLinks) {
        this.nVisitedLinks = argNVisitedLinks;
    }

    /**
     * Gets the value of nFailedRequests
     *
     * @return the value of nFailedRequests
     */
    public final String getNFailedRequests() {
        return this.nFailedRequests;
    }

    /**
     * Sets the value of nFailedRequests
     *
     * @param argNFailedRequests Value to assign to this.nFailedRequests
     */
    public final void setNFailedRequests(final String argNFailedRequests) {
        this.nFailedRequests = argNFailedRequests;
    }

    /**
     * Gets the value of fullPath
     *
     * @return the value of fullPath
     */
    public final String getFullPath() {
        return this.fullPath;
    }

    /**
     * Sets the value of fullPath
     *
     * @param argFullPath Value to assign to this.fullPath
     */
    public final void setFullPath(final String argFullPath) {
        this.fullPath = argFullPath;
    }

}
