// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to core.clinical.CsPrimaryDiagnosis business object (ID: 1003100065).
 */
public class CSPrimaryDiagnosisForClinicalNotesVo extends ims.core.clinical.vo.CsPrimaryDiagnosisRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CSPrimaryDiagnosisForClinicalNotesVo()
	{
	}
	public CSPrimaryDiagnosisForClinicalNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public CSPrimaryDiagnosisForClinicalNotesVo(ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.diagnosis = bean.getDiagnosis() == null ? null : new ims.core.clinical.vo.PatientDiagnosisRefVo(new Integer(bean.getDiagnosis().getId()), bean.getDiagnosis().getVersion());
		this.isactive = bean.getIsActive();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.diagnosis = bean.getDiagnosis() == null ? null : new ims.core.clinical.vo.PatientDiagnosisRefVo(new Integer(bean.getDiagnosis().getId()), bean.getDiagnosis().getVersion());
		this.isactive = bean.getIsActive();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.clinical.vo.PatientDiagnosisRefVo getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.clinical.vo.PatientDiagnosisRefVo value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.diagnosis == null)
			listOfErrors.add("Diagnosis is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CSPrimaryDiagnosisForClinicalNotesVo clone = new CSPrimaryDiagnosisForClinicalNotesVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.carecontext = this.carecontext;
		clone.clinicalcontact = this.clinicalcontact;
		clone.diagnosis = this.diagnosis;
		clone.isactive = this.isactive;
		clone.episodeofcare = this.episodeofcare;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(CSPrimaryDiagnosisForClinicalNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CSPrimaryDiagnosisForClinicalNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CSPrimaryDiagnosisForClinicalNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CSPrimaryDiagnosisForClinicalNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.diagnosis != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.clinical.vo.PatientDiagnosisRefVo diagnosis;
	protected Boolean isactive;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
