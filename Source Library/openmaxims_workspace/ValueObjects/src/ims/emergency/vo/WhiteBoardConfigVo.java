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
 * Linked to emergency.Configuration.WhiteBoardConfig business object (ID: 1087100018).
 */
public class WhiteBoardConfigVo extends ims.emergency.configuration.vo.WhiteBoardConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WhiteBoardConfigVo()
	{
	}
	public WhiteBoardConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public WhiteBoardConfigVo(ims.emergency.vo.beans.WhiteBoardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.edlocation = bean.getEDLocation() == null ? null : bean.getEDLocation().buildVo();
		this.isactive = bean.getIsActive();
		this.assessments = ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection.buildFromBeanCollection(bean.getAssessments());
		this.comments = bean.getComments();
		this.currentarea = bean.getCurrentArea() == null ? null : bean.getCurrentArea().buildVo();
		this.selectedactions = ims.emergency.vo.WhiteBoardOtherActionsVoCollection.buildFromBeanCollection(bean.getSelectedActions());
		this.refreshinterval = bean.getRefreshInterval();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.WhiteBoardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.edlocation = bean.getEDLocation() == null ? null : bean.getEDLocation().buildVo(map);
		this.isactive = bean.getIsActive();
		this.assessments = ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection.buildFromBeanCollection(bean.getAssessments());
		this.comments = bean.getComments();
		this.currentarea = bean.getCurrentArea() == null ? null : bean.getCurrentArea().buildVo(map);
		this.selectedactions = ims.emergency.vo.WhiteBoardOtherActionsVoCollection.buildFromBeanCollection(bean.getSelectedActions());
		this.refreshinterval = bean.getRefreshInterval();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.WhiteBoardConfigVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.WhiteBoardConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.WhiteBoardConfigVoBean();
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
		if(fieldName.equals("EDLOCATION"))
			return getEDLocation();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ASSESSMENTS"))
			return getAssessments();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("CURRENTAREA"))
			return getCurrentArea();
		if(fieldName.equals("SELECTEDACTIONS"))
			return getSelectedActions();
		if(fieldName.equals("REFRESHINTERVAL"))
			return getRefreshInterval();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEDLocationIsNotNull()
	{
		return this.edlocation != null;
	}
	public ims.core.vo.LocationLiteVo getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.edlocation = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getAssessmentsIsNotNull()
	{
		return this.assessments != null;
	}
	public ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection getAssessments()
	{
		return this.assessments;
	}
	public void setAssessments(ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection value)
	{
		this.isValidated = false;
		this.assessments = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public Boolean getComments()
	{
		return this.comments;
	}
	public void setComments(Boolean value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getCurrentAreaIsNotNull()
	{
		return this.currentarea != null;
	}
	public ims.emergency.vo.TrackingAreaLiteVo getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.vo.TrackingAreaLiteVo value)
	{
		this.isValidated = false;
		this.currentarea = value;
	}
	public boolean getSelectedActionsIsNotNull()
	{
		return this.selectedactions != null;
	}
	public ims.emergency.vo.WhiteBoardOtherActionsVoCollection getSelectedActions()
	{
		return this.selectedactions;
	}
	public void setSelectedActions(ims.emergency.vo.WhiteBoardOtherActionsVoCollection value)
	{
		this.isValidated = false;
		this.selectedactions = value;
	}
	public boolean getRefreshIntervalIsNotNull()
	{
		return this.refreshinterval != null;
	}
	public Integer getRefreshInterval()
	{
		return this.refreshinterval;
	}
	public void setRefreshInterval(Integer value)
	{
		this.isValidated = false;
		this.refreshinterval = value;
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
		if(this.assessments != null)
		{
			if(!this.assessments.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.selectedactions != null)
		{
			if(!this.selectedactions.isValidated())
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
		if(this.edlocation == null)
			listOfErrors.add("EDLocation is mandatory");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.assessments != null)
		{
			String[] listOfOtherErrors = this.assessments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments == null)
			listOfErrors.add("Comments is mandatory");
		if(this.selectedactions != null)
		{
			String[] listOfOtherErrors = this.selectedactions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		WhiteBoardConfigVo clone = new WhiteBoardConfigVo(this.id, this.version);
		
		if(this.edlocation == null)
			clone.edlocation = null;
		else
			clone.edlocation = (ims.core.vo.LocationLiteVo)this.edlocation.clone();
		clone.isactive = this.isactive;
		if(this.assessments == null)
			clone.assessments = null;
		else
			clone.assessments = (ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection)this.assessments.clone();
		clone.comments = this.comments;
		if(this.currentarea == null)
			clone.currentarea = null;
		else
			clone.currentarea = (ims.emergency.vo.TrackingAreaLiteVo)this.currentarea.clone();
		if(this.selectedactions == null)
			clone.selectedactions = null;
		else
			clone.selectedactions = (ims.emergency.vo.WhiteBoardOtherActionsVoCollection)this.selectedactions.clone();
		clone.refreshinterval = this.refreshinterval;
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
		if (!(WhiteBoardConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WhiteBoardConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WhiteBoardConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WhiteBoardConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.edlocation != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.assessments != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.currentarea != null)
			count++;
		if(this.selectedactions != null)
			count++;
		if(this.refreshinterval != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.LocationLiteVo edlocation;
	protected Boolean isactive;
	protected ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection assessments;
	protected Boolean comments;
	protected ims.emergency.vo.TrackingAreaLiteVo currentarea;
	protected ims.emergency.vo.WhiteBoardOtherActionsVoCollection selectedactions;
	protected Integer refreshinterval;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
