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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4091.21781)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseClinicalOutcomeImpl;
import ims.RefMan.domain.objects.ClinicalOutcome;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ClinicalOutcomeDisplayVo;
import ims.RefMan.vo.ClinicalOutcomeDisplayVoCollection;
import ims.RefMan.vo.ClinicalOutcomeProcedureVoCollection;
import ims.RefMan.vo.ClinicalOutcomeRefVo;
import ims.RefMan.vo.ClinicalOutcomeVo;
import ims.RefMan.vo.domain.ClinicalOutcomeLiteVoAssembler;
import ims.RefMan.vo.domain.ClinicalOutcomeProcedureVoAssembler;
import ims.RefMan.vo.domain.ClinicalOutcomeVoAssembler;
import ims.core.clinical.vo.IntraOperativeCareRecordRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.DomainRuntimeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClinicalOutcomeImpl extends BaseClinicalOutcomeImpl
{

	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeProcedureVoCollection listIntraOperativeCareRecords(PatientRefVo patient, CatsReferralRefVo referral)
	{
		// We must have at least the selected patient to be able to search
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Invalid Patient record in domain");
		
		// Declare the query (as a StringBuilder to avoid unnecessary memory usage)
		StringBuilder query = new StringBuilder();
		// This part of the query will be common to all cases
		query.append("select operative from IntraOperativeCareRecord as operative left join operative.careContext as context1 ");
		
		// Initialize parameter arrays
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		// If we have a valid referral perform search only after referral
		if (referral != null && referral.getID_CatsReferralIsNotNull())
		{
			query.append(", CatsReferral as cats left join cats.careContext as context2 where context1.id = context2.id and cats.id = :ID order by operative.systemInformation.creationDateTime desc");  //wdev-12194			
			paramNames.add("ID");
			paramValues.add(referral.getID_CatsReferral());
		}
		else	// If we don't have a valid referral record then query after patient
		{
			query.append(" left join context1.episodeOfCare as ep left join ep.careSpell as spell left join spell.patient as patient where patient.id = :ID order by operative.systemInformation.creationDateTime desc");	//wdev-12194
			
			paramNames.add("ID");
			paramValues.add(patient.getID_Patient());
		}
		
		// Execute query and return
		return ClinicalOutcomeProcedureVoAssembler.createClinicalOutcomeProcedureVoCollectionFromIntraOperativeCareRecord(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	
	public ClinicalOutcomeDisplayVoCollection listClinicalOutcomes(PatientRefVo patient, CatsReferralRefVo referral, IntraOperativeCareRecordRefVo intraOperative)
	{
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Invalid Patient record in domain");
		
		StringBuilder query = new StringBuilder();

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		query.append("select outcome, taxType.id, map.taxonomyCode from ClinicalOutcome as outcome left join outcome.catsReferral as referral left join outcome.procedure as intraOperative left join referral.patient as patient");
		query.append(" left join outcome.clinicalOutcome as outcomeConfig left join outcomeConfig.codeMappings as map left join map.taxonomyName as taxType");
		query.append(" where patient.id = :PAT_ID");
		
		paramNames.add("PAT_ID");
		paramValues.add(patient.getID_Patient());
		
		if (referral != null && referral.getID_CatsReferralIsNotNull())
		{
			query.append(" and referral.id = :REF_ID");
			
			paramNames.add("REF_ID");
			paramValues.add(referral.getID_CatsReferral());
		}
		
		if (intraOperative != null && intraOperative.getID_IntraOperativeCareRecordIsNotNull())
		{
			query.append(" and intraOperative.id = :IOP_ID");
			
			paramNames.add("IOP_ID");
			paramValues.add(intraOperative.getID_IntraOperativeCareRecord());
		}

		// Query for display records
		@SuppressWarnings("unchecked")
		List<Object[]> results = getDomainFactory().find(query.toString(), paramNames, paramValues);
		// Prepare results iterator
		Iterator<Object[]> resultsIterator = results.iterator();
		
		// Create results collection to be returned
		ClinicalOutcomeDisplayVoCollection displayResults = new ClinicalOutcomeDisplayVoCollection();
		
		while (resultsIterator.hasNext())
		{
			// Get next result value
			Object[] value = resultsIterator.next();
			
			// Create outcome
			if (value.length > 0)
			{
				ClinicalOutcomeDisplayVo displayOutcome = new ClinicalOutcomeDisplayVo(ClinicalOutcomeLiteVoAssembler.create((ClinicalOutcome) value[0]));
				
				for (int i = 1; i + 1 < value.length; i += 2)
				{
					if (value[i] instanceof Integer && TaxonomyType.CLINICAL_OUTCOME_CODE.getID() == (Integer) value[i] && value[i + 1] instanceof String)
					{
						displayOutcome.setCode((String) value[i + 1]);

						if (displayResults.contains(displayOutcome))
							displayResults.remove(displayOutcome);
					}
				}
				
				// Add display result to display collection
				displayResults.add(displayOutcome);
			}
		}
		
		return displayResults;
	}

	public ClinicalOutcomeVo getClinicalOutcome(ClinicalOutcomeRefVo clinicalOutcome)
	{
		if (clinicalOutcome == null || !clinicalOutcome.getID_ClinicalOutcomeIsNotNull())
			return null;
		
		return ClinicalOutcomeVoAssembler.create((ClinicalOutcome) getDomainFactory().getDomainObject(ClinicalOutcome.class, clinicalOutcome.getID_ClinicalOutcome()));
	}
}
