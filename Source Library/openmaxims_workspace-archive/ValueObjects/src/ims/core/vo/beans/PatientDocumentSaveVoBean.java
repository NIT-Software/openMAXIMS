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

package ims.core.vo.beans;

public class PatientDocumentSaveVoBean extends ims.vo.ValueObjectBean
{
	public PatientDocumentSaveVoBean()
	{
	}
	public PatientDocumentSaveVoBean(ims.core.vo.PatientDocumentSaveVo vo)
	{
		this.patientdocumentvo = vo.getPatientDocumentVo() == null ? null : (ims.core.vo.beans.PatientDocumentVoBean)vo.getPatientDocumentVo().getBean();
		this.catsreferralwizardvo = vo.getCatsReferralWizardVo() == null ? null : (ims.RefMan.vo.beans.CatsReferralWizardVoBean)vo.getCatsReferralWizardVo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDocumentSaveVo vo)
	{
		this.patientdocumentvo = vo.getPatientDocumentVo() == null ? null : (ims.core.vo.beans.PatientDocumentVoBean)vo.getPatientDocumentVo().getBean(map);
		this.catsreferralwizardvo = vo.getCatsReferralWizardVo() == null ? null : (ims.RefMan.vo.beans.CatsReferralWizardVoBean)vo.getCatsReferralWizardVo().getBean(map);
	}

	public ims.core.vo.PatientDocumentSaveVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDocumentSaveVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDocumentSaveVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDocumentSaveVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDocumentSaveVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PatientDocumentVoBean getPatientDocumentVo()
	{
		return this.patientdocumentvo;
	}
	public void setPatientDocumentVo(ims.core.vo.beans.PatientDocumentVoBean value)
	{
		this.patientdocumentvo = value;
	}
	public ims.RefMan.vo.beans.CatsReferralWizardVoBean getCatsReferralWizardVo()
	{
		return this.catsreferralwizardvo;
	}
	public void setCatsReferralWizardVo(ims.RefMan.vo.beans.CatsReferralWizardVoBean value)
	{
		this.catsreferralwizardvo = value;
	}

	private ims.core.vo.beans.PatientDocumentVoBean patientdocumentvo;
	private ims.RefMan.vo.beans.CatsReferralWizardVoBean catsreferralwizardvo;
}