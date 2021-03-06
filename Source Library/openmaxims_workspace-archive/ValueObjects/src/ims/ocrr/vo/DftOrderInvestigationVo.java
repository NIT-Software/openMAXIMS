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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class DftOrderInvestigationVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DftOrderInvestigationVo()
	{
	}
	public DftOrderInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public DftOrderInvestigationVo(ims.ocrr.vo.beans.DftOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo();
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.DftOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo(map);
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.DftOrderInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.DftOrderInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.DftOrderInvestigationVoBean();
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
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("PLACERORDNUM"))
			return getPlacerOrdNum();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationUnderSpecimenVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationUnderSpecimenVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.vo.OcsOrderForDFTOrderInvestigationVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.OcsOrderForDFTOrderInvestigationVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getPlacerOrdNumIsNotNull()
	{
		return this.placerordnum != null;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public static int getPlacerOrdNumMaxLength()
	{
		return 20;
	}
	public void setPlacerOrdNum(String value)
	{
		this.isValidated = false;
		this.placerordnum = value;
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
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.placerordnum != null)
			if(this.placerordnum.length() > 20)
				listOfErrors.add("The length of the field [placerordnum] in the value object [ims.ocrr.vo.DftOrderInvestigationVo] is too big. It should be less or equal to 20");
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
	
		DftOrderInvestigationVo clone = new DftOrderInvestigationVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationUnderSpecimenVo)this.investigation.clone();
		if(this.orderdetails == null)
			clone.orderdetails = null;
		else
			clone.orderdetails = (ims.ocrr.vo.OcsOrderForDFTOrderInvestigationVo)this.orderdetails.clone();
		clone.placerordnum = this.placerordnum;
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
		if (!(DftOrderInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DftOrderInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DftOrderInvestigationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DftOrderInvestigationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigation != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.placerordnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.ocrr.vo.InvestigationUnderSpecimenVo investigation;
	protected ims.ocrr.vo.OcsOrderForDFTOrderInvestigationVo orderdetails;
	protected String placerordnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
