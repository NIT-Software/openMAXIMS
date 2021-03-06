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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.clinical.PatientCustomItem business object (ID: 1000100003).
 */
public class PatientCustomItemVo extends ims.core.clinical.vo.PatientCustomItemRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCustomItemVo()
	{
	}
	public PatientCustomItemVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCustomItemVo(ims.core.vo.beans.PatientCustomItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.addedby = bean.getAddedBy() == null ? null : bean.getAddedBy().buildVo();
		this.addeddatetime = bean.getAddedDateTime() == null ? null : bean.getAddedDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCustomItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.addedby = bean.getAddedBy() == null ? null : bean.getAddedBy().buildVo(map);
		this.addeddatetime = bean.getAddedDateTime() == null ? null : bean.getAddedDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCustomItemVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCustomItemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCustomItemVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("ADDEDBY"))
			return getAddedBy();
		if(fieldName.equals("ADDEDDATETIME"))
			return getAddedDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getAddedByIsNotNull()
	{
		return this.addedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAddedBy()
	{
		return this.addedby;
	}
	public void setAddedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.addedby = value;
	}
	public boolean getAddedDateTimeIsNotNull()
	{
		return this.addeddatetime != null;
	}
	public ims.framework.utils.DateTime getAddedDateTime()
	{
		return this.addeddatetime;
	}
	public void setAddedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.addeddatetime = value;
	}
	/**
	* PatientCustomItemVoDateTimeComparator (class definition)
	*/
	public static PatientCustomItemVoDateTimeComparator getDateTimeComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new PatientCustomItemVo.PatientCustomItemVoDateTimeComparator(sortOrder);
	}
	/**
	* getDateTimeComparator - retrieves a new instance of static class PatientCustomItemVoDateTimeComparator
	*/
	public static class PatientCustomItemVoDateTimeComparator implements java.util.Comparator
	{
		private int direction = 1;
		public PatientCustomItemVoDateTimeComparator ()
		{
			this(ims.framework.enumerations.SortOrder.ASCENDING);
		}
		public PatientCustomItemVoDateTimeComparator (ims.framework.enumerations.SortOrder order)
		{
			if (order == ims.framework.enumerations.SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientCustomItemVo voObj1 = (PatientCustomItemVo)obj1;
			PatientCustomItemVo voObj2 = (PatientCustomItemVo)obj2;
			if(voObj1.getAddedDateTimeIsNotNull() && voObj2.getAddedDateTimeIsNotNull())
				return direction*(voObj1.getAddedDateTime().compareTo(voObj2.getAddedDateTime()));
			else
				return direction;
		}
		public boolean equals(Object obj)
		{
			return false;
		}	
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.addedby == null)
			listOfErrors.add("AddedBy is mandatory");
		if(this.addeddatetime == null)
			listOfErrors.add("AddedDateTime is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientCustomItemVo clone = new PatientCustomItemVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.addedby == null)
			clone.addedby = null;
		else
			clone.addedby = (ims.core.vo.MemberOfStaffLiteVo)this.addedby.clone();
		if(this.addeddatetime == null)
			clone.addeddatetime = null;
		else
			clone.addeddatetime = (ims.framework.utils.DateTime)this.addeddatetime.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientCustomItemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCustomItemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCustomItemVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCustomItemVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.addedby != null)
			count++;
		if(this.addeddatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.MemberOfStaffLiteVo addedby;
	protected ims.framework.utils.DateTime addeddatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
