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

package ims.emergency.vo;

/**
 * Linked to core.resource.people.Nurse business object (ID: 1006100007).
 */
public class NurseForTrackingVo extends ims.core.resource.people.vo.NurseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurseForTrackingVo()
	{
	}
	public NurseForTrackingVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurseForTrackingVo(ims.emergency.vo.beans.NurseForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.NurseForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.NurseForTrackingVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.NurseForTrackingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.NurseForTrackingVoBean();
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
		if(fieldName.equals("MOS"))
			return getMos();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMosIsNotNull()
	{
		return this.mos != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getMos()
	{
		return this.mos;
	}
	public void setMos(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.mos = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.mos != null)
			sb.append(this.mos);
		return sb.toString();
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
	
		NurseForTrackingVo clone = new NurseForTrackingVo(this.id, this.version);
		
		if(this.mos == null)
			clone.mos = null;
		else
			clone.mos = (ims.core.vo.MemberOfStaffLiteVo)this.mos.clone();
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
		if (!(NurseForTrackingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurseForTrackingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NurseForTrackingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NurseForTrackingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.mos != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.core.vo.MemberOfStaffLiteVo mos;
	private boolean isValidated = false;
	private boolean isBusy = false;
}