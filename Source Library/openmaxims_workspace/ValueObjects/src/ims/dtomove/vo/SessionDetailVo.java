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

package ims.dtomove.vo;

/**
 * Linked to dto_move.SessionDetail business object (ID: 1105100031).
 */
public class SessionDetailVo extends ims.dto_move.vo.SessionDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionDetailVo()
	{
	}
	public SessionDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionDetailVo(ims.dtomove.vo.beans.SessionDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.machine_id = bean.getMachine_id() == null ? null : bean.getMachine_id().buildVo();
		this.maxappts = bean.getMaxAppts();
		this.remappts = bean.getRemAppts();
		this.mininterval = bean.getMinInterval();
		this.remtime = bean.getRemTime();
		this.active = bean.getActive();
		this.internalloc = bean.getInternalLoc() == null ? null : new ims.dto_move.vo.InternalLocationRefVo(new Integer(bean.getInternalLoc().getId()), bean.getInternalLoc().getVersion());
		this.duration = bean.getDuration();
		this.modindicator = bean.getModIndicator();
		this.description = bean.getDescription();
		this.status = bean.getStatus();
		this.statusreason = bean.getStatusReason();
		this.profiledetailid = bean.getProfileDetailId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.beans.SessionDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.machine_id = bean.getMachine_id() == null ? null : bean.getMachine_id().buildVo(map);
		this.maxappts = bean.getMaxAppts();
		this.remappts = bean.getRemAppts();
		this.mininterval = bean.getMinInterval();
		this.remtime = bean.getRemTime();
		this.active = bean.getActive();
		this.internalloc = bean.getInternalLoc() == null ? null : new ims.dto_move.vo.InternalLocationRefVo(new Integer(bean.getInternalLoc().getId()), bean.getInternalLoc().getVersion());
		this.duration = bean.getDuration();
		this.modindicator = bean.getModIndicator();
		this.description = bean.getDescription();
		this.status = bean.getStatus();
		this.statusreason = bean.getStatusReason();
		this.profiledetailid = bean.getProfileDetailId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.beans.SessionDetailVoBean bean = null;
		if(map != null)
			bean = (ims.dtomove.vo.beans.SessionDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.dtomove.vo.beans.SessionDetailVoBean();
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
		if(fieldName.equals("MACHINE_ID"))
			return getMachine_id();
		if(fieldName.equals("MAXAPPTS"))
			return getMaxAppts();
		if(fieldName.equals("REMAPPTS"))
			return getRemAppts();
		if(fieldName.equals("MININTERVAL"))
			return getMinInterval();
		if(fieldName.equals("REMTIME"))
			return getRemTime();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("INTERNALLOC"))
			return getInternalLoc();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("MODINDICATOR"))
			return getModIndicator();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("PROFILEDETAILID"))
			return getProfileDetailId();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMachine_idIsNotNull()
	{
		return this.machine_id != null;
	}
	public ims.dtomove.vo.RadiotherapyMachineVo getMachine_id()
	{
		return this.machine_id;
	}
	public void setMachine_id(ims.dtomove.vo.RadiotherapyMachineVo value)
	{
		this.isValidated = false;
		this.machine_id = value;
	}
	public boolean getMaxApptsIsNotNull()
	{
		return this.maxappts != null;
	}
	public Integer getMaxAppts()
	{
		return this.maxappts;
	}
	public void setMaxAppts(Integer value)
	{
		this.isValidated = false;
		this.maxappts = value;
	}
	public boolean getRemApptsIsNotNull()
	{
		return this.remappts != null;
	}
	public Integer getRemAppts()
	{
		return this.remappts;
	}
	public void setRemAppts(Integer value)
	{
		this.isValidated = false;
		this.remappts = value;
	}
	public boolean getMinIntervalIsNotNull()
	{
		return this.mininterval != null;
	}
	public Integer getMinInterval()
	{
		return this.mininterval;
	}
	public void setMinInterval(Integer value)
	{
		this.isValidated = false;
		this.mininterval = value;
	}
	public boolean getRemTimeIsNotNull()
	{
		return this.remtime != null;
	}
	public Integer getRemTime()
	{
		return this.remtime;
	}
	public void setRemTime(Integer value)
	{
		this.isValidated = false;
		this.remtime = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public String getActive()
	{
		return this.active;
	}
	public static int getActiveMaxLength()
	{
		return 1;
	}
	public void setActive(String value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getInternalLocIsNotNull()
	{
		return this.internalloc != null;
	}
	public ims.dto_move.vo.InternalLocationRefVo getInternalLoc()
	{
		return this.internalloc;
	}
	public void setInternalLoc(ims.dto_move.vo.InternalLocationRefVo value)
	{
		this.isValidated = false;
		this.internalloc = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getModIndicatorIsNotNull()
	{
		return this.modindicator != null;
	}
	public String getModIndicator()
	{
		return this.modindicator;
	}
	public static int getModIndicatorMaxLength()
	{
		return 1;
	}
	public void setModIndicator(String value)
	{
		this.isValidated = false;
		this.modindicator = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public Integer getStatus()
	{
		return this.status;
	}
	public void setStatus(Integer value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public Integer getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(Integer value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getProfileDetailIdIsNotNull()
	{
		return this.profiledetailid != null;
	}
	public Integer getProfileDetailId()
	{
		return this.profiledetailid;
	}
	public void setProfileDetailId(Integer value)
	{
		this.isValidated = false;
		this.profiledetailid = value;
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
		if(this.machine_id != null)
		{
			if(!this.machine_id.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.machine_id != null)
		{
			String[] listOfOtherErrors = this.machine_id.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.active != null)
			if(this.active.length() > 1)
				listOfErrors.add("The length of the field [active] in the value object [ims.dtomove.vo.SessionDetailVo] is too big. It should be less or equal to 1");
		if(this.modindicator != null)
			if(this.modindicator.length() > 1)
				listOfErrors.add("The length of the field [modindicator] in the value object [ims.dtomove.vo.SessionDetailVo] is too big. It should be less or equal to 1");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.dtomove.vo.SessionDetailVo] is too big. It should be less or equal to 255");
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
	
		SessionDetailVo clone = new SessionDetailVo(this.id, this.version);
		
		if(this.machine_id == null)
			clone.machine_id = null;
		else
			clone.machine_id = (ims.dtomove.vo.RadiotherapyMachineVo)this.machine_id.clone();
		clone.maxappts = this.maxappts;
		clone.remappts = this.remappts;
		clone.mininterval = this.mininterval;
		clone.remtime = this.remtime;
		clone.active = this.active;
		clone.internalloc = this.internalloc;
		clone.duration = this.duration;
		clone.modindicator = this.modindicator;
		clone.description = this.description;
		clone.status = this.status;
		clone.statusreason = this.statusreason;
		clone.profiledetailid = this.profiledetailid;
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
		if (!(SessionDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.machine_id != null)
			count++;
		if(this.maxappts != null)
			count++;
		if(this.remappts != null)
			count++;
		if(this.mininterval != null)
			count++;
		if(this.remtime != null)
			count++;
		if(this.active != null)
			count++;
		if(this.internalloc != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.modindicator != null)
			count++;
		if(this.description != null)
			count++;
		if(this.status != null)
			count++;
		if(this.statusreason != null)
			count++;
		if(this.profiledetailid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.dtomove.vo.RadiotherapyMachineVo machine_id;
	protected Integer maxappts;
	protected Integer remappts;
	protected Integer mininterval;
	protected Integer remtime;
	protected String active;
	protected ims.dto_move.vo.InternalLocationRefVo internalloc;
	protected Integer duration;
	protected String modindicator;
	protected String description;
	protected Integer status;
	protected Integer statusreason;
	protected Integer profiledetailid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}