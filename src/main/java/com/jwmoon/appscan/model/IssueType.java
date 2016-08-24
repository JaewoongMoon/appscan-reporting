/**
 * @ IssueType.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.model;

/**
 * <pre>
 * com.jwmoon.appscan.model
 * IssueType.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 28.
 */
public class IssueType {

	private String engineId;
	private String name;
	private String invasive;
	private String severity;
	private String threatClass;
	private String threatClassReference; 
	private String remediationTypeId;
	private String testType;
	private String shortName; 
	private String id;
	private String cveId; 
	private String cweId;
	
	public String getEngineId() {
		return engineId;
	}
	public void setEngineId(String engineId) {
		this.engineId = engineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInvasive() {
		return invasive;
	}
	public void setInvasive(String invasive) {
		this.invasive = invasive;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getThreatClass() {
		return threatClass;
	}
	public void setThreatClass(String threatClass) {
		this.threatClass = threatClass;
	}
	public String getThreatClassReference() {
		return threatClassReference;
	}
	public void setThreatClassReference(String threatClassReference) {
		this.threatClassReference = threatClassReference;
	}
	public String getRemediationTypeId() {
		return remediationTypeId;
	}
	public void setRemediationTypeId(String remediationTypeId) {
		this.remediationTypeId = remediationTypeId;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCveId() {
		return cveId;
	}
	public void setCveId(String cveId) {
		this.cveId = cveId;
	}
	public String getCweId() {
		return cweId;
	}
	public void setCweId(String cweId) {
		this.cweId = cweId;
	}
	
	
	
	
}
