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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3035.29542)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.vo.ClinicRefVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.Specialty;
import ims.correspondence.configuration.domain.objects.NoLetterIsRequired;
import ims.correspondence.domain.base.impl.BaseNoLetterRequiredAdminConfigImpl;
import ims.correspondence.vo.NoLetterIsRequiredVo;
import ims.correspondence.vo.NoLetterIsRequiredVoCollection;
import ims.correspondence.vo.domain.NoLetterIsRequiredVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;

public class NoLetterRequiredAdminConfigImpl extends BaseNoLetterRequiredAdminConfigImpl
{

	private static final long serialVersionUID = 1L;

	public NoLetterIsRequiredVoCollection listNoLetterIsRequired() 
	{
		DomainFactory factory = getDomainFactory();		
		List lstNLR = factory.find("from NoLetterIsRequired");				
		return NoLetterIsRequiredVoAssembler.createNoLetterIsRequiredVoCollectionFromNoLetterIsRequired(lstNLR);
	}

	public ClinicLiteVoCollection listClinics(String textTyped) 
	{
		if (textTyped == null)
			throw new CodingRuntimeException("Can not search on null text");
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		String query = " from Clinic c ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		{
			if (markers.size() > 0)
				hql.append(" and ");
			
				hql.append("c.upperName like :clinicName");
				markers.add("clinicName");
				values.add("%" + textTyped.toUpperCase() + "%");
				
		}
		
		if (markers.size() > 0)
			query += " where ";
		
		query += hql.toString();
		
		List listClinics = factory.find(query, markers, values);
		
		return ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(listClinics);
	}

	public MedicLiteVoCollection listConsultants(String textTyped) 
	{
		if(textTyped == null)
			throw new CodingRuntimeException("Cannot search on null text!");
		
		MedicLiteVoCollection voCollMedicsLite = new MedicLiteVoCollection();
		List lstMedics = listActiveMedics(textTyped);
		if (lstMedics != null)
		{
			for (int i = 0; i < lstMedics.size(); i++)
			{
				Hcp hcp = (Hcp) lstMedics.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass()))
					voCollMedicsLite.add(MedicLiteVoAssembler.create((Medic) hcp));
			}
		}
		
		return voCollMedicsLite;
	}
	
	private List listActiveMedics(String textToSearch) 
	{
		DomainFactory factory = getDomainFactory();
		return factory.find("from Hcp h where h.hcpType = :hcpType and h.isActive = :bActive and h.mos.name.surname like :sur or h.mos.name.forename like :for", new String[]{"hcpType", "bActive", "sur", "for"}, new Object[]{getDomLookup(HcpDisType.MEDICAL), Boolean.TRUE, "%" + textToSearch.toUpperCase() + "%", "%" + textToSearch.toUpperCase() + "%"});
	}

	public NoLetterIsRequiredVo getNLRItems() 
	{
		DomainFactory factory = getDomainFactory();		
		List letterVo = factory.find("from NoLetterIsRequired");
		
		if (letterVo == null || letterVo.size() == 0) return null;
		
		if (letterVo.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. NoLetterIsRequired = returned " + letterVo.size() + " records. " );
		
		return NoLetterIsRequiredVoAssembler.create((NoLetterIsRequired) letterVo.get(0));
	}

	public NoLetterIsRequiredVo saveNoLetterIsRequired(NoLetterIsRequiredVo letterVo) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!letterVo.isValidated())
		{
			throw new CodingRuntimeException("NoLetter is required record has not been validated");
		}
				
		DomainFactory factory = getDomainFactory();				
		NoLetterIsRequired domNLR =  NoLetterIsRequiredVoAssembler.extractNoLetterIsRequired(factory, letterVo);
		try
		{
			factory.save(domNLR);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("No Letter required already exists within the system. Please try again to update.", e);
		}
		
		return NoLetterIsRequiredVoAssembler.create(domNLR);
	}

	public Boolean isLetterRequired(HcpRefVo voRefMedic, Specialty lkpSpecialty, ClinicRefVo voRefClinicNew, ClinicRefVo voRefClinicReview) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = " from NoLetterIsRequired n ";
		String sWhere = "";
		
		if (voRefMedic != null)
		{
			sWhere = " join fetch n.consultants cons where cons.id = " + voRefMedic.getID_Hcp();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (lkpSpecialty != null)
		{
			sWhere = " join fetch n.specialties spec join spec.instance instance where instance = " + getDomLookup(lkpSpecialty).getId();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (voRefClinicNew != null)
		{
			sWhere = " join fetch n.newClinics nc where nc.id = " + voRefClinicNew.getID_Clinic();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (voRefClinicReview != null)
		{
			sWhere = " join fetch n.reviewClinics rc where rc.id = " + voRefClinicReview.getID_Clinic();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		return Boolean.TRUE;
	}

}