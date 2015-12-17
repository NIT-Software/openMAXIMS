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
// This code was generated by Mara Iroaie using IMS Development Environment (version 1.80 build 5354.19352)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.pathways.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.domain.base.impl.BaseBreachReasonListDialogImpl;
import ims.pathways.domain.objects.PatientJourneyBreach;
import ims.pathways.vo.PatientJourneyBreachReasonListVo;
import ims.pathways.vo.PatientJourneyBreachReasonListVoCollection;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.domain.PatientJourneyBreachReasonListVoAssembler;

import java.util.ArrayList;

public class BreachReasonListDialogImpl extends BaseBreachReasonListDialogImpl
{

	private static final long serialVersionUID = 1L;

	public PatientJourneyBreachReasonListVoCollection getBreachReasonsForPathway(PatientPathwayJourneyRefVo pathwayRef, Boolean latestFirst)
	{

		if(pathwayRef == null)
			   throw new CodingRuntimeException("Cannot get Pathway Breach Reasons for null pathway ID");
		
		DomainFactory factory = getDomainFactory();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = " select reason from PatientPathwayJourney as journey left join journey.patientJourneyBreachReason as reason where journey.id = :journeyID";

		markers.add("journeyID");
		values.add(pathwayRef.getID_PatientPathwayJourney());
		
		if (Boolean.TRUE.equals(latestFirst))
			hql += " order by reason.breachReasonDate asc ";
		else
			hql += " order by reason.breachReasonDate desc ";
			
		return PatientJourneyBreachReasonListVoAssembler.createPatientJourneyBreachReasonListVoCollectionFromPatientJourneyBreach(factory.find(hql, markers, values));
	}

	public void saveCorrection(PatientJourneyBreachReasonListVo breachReason) throws StaleObjectException
	{
		if (breachReason == null)
			throw new CodingRuntimeException("Cannot save null Breach Reason");

		DomainFactory factory = getDomainFactory();
		PatientJourneyBreach domainBreachReason = PatientJourneyBreachReasonListVoAssembler.extractPatientJourneyBreach(factory, breachReason);

		factory.save(domainBreachReason);
		
	}

}