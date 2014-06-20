/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class ConsultationDetailsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.ConsultationDetailsVo copy(ims.RefMan.vo.ConsultationDetailsVo valueObjectDest, ims.RefMan.vo.ConsultationDetailsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ConsultationDetails(valueObjectSrc.getID_ConsultationDetails());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// ReferralSummary
		valueObjectDest.setReferralSummary(valueObjectSrc.getReferralSummary());
		// BaselineObs
		valueObjectDest.setBaselineObs(valueObjectSrc.getBaselineObs());
		// OnExam
		valueObjectDest.setOnExam(valueObjectSrc.getOnExam());
		// AtConsultation
		valueObjectDest.setAtConsultation(valueObjectSrc.getAtConsultation());
		// Outcome
		valueObjectDest.setOutcome(valueObjectSrc.getOutcome());
		// CATSReferral
		valueObjectDest.setCATSReferral(valueObjectSrc.getCATSReferral());
		// ConsultationTimes
		valueObjectDest.setConsultationTimes(valueObjectSrc.getConsultationTimes());
		// TltTimes
		valueObjectDest.setTltTimes(valueObjectSrc.getTltTimes());
		// ClinicalContactTime
		valueObjectDest.setClinicalContactTime(valueObjectSrc.getClinicalContactTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createConsultationDetailsVoCollectionFromConsultationDetails(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ConsultationDetails objects.
	 */
	public static ims.RefMan.vo.ConsultationDetailsVoCollection createConsultationDetailsVoCollectionFromConsultationDetails(java.util.Set domainObjectSet)	
	{
		return createConsultationDetailsVoCollectionFromConsultationDetails(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ConsultationDetails objects.
	 */
	public static ims.RefMan.vo.ConsultationDetailsVoCollection createConsultationDetailsVoCollectionFromConsultationDetails(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.ConsultationDetailsVoCollection voList = new ims.RefMan.vo.ConsultationDetailsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.ConsultationDetails domainObject = (ims.RefMan.domain.objects.ConsultationDetails) iterator.next();
			ims.RefMan.vo.ConsultationDetailsVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ConsultationDetails objects.
	 */
	public static ims.RefMan.vo.ConsultationDetailsVoCollection createConsultationDetailsVoCollectionFromConsultationDetails(java.util.List domainObjectList) 
	{
		return createConsultationDetailsVoCollectionFromConsultationDetails(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ConsultationDetails objects.
	 */
	public static ims.RefMan.vo.ConsultationDetailsVoCollection createConsultationDetailsVoCollectionFromConsultationDetails(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.ConsultationDetailsVoCollection voList = new ims.RefMan.vo.ConsultationDetailsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.ConsultationDetails domainObject = (ims.RefMan.domain.objects.ConsultationDetails) domainObjectList.get(i);
			ims.RefMan.vo.ConsultationDetailsVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.RefMan.domain.objects.ConsultationDetails set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractConsultationDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVoCollection voCollection) 
	 {
	 	return extractConsultationDetailsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractConsultationDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ConsultationDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ConsultationDetails domainObject = ConsultationDetailsVoAssembler.extractConsultationDetails(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.RefMan.domain.objects.ConsultationDetails list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractConsultationDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVoCollection voCollection) 
	 {
	 	return extractConsultationDetailsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractConsultationDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ConsultationDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ConsultationDetails domainObject = ConsultationDetailsVoAssembler.extractConsultationDetails(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.RefMan.domain.objects.ConsultationDetails object.
	 * @param domainObject ims.RefMan.domain.objects.ConsultationDetails
	 */
	 public static ims.RefMan.vo.ConsultationDetailsVo create(ims.RefMan.domain.objects.ConsultationDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.ConsultationDetails object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.ConsultationDetailsVo create(DomainObjectMap map, ims.RefMan.domain.objects.ConsultationDetails domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.ConsultationDetailsVo valueObject = (ims.RefMan.vo.ConsultationDetailsVo) map.getValueObject(domainObject, ims.RefMan.vo.ConsultationDetailsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.ConsultationDetailsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ConsultationDetails
	 */
	 public static ims.RefMan.vo.ConsultationDetailsVo insert(ims.RefMan.vo.ConsultationDetailsVo valueObject, ims.RefMan.domain.objects.ConsultationDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ConsultationDetails
	 */
	 public static ims.RefMan.vo.ConsultationDetailsVo insert(DomainObjectMap map, ims.RefMan.vo.ConsultationDetailsVo valueObject, ims.RefMan.domain.objects.ConsultationDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ConsultationDetails(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
		// ReferralSummary
		valueObject.setReferralSummary(ims.RefMan.vo.domain.PresentationReferralSummaryVoAssembler.create(map, domainObject.getReferralSummary()) );
		// BaselineObs
		valueObject.setBaselineObs(ims.RefMan.vo.domain.BaselineObservationsVoAssembler.create(map, domainObject.getBaselineObs()) );
		// OnExam
		valueObject.setOnExam(ims.RefMan.vo.domain.onExaminationVoAssembler.create(map, domainObject.getOnExam()) );
		// AtConsultation
		valueObject.setAtConsultation(ims.RefMan.vo.domain.AtConsultationVoAssembler.create(map, domainObject.getAtConsultation()) );
		// Outcome
		valueObject.setOutcome(ims.RefMan.vo.domain.ReferralOutcomeVoAssembler.create(map, domainObject.getOutcome()) );
		// CATSReferral
		if (domainObject.getCATSReferral() != null)
		{
			if(domainObject.getCATSReferral() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCATSReferral();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCATSReferral(new ims.RefMan.vo.CatsReferralRefVo(id, -1));				
			}
			else
			{
				valueObject.setCATSReferral(new ims.RefMan.vo.CatsReferralRefVo(domainObject.getCATSReferral().getId(), domainObject.getCATSReferral().getVersion()));
			}
		}
		// ConsultationTimes
		valueObject.setConsultationTimes(ims.RefMan.vo.domain.ConsultationTimeVoAssembler.createConsultationTimeVoCollectionFromConsultationTime(map, domainObject.getConsultationTimes()) );
		// TltTimes
		valueObject.setTltTimes(ims.RefMan.vo.domain.TLTContactTimeVoAssembler.createTLTContactTimeVoCollectionFromTltContactTime(map, domainObject.getTltTimes()) );
		// ClinicalContactTime
		valueObject.setClinicalContactTime(ims.RefMan.vo.domain.ClinicalContactTimeVoAssembler.createClinicalContactTimeVoCollectionFromClinicalContactTime(map, domainObject.getClinicalContactTime()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.ConsultationDetails extractConsultationDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVo valueObject) 
	{
		return 	extractConsultationDetails(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.ConsultationDetails extractConsultationDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ConsultationDetailsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ConsultationDetails();
		ims.RefMan.domain.objects.ConsultationDetails domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.ConsultationDetails)domMap.get(valueObject);
			}
			// ims.RefMan.vo.ConsultationDetailsVo ID_ConsultationDetails field is unknown
			domainObject = new ims.RefMan.domain.objects.ConsultationDetails();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ConsultationDetails());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.ConsultationDetails)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.ConsultationDetails) domainFactory.getDomainObject(ims.RefMan.domain.objects.ConsultationDetails.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ConsultationDetails());

		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.RefMan.domain.objects.PresentationReferralSummary value2 = null;
		if ( null != valueObject.getReferralSummary() ) 
		{
			if (valueObject.getReferralSummary().getBoId() == null)
			{
				if (domMap.get(valueObject.getReferralSummary()) != null)
				{
					value2 = (ims.RefMan.domain.objects.PresentationReferralSummary)domMap.get(valueObject.getReferralSummary());
				}
			}
			else
			{
				value2 = (ims.RefMan.domain.objects.PresentationReferralSummary)domainFactory.getDomainObject(ims.RefMan.domain.objects.PresentationReferralSummary.class, valueObject.getReferralSummary().getBoId());
			}
		}
		domainObject.setReferralSummary(value2);
		domainObject.setBaselineObs(ims.RefMan.vo.domain.BaselineObservationsVoAssembler.extractNursingNotes(domainFactory, valueObject.getBaselineObs(), domMap));
		domainObject.setOnExam(ims.RefMan.vo.domain.onExaminationVoAssembler.extractOnExamination(domainFactory, valueObject.getOnExam(), domMap));
		domainObject.setAtConsultation(ims.RefMan.vo.domain.AtConsultationVoAssembler.extractAtConsultation(domainFactory, valueObject.getAtConsultation(), domMap));
		domainObject.setOutcome(ims.RefMan.vo.domain.ReferralOutcomeVoAssembler.extractReferralOutcome(domainFactory, valueObject.getOutcome(), domMap));
		ims.RefMan.domain.objects.CatsReferral value7 = null;
		if ( null != valueObject.getCATSReferral() ) 
		{
			if (valueObject.getCATSReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCATSReferral()) != null)
				{
					value7 = (ims.RefMan.domain.objects.CatsReferral)domMap.get(valueObject.getCATSReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value7 = domainObject.getCATSReferral();	
			}
			else
			{
				value7 = (ims.RefMan.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.RefMan.domain.objects.CatsReferral.class, valueObject.getCATSReferral().getBoId());
			}
		}
		domainObject.setCATSReferral(value7);
		domainObject.setConsultationTimes(ims.RefMan.vo.domain.ConsultationTimeVoAssembler.extractConsultationTimeSet(domainFactory, valueObject.getConsultationTimes(), domainObject.getConsultationTimes(), domMap));		
		domainObject.setTltTimes(ims.RefMan.vo.domain.TLTContactTimeVoAssembler.extractTltContactTimeSet(domainFactory, valueObject.getTltTimes(), domainObject.getTltTimes(), domMap));		
		domainObject.setClinicalContactTime(ims.RefMan.vo.domain.ClinicalContactTimeVoAssembler.extractClinicalContactTimeSet(domainFactory, valueObject.getClinicalContactTime(), domainObject.getClinicalContactTime(), domMap));		

		return domainObject;
	}

}
