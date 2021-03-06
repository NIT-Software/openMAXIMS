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
// This code was generated by Silviu Checherita using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;

import ims.admin.domain.PatientSearchConfiguration;
import ims.admin.domain.impl.PatientSearchConfigurationImpl;
import ims.admin.vo.AppRightVoCollection;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.PDSConfigurationVo;
import ims.admin.vo.domain.AppRightVoAssembler;
import ims.admin.vo.domain.AppUserShortVoAssembler;
import ims.core.admin.domain.objects.PDSBackOfficeItem;
import ims.core.configuration.domain.objects.AppRole;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.domain.base.impl.BasePDSBackOfficeWorklistImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PDSBackOfficeItemVo;
import ims.core.vo.PDSBackOfficeItemVoCollection;
import ims.core.vo.PDSGeneralUpdateRequestVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PDSBackOfficeItemVoAssembler;
import ims.core.vo.domain.PDSGeneralUpdateRequestVoAssembler;
import ims.core.vo.domain.PatientAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.PDSSearchStatus;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.List;


public class PDSBackOfficeWorklistImpl extends BasePDSBackOfficeWorklistImpl
{

	private static final long serialVersionUID = 1L;
	private static final String SOURCE = "PDS";

	public ims.admin.vo.AppUserShortVoCollection listUsers(ims.admin.vo.AppUserShortVo filter)
	{

		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "  from AppUser u ";

		if (filter.getUsername() != null && filter.getUsername().length() > 0)

		{
			hql = " from AppUser u ";
			clause.append(" upper(u.username) like :username");
			names.add("username");
			values.add("%" + filter.getUsername().trim().toUpperCase() + "%");
			andStr = " and ";
		}		
		clause.append(andStr + " u.isActive = :isActive" );
		names.add("isActive");
		values.add(Boolean.TRUE);		
		andStr = " and ";

		clause.append(andStr).append(" u.username != 'xxxxx'");
		andStr=" and ";

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		hql += clause.toString();
		AppUserShortVoCollection ret = new AppUserShortVoCollection();
		List<?> list = factory.find(hql, names, values);

		for (int i = 0; i < list.size(); i++)
		{
			AppUser domUser = (AppUser) list.get(i);
			AppUserShortVo voUser = AppUserShortVoAssembler.create(domUser);
			if (domUser.getMos() != null && domUser.getMos().getName() != null)
				voUser.setUserRealName(domUser.getMos().getName().toString());
			ret.add(voUser);	
		}
		return ret.sort();

	}


