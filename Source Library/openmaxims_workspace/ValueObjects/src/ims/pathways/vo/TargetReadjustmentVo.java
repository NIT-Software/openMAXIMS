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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.pathways.vo;

/**
 * Linked to Pathways.TargetReadjustment business object (ID: 1088100008).
 */
public class TargetReadjustmentVo extends ims.pathways.vo.TargetReadjustmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TargetReadjustmentVo()
	{
	}
	public TargetReadjustmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public TargetReadjustmentVo(ims.pathways.vo.beans.TargetReadjustmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.noofdays = bean.getNoOfDays();
		this.reason = bean.getReason();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.targetreadjustment = bean.getTargetReadjustment() == null ? null : ims.pathways.vo.lookups.TargetReadjustment.buildLookup(bean.getTargetReadjustment());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.TargetReadjustmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.noofdays = bean.getNoOfDays();
		this.reason = bean.getReason();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.targetreadjustment = bean.getTargetReadjustment() == null ? null : ims.pathways.vo.lookups.TargetReadjustment.buildLookup(bean.getTargetReadjustment());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.TargetReadjustmentVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.TargetReadjustmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.TargetReadjustmentVoBean();
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
		if(fieldName.equals("NOOFDAYS"))
			return getNoOfDays();
		if(fieldName.equals("REASON"))
			return getReason();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		if(fieldName.equals("TARGETREADJUSTMENT"))
			return getTargetReadjustment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNoOfDaysIsNotNull()
	{
		return this.noofdays != null;
	}
	public Integer getNoOfDays()
	{
		return this.noofdays;
	}
	public void setNoOfDays(Integer value)
	{
		this.isValidated = false;
		this.noofdays = value;
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public String getReason()
	{
		return this.reason;
	}
	public static int getReasonMaxLength()
	{
		return 3000;
	}
	public void setReason(String value)
	{
		this.isValidated = false;
		this.reason = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public boolean getTargetReadjustmentIsNotNull()
	{
		return this.targetreadjustment != null;
	}
	public ims.pathways.vo.lookups.TargetReadjustment getTargetReadjustment()
	{
		return this.targetreadjustment;
	}
	public void setTargetReadjustment(ims.pathways.vo.lookups.TargetReadjustment value)
	{
		this.isValidated = false;
		this.targetreadjustment = value;
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
		if(this.noofdays == null)
			listOfErrors.add("No. of Days is mandatory");
		if(this.reason != null)
			if(this.reason.length() > 3000)
				listOfErrors.add("The length of the field [reason] in the value object [ims.pathways.vo.TargetReadjustmentVo] is too big. It should be less or equal to 3000");
		if(this.targetreadjustment == null)
			listOfErrors.add("Reason is mandatory");
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
	
		TargetReadjustmentVo clone = new TargetReadjustmentVo(this.id, this.version);
		
		clone.noofdays = this.noofdays;
		clone.reason = this.reason;
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		if(this.targetreadjustment == null)
			clone.targetreadjustment = null;
		else
			clone.targetreadjustment = (ims.pathways.vo.lookups.TargetReadjustment)this.targetreadjustment.clone();
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
		if (!(TargetReadjustmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TargetReadjustmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TargetReadjustmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TargetReadjustmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.noofdays != null)
			count++;
		if(this.reason != null)
			count++;
		if(this.systeminformation != null)
			count++;
		if(this.targetreadjustment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected Integer noofdays;
	protected String reason;
	protected ims.vo.SystemInformation systeminformation;
	protected ims.pathways.vo.lookups.TargetReadjustment targetreadjustment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}