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


public class ActionWhiteBoardVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionWhiteBoardVo()
	{
	}
	public ActionWhiteBoardVo(ims.emergency.vo.beans.ActionWhiteBoardVoBean bean)
	{
		this.action = bean.getAction() == null ? null : bean.getAction().buildVo();
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.WhiteBoardActionStatus.buildLookup(bean.getStatus());
		this.nrcolumn = bean.getNrColumn();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ActionWhiteBoardVoBean bean)
	{
		this.action = bean.getAction() == null ? null : bean.getAction().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.WhiteBoardActionStatus.buildLookup(bean.getStatus());
		this.nrcolumn = bean.getNrColumn();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ActionWhiteBoardVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ActionWhiteBoardVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ActionWhiteBoardVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getActionIsNotNull()
	{
		return this.action != null;
	}
	public ims.emergency.vo.WhiteBoardOtherActionsVo getAction()
	{
		return this.action;
	}
	public void setAction(ims.emergency.vo.WhiteBoardOtherActionsVo value)
	{
		this.isValidated = false;
		this.action = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.emergency.vo.lookups.WhiteBoardActionStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.emergency.vo.lookups.WhiteBoardActionStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getNrColumnIsNotNull()
	{
		return this.nrcolumn != null;
	}
	public Integer getNrColumn()
	{
		return this.nrcolumn;
	}
	public void setNrColumn(Integer value)
	{
		this.isValidated = false;
		this.nrcolumn = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ActionWhiteBoardVo))
			return false;
		ActionWhiteBoardVo compareObj = (ActionWhiteBoardVo)obj;
		if(this.getAction() == null && compareObj.getAction() != null)
			return false;
		if(this.getAction() != null && compareObj.getAction() == null)
			return false;
		if(this.getAction() != null && compareObj.getAction() != null)
			return this.getAction().equals(compareObj.getAction());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ActionWhiteBoardVo clone = new ActionWhiteBoardVo();
		
		if(this.action == null)
			clone.action = null;
		else
			clone.action = (ims.emergency.vo.WhiteBoardOtherActionsVo)this.action.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.emergency.vo.lookups.WhiteBoardActionStatus)this.status.clone();
		clone.nrcolumn = this.nrcolumn;
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
		if (!(ActionWhiteBoardVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionWhiteBoardVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ActionWhiteBoardVo compareObj = (ActionWhiteBoardVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAction() == null && compareObj.getAction() != null)
				return -1;
			if(this.getAction() != null && compareObj.getAction() == null)
				return 1;
			if(this.getAction() != null && compareObj.getAction() != null)
				retVal = this.getAction().compareTo(compareObj.getAction());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.action != null)
			count++;
		if(this.status != null)
			count++;
		if(this.nrcolumn != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.emergency.vo.WhiteBoardOtherActionsVo action;
	protected ims.emergency.vo.lookups.WhiteBoardActionStatus status;
	protected Integer nrcolumn;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