	public PDSBackOfficeItemVoCollection listBackOfficeItems(String type,
			String priority, String status, DateTime dateFrom, DateTime dateTo,
			Boolean notifSeen, Integer notifPriority, String notifUser,
			Boolean notificationAreaVisible, String nhsNumber,
			Boolean superNhsNum)	
	{
		StringBuilder  queryBuilder = new StringBuilder();

		queryBuilder.append( "SELECT item FROM PDSBackOfficeItem AS item LEFT JOIN item.notifications AS n");

		ArrayList<String> paramName = new ArrayList<String>();
		ArrayList<Object> paramValue = new ArrayList<Object>();
		boolean whereClause = false;
		String source = SOURCE;
		DomainFactory domainFactory = getDomainFactory();

		//TODO link to lookup and mapping
//		if (source != "")
//		{
//			if (!whereClause)
//			{
//				whereClause = true;
//				queryBuilder.append(" WHERE ");
//			}
//			else
//			{
//				queryBuilder.append(" AND ");
//			}
//			queryBuilder.append("upper(item.source) = :SOURCE ");
//			paramName.add("SOURCE");		paramValue.add(source.toUpperCase());
//		}

		if (nhsNumber != null && !superNhsNum)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("item.nHSNumber = :NHSNUMBER ");
			paramName.add("NHSNUMBER");		paramValue.add(nhsNumber);
		}
		else if (nhsNumber != null && superNhsNum)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("item.nHSNumberSuperseded = :NHSNUMBER ");
			paramName.add("NHSNUMBER");		paramValue.add(nhsNumber);			
		}

		if (type != null)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("upper(item.type.text) LIKE :FAILURE ");
			paramName.add("FAILURE");		paramValue.add(type.toUpperCase() + "%");
		}

		if (priority != null)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("upper(item.priority.text) LIKE :PRIORITY ");
			paramName.add("PRIORITY");		paramValue.add(priority.toUpperCase() + "%");
		}

		if (status != null)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("upper(item.currentStatus.text) LIKE :STATUS ");
			paramName.add("STATUS");		paramValue.add(status.toUpperCase() + "%");
		}

		if (dateFrom != null && dateTo != null)
		{
			if (!whereClause)
			{
				whereClause = true;
				queryBuilder.append(" WHERE ");
			}
			else
			{
				queryBuilder.append(" AND ");
			}
			queryBuilder.append("item.systemInformation.creationDateTime BETWEEN :DATEFROM AND :DATETO");
			paramName.add("DATEFROM");		paramValue.add(dateFrom.getJavaDate());
			paramName.add("DATETO");		paramValue.add(dateTo.getJavaDate());
		}
		
		if(Boolean.TRUE.equals(notificationAreaVisible))
		{
			if (notifPriority != null)
			{
				if (!whereClause)
				{
					whereClause = true;
					queryBuilder.append(" WHERE ");
				}
				else
				{
					queryBuilder.append(" AND ");
				}
				queryBuilder.append("n.priority = :NOTIFPRIORITY ");
				paramName.add("NOTIFPRIORITY");		paramValue.add(notifPriority);
			}

			if (notifSeen != null)
			{
				if (!whereClause)
				{
					whereClause = true;
					queryBuilder.append(" WHERE ");
				}
				else
				{
					queryBuilder.append(" AND ");
				}
				queryBuilder.append("n.seen = :NOTIFSEEN ");
				paramName.add("NOTIFSEEN");		paramValue.add(notifSeen);
			}

			if (notifUser != null)
			{
				if (!whereClause)
				{
					whereClause = true;
					queryBuilder.append(" WHERE ");
				}
				else
				{
					queryBuilder.append(" AND ");
				}
				queryBuilder.append("upper(n.user.username) LIKE :NOTIFUSER ");
				paramName.add("NOTIFUSER");		paramValue.add(notifUser.toUpperCase() + "%");
			}
		}

		List<?> find = domainFactory.find(queryBuilder.toString(), paramName, paramValue);
		PDSBackOfficeItemVoCollection coll = PDSBackOfficeItemVoAssembler.createPDSBackOfficeItemVoCollectionFromPDSBackOfficeItem(find);
		return coll;

	}


	
	public PDSBackOfficeItemVo saveBackOfficeItem(PDSBackOfficeItemVo backOfficeItem) throws StaleObjectException 
	{
		if (backOfficeItem == null)
			throw new DomainRuntimeException("Cannot save null record.");

		if (!backOfficeItem.isValidated())
			throw new DomainRuntimeException("Record not validated.");

		DomainFactory domainFactory = getDomainFactory();



		PDSBackOfficeItem domBackOfficeItem = PDSBackOfficeItemVoAssembler.extractPDSBackOfficeItem(domainFactory, backOfficeItem);
		domainFactory.save(domBackOfficeItem);	
		PDSBackOfficeItemVo item = PDSBackOfficeItemVoAssembler.create(domBackOfficeItem);
		return item;
	}


	
	public Boolean getRequiresPds(Integer id) 
	{
		if (id != null)
		{	
			AppRole role = (AppRole) getDomainFactory().getDomainObject(AppRole.class,id);
			//WDEV-21387
			return role.isRequiresPDS();
		}
		return null;
	}


	
	public AppRightVoCollection getPDSRights(Integer id) 
	{
		if (id != null)
		{	
			AppRole role = (AppRole) getDomainFactory().getDomainObject(AppRole.class,id);
			//WDEV-21387
			return AppRightVoAssembler.createAppRightVoCollectionFromAppRight(role.getPdsRights());
		}
		return null;
	}

	
	public PDSConfigurationVo getPDSConfiguration() 
	{
		PatientSearchConfiguration impl = (PatientSearchConfiguration) getDomainImpl(PatientSearchConfigurationImpl.class);
		return impl.getPatientSearchConfig();
	}

	
	public PatientShort getPatientShort(PatientRefVo ref) 
	{
		if (ref != null)
		{	
			Patient patient = (Patient) getDomainFactory().getDomainObject(Patient.class,ref.getID_Patient());
			PatientShort voPatientShort = PatientShortAssembler.create(patient);
			return voPatientShort;
		}
		return null;
	}

	
	public ims.core.vo.Patient getPatient(PatientRefVo ref) 
	{
		if (ref != null)
		{	
			Patient patient = (Patient) getDomainFactory().getDomainObject(Patient.class,ref.getID_Patient());
			ims.core.vo.Patient voPatient = PatientAssembler.create(patient);
			return voPatient;
		}
		return null;
	}


	public ims.core.vo.Patient getPatientByIdentifier(String nhsNumber,
			PatIdType idType) 
	{
		DomainFactory factory = getDomainFactory();

		if (nhsNumber == null || nhsNumber.length() == 0)
		{
			throw new CodingRuntimeException("getPatientByIdentifier: invalid identifier: " + nhsNumber);
		}

		if (idType == null)
		{
			throw new CodingRuntimeException("getPatientByIdentifier: invalid identifier type");
		}

		String hql = "select p1_1 from Patient as p1_1 left join p1_1.identifiers as p2_1 left join p2_1.type as l1_1 where (l1_1.id = :type and p2_1.value = :value)";
		java.util.List patientList = factory.find(hql, new String[]{"type", "value"}, new Object[]{idType.getId(), nhsNumber});
		if (patientList != null && !patientList.isEmpty())
		{
			// 	Patient Should be unique per id value and type
			if (patientList.size() > 1)
			{
				throw new DomainRuntimeException("More than one patient found with identifier type = " + idType.getText() + " and value = " + nhsNumber);
			}

			ims.core.patient.domain.objects.Patient domPatient = (ims.core.patient.domain.objects.Patient) patientList.get(0);
			
			return PatientAssembler.create(domPatient);
		}
		
		return null;

	}


	//WDEV-22292
	public PDSGeneralUpdateRequestVoCollection listPendingUpdate(PatientRefVo patientRef) 
	{
		DomainFactory factory = getDomainFactory();

		if (patientRef == null)
			//no patient found locally
			return null;
		
		String hql = "from PDSGeneralUpdateRequest as pu1 where (pu1.patient.id = :patId) and pu1.status != :status";
		java.util.List pdsgeneralUpdateList = factory.find(hql, new String[]{"patId","status"}, new Object[]{patientRef.getID_Patient(),getDomLookup(PDSSearchStatus.COMPLETE)});
		if (pdsgeneralUpdateList != null && !pdsgeneralUpdateList.isEmpty())
		{			
			return PDSGeneralUpdateRequestVoAssembler.createPDSGeneralUpdateRequestVoCollectionFromPDSGeneralUpdateRequest(pdsgeneralUpdateList);
		}
		
		return null;
	}
	//WDEV-22292

}
