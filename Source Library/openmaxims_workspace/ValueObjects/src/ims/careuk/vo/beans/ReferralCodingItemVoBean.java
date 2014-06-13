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

package ims.careuk.vo.beans;

public class ReferralCodingItemVoBean extends ims.vo.ValueObjectBean
{
	public ReferralCodingItemVoBean()
	{
	}
	public ReferralCodingItemVoBean(ims.careuk.vo.ReferralCodingItemVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientprocedure = vo.getPatientProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureShortWithCareIntraOperativeVoBean)vo.getPatientProcedure().getBean();
		this.patientdiagnosis = vo.getPatientDiagnosis() == null ? null : (ims.core.vo.beans.PatientDiagnosisShortVoBean)vo.getPatientDiagnosis().getBean();
		this.opcs4 = vo.getOPCS4();
		this.icd10 = vo.getICD10();
		this.proclaterality = vo.getProcLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLaterality().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReferralCodingItemVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientprocedure = vo.getPatientProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureShortWithCareIntraOperativeVoBean)vo.getPatientProcedure().getBean(map);
		this.patientdiagnosis = vo.getPatientDiagnosis() == null ? null : (ims.core.vo.beans.PatientDiagnosisShortVoBean)vo.getPatientDiagnosis().getBean(map);
		this.opcs4 = vo.getOPCS4();
		this.icd10 = vo.getICD10();
		this.proclaterality = vo.getProcLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLaterality().getBean();
	}

	public ims.careuk.vo.ReferralCodingItemVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReferralCodingItemVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReferralCodingItemVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReferralCodingItemVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReferralCodingItemVo();
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
	public ims.core.vo.beans.PatientProcedureShortWithCareIntraOperativeVoBean getPatientProcedure()
	{
		return this.patientprocedure;
	}
	public void setPatientProcedure(ims.core.vo.beans.PatientProcedureShortWithCareIntraOperativeVoBean value)
	{
		this.patientprocedure = value;
	}
	public ims.core.vo.beans.PatientDiagnosisShortVoBean getPatientDiagnosis()
	{
		return this.patientdiagnosis;
	}
	public void setPatientDiagnosis(ims.core.vo.beans.PatientDiagnosisShortVoBean value)
	{
		this.patientdiagnosis = value;
	}
	public String getOPCS4()
	{
		return this.opcs4;
	}
	public void setOPCS4(String value)
	{
		this.opcs4 = value;
	}
	public String getICD10()
	{
		return this.icd10;
	}
	public void setICD10(String value)
	{
		this.icd10 = value;
	}
	public ims.vo.LookupInstanceBean getProcLaterality()
	{
		return this.proclaterality;
	}
	public void setProcLaterality(ims.vo.LookupInstanceBean value)
	{
		this.proclaterality = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientProcedureShortWithCareIntraOperativeVoBean patientprocedure;
	private ims.core.vo.beans.PatientDiagnosisShortVoBean patientdiagnosis;
	private String opcs4;
	private String icd10;
	private ims.vo.LookupInstanceBean proclaterality;
}