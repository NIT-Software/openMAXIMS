// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ConsultationClinicalNotesVoBean extends ims.vo.ValueObjectBean
{
	public ConsultationClinicalNotesVoBean()
	{
	}
	public ConsultationClinicalNotesVoBean(ims.RefMan.vo.ConsultationClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean();
		this.lastupdatinghcp = vo.getLastUpdatingHCP() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getLastUpdatingHCP().getBean();
		this.initiallyseenby = vo.getInitiallySeenBy() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getInitiallySeenBy().getBean();
		this.historypresentingcomplaint = vo.getHistoryPresentingComplaint();
		this.relevantpmh = vo.getRelevantPMH();
		this.otherrelevanthistory = vo.getOtherRelevantHistory();
		this.relevantmedication = vo.getRelevantMedication();
		this.examination = vo.getExamination();
		this.hasnoknownallergies = vo.getHasNoKnownAllergies();
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.seescannednotes = vo.getSeeScannedNotes();
		this.notesdictated = vo.getNotesDictated();
		this.includenotesingpreport = vo.getIncludeNotesInGpReport();
		this.clinicalimpression = vo.getClinicalImpression();
		this.healthquestionnairecompleted = vo.getHealthQuestionnaireCompleted();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ConsultationClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean(map);
		this.lastupdatinghcp = vo.getLastUpdatingHCP() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getLastUpdatingHCP().getBean(map);
		this.initiallyseenby = vo.getInitiallySeenBy() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getInitiallySeenBy().getBean(map);
		this.historypresentingcomplaint = vo.getHistoryPresentingComplaint();
		this.relevantpmh = vo.getRelevantPMH();
		this.otherrelevanthistory = vo.getOtherRelevantHistory();
		this.relevantmedication = vo.getRelevantMedication();
		this.examination = vo.getExamination();
		this.hasnoknownallergies = vo.getHasNoKnownAllergies();
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.seescannednotes = vo.getSeeScannedNotes();
		this.notesdictated = vo.getNotesDictated();
		this.includenotesingpreport = vo.getIncludeNotesInGpReport();
		this.clinicalimpression = vo.getClinicalImpression();
		this.healthquestionnairecompleted = vo.getHealthQuestionnaireCompleted();
	}

	public ims.RefMan.vo.ConsultationClinicalNotesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ConsultationClinicalNotesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ConsultationClinicalNotesVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ConsultationClinicalNotesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ConsultationClinicalNotesVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.recordinginformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getLastUpdatingHCP()
	{
		return this.lastupdatinghcp;
	}
	public void setLastUpdatingHCP(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.lastupdatinghcp = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getInitiallySeenBy()
	{
		return this.initiallyseenby;
	}
	public void setInitiallySeenBy(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.initiallyseenby = value;
	}
	public String getHistoryPresentingComplaint()
	{
		return this.historypresentingcomplaint;
	}
	public void setHistoryPresentingComplaint(String value)
	{
		this.historypresentingcomplaint = value;
	}
	public String getRelevantPMH()
	{
		return this.relevantpmh;
	}
	public void setRelevantPMH(String value)
	{
		this.relevantpmh = value;
	}
	public String getOtherRelevantHistory()
	{
		return this.otherrelevanthistory;
	}
	public void setOtherRelevantHistory(String value)
	{
		this.otherrelevanthistory = value;
	}
	public String getRelevantMedication()
	{
		return this.relevantmedication;
	}
	public void setRelevantMedication(String value)
	{
		this.relevantmedication = value;
	}
	public String getExamination()
	{
		return this.examination;
	}
	public void setExamination(String value)
	{
		this.examination = value;
	}
	public Boolean getHasNoKnownAllergies()
	{
		return this.hasnoknownallergies;
	}
	public void setHasNoKnownAllergies(Boolean value)
	{
		this.hasnoknownallergies = value;
	}
	public ims.core.vo.beans.PatientAllergyBean[] getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.core.vo.beans.PatientAllergyBean[] value)
	{
		this.allergies = value;
	}
	public Boolean getSeeScannedNotes()
	{
		return this.seescannednotes;
	}
	public void setSeeScannedNotes(Boolean value)
	{
		this.seescannednotes = value;
	}
	public Boolean getNotesDictated()
	{
		return this.notesdictated;
	}
	public void setNotesDictated(Boolean value)
	{
		this.notesdictated = value;
	}
	public Boolean getIncludeNotesInGpReport()
	{
		return this.includenotesingpreport;
	}
	public void setIncludeNotesInGpReport(Boolean value)
	{
		this.includenotesingpreport = value;
	}
	public String getClinicalImpression()
	{
		return this.clinicalimpression;
	}
	public void setClinicalImpression(String value)
	{
		this.clinicalimpression = value;
	}
	public Boolean getHealthQuestionnaireCompleted()
	{
		return this.healthquestionnairecompleted;
	}
	public void setHealthQuestionnaireCompleted(Boolean value)
	{
		this.healthquestionnairecompleted = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.AuthoringInformationVoBean recordinginformation;
	private ims.core.vo.beans.AuthoringInformationVoBean lastupdatinghcp;
	private ims.core.vo.beans.AuthoringInformationVoBean initiallyseenby;
	private String historypresentingcomplaint;
	private String relevantpmh;
	private String otherrelevanthistory;
	private String relevantmedication;
	private String examination;
	private Boolean hasnoknownallergies;
	private ims.core.vo.beans.PatientAllergyBean[] allergies;
	private Boolean seescannednotes;
	private Boolean notesdictated;
	private Boolean includenotesingpreport;
	private String clinicalimpression;
	private Boolean healthquestionnairecompleted;
}
