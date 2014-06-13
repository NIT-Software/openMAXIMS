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
// This code was generated by Peter Martin using IMS Development Environment (version 1.70 build 3478.14513)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.configuration.vo.CustomListRefVo;
import ims.core.domain.CustomListMaintenance;
import ims.core.domain.base.impl.BaseMDTCustomListImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareSpellVoCollection;
import ims.core.vo.CustomListVo;
import ims.core.vo.CustomListVoCollection;
import ims.core.vo.MDTPatientCustomListVo;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.lookups.CustomListType;
import ims.domain.DomainFactory;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class MDTCustomListImpl extends BaseMDTCustomListImpl
{
	private static final long serialVersionUID = 1L;

	public CustomListVoCollection listCustomListTypes(CustomListVo filter) {
		CustomListMaintenance customListMaintenanceImpl = (CustomListMaintenance)getDomainImpl(CustomListMaintenanceImpl.class);
		filter.setIsActive(true);
		filter.setListType(CustomListType.MDT);
        return customListMaintenanceImpl.listCustomListTypes(filter);
	}

	public CareSpellVoCollection listCareSpellsByPatient(PatientRefVo patientRefVo) {
		if(patientRefVo == null || patientRefVo.getID_Patient() == null)
			throw new CodingRuntimeException("Patient not provided");
		
		DomainFactory factory = getDomainFactory();
		List careSpells = factory.find("from CareSpell careSpell where careSpell.patient.id = :idPatient", new String[] {"idPatient"}, new Object[] {patientRefVo.getID_Patient()});
		
		if (careSpells != null && careSpells.size() > 0)
			return CareSpellVoAssembler.createCareSpellVoCollectionFromCareSpell(careSpells).sort(SortOrder.DESCENDING);
		
		return null;
	}

	public MDTPatientCustomListVo getCustomList(CustomListRefVo reVoCustomList) {
		CustomListMaintenance customListMaintenanceImpl = (CustomListMaintenance)getDomainImpl(CustomListMaintenanceImpl.class);
        return customListMaintenanceImpl.getCustomList(reVoCustomList);
	}
}