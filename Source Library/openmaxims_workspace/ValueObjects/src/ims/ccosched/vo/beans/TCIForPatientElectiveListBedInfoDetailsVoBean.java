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

package ims.ccosched.vo.beans;

public class TCIForPatientElectiveListBedInfoDetailsVoBean extends ims.vo.ValueObjectBean
{
	public TCIForPatientElectiveListBedInfoDetailsVoBean()
	{
	}
	public TCIForPatientElectiveListBedInfoDetailsVoBean(ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.tciward = vo.getTCIWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTCIWard().getBean();
		this.tcibed = vo.getTCIBed();
		this.bedmanagercomment = vo.getBedManagerComment();
		this.tciconsultant = vo.getTCIConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTCIConsultant().getBean();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : (ims.core.vo.beans.AdmissionDetailVoBean)vo.getAdmissionDetail().getBean();
		this.currentoutcome = vo.getCurrentOutcome() == null ? null : (ims.careuk.vo.beans.TCIOutcomeForPatientElectiveListVoBean)vo.getCurrentOutcome().getBean();
		if(vo.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.vo.RefVoBean[vo.getOutcomeHistory().size()];
			for(int outcomehistory_i = 0; outcomehistory_i < vo.getOutcomeHistory().size(); outcomehistory_i++)
			{
				this.outcomehistory[outcomehistory_i] = new ims.vo.RefVoBean(vo.getOutcomeHistory().get(outcomehistory_i).getBoId(),vo.getOutcomeHistory().get(outcomehistory_i).getBoVersion());
			}
		}
		this.isactive = vo.getIsActive();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.BookingAppointmentTheatreVoBean)vo.getAppointment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.tciward = vo.getTCIWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTCIWard().getBean(map);
		this.tcibed = vo.getTCIBed();
		this.bedmanagercomment = vo.getBedManagerComment();
		this.tciconsultant = vo.getTCIConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTCIConsultant().getBean(map);
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : (ims.core.vo.beans.AdmissionDetailVoBean)vo.getAdmissionDetail().getBean(map);
		this.currentoutcome = vo.getCurrentOutcome() == null ? null : (ims.careuk.vo.beans.TCIOutcomeForPatientElectiveListVoBean)vo.getCurrentOutcome().getBean(map);
		if(vo.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.vo.RefVoBean[vo.getOutcomeHistory().size()];
			for(int outcomehistory_i = 0; outcomehistory_i < vo.getOutcomeHistory().size(); outcomehistory_i++)
			{
				this.outcomehistory[outcomehistory_i] = new ims.vo.RefVoBean(vo.getOutcomeHistory().get(outcomehistory_i).getBoId(),vo.getOutcomeHistory().get(outcomehistory_i).getBoVersion());
			}
		}
		this.isactive = vo.getIsActive();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.BookingAppointmentTheatreVoBean)vo.getAppointment().getBean(map);
	}

	public ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo vo = null;
		if(map != null)
			vo = (ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo();
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
	public ims.framework.utils.beans.DateBean getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.beans.DateBean value)
	{
		this.tcidate = value;
	}
	public ims.framework.utils.beans.TimeBean getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.beans.TimeBean value)
	{
		this.tcitime = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getTCIWard()
	{
		return this.tciward;
	}
	public void setTCIWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.tciward = value;
	}
	public String getTCIBed()
	{
		return this.tcibed;
	}
	public void setTCIBed(String value)
	{
		this.tcibed = value;
	}
	public String getBedManagerComment()
	{
		return this.bedmanagercomment;
	}
	public void setBedManagerComment(String value)
	{
		this.bedmanagercomment = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getTCIConsultant()
	{
		return this.tciconsultant;
	}
	public void setTCIConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.tciconsultant = value;
	}
	public ims.core.vo.beans.AdmissionDetailVoBean getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.core.vo.beans.AdmissionDetailVoBean value)
	{
		this.admissiondetail = value;
	}
	public ims.careuk.vo.beans.TCIOutcomeForPatientElectiveListVoBean getCurrentOutcome()
	{
		return this.currentoutcome;
	}
	public void setCurrentOutcome(ims.careuk.vo.beans.TCIOutcomeForPatientElectiveListVoBean value)
	{
		this.currentoutcome = value;
	}
	public ims.vo.RefVoBean[] getOutcomeHistory()
	{
		return this.outcomehistory;
	}
	public void setOutcomeHistory(ims.vo.RefVoBean[] value)
	{
		this.outcomehistory = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.scheduling.vo.beans.BookingAppointmentTheatreVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.beans.BookingAppointmentTheatreVoBean value)
	{
		this.appointment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean tcidate;
	private ims.framework.utils.beans.TimeBean tcitime;
	private ims.core.vo.beans.LocationLiteVoBean tciward;
	private String tcibed;
	private String bedmanagercomment;
	private ims.core.vo.beans.HcpLiteVoBean tciconsultant;
	private ims.core.vo.beans.AdmissionDetailVoBean admissiondetail;
	private ims.careuk.vo.beans.TCIOutcomeForPatientElectiveListVoBean currentoutcome;
	private ims.vo.RefVoBean[] outcomehistory;
	private Boolean isactive;
	private ims.scheduling.vo.beans.BookingAppointmentTheatreVoBean appointment;
}