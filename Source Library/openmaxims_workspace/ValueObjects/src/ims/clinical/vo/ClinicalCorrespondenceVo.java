//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo;

/**
 * Linked to clinical.ClinicalCorrespondence business object (ID: 1072100040).
 */
public class ClinicalCorrespondenceVo extends ims.clinical.vo.ClinicalCorrespondenceLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalCorrespondenceVo()
	{
	}
	public ClinicalCorrespondenceVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalCorrespondenceVo(ims.clinical.vo.beans.ClinicalCorrespondenceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.verifyinghcp = bean.getVerifyingHCP() == null ? null : bean.getVerifyingHCP().buildVo();
		this.verifyingdatetime = bean.getVerifyingDateTime() == null ? null : bean.getVerifyingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.opdnotes = bean.getOPDNotes() == null ? null : bean.getOPDNotes().buildVo();
		this.hasobjectivenote = bean.getHasObjectiveNote();
		this.hasplannote = bean.getHasPlanNote();
		this.hasinstructionsnote = bean.getHasInstructionsNote();
		this.inpatientdischargesummary = bean.getInpatientDischargeSummary() == null ? null : bean.getInpatientDischargeSummary().buildVo();
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.ClinicalCorrespondenceType.buildLookup(bean.getType());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.recipients = ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection.buildFromBeanCollection(bean.getRecipients());
		this.statushistory = ims.clinical.vo.CorrespondenceStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.problems = ims.clinical.vo.CorrespondenceProblemVoCollection.buildFromBeanCollection(bean.getProblems());
		this.diagnosescomplications = ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection.buildFromBeanCollection(bean.getDiagnosesComplications());
		this.procedures = ims.clinical.vo.CorrespondenceProcedureVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.medication = bean.getMedication() == null ? null : new ims.clinical.vo.MedicationOverviewRefVo(new Integer(bean.getMedication().getId()), bean.getMedication().getVersion());
		this.primaryrecipient = bean.getPrimaryRecipient() == null ? null : bean.getPrimaryRecipient().buildVo();
		this.ruserverifyingdatetime = bean.getRUserVerifyingDateTime() == null ? null : bean.getRUserVerifyingDateTime().buildDateTime();
		this.ruserverifyinghcp = bean.getRUserVerifyingHCP() == null ? null : bean.getRUserVerifyingHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalCorrespondenceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.verifyinghcp = bean.getVerifyingHCP() == null ? null : bean.getVerifyingHCP().buildVo(map);
		this.verifyingdatetime = bean.getVerifyingDateTime() == null ? null : bean.getVerifyingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.opdnotes = bean.getOPDNotes() == null ? null : bean.getOPDNotes().buildVo(map);
		this.hasobjectivenote = bean.getHasObjectiveNote();
		this.hasplannote = bean.getHasPlanNote();
		this.hasinstructionsnote = bean.getHasInstructionsNote();
		this.inpatientdischargesummary = bean.getInpatientDischargeSummary() == null ? null : bean.getInpatientDischargeSummary().buildVo(map);
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.ClinicalCorrespondenceType.buildLookup(bean.getType());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.recipients = ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection.buildFromBeanCollection(bean.getRecipients());
		this.statushistory = ims.clinical.vo.CorrespondenceStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.problems = ims.clinical.vo.CorrespondenceProblemVoCollection.buildFromBeanCollection(bean.getProblems());
		this.diagnosescomplications = ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection.buildFromBeanCollection(bean.getDiagnosesComplications());
		this.procedures = ims.clinical.vo.CorrespondenceProcedureVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.medication = bean.getMedication() == null ? null : new ims.clinical.vo.MedicationOverviewRefVo(new Integer(bean.getMedication().getId()), bean.getMedication().getVersion());
		this.primaryrecipient = bean.getPrimaryRecipient() == null ? null : bean.getPrimaryRecipient().buildVo(map);
		this.ruserverifyingdatetime = bean.getRUserVerifyingDateTime() == null ? null : bean.getRUserVerifyingDateTime().buildDateTime();
		this.ruserverifyinghcp = bean.getRUserVerifyingHCP() == null ? null : bean.getRUserVerifyingHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalCorrespondenceVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalCorrespondenceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalCorrespondenceVoBean();
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
		if(fieldName.equals("RECIPIENTS"))
			return getRecipients();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("PROBLEMS"))
			return getProblems();
		if(fieldName.equals("DIAGNOSESCOMPLICATIONS"))
			return getDiagnosesComplications();
		if(fieldName.equals("PROCEDURES"))
			return getProcedures();
		if(fieldName.equals("MEDICATION"))
			return getMedication();
		if(fieldName.equals("PRIMARYRECIPIENT"))
			return getPrimaryRecipient();
		if(fieldName.equals("RUSERVERIFYINGDATETIME"))
			return getRUserVerifyingDateTime();
		if(fieldName.equals("RUSERVERIFYINGHCP"))
			return getRUserVerifyingHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRecipientsIsNotNull()
	{
		return this.recipients != null;
	}
	public ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection getRecipients()
	{
		return this.recipients;
	}
	public void setRecipients(ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection value)
	{
		this.isValidated = false;
		this.recipients = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.clinical.vo.CorrespondenceStatusVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.clinical.vo.CorrespondenceStatusVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getProblemsIsNotNull()
	{
		return this.problems != null;
	}
	public ims.clinical.vo.CorrespondenceProblemVoCollection getProblems()
	{
		return this.problems;
	}
	public void setProblems(ims.clinical.vo.CorrespondenceProblemVoCollection value)
	{
		this.isValidated = false;
		this.problems = value;
	}
	public boolean getDiagnosesComplicationsIsNotNull()
	{
		return this.diagnosescomplications != null;
	}
	public ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection getDiagnosesComplications()
	{
		return this.diagnosescomplications;
	}
	public void setDiagnosesComplications(ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection value)
	{
		this.isValidated = false;
		this.diagnosescomplications = value;
	}
	public boolean getProceduresIsNotNull()
	{
		return this.procedures != null;
	}
	public ims.clinical.vo.CorrespondenceProcedureVoCollection getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.clinical.vo.CorrespondenceProcedureVoCollection value)
	{
		this.isValidated = false;
		this.procedures = value;
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public ims.clinical.vo.MedicationOverviewRefVo getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.clinical.vo.MedicationOverviewRefVo value)
	{
		this.isValidated = false;
		this.medication = value;
	}
	public boolean getPrimaryRecipientIsNotNull()
	{
		return this.primaryrecipient != null;
	}
	public ims.clinical.vo.ClinicalCorrespondenceRecipientsVo getPrimaryRecipient()
	{
		return this.primaryrecipient;
	}
	public void setPrimaryRecipient(ims.clinical.vo.ClinicalCorrespondenceRecipientsVo value)
	{
		this.isValidated = false;
		this.primaryrecipient = value;
	}
	public boolean getRUserVerifyingDateTimeIsNotNull()
	{
		return this.ruserverifyingdatetime != null;
	}
	public ims.framework.utils.DateTime getRUserVerifyingDateTime()
	{
		return this.ruserverifyingdatetime;
	}
	public void setRUserVerifyingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.ruserverifyingdatetime = value;
	}
	public boolean getRUserVerifyingHCPIsNotNull()
	{
		return this.ruserverifyinghcp != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getRUserVerifyingHCP()
	{
		return this.ruserverifyinghcp;
	}
	public void setRUserVerifyingHCP(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.ruserverifyinghcp = value;
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
		if(this.verifyinghcp != null)
		{
			if(!this.verifyinghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.opdnotes != null)
		{
			if(!this.opdnotes.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.inpatientdischargesummary != null)
		{
			if(!this.inpatientdischargesummary.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.recipients != null)
		{
			if(!this.recipients.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.problems != null)
		{
			if(!this.problems.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.diagnosescomplications != null)
		{
			if(!this.diagnosescomplications.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.procedures != null)
		{
			if(!this.procedures.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.primaryrecipient != null)
		{
			if(!this.primaryrecipient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ruserverifyinghcp != null)
		{
			if(!this.ruserverifyinghcp.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.verifyinghcp != null)
		{
			String[] listOfOtherErrors = this.verifyinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.opdnotes != null)
		{
			String[] listOfOtherErrors = this.opdnotes.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.inpatientdischargesummary != null)
		{
			String[] listOfOtherErrors = this.inpatientdischargesummary.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
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
		if(this.recipients == null || this.recipients.size() == 0)
			listOfErrors.add("Recipients collection cannot be null.");
		if(this.recipients != null)
		{
			String[] listOfOtherErrors = this.recipients.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.problems != null)
		{
			String[] listOfOtherErrors = this.problems.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.diagnosescomplications != null)
		{
			String[] listOfOtherErrors = this.diagnosescomplications.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.procedures != null)
		{
			String[] listOfOtherErrors = this.procedures.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.primaryrecipient == null)
			listOfErrors.add("PrimaryRecipient is mandatory");
		if(this.primaryrecipient != null)
		{
			String[] listOfOtherErrors = this.primaryrecipient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ruserverifyinghcp != null)
		{
			String[] listOfOtherErrors = this.ruserverifyinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		ClinicalCorrespondenceVo clone = new ClinicalCorrespondenceVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextListVo)this.carecontext.clone();
		if(this.verifyinghcp == null)
			clone.verifyinghcp = null;
		else
			clone.verifyinghcp = (ims.core.vo.HcpLiteVo)this.verifyinghcp.clone();
		if(this.verifyingdatetime == null)
			clone.verifyingdatetime = null;
		else
			clone.verifyingdatetime = (ims.framework.utils.DateTime)this.verifyingdatetime.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.clinical.vo.CorrespondenceStatusVo)this.currentstatus.clone();
		if(this.opdnotes == null)
			clone.opdnotes = null;
		else
			clone.opdnotes = (ims.clinical.vo.OutpatientNotesOutcomeVo)this.opdnotes.clone();
		clone.hasobjectivenote = this.hasobjectivenote;
		clone.hasplannote = this.hasplannote;
		clone.hasinstructionsnote = this.hasinstructionsnote;
		if(this.inpatientdischargesummary == null)
			clone.inpatientdischargesummary = null;
		else
			clone.inpatientdischargesummary = (ims.clinical.vo.InpatientDischargeNoteFollowupVo)this.inpatientdischargesummary.clone();
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.clinical.vo.lookups.ClinicalCorrespondenceType)this.type.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeofCareShortVo)this.episodeofcare.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.recipients == null)
			clone.recipients = null;
		else
			clone.recipients = (ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection)this.recipients.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.clinical.vo.CorrespondenceStatusVoCollection)this.statushistory.clone();
		if(this.problems == null)
			clone.problems = null;
		else
			clone.problems = (ims.clinical.vo.CorrespondenceProblemVoCollection)this.problems.clone();
		if(this.diagnosescomplications == null)
			clone.diagnosescomplications = null;
		else
			clone.diagnosescomplications = (ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection)this.diagnosescomplications.clone();
		if(this.procedures == null)
			clone.procedures = null;
		else
			clone.procedures = (ims.clinical.vo.CorrespondenceProcedureVoCollection)this.procedures.clone();
		clone.medication = this.medication;
		if(this.primaryrecipient == null)
			clone.primaryrecipient = null;
		else
			clone.primaryrecipient = (ims.clinical.vo.ClinicalCorrespondenceRecipientsVo)this.primaryrecipient.clone();
		if(this.ruserverifyingdatetime == null)
			clone.ruserverifyingdatetime = null;
		else
			clone.ruserverifyingdatetime = (ims.framework.utils.DateTime)this.ruserverifyingdatetime.clone();
		if(this.ruserverifyinghcp == null)
			clone.ruserverifyinghcp = null;
		else
			clone.ruserverifyinghcp = (ims.core.vo.MemberOfStaffLiteVo)this.ruserverifyinghcp.clone();
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
		if (!(ClinicalCorrespondenceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalCorrespondenceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalCorrespondenceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalCorrespondenceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.recipients != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.problems != null)
			count++;
		if(this.diagnosescomplications != null)
			count++;
		if(this.procedures != null)
			count++;
		if(this.medication != null)
			count++;
		if(this.primaryrecipient != null)
			count++;
		if(this.ruserverifyingdatetime != null)
			count++;
		if(this.ruserverifyinghcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.clinical.vo.ClinicalCorrespondenceRecipientsVoCollection recipients;
	protected ims.clinical.vo.CorrespondenceStatusVoCollection statushistory;
	protected ims.clinical.vo.CorrespondenceProblemVoCollection problems;
	protected ims.clinical.vo.CorrespondenceDiagnosisCompVoCollection diagnosescomplications;
	protected ims.clinical.vo.CorrespondenceProcedureVoCollection procedures;
	protected ims.clinical.vo.MedicationOverviewRefVo medication;
	protected ims.clinical.vo.ClinicalCorrespondenceRecipientsVo primaryrecipient;
	protected ims.framework.utils.DateTime ruserverifyingdatetime;
	protected ims.core.vo.MemberOfStaffLiteVo ruserverifyinghcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
