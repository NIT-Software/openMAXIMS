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

package ims.core.vo;

/**
 * Linked to core.resource.place.CCGPCTPCCodes business object (ID: 1007100017).
 */
public class CCGPCTPCCodesVo extends ims.core.resource.place.vo.CCGPCTPCCodesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CCGPCTPCCodesVo()
	{
	}
	public CCGPCTPCCodesVo(Integer id, int version)
	{
		super(id, version);
	}
	public CCGPCTPCCodesVo(ims.core.vo.beans.CCGPCTPCCodesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ccgcode = bean.getCCGCode();
		this.ccgdescription = bean.getCCGDescription();
		this.postcode = bean.getPostcode();
		this.dhacode = bean.getDHACode();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CCGPCTPCCodesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ccgcode = bean.getCCGCode();
		this.ccgdescription = bean.getCCGDescription();
		this.postcode = bean.getPostcode();
		this.dhacode = bean.getDHACode();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CCGPCTPCCodesVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CCGPCTPCCodesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CCGPCTPCCodesVoBean();
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
		if(fieldName.equals("CCGCODE"))
			return getCCGCode();
		if(fieldName.equals("CCGDESCRIPTION"))
			return getCCGDescription();
		if(fieldName.equals("POSTCODE"))
			return getPostcode();
		if(fieldName.equals("DHACODE"))
			return getDHACode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCCGCodeIsNotNull()
	{
		return this.ccgcode != null;
	}
	public String getCCGCode()
	{
		return this.ccgcode;
	}
	public static int getCCGCodeMaxLength()
	{
		return 5;
	}
	public void setCCGCode(String value)
	{
		this.isValidated = false;
		this.ccgcode = value;
	}
	public boolean getCCGDescriptionIsNotNull()
	{
		return this.ccgdescription != null;
	}
	public String getCCGDescription()
	{
		return this.ccgdescription;
	}
	public static int getCCGDescriptionMaxLength()
	{
		return 70;
	}
	public void setCCGDescription(String value)
	{
		this.isValidated = false;
		this.ccgdescription = value;
	}
	public boolean getPostcodeIsNotNull()
	{
		return this.postcode != null;
	}
	public String getPostcode()
	{
		return this.postcode;
	}
	public static int getPostcodeMaxLength()
	{
		return 8;
	}
	public void setPostcode(String value)
	{
		this.isValidated = false;
		this.postcode = value;
	}
	public boolean getDHACodeIsNotNull()
	{
		return this.dhacode != null;
	}
	public String getDHACode()
	{
		return this.dhacode;
	}
	public static int getDHACodeMaxLength()
	{
		return 5;
	}
	public void setDHACode(String value)
	{
		this.isValidated = false;
		this.dhacode = value;
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
		if(this.ccgcode == null || this.ccgcode.length() == 0)
			listOfErrors.add("CCGCode is mandatory");
		else if(this.ccgcode.length() > 5)
			listOfErrors.add("The length of the field [ccgcode] in the value object [ims.core.vo.CCGPCTPCCodesVo] is too big. It should be less or equal to 5");
		if(this.ccgdescription != null)
			if(this.ccgdescription.length() > 70)
				listOfErrors.add("The length of the field [ccgdescription] in the value object [ims.core.vo.CCGPCTPCCodesVo] is too big. It should be less or equal to 70");
		if(this.postcode == null || this.postcode.length() == 0)
			listOfErrors.add("Postcode is mandatory");
		else if(this.postcode.length() > 8)
			listOfErrors.add("The length of the field [postcode] in the value object [ims.core.vo.CCGPCTPCCodesVo] is too big. It should be less or equal to 8");
		if(this.dhacode != null)
			if(this.dhacode.length() > 5)
				listOfErrors.add("The length of the field [dhacode] in the value object [ims.core.vo.CCGPCTPCCodesVo] is too big. It should be less or equal to 5");
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
	
		CCGPCTPCCodesVo clone = new CCGPCTPCCodesVo(this.id, this.version);
		
		clone.ccgcode = this.ccgcode;
		clone.ccgdescription = this.ccgdescription;
		clone.postcode = this.postcode;
		clone.dhacode = this.dhacode;
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
		if (!(CCGPCTPCCodesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CCGPCTPCCodesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CCGPCTPCCodesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CCGPCTPCCodesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ccgcode != null)
			count++;
		if(this.ccgdescription != null)
			count++;
		if(this.postcode != null)
			count++;
		if(this.dhacode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String ccgcode;
	protected String ccgdescription;
	protected String postcode;
	protected String dhacode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
