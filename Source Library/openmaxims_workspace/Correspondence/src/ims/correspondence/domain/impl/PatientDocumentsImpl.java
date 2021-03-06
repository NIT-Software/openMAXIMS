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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.28 build 2001.21673)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.PatientShort;
import ims.core.vo.DocumentVoCollection;
import ims.core.vo.domain.DocumentVoAssembler;
import ims.core.documents.domain.objects.Document;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;

public class PatientDocumentsImpl extends DomainImpl implements ims.correspondence.domain.PatientDocuments, ims.domain.impl.Transactional
{
	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.PatientDocuments#listPatientDocs(ims.core.vo.PatientShort)
	 */
	public DocumentVoCollection listPatientDocs(PatientShort voPatientFilter) 
	{
		if (voPatientFilter != null)
		{			
			DomainFactory factory = getDomainFactory();
			
			String hql = " from Document document "; 
			StringBuffer condStr = new StringBuffer();
		
			ArrayList markers = new ArrayList();
			ArrayList values = new ArrayList();
		
			condStr.append(" document.patient.id = :patientid");
			markers.add("patientid");
							
			values.add(voPatientFilter.getID_Patient());
			
			hql += " where ";
	
			hql += condStr.toString();
			List docDetails = factory.find(hql,markers, values);
			
			DocumentVoCollection collDocvo = DocumentVoAssembler.createDocumentVoCollectionFromDocument(docDetails);
			
			if (docDetails !=  null)
			{
				Document boDoc;
				//add system information
				for (int i=0; i<docDetails.size();i++)
				{
					boDoc = (Document)docDetails.get(i);
					if (boDoc.getSystemInformation() != null)
					{
						//creation date
						collDocvo.get(i).setCreationDate(new ims.framework.utils.Date(boDoc.getSystemInformation().getCreationDateTime()));
						//creation user
						collDocvo.get(i).setRecUser(boDoc.getSystemInformation().getCreationUser());
					}
				}
			}
			return collDocvo;
		}
		return null;
	}
}
