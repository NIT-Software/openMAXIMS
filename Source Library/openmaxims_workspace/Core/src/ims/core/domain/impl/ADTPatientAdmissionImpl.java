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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4738.16294)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.AdmissionDetail;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.base.impl.BaseADTPatientAdmissionImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.AdmissionDetailVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.AdmissionDetailVoAssembler;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class ADTPatientAdmissionImpl extends BaseADTPatientAdmissionImpl
{

	private static final long serialVersionUID = 1L;

	public AdmissionDetailVo getAdmissionDetail(PatientRefVo patientRef)
	{
		StringBuffer hql = new StringBuffer("select admDet from AdmissionDetail as admDet left join admDet.pasEvent as pasEvent left join pasEvent.patient as pat where pat.id = :patID order by admDet.systemInformation.creationDateTime desc ");

		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find(hql.toString(), new String[] { "patID" }, new Object[] { patientRef.getID_Patient() });

		if (list != null && list.size() > 0)
			return AdmissionDetailVoAssembler.create((AdmissionDetail) list.get(0));

		return null;
	}

	public CareContextShortVo getCareContext(PASEventRefVo pasEventRef)
	{
		if (pasEventRef == null || pasEventRef.getID_PASEvent() == null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");

		StringBuffer hql = new StringBuffer("select careContext from CareContext as careContext left join careContext.pasEvent as pasEvent where pasEvent.id = :pasEventID) ");

		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find(hql.toString(), new String[] { "pasEventID" }, new Object[] { pasEventRef.getID_PASEvent() });

		if (list != null && list.size() > 0)
			return CareContextShortVoAssembler.create((CareContext) list.get(0));

		return null;

	}

	public PatientShort getPatient(PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot get Patient value on null patientRef.");

		DomainFactory factory = getDomainFactory();
		Patient domPat = (Patient) factory.getDomainObject(Patient.class, patientRef.getID_Patient());
		return PatientShortAssembler.create(domPat);
	}

	public AdmissionDetailVo getAdmissionDetailByPasEvent(PASEventRefVo pasEventRef)
	{
		if (pasEventRef == null || pasEventRef.getID_PASEvent() == null)
			throw new CodingRuntimeException("Cannot get AdmissionDetails value on null pasEventRef.");

		StringBuffer hql = new StringBuffer("select admDetail from AdmissionDetail as admDetail left join admDetail.pasEvent as pasEvent where pasEvent.id = :pasEventID) ");

		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find(hql.toString(), new String[] { "pasEventID" }, new Object[] { pasEventRef.getID_PASEvent() });

		if (list != null && list.size() > 0)
			return AdmissionDetailVoAssembler.create((AdmissionDetail) list.get(0));

		return null;
	}

	public CareContextVo getCareContextByCareContextRef(CareContextRefVo careContextRef)
	{
		if(careContextRef == null || careContextRef.getID_CareContext()==null)
			throw new CodingRuntimeException("Cannot get CareContext value on null careContextRef.");
		
		DomainFactory factory = getDomainFactory();
		CareContext domCareContext=(CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());
		return CareContextVoAssembler.create(domCareContext);
	}

}
