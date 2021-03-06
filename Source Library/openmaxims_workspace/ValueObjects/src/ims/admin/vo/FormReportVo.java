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

package ims.admin.vo;

/**
 * Linked to core.admin.FormReportBo business object (ID: 1004100012).
 */
public class FormReportVo extends ims.core.admin.vo.FormReportBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FormReportVo()
	{
	}
	public FormReportVo(Integer id, int version)
	{
		super(id, version);
	}
	public FormReportVo(ims.admin.vo.beans.FormReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.form = bean.getForm() == null ? null : new ims.core.configuration.vo.AppFormRefVo(new Integer(bean.getForm().getId()), bean.getForm().getVersion());
		this.report = bean.getReport() == null ? null : new ims.core.admin.vo.ReportBoRefVo(new Integer(bean.getReport().getId()), bean.getReport().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.FormReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.form = bean.getForm() == null ? null : new ims.core.configuration.vo.AppFormRefVo(new Integer(bean.getForm().getId()), bean.getForm().getVersion());
		this.report = bean.getReport() == null ? null : new ims.core.admin.vo.ReportBoRefVo(new Integer(bean.getReport().getId()), bean.getReport().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.FormReportVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.FormReportVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.FormReportVoBean();
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
		if(fieldName.equals("FORM"))
			return getForm();
		if(fieldName.equals("REPORT"))
			return getReport();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFormIsNotNull()
	{
		return this.form != null;
	}
	public ims.core.configuration.vo.AppFormRefVo getForm()
	{
		return this.form;
	}
	public void setForm(ims.core.configuration.vo.AppFormRefVo value)
	{
		this.isValidated = false;
		this.form = value;
	}
	public boolean getReportIsNotNull()
	{
		return this.report != null;
	}
	public ims.core.admin.vo.ReportBoRefVo getReport()
	{
		return this.report;
	}
	public void setReport(ims.core.admin.vo.ReportBoRefVo value)
	{
		this.isValidated = false;
		this.report = value;
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
	
		FormReportVo clone = new FormReportVo(this.id, this.version);
		
		clone.form = this.form;
		clone.report = this.report;
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
		if (!(FormReportVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FormReportVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FormReportVo compareObj = (FormReportVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getForm() == null && compareObj.getForm() != null)
				return -1;
			if(this.getForm() != null && compareObj.getForm() == null)
				return 1;
			if(this.getForm() != null && compareObj.getForm() != null)
				retVal = this.getForm().compareTo(compareObj.getForm());
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
		if(this.form != null)
			count++;
		if(this.report != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.configuration.vo.AppFormRefVo form;
	protected ims.core.admin.vo.ReportBoRefVo report;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
