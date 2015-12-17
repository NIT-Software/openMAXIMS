//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.oncology.vo;

/**
 * Linked to Oncology.RadiotherapyDetails business object (ID: 1074100003).
 */
public class RadiotherapyDetailsVo extends ims.oncology.vo.RadiotherapyDetailsShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RadiotherapyDetailsVo()
	{
	}
	public RadiotherapyDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public RadiotherapyDetailsVo(ims.oncology.vo.beans.RadiotherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.radiotherapytype = bean.getRadiotherapyType() == null ? null : ims.oncology.vo.lookups.RadiotherapyType.buildLookup(bean.getRadiotherapyType());
		// Interface field type not supported.
		this.treatementintent = bean.getTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getTreatementIntent());
		this.anatomicaltreatmentsite = bean.getAnatomicalTreatmentSite() == null ? null : ims.oncology.vo.lookups.AnatomicalTreatmentSite.buildLookup(bean.getAnatomicalTreatmentSite());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.prescribeddose = bean.getPrescribedDose();
		this.prescribedfractions = bean.getPrescribedFractions();
		this.prescribedduration = bean.getPrescribedDuration();
		this.teletherapydetails = bean.getTeletherapyDetails() == null ? null : bean.getTeletherapyDetails().buildVo();
		this.brachytherapydetails = bean.getBrachytherapyDetails() == null ? null : bean.getBrachytherapyDetails().buildVo();
		this.treatmentcoursestatus = bean.getTreatmentCourseStatus() == null ? null : ims.oncology.vo.lookups.TreatmentCourseStatus.buildLookup(bean.getTreatmentCourseStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.treatinghospital = bean.getTreatingHospital() == null ? null : ims.oncology.vo.lookups.TreatmentHospital.buildLookup(bean.getTreatingHospital());
		this.performancestatusatddt = bean.getPerformanceStatusAtDDT() == null ? null : ims.medicaloncology.vo.lookups.PerformanceStatus.buildLookup(bean.getPerformanceStatusAtDDT());
		this.concurrentchemotherapy = bean.getConcurrentChemotherapy() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConcurrentChemotherapy());
		this.treatmentcategory = bean.getTreatmentCategory();
		this.diseasestatus = bean.getDiseaseStatus() == null ? null : ims.oncology.vo.lookups.DiseaseStatus.buildLookup(bean.getDiseaseStatus());
		this.diseasetreatment = bean.getDiseaseTreatment() == null ? null : ims.oncology.vo.lookups.DiseaseStatus.buildLookup(bean.getDiseaseTreatment());
		this.reasondelay1 = bean.getReasonDelay1() == null ? null : ims.oncology.vo.lookups.RadiotherapyDelayReason.buildLookup(bean.getReasonDelay1());
		this.reasondelay2 = bean.getReasonDelay2() == null ? null : ims.oncology.vo.lookups.RadiotherapyDelayReason.buildLookup(bean.getReasonDelay2());
		this.prescribinghcp = bean.getPrescribingHCP() == null ? null : bean.getPrescribingHCP().buildVo();
		this.prescribeddate = bean.getPrescribedDate() == null ? null : bean.getPrescribedDate().buildDate();
		this.associatedtreatmentplanaction = bean.getAssociatedTreatmentPlanAction() == null ? null : new ims.oncology.vo.PatActionRefVo(new Integer(bean.getAssociatedTreatmentPlanAction().getId()), bean.getAssociatedTreatmentPlanAction().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.RadiotherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.radiotherapytype = bean.getRadiotherapyType() == null ? null : ims.oncology.vo.lookups.RadiotherapyType.buildLookup(bean.getRadiotherapyType());
		// Interface field type not supported.
		this.treatementintent = bean.getTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getTreatementIntent());
		this.anatomicaltreatmentsite = bean.getAnatomicalTreatmentSite() == null ? null : ims.oncology.vo.lookups.AnatomicalTreatmentSite.buildLookup(bean.getAnatomicalTreatmentSite());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.prescribeddose = bean.getPrescribedDose();
		this.prescribedfractions = bean.getPrescribedFractions();
		this.prescribedduration = bean.getPrescribedDuration();
		this.teletherapydetails = bean.getTeletherapyDetails() == null ? null : bean.getTeletherapyDetails().buildVo(map);
		this.brachytherapydetails = bean.getBrachytherapyDetails() == null ? null : bean.getBrachytherapyDetails().buildVo(map);
		this.treatmentcoursestatus = bean.getTreatmentCourseStatus() == null ? null : ims.oncology.vo.lookups.TreatmentCourseStatus.buildLookup(bean.getTreatmentCourseStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.treatinghospital = bean.getTreatingHospital() == null ? null : ims.oncology.vo.lookups.TreatmentHospital.buildLookup(bean.getTreatingHospital());
		this.performancestatusatddt = bean.getPerformanceStatusAtDDT() == null ? null : ims.medicaloncology.vo.lookups.PerformanceStatus.buildLookup(bean.getPerformanceStatusAtDDT());
		this.concurrentchemotherapy = bean.getConcurrentChemotherapy() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConcurrentChemotherapy());
		this.treatmentcategory = bean.getTreatmentCategory();
		this.diseasestatus = bean.getDiseaseStatus() == null ? null : ims.oncology.vo.lookups.DiseaseStatus.buildLookup(bean.getDiseaseStatus());
		this.diseasetreatment = bean.getDiseaseTreatment() == null ? null : ims.oncology.vo.lookups.DiseaseStatus.buildLookup(bean.getDiseaseTreatment());
		this.reasondelay1 = bean.getReasonDelay1() == null ? null : ims.oncology.vo.lookups.RadiotherapyDelayReason.buildLookup(bean.getReasonDelay1());
		this.reasondelay2 = bean.getReasonDelay2() == null ? null : ims.oncology.vo.lookups.RadiotherapyDelayReason.buildLookup(bean.getReasonDelay2());
		this.prescribinghcp = bean.getPrescribingHCP() == null ? null : bean.getPrescribingHCP().buildVo(map);
		this.prescribeddate = bean.getPrescribedDate() == null ? null : bean.getPrescribedDate().buildDate();
		this.associatedtreatmentplanaction = bean.getAssociatedTreatmentPlanAction() == null ? null : new ims.oncology.vo.PatActionRefVo(new Integer(bean.getAssociatedTreatmentPlanAction().getId()), bean.getAssociatedTreatmentPlanAction().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.RadiotherapyDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.RadiotherapyDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.RadiotherapyDetailsVoBean();
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
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("PRESCRIBEDDOSE"))
			return getPrescribedDose();
		if(fieldName.equals("PRESCRIBEDFRACTIONS"))
			return getPrescribedFractions();
		if(fieldName.equals("PRESCRIBEDDURATION"))
			return getPrescribedDuration();
		if(fieldName.equals("TELETHERAPYDETAILS"))
			return getTeletherapyDetails();
		if(fieldName.equals("BRACHYTHERAPYDETAILS"))
			return getBrachytherapyDetails();
		if(fieldName.equals("TREATMENTCOURSESTATUS"))
			return getTreatmentCourseStatus();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("TREATINGHOSPITAL"))
			return getTreatingHospital();
		if(fieldName.equals("PERFORMANCESTATUSATDDT"))
			return getPerformanceStatusAtDDT();
		if(fieldName.equals("CONCURRENTCHEMOTHERAPY"))
			return getConcurrentChemotherapy();
		if(fieldName.equals("TREATMENTCATEGORY"))
			return getTreatmentCategory();
		if(fieldName.equals("DISEASESTATUS"))
			return getDiseaseStatus();
		if(fieldName.equals("DISEASETREATMENT"))
			return getDiseaseTreatment();
		if(fieldName.equals("REASONDELAY1"))
			return getReasonDelay1();
		if(fieldName.equals("REASONDELAY2"))
			return getReasonDelay2();
		if(fieldName.equals("PRESCRIBINGHCP"))
			return getPrescribingHCP();
		if(fieldName.equals("PRESCRIBEDDATE"))
			return getPrescribedDate();
		if(fieldName.equals("ASSOCIATEDTREATMENTPLANACTION"))
			return getAssociatedTreatmentPlanAction();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getPrescribedDoseIsNotNull()
	{
		return this.prescribeddose != null;
	}
	public Float getPrescribedDose()
	{
		return this.prescribeddose;
	}
	public void setPrescribedDose(Float value)
	{
		this.isValidated = false;
		this.prescribeddose = value;
	}
	public boolean getPrescribedFractionsIsNotNull()
	{
		return this.prescribedfractions != null;
	}
	public Integer getPrescribedFractions()
	{
		return this.prescribedfractions;
	}
	public void setPrescribedFractions(Integer value)
	{
		this.isValidated = false;
		this.prescribedfractions = value;
	}
	public boolean getPrescribedDurationIsNotNull()
	{
		return this.prescribedduration != null;
	}
	public Integer getPrescribedDuration()
	{
		return this.prescribedduration;
	}
	public void setPrescribedDuration(Integer value)
	{
		this.isValidated = false;
		this.prescribedduration = value;
	}
	public boolean getTeletherapyDetailsIsNotNull()
	{
		return this.teletherapydetails != null;
	}
	public ims.oncology.vo.TeletherapyDetailsVo getTeletherapyDetails()
	{
		return this.teletherapydetails;
	}
	public void setTeletherapyDetails(ims.oncology.vo.TeletherapyDetailsVo value)
	{
		this.isValidated = false;
		this.teletherapydetails = value;
	}
	public boolean getBrachytherapyDetailsIsNotNull()
	{
		return this.brachytherapydetails != null;
	}
	public ims.oncology.vo.BrachytherapyDetailsVo getBrachytherapyDetails()
	{
		return this.brachytherapydetails;
	}
	public void setBrachytherapyDetails(ims.oncology.vo.BrachytherapyDetailsVo value)
	{
		this.isValidated = false;
		this.brachytherapydetails = value;
	}
	public boolean getTreatmentCourseStatusIsNotNull()
	{
		return this.treatmentcoursestatus != null;
	}
	public ims.oncology.vo.lookups.TreatmentCourseStatus getTreatmentCourseStatus()
	{
		return this.treatmentcoursestatus;
	}
	public void setTreatmentCourseStatus(ims.oncology.vo.lookups.TreatmentCourseStatus value)
	{
		this.isValidated = false;
		this.treatmentcoursestatus = value;
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
	public boolean getTreatingHospitalIsNotNull()
	{
		return this.treatinghospital != null;
	}
	public ims.oncology.vo.lookups.TreatmentHospital getTreatingHospital()
	{
		return this.treatinghospital;
	}
	public void setTreatingHospital(ims.oncology.vo.lookups.TreatmentHospital value)
	{
		this.isValidated = false;
		this.treatinghospital = value;
	}
	public boolean getPerformanceStatusAtDDTIsNotNull()
	{
		return this.performancestatusatddt != null;
	}
	public ims.medicaloncology.vo.lookups.PerformanceStatus getPerformanceStatusAtDDT()
	{
		return this.performancestatusatddt;
	}
	public void setPerformanceStatusAtDDT(ims.medicaloncology.vo.lookups.PerformanceStatus value)
	{
		this.isValidated = false;
		this.performancestatusatddt = value;
	}
	public boolean getConcurrentChemotherapyIsNotNull()
	{
		return this.concurrentchemotherapy != null;
	}
	public ims.core.vo.lookups.YesNo getConcurrentChemotherapy()
	{
		return this.concurrentchemotherapy;
	}
	public void setConcurrentChemotherapy(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.concurrentchemotherapy = value;
	}
	public boolean getTreatmentCategoryIsNotNull()
	{
		return this.treatmentcategory != null;
	}
	public Integer getTreatmentCategory()
	{
		return this.treatmentcategory;
	}
	public void setTreatmentCategory(Integer value)
	{
		this.isValidated = false;
		this.treatmentcategory = value;
	}
	public boolean getDiseaseStatusIsNotNull()
	{
		return this.diseasestatus != null;
	}
	public ims.oncology.vo.lookups.DiseaseStatus getDiseaseStatus()
	{
		return this.diseasestatus;
	}
	public void setDiseaseStatus(ims.oncology.vo.lookups.DiseaseStatus value)
	{
		this.isValidated = false;
		this.diseasestatus = value;
	}
	public boolean getDiseaseTreatmentIsNotNull()
	{
		return this.diseasetreatment != null;
	}
	public ims.oncology.vo.lookups.DiseaseStatus getDiseaseTreatment()
	{
		return this.diseasetreatment;
	}
	public void setDiseaseTreatment(ims.oncology.vo.lookups.DiseaseStatus value)
	{
		this.isValidated = false;
		this.diseasetreatment = value;
	}
	public boolean getReasonDelay1IsNotNull()
	{
		return this.reasondelay1 != null;
	}
	public ims.oncology.vo.lookups.RadiotherapyDelayReason getReasonDelay1()
	{
		return this.reasondelay1;
	}
	public void setReasonDelay1(ims.oncology.vo.lookups.RadiotherapyDelayReason value)
	{
		this.isValidated = false;
		this.reasondelay1 = value;
	}
	public boolean getReasonDelay2IsNotNull()
	{
		return this.reasondelay2 != null;
	}
	public ims.oncology.vo.lookups.RadiotherapyDelayReason getReasonDelay2()
	{
		return this.reasondelay2;
	}
	public void setReasonDelay2(ims.oncology.vo.lookups.RadiotherapyDelayReason value)
	{
		this.isValidated = false;
		this.reasondelay2 = value;
	}
	public boolean getPrescribingHCPIsNotNull()
	{
		return this.prescribinghcp != null;
	}
	public ims.core.vo.MedicVo getPrescribingHCP()
	{
		return this.prescribinghcp;
	}
	public void setPrescribingHCP(ims.core.vo.MedicVo value)
	{
		this.isValidated = false;
		this.prescribinghcp = value;
	}
	public boolean getPrescribedDateIsNotNull()
	{
		return this.prescribeddate != null;
	}
	public ims.framework.utils.Date getPrescribedDate()
	{
		return this.prescribeddate;
	}
	public void setPrescribedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.prescribeddate = value;
	}
	public boolean getAssociatedTreatmentPlanActionIsNotNull()
	{
		return this.associatedtreatmentplanaction != null;
	}
	public ims.oncology.vo.PatActionRefVo getAssociatedTreatmentPlanAction()
	{
		return this.associatedtreatmentplanaction;
	}
	public void setAssociatedTreatmentPlanAction(ims.oncology.vo.PatActionRefVo value)
	{
		this.isValidated = false;
		this.associatedtreatmentplanaction = value;
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
		if(this.teletherapydetails != null)
		{
			if(!this.teletherapydetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.brachytherapydetails != null)
		{
			if(!this.brachytherapydetails.isValidated())
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
		if(this.radiotherapytype == null)
			listOfErrors.add("RadiotherapyType is mandatory");
		if(this.treatingconsultant == null)
			listOfErrors.add("TreatingConsultant is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.teletherapydetails != null)
		{
			String[] listOfOtherErrors = this.teletherapydetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.brachytherapydetails != null)
		{
			String[] listOfOtherErrors = this.brachytherapydetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.treatinghospital == null)
			listOfErrors.add("TreatingHospital is mandatory");
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
	
		RadiotherapyDetailsVo clone = new RadiotherapyDetailsVo(this.id, this.version);
		
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.radiotherapytype == null)
			clone.radiotherapytype = null;
		else
			clone.radiotherapytype = (ims.oncology.vo.lookups.RadiotherapyType)this.radiotherapytype.clone();
		clone.treatingconsultant = this.treatingconsultant;
		if(this.treatementintent == null)
			clone.treatementintent = null;
		else
			clone.treatementintent = (ims.oncology.vo.lookups.CancerTreatmentIntent)this.treatementintent.clone();
		if(this.anatomicaltreatmentsite == null)
			clone.anatomicaltreatmentsite = null;
		else
			clone.anatomicaltreatmentsite = (ims.oncology.vo.lookups.AnatomicalTreatmentSite)this.anatomicaltreatmentsite.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		clone.episodeofcare = this.episodeofcare;
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.prescribeddose = this.prescribeddose;
		clone.prescribedfractions = this.prescribedfractions;
		clone.prescribedduration = this.prescribedduration;
		if(this.teletherapydetails == null)
			clone.teletherapydetails = null;
		else
			clone.teletherapydetails = (ims.oncology.vo.TeletherapyDetailsVo)this.teletherapydetails.clone();
		if(this.brachytherapydetails == null)
			clone.brachytherapydetails = null;
		else
			clone.brachytherapydetails = (ims.oncology.vo.BrachytherapyDetailsVo)this.brachytherapydetails.clone();
		if(this.treatmentcoursestatus == null)
			clone.treatmentcoursestatus = null;
		else
			clone.treatmentcoursestatus = (ims.oncology.vo.lookups.TreatmentCourseStatus)this.treatmentcoursestatus.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.treatinghospital == null)
			clone.treatinghospital = null;
		else
			clone.treatinghospital = (ims.oncology.vo.lookups.TreatmentHospital)this.treatinghospital.clone();
		if(this.performancestatusatddt == null)
			clone.performancestatusatddt = null;
		else
			clone.performancestatusatddt = (ims.medicaloncology.vo.lookups.PerformanceStatus)this.performancestatusatddt.clone();
		if(this.concurrentchemotherapy == null)
			clone.concurrentchemotherapy = null;
		else
			clone.concurrentchemotherapy = (ims.core.vo.lookups.YesNo)this.concurrentchemotherapy.clone();
		clone.treatmentcategory = this.treatmentcategory;
		if(this.diseasestatus == null)
			clone.diseasestatus = null;
		else
			clone.diseasestatus = (ims.oncology.vo.lookups.DiseaseStatus)this.diseasestatus.clone();
		if(this.diseasetreatment == null)
			clone.diseasetreatment = null;
		else
			clone.diseasetreatment = (ims.oncology.vo.lookups.DiseaseStatus)this.diseasetreatment.clone();
		if(this.reasondelay1 == null)
			clone.reasondelay1 = null;
		else
			clone.reasondelay1 = (ims.oncology.vo.lookups.RadiotherapyDelayReason)this.reasondelay1.clone();
		if(this.reasondelay2 == null)
			clone.reasondelay2 = null;
		else
			clone.reasondelay2 = (ims.oncology.vo.lookups.RadiotherapyDelayReason)this.reasondelay2.clone();
		if(this.prescribinghcp == null)
			clone.prescribinghcp = null;
		else
			clone.prescribinghcp = (ims.core.vo.MedicVo)this.prescribinghcp.clone();
		if(this.prescribeddate == null)
			clone.prescribeddate = null;
		else
			clone.prescribeddate = (ims.framework.utils.Date)this.prescribeddate.clone();
		clone.associatedtreatmentplanaction = this.associatedtreatmentplanaction;
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
		if (!(RadiotherapyDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RadiotherapyDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RadiotherapyDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RadiotherapyDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.enddate != null)
			count++;
		if(this.prescribeddose != null)
			count++;
		if(this.prescribedfractions != null)
			count++;
		if(this.prescribedduration != null)
			count++;
		if(this.teletherapydetails != null)
			count++;
		if(this.brachytherapydetails != null)
			count++;
		if(this.treatmentcoursestatus != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.treatinghospital != null)
			count++;
		if(this.performancestatusatddt != null)
			count++;
		if(this.concurrentchemotherapy != null)
			count++;
		if(this.treatmentcategory != null)
			count++;
		if(this.diseasestatus != null)
			count++;
		if(this.diseasetreatment != null)
			count++;
		if(this.reasondelay1 != null)
			count++;
		if(this.reasondelay2 != null)
			count++;
		if(this.prescribinghcp != null)
			count++;
		if(this.prescribeddate != null)
			count++;
		if(this.associatedtreatmentplanaction != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 19;
	}
	protected ims.framework.utils.Date enddate;
	protected Float prescribeddose;
	protected Integer prescribedfractions;
	protected Integer prescribedduration;
	protected ims.oncology.vo.TeletherapyDetailsVo teletherapydetails;
	protected ims.oncology.vo.BrachytherapyDetailsVo brachytherapydetails;
	protected ims.oncology.vo.lookups.TreatmentCourseStatus treatmentcoursestatus;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.oncology.vo.lookups.TreatmentHospital treatinghospital;
	protected ims.medicaloncology.vo.lookups.PerformanceStatus performancestatusatddt;
	protected ims.core.vo.lookups.YesNo concurrentchemotherapy;
	protected Integer treatmentcategory;
	protected ims.oncology.vo.lookups.DiseaseStatus diseasestatus;
	protected ims.oncology.vo.lookups.DiseaseStatus diseasetreatment;
	protected ims.oncology.vo.lookups.RadiotherapyDelayReason reasondelay1;
	protected ims.oncology.vo.lookups.RadiotherapyDelayReason reasondelay2;
	protected ims.core.vo.MedicVo prescribinghcp;
	protected ims.framework.utils.Date prescribeddate;
	protected ims.oncology.vo.PatActionRefVo associatedtreatmentplanaction;
	private boolean isValidated = false;
	private boolean isBusy = false;
}