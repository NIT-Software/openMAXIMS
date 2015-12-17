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

package ims.core.vo;

/**
 * Linked to RefMan.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralPendingEmergencyNonEDAdmissionListVo extends ims.RefMan.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPendingAdmission, ims.vo.interfaces.IPendingAdmissionDetails
{
	private static final long serialVersionUID = 1L;

	public CatsReferralPendingEmergencyNonEDAdmissionListVo()
	{
	}
	public CatsReferralPendingEmergencyNonEDAdmissionListVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralPendingEmergencyNonEDAdmissionListVo(ims.core.vo.beans.CatsReferralPendingEmergencyNonEDAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.repatriationrequest = bean.getRepatriationRequest() == null ? null : bean.getRepatriationRequest().buildVo();
		this.acceptedstatus = bean.getAcceptedStatus() == null ? null : bean.getAcceptedStatus().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CatsReferralPendingEmergencyNonEDAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.repatriationrequest = bean.getRepatriationRequest() == null ? null : bean.getRepatriationRequest().buildVo(map);
		this.acceptedstatus = bean.getAcceptedStatus() == null ? null : bean.getAcceptedStatus().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CatsReferralPendingEmergencyNonEDAdmissionListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CatsReferralPendingEmergencyNonEDAdmissionListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CatsReferralPendingEmergencyNonEDAdmissionListVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REPATRIATIONREQUEST"))
			return getRepatriationRequest();
		if(fieldName.equals("ACCEPTEDSTATUS"))
			return getAcceptedStatus();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getRepatriationRequestIsNotNull()
	{
		return this.repatriationrequest != null;
	}
	public ims.core.vo.PendingEmergencyNonEDAdmissionListVo getRepatriationRequest()
	{
		return this.repatriationrequest;
	}
	public void setRepatriationRequest(ims.core.vo.PendingEmergencyNonEDAdmissionListVo value)
	{
		this.isValidated = false;
		this.repatriationrequest = value;
	}
	public boolean getAcceptedStatusIsNotNull()
	{
		return this.acceptedstatus != null;
	}
	public ims.core.vo.CatsReferralStatusWithHcpVo getAcceptedStatus()
	{
		return this.acceptedstatus;
	}
	public void setAcceptedStatus(ims.core.vo.CatsReferralStatusWithHcpVo value)
	{
		this.isValidated = false;
		this.acceptedstatus = value;
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
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public ims.core.vo.CatsReferralDetailsRepatriationRequestLiteVo getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.core.vo.CatsReferralDetailsRepatriationRequestLiteVo value)
	{
		this.isValidated = false;
		this.referraldetails = value;
	}
	/**
	* IPendingAdmission implementation
	*/
	public String getPatientSurname()
	{
		if (this.patient != null)
			return this.patient.getPatientSurname();
	
		return null;
	}
	
	public String getPatientForename()
	{
		if (this.patient != null)
			return this.patient.getPatientForename();
	
		return null;
	}
	
	public PatientId getPatientDisplayIdentifier()
	{
		if (this.patient != null)
			return this.patient.getPatientDisplayIdentifier();
	
		return null;
	}
	
	public ims.core.vo.lookups.Sex getPatientSex()
	{
		if (this.patient != null)
			return this.patient.getPatientSex();
	
		return null;
	}
	
	public Integer getPatientAge()
	{
		if (this.patient != null)
			return this.patient.getPatientAge();
	
		return null;
	}
	
	public ims.framework.utils.PartialDate getPatientDoB()
	{
		if (this.patient != null)
			return this.patient.getPatientDoB();
	
		return null;
	}
	
	public String getLengthOfStay()
	{
	
		return null;
	}
	
	public ims.framework.utils.DateTime getTCIDateTime()
	{
		return null;
	}
	
	public Boolean hasTCIComments()
	{
		return null;
	}
	
	public ims.framework.utils.Time getWardAttendanceAppointmentTime()
	{
	
		return null;
	}
	public ims.framework.utils.Date getPatientDod()
	{
		return this.patient.getDod();
	}
	
	public ims.core.patient.vo.PatientRefVo getPatientAssociatedPatient()
	{
		return this.patient.getAssociatedPatient();
	}
	
	public ims.framework.utils.Time getPatientTimeOfDeath()
	{
		return this.patient.getTimeOfDeath();
	}
	
	public String getPatientAgeText()
	{
		return this.patient.calculateAgeText();
	}
	
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return new ims.RefMan.vo.CatsReferralRefVo(this.id,this.version);
	}
	/**
	* IPendingAdmissionDetails implementation
	*/
	public ServiceLiteVo getPendingAdmissionService()
	{
		if (this.repatriationrequest != null)
			return this.repatriationrequest.service;
		
		return null;
	}
	
	public ims.core.vo.lookups.Specialty getPendingAdmissionSpecialty()
	{
		if (this.repatriationrequest != null && this.repatriationrequest.service != null)
			return this.repatriationrequest.service.specialty;
	
		return null;
	}
	
	public MemberOfStaffLiteVo getPendingAdmissionConsultant()
	{
		if (this.referraldetails != null)
			return this.referraldetails.consultant.getMos();
		
		return null;
	}
	
	public ims.core.vo.lookups.MethodOfAdmission getPendingAdmissionMethodOfAdmission()
	{
		return ims.core.vo.lookups.MethodOfAdmission.EMERGENCY;
	}
	
	public ims.core.vo.lookups.PatientStatus getPendingAdmissionPatientCategory()
	{
		if (this.repatriationrequest != null)
			return this.repatriationrequest.category;
		else if (this.patient != null)
			return this.patient.getPatientCategory();
		return null;
	}
	
	public Integer getPendingAdmissionAnticipatedStay()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfEmergencyReferral getPendingAdmissionSourceOfEmergencyReferral()
	{
		if (this.repatriationrequest != null)
		{
			if (ims.core.vo.lookups.PendingEmergencyAdmissionType.GP.equals(this.repatriationrequest.type))
				return ims.core.vo.lookups.SourceOfEmergencyReferral.GENERAL_PRACTITIONER;
				
			if (ims.core.vo.lookups.PendingEmergencyAdmissionType.CLINICAL_NEED.equals(this.repatriationrequest.type))
				return ims.core.vo.lookups.SourceOfEmergencyReferral.TRANSFER_FROM_HOSPITAL_PROVIDER;
				
			if (ims.core.vo.lookups.PendingEmergencyAdmissionType.REQUEST_FOR_REPATRIATION.equals(this.repatriationrequest.type))
				return ims.core.vo.lookups.SourceOfEmergencyReferral.TRANSFER_FROM_HOSPITAL_PROVIDER;
			
			if (ims.core.vo.lookups.PendingEmergencyAdmissionType.OTHER.equals(this.repatriationrequest.type))
				return this.repatriationrequest.getSourceOfEmergencyReferral();
		}
		
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfReferral getPendingAdmissionSourceOfReferral()
	{
		return null;
	}
	
	public String getPendingAdmissionReasonForAdmission()
	{
		return null;
	}
	
	public MedicLiteVo getPendingAdmissionReferringConsultant()
	{
		return null;
	}
	
	public Boolean getPendingAdmissionSelfAdmit()
	{
		return null;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		CatsReferralPendingEmergencyNonEDAdmissionListVo clone = new CatsReferralPendingEmergencyNonEDAdmissionListVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.repatriationrequest == null)
			clone.repatriationrequest = null;
		else
			clone.repatriationrequest = (ims.core.vo.PendingEmergencyNonEDAdmissionListVo)this.repatriationrequest.clone();
		if(this.acceptedstatus == null)
			clone.acceptedstatus = null;
		else
			clone.acceptedstatus = (ims.core.vo.CatsReferralStatusWithHcpVo)this.acceptedstatus.clone();
		clone.carecontext = this.carecontext;
		if(this.referraldetails == null)
			clone.referraldetails = null;
		else
			clone.referraldetails = (ims.core.vo.CatsReferralDetailsRepatriationRequestLiteVo)this.referraldetails.clone();
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
		if (!(CatsReferralPendingEmergencyNonEDAdmissionListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralPendingEmergencyNonEDAdmissionListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatsReferralPendingEmergencyNonEDAdmissionListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatsReferralPendingEmergencyNonEDAdmissionListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.repatriationrequest != null)
			count++;
		if(this.acceptedstatus != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.referraldetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.core.vo.PendingEmergencyNonEDAdmissionListVo repatriationrequest;
	protected ims.core.vo.CatsReferralStatusWithHcpVo acceptedstatus;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.CatsReferralDetailsRepatriationRequestLiteVo referraldetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}