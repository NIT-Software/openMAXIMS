// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.ReportNotePrintTemplate business object (ID: 1096100032).
 */
public class ReportNotePrintTemplateVo extends ims.RefMan.vo.ReportNotePrintTemplateRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReportNotePrintTemplateVo()
	{
	}
	public ReportNotePrintTemplateVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReportNotePrintTemplateVo(ims.RefMan.vo.beans.ReportNotePrintTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReportNotePrintTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReportNotePrintTemplateVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReportNotePrintTemplateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReportNotePrintTemplateVoBean();
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
		if(fieldName.equals("NOTETYPE"))
			return getNoteType();
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNoteTypeIsNotNull()
	{
		return this.notetype != null;
	}
	public ims.RefMan.vo.lookups.ReportNoteType getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.RefMan.vo.lookups.ReportNoteType value)
	{
		this.isValidated = false;
		this.notetype = value;
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.admin.vo.ReportTemplateLiteVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.admin.vo.ReportTemplateLiteVo value)
	{
		this.isValidated = false;
		this.template = value;
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
		if(this.template != null)
		{
			if(!this.template.isValidated())
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
		if(this.notetype == null)
			listOfErrors.add("NoteType is mandatory");
		if(this.template == null)
			listOfErrors.add("Template is mandatory");
		if(this.template != null)
		{
			String[] listOfOtherErrors = this.template.validate();
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
	
		ReportNotePrintTemplateVo clone = new ReportNotePrintTemplateVo(this.id, this.version);
		
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.RefMan.vo.lookups.ReportNoteType)this.notetype.clone();
		if(this.template == null)
			clone.template = null;
		else
			clone.template = (ims.admin.vo.ReportTemplateLiteVo)this.template.clone();
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
		if (!(ReportNotePrintTemplateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReportNotePrintTemplateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReportNotePrintTemplateVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReportNotePrintTemplateVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.notetype != null)
			count++;
		if(this.template != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.RefMan.vo.lookups.ReportNoteType notetype;
	protected ims.admin.vo.ReportTemplateLiteVo template;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
