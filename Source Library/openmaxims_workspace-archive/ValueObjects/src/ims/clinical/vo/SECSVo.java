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

package ims.clinical.vo;

/**
 * Linked to clinical.configuration.SECS business object (ID: 1028100042).
 */
public class SECSVo extends ims.clinical.configuration.vo.SECSRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SECSVo()
	{
	}
	public SECSVo(Integer id, int version)
	{
		super(id, version);
	}
	public SECSVo(ims.clinical.vo.beans.SECSVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuration = ims.clinical.vo.SECSConfigurationVoCollection.buildFromBeanCollection(bean.getConfiguration());
		this.ewstriggerscore = bean.getEWSTriggerScore();
		this.ewsprotocol = bean.getEWSProtocol() == null ? null : bean.getEWSProtocol().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SECSVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuration = ims.clinical.vo.SECSConfigurationVoCollection.buildFromBeanCollection(bean.getConfiguration());
		this.ewstriggerscore = bean.getEWSTriggerScore();
		this.ewsprotocol = bean.getEWSProtocol() == null ? null : bean.getEWSProtocol().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SECSVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SECSVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SECSVoBean();
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
		if(fieldName.equals("CONFIGURATION"))
			return getConfiguration();
		if(fieldName.equals("EWSTRIGGERSCORE"))
			return getEWSTriggerScore();
		if(fieldName.equals("EWSPROTOCOL"))
			return getEWSProtocol();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getConfigurationIsNotNull()
	{
		return this.configuration != null;
	}
	public ims.clinical.vo.SECSConfigurationVoCollection getConfiguration()
	{
		return this.configuration;
	}
	public void setConfiguration(ims.clinical.vo.SECSConfigurationVoCollection value)
	{
		this.isValidated = false;
		this.configuration = value;
	}
	public boolean getEWSTriggerScoreIsNotNull()
	{
		return this.ewstriggerscore != null;
	}
	public Integer getEWSTriggerScore()
	{
		return this.ewstriggerscore;
	}
	public void setEWSTriggerScore(Integer value)
	{
		this.isValidated = false;
		this.ewstriggerscore = value;
	}
	public boolean getEWSProtocolIsNotNull()
	{
		return this.ewsprotocol != null;
	}
	public ims.assessment.vo.UserAssessmentLiteVo getEWSProtocol()
	{
		return this.ewsprotocol;
	}
	public void setEWSProtocol(ims.assessment.vo.UserAssessmentLiteVo value)
	{
		this.isValidated = false;
		this.ewsprotocol = value;
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
		if(this.configuration != null)
		{
			if(!this.configuration.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ewsprotocol != null)
		{
			if(!this.ewsprotocol.isValidated())
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
		if(this.configuration != null)
		{
			String[] listOfOtherErrors = this.configuration.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ewstriggerscore == null)
			listOfErrors.add("Score which triggers EWS/SECS Protocol is a mandatory field");
		if(this.ewsprotocol != null)
		{
			String[] listOfOtherErrors = this.ewsprotocol.validate();
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
	
		SECSVo clone = new SECSVo(this.id, this.version);
		
		if(this.configuration == null)
			clone.configuration = null;
		else
			clone.configuration = (ims.clinical.vo.SECSConfigurationVoCollection)this.configuration.clone();
		clone.ewstriggerscore = this.ewstriggerscore;
		if(this.ewsprotocol == null)
			clone.ewsprotocol = null;
		else
			clone.ewsprotocol = (ims.assessment.vo.UserAssessmentLiteVo)this.ewsprotocol.clone();
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
		if (!(SECSVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SECSVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SECSVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SECSVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.configuration != null)
			count++;
		if(this.ewstriggerscore != null)
			count++;
		if(this.ewsprotocol != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.clinical.vo.SECSConfigurationVoCollection configuration;
	protected Integer ewstriggerscore;
	protected ims.assessment.vo.UserAssessmentLiteVo ewsprotocol;
	private boolean isValidated = false;
	private boolean isBusy = false;
}