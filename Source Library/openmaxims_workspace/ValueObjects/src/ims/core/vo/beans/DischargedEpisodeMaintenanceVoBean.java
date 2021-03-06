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

package ims.core.vo.beans;

public class DischargedEpisodeMaintenanceVoBean extends ims.vo.ValueObjectBean
{
	public DischargedEpisodeMaintenanceVoBean()
	{
	}
	public DischargedEpisodeMaintenanceVoBean(ims.core.vo.DischargedEpisodeMaintenanceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.isactive = vo.getIsActive();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedDischargeDetailVoBean)vo.getExtendedDetails().getBean();
		this.dischargingward = vo.getDischargingWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getDischargingWard().getBean();
		this.wardstays = vo.getWardStays() == null ? null : vo.getWardStays().getBeanCollection();
		this.consultantstays = vo.getConsultantStays() == null ? null : vo.getConsultantStays().getBeanCollection();
		this.wastreatmentdeferred = vo.getWasTreatmentDeferred();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getReferringConsultant().getBean();
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.deferredreason = vo.getDeferredReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeferredReason().getBean();
		this.deferredreasonconfig = vo.getDeferredReasonConfig() == null ? null : (ims.scheduling.vo.beans.CancellationTypeReasonVoBean)vo.getDeferredReasonConfig().getBean();
		this.admissionward = vo.getAdmissionWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAdmissionWard().getBean();
		this.dischargetreatmentdeferredresponse = vo.getDischargeTreatmentDeferredResponse();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DischargedEpisodeMaintenanceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean(map);
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.isactive = vo.getIsActive();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedDischargeDetailVoBean)vo.getExtendedDetails().getBean(map);
		this.dischargingward = vo.getDischargingWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getDischargingWard().getBean(map);
		this.wardstays = vo.getWardStays() == null ? null : vo.getWardStays().getBeanCollection();
		this.consultantstays = vo.getConsultantStays() == null ? null : vo.getConsultantStays().getBeanCollection();
		this.wastreatmentdeferred = vo.getWasTreatmentDeferred();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getReferringConsultant().getBean(map);
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.deferredreason = vo.getDeferredReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeferredReason().getBean();
		this.deferredreasonconfig = vo.getDeferredReasonConfig() == null ? null : (ims.scheduling.vo.beans.CancellationTypeReasonVoBean)vo.getDeferredReasonConfig().getBean(map);
		this.admissionward = vo.getAdmissionWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAdmissionWard().getBean(map);
		this.dischargetreatmentdeferredresponse = vo.getDischargeTreatmentDeferredResponse();
	}

	public ims.core.vo.DischargedEpisodeMaintenanceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DischargedEpisodeMaintenanceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DischargedEpisodeMaintenanceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DischargedEpisodeMaintenanceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DischargedEpisodeMaintenanceVo();
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
	public ims.core.vo.beans.PasEventVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.vo.LookupInstanceBean value)
	{
		this.dischargedestination = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.vo.LookupInstanceBean value)
	{
		this.admissiontype = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.vo.LookupInstanceBean value)
	{
		this.methodofdischarge = value;
	}
	public ims.vo.RefVoBean getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.vo.RefVoBean value)
	{
		this.admissiondetail = value;
	}
	public ims.core.vo.beans.ExtendedDischargeDetailVoBean getExtendedDetails()
	{
		return this.extendeddetails;
	}
	public void setExtendedDetails(ims.core.vo.beans.ExtendedDischargeDetailVoBean value)
	{
		this.extendeddetails = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getDischargingWard()
	{
		return this.dischargingward;
	}
	public void setDischargingWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.dischargingward = value;
	}
	public ims.core.vo.beans.WardStayVoBean[] getWardStays()
	{
		return this.wardstays;
	}
	public void setWardStays(ims.core.vo.beans.WardStayVoBean[] value)
	{
		this.wardstays = value;
	}
	public ims.core.vo.beans.ConsultantStayVoBean[] getConsultantStays()
	{
		return this.consultantstays;
	}
	public void setConsultantStays(ims.core.vo.beans.ConsultantStayVoBean[] value)
	{
		this.consultantstays = value;
	}
	public Boolean getWasTreatmentDeferred()
	{
		return this.wastreatmentdeferred;
	}
	public void setWasTreatmentDeferred(Boolean value)
	{
		this.wastreatmentdeferred = value;
	}
	public ims.vo.LookupInstanceBean getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.vo.LookupInstanceBean value)
	{
		this.wardtype = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfAdmission()
	{
		return this.sourceofadmission;
	}
	public void setSourceOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.sourceofadmission = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfAdmission()
	{
		return this.methodofadmission;
	}
	public void setMethodOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.methodofadmission = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estdischargedate = value;
	}
	public Boolean getIsChaplainRequired()
	{
		return this.ischaplainrequired;
	}
	public void setIsChaplainRequired(Boolean value)
	{
		this.ischaplainrequired = value;
	}
	public String getReasonForAdmission()
	{
		return this.reasonforadmission;
	}
	public void setReasonForAdmission(String value)
	{
		this.reasonforadmission = value;
	}
	public ims.core.vo.beans.MedicVoBean getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.beans.MedicVoBean value)
	{
		this.referringconsultant = value;
	}
	public ims.vo.LookupInstanceBean getPatientCategory()
	{
		return this.patientcategory;
	}
	public void setPatientCategory(ims.vo.LookupInstanceBean value)
	{
		this.patientcategory = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfEmergencyReferral()
	{
		return this.sourceofemergencyreferral;
	}
	public void setSourceOfEmergencyReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofemergencyreferral = value;
	}
	public ims.vo.LookupInstanceBean getDeferredReason()
	{
		return this.deferredreason;
	}
	public void setDeferredReason(ims.vo.LookupInstanceBean value)
	{
		this.deferredreason = value;
	}
	public ims.scheduling.vo.beans.CancellationTypeReasonVoBean getDeferredReasonConfig()
	{
		return this.deferredreasonconfig;
	}
	public void setDeferredReasonConfig(ims.scheduling.vo.beans.CancellationTypeReasonVoBean value)
	{
		this.deferredreasonconfig = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getAdmissionWard()
	{
		return this.admissionward;
	}
	public void setAdmissionWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.admissionward = value;
	}
	public Integer getDischargeTreatmentDeferredResponse()
	{
		return this.dischargetreatmentdeferredresponse;
	}
	public void setDischargeTreatmentDeferredResponse(Integer value)
	{
		this.dischargetreatmentdeferredresponse = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean dischargedestination;
	private ims.vo.LookupInstanceBean admissiontype;
	private ims.vo.LookupInstanceBean methodofdischarge;
	private ims.vo.RefVoBean admissiondetail;
	private ims.core.vo.beans.ExtendedDischargeDetailVoBean extendeddetails;
	private ims.core.vo.beans.LocationLiteVoBean dischargingward;
	private ims.core.vo.beans.WardStayVoBean[] wardstays;
	private ims.core.vo.beans.ConsultantStayVoBean[] consultantstays;
	private Boolean wastreatmentdeferred;
	private ims.vo.LookupInstanceBean wardtype;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean sourceofadmission;
	private ims.vo.LookupInstanceBean methodofadmission;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.framework.utils.beans.DateTimeBean estdischargedate;
	private Boolean ischaplainrequired;
	private String reasonforadmission;
	private ims.core.vo.beans.MedicVoBean referringconsultant;
	private ims.vo.LookupInstanceBean patientcategory;
	private ims.vo.LookupInstanceBean sourceofemergencyreferral;
	private ims.vo.LookupInstanceBean deferredreason;
	private ims.scheduling.vo.beans.CancellationTypeReasonVoBean deferredreasonconfig;
	private ims.core.vo.beans.LocationLiteVoBean admissionward;
	private Integer dischargetreatmentdeferredresponse;
}
