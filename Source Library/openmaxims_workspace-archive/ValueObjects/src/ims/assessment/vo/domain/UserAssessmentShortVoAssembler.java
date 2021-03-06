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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.assessment.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Vasile Purdila
 */
public class UserAssessmentShortVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.assessment.vo.UserAssessmentShortVo copy(ims.assessment.vo.UserAssessmentShortVo valueObjectDest, ims.assessment.vo.UserAssessmentShortVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_UserAssessment(valueObjectSrc.getID_UserAssessment());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ScoringMethod
		valueObjectDest.setScoringMethod(valueObjectSrc.getScoringMethod());
		// isFlatView
		valueObjectDest.setIsFlatView(valueObjectSrc.getIsFlatView());
		// Category
		valueObjectDest.setCategory(valueObjectSrc.getCategory());
		// isMultipleGroup
		valueObjectDest.setIsMultipleGroup(valueObjectSrc.getIsMultipleGroup());
		// GroupQuestionWidth
		valueObjectDest.setGroupQuestionWidth(valueObjectSrc.getGroupQuestionWidth());
		// StorePrintedAssessment
		valueObjectDest.setStorePrintedAssessment(valueObjectSrc.getStorePrintedAssessment());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
		// AssessmentType
		valueObjectDest.setAssessmentType(valueObjectSrc.getAssessmentType());
		// ActiveStatus
		valueObjectDest.setActiveStatus(valueObjectSrc.getActiveStatus());
		// HelpURL
		valueObjectDest.setHelpURL(valueObjectSrc.getHelpURL());
		// SystemInfo
		valueObjectDest.setSystemInfo(valueObjectSrc.getSystemInfo());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createUserAssessmentShortVoCollectionFromUserAssessment(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.assessment.configuration.domain.objects.UserAssessment objects.
	 */
	public static ims.assessment.vo.UserAssessmentShortVoCollection createUserAssessmentShortVoCollectionFromUserAssessment(java.util.Set domainObjectSet)	
	{
		return createUserAssessmentShortVoCollectionFromUserAssessment(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.assessment.configuration.domain.objects.UserAssessment objects.
	 */
	public static ims.assessment.vo.UserAssessmentShortVoCollection createUserAssessmentShortVoCollectionFromUserAssessment(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.assessment.vo.UserAssessmentShortVoCollection voList = new ims.assessment.vo.UserAssessmentShortVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.assessment.configuration.domain.objects.UserAssessment domainObject = (ims.assessment.configuration.domain.objects.UserAssessment) iterator.next();
			ims.assessment.vo.UserAssessmentShortVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.assessment.configuration.domain.objects.UserAssessment objects.
	 */
	public static ims.assessment.vo.UserAssessmentShortVoCollection createUserAssessmentShortVoCollectionFromUserAssessment(java.util.List domainObjectList) 
	{
		return createUserAssessmentShortVoCollectionFromUserAssessment(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.assessment.configuration.domain.objects.UserAssessment objects.
	 */
	public static ims.assessment.vo.UserAssessmentShortVoCollection createUserAssessmentShortVoCollectionFromUserAssessment(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.assessment.vo.UserAssessmentShortVoCollection voList = new ims.assessment.vo.UserAssessmentShortVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.assessment.configuration.domain.objects.UserAssessment domainObject = (ims.assessment.configuration.domain.objects.UserAssessment) domainObjectList.get(i);
			ims.assessment.vo.UserAssessmentShortVo vo = create(map, domainObject);

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
	 * Create the ims.assessment.configuration.domain.objects.UserAssessment set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractUserAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVoCollection voCollection) 
	 {
	 	return extractUserAssessmentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractUserAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.assessment.vo.UserAssessmentShortVo vo = voCollection.get(i);
			ims.assessment.configuration.domain.objects.UserAssessment domainObject = UserAssessmentShortVoAssembler.extractUserAssessment(domainFactory, vo, domMap);

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
	 * Create the ims.assessment.configuration.domain.objects.UserAssessment list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractUserAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVoCollection voCollection) 
	 {
	 	return extractUserAssessmentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractUserAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.assessment.vo.UserAssessmentShortVo vo = voCollection.get(i);
			ims.assessment.configuration.domain.objects.UserAssessment domainObject = UserAssessmentShortVoAssembler.extractUserAssessment(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.assessment.configuration.domain.objects.UserAssessment object.
	 * @param domainObject ims.assessment.configuration.domain.objects.UserAssessment
	 */
	 public static ims.assessment.vo.UserAssessmentShortVo create(ims.assessment.configuration.domain.objects.UserAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.assessment.configuration.domain.objects.UserAssessment object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.assessment.vo.UserAssessmentShortVo create(DomainObjectMap map, ims.assessment.configuration.domain.objects.UserAssessment domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.assessment.vo.UserAssessmentShortVo valueObject = (ims.assessment.vo.UserAssessmentShortVo) map.getValueObject(domainObject, ims.assessment.vo.UserAssessmentShortVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.assessment.vo.UserAssessmentShortVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.assessment.configuration.domain.objects.UserAssessment
	 */
	 public static ims.assessment.vo.UserAssessmentShortVo insert(ims.assessment.vo.UserAssessmentShortVo valueObject, ims.assessment.configuration.domain.objects.UserAssessment domainObject) 
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
	 * @param domainObject ims.assessment.configuration.domain.objects.UserAssessment
	 */
	 public static ims.assessment.vo.UserAssessmentShortVo insert(DomainObjectMap map, ims.assessment.vo.UserAssessmentShortVo valueObject, ims.assessment.configuration.domain.objects.UserAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_UserAssessment(domainObject.getId());
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
			
		// ScoringMethod
		ims.domain.lookups.LookupInstance instance1 = domainObject.getScoringMethod();
		if ( null != instance1 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance1.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance1.getImage().getImageId(), instance1.getImage().getImagePath());
			}
			color = instance1.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.UserAssessmentScoringMethod voLookup1 = new ims.core.vo.lookups.UserAssessmentScoringMethod(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.UserAssessmentScoringMethod parentVoLookup1 = voLookup1;
			ims.domain.lookups.LookupInstance parent1 = instance1.getParent();
			while (parent1 != null)
			{
				if (parent1.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent1.getImage().getImageId(), parent1.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent1.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup1.setParent(new ims.core.vo.lookups.UserAssessmentScoringMethod(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setScoringMethod(voLookup1);
		}
				// isFlatView
		valueObject.setIsFlatView( domainObject.isIsFlatView() );
		// Category
		ims.domain.lookups.LookupInstance instance3 = domainObject.getCategory();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.UserAssessmentCategory voLookup3 = new ims.core.vo.lookups.UserAssessmentCategory(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.UserAssessmentCategory parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.UserAssessmentCategory(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setCategory(voLookup3);
		}
				// isMultipleGroup
		valueObject.setIsMultipleGroup( domainObject.isIsMultipleGroup() );
		// GroupQuestionWidth
		valueObject.setGroupQuestionWidth(domainObject.getGroupQuestionWidth());
		// StorePrintedAssessment
		valueObject.setStorePrintedAssessment( domainObject.isStorePrintedAssessment() );
		// Name
		valueObject.setName(domainObject.getName());
		// Description
		valueObject.setDescription(domainObject.getDescription());
		// AssessmentType
		ims.domain.lookups.LookupInstance instance9 = domainObject.getAssessmentType();
		if ( null != instance9 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance9.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance9.getImage().getImageId(), instance9.getImage().getImagePath());
			}
			color = instance9.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.UserDefinedAssessmentType voLookup9 = new ims.core.vo.lookups.UserDefinedAssessmentType(instance9.getId(),instance9.getText(), instance9.isActive(), null, img, color);
			ims.core.vo.lookups.UserDefinedAssessmentType parentVoLookup9 = voLookup9;
			ims.domain.lookups.LookupInstance parent9 = instance9.getParent();
			while (parent9 != null)
			{
				if (parent9.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent9.getImage().getImageId(), parent9.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent9.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup9.setParent(new ims.core.vo.lookups.UserDefinedAssessmentType(parent9.getId(),parent9.getText(), parent9.isActive(), null, img, color));
				parentVoLookup9 = parentVoLookup9.getParent();
								parent9 = parent9.getParent();
			}			
			valueObject.setAssessmentType(voLookup9);
		}
				// ActiveStatus
		ims.domain.lookups.LookupInstance instance10 = domainObject.getActiveStatus();
		if ( null != instance10 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance10.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance10.getImage().getImageId(), instance10.getImage().getImagePath());
			}
			color = instance10.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup10 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance10.getId(),instance10.getText(), instance10.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup10 = voLookup10;
			ims.domain.lookups.LookupInstance parent10 = instance10.getParent();
			while (parent10 != null)
			{
				if (parent10.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent10.getImage().getImageId(), parent10.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent10.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup10.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent10.getId(),parent10.getText(), parent10.isActive(), null, img, color));
				parentVoLookup10 = parentVoLookup10.getParent();
								parent10 = parent10.getParent();
			}			
			valueObject.setActiveStatus(voLookup10);
		}
				// HelpURL
		valueObject.setHelpURL(domainObject.getHelpURL());
		// SystemInfo
		// set system information
		valueObject.setSystemInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.assessment.configuration.domain.objects.UserAssessment extractUserAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVo valueObject) 
	{
		return 	extractUserAssessment(domainFactory, valueObject, new HashMap());
	}

	public static ims.assessment.configuration.domain.objects.UserAssessment extractUserAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.assessment.vo.UserAssessmentShortVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_UserAssessment();
		ims.assessment.configuration.domain.objects.UserAssessment domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.assessment.configuration.domain.objects.UserAssessment)domMap.get(valueObject);
			}
			// ims.assessment.vo.UserAssessmentShortVo ID_UserAssessment field is unknown
			domainObject = new ims.assessment.configuration.domain.objects.UserAssessment();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_UserAssessment());
			if (domMap.get(key) != null)
			{
				return (ims.assessment.configuration.domain.objects.UserAssessment)domMap.get(key);
			}
			domainObject = (ims.assessment.configuration.domain.objects.UserAssessment) domainFactory.getDomainObject(ims.assessment.configuration.domain.objects.UserAssessment.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_UserAssessment());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getScoringMethod() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getScoringMethod().getID());
		}
		domainObject.setScoringMethod(value1);
		domainObject.setIsFlatView(valueObject.getIsFlatView());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getCategory() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getCategory().getID());
		}
		domainObject.setCategory(value3);
		domainObject.setIsMultipleGroup(valueObject.getIsMultipleGroup());
		domainObject.setGroupQuestionWidth(valueObject.getGroupQuestionWidth());
		domainObject.setStorePrintedAssessment(valueObject.getStorePrintedAssessment());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value9 = null;
		if ( null != valueObject.getAssessmentType() ) 
		{
			value9 =
				domainFactory.getLookupInstance(valueObject.getAssessmentType().getID());
		}
		domainObject.setAssessmentType(value9);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value10 = null;
		if ( null != valueObject.getActiveStatus() ) 
		{
			value10 =
				domainFactory.getLookupInstance(valueObject.getActiveStatus().getID());
		}
		domainObject.setActiveStatus(value10);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHelpURL() != null && valueObject.getHelpURL().equals(""))
		{
			valueObject.setHelpURL(null);
		}
		domainObject.setHelpURL(valueObject.getHelpURL());

		return domainObject;
	}

}
