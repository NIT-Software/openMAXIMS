// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class CorrespondenceNoteVoBean extends ims.vo.ValueObjectBean
{
	public CorrespondenceNoteVoBean()
	{
	}
	public CorrespondenceNoteVoBean(ims.RefMan.vo.CorrespondenceNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean();
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.reportnote = vo.getReportNote();
		this.notestatus = vo.getNoteStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteStatus().getBean();
		this.copytogp = vo.getCopyToGP();
		this.copytopatient = vo.getCopyToPatient();
		this.copytosecondarycare = vo.getCopyToSecondaryCare();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CorrespondenceNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean(map);
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.reportnote = vo.getReportNote();
		this.notestatus = vo.getNoteStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteStatus().getBean();
		this.copytogp = vo.getCopyToGP();
		this.copytopatient = vo.getCopyToPatient();
		this.copytosecondarycare = vo.getCopyToSecondaryCare();
	}

	public ims.RefMan.vo.CorrespondenceNoteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CorrespondenceNoteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CorrespondenceNoteVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CorrespondenceNoteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CorrespondenceNoteVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.recordinginformation = value;
	}
	public ims.vo.LookupInstanceBean getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.vo.LookupInstanceBean value)
	{
		this.notetype = value;
	}
	public String getReportNote()
	{
		return this.reportnote;
	}
	public void setReportNote(String value)
	{
		this.reportnote = value;
	}
	public ims.vo.LookupInstanceBean getNoteStatus()
	{
		return this.notestatus;
	}
	public void setNoteStatus(ims.vo.LookupInstanceBean value)
	{
		this.notestatus = value;
	}
	public Boolean getCopyToGP()
	{
		return this.copytogp;
	}
	public void setCopyToGP(Boolean value)
	{
		this.copytogp = value;
	}
	public Boolean getCopyToPatient()
	{
		return this.copytopatient;
	}
	public void setCopyToPatient(Boolean value)
	{
		this.copytopatient = value;
	}
	public Boolean getCopyToSecondaryCare()
	{
		return this.copytosecondarycare;
	}
	public void setCopyToSecondaryCare(Boolean value)
	{
		this.copytosecondarycare = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean recordinginformation;
	private ims.vo.LookupInstanceBean notetype;
	private String reportnote;
	private ims.vo.LookupInstanceBean notestatus;
	private Boolean copytogp;
	private Boolean copytopatient;
	private Boolean copytosecondarycare;
}
