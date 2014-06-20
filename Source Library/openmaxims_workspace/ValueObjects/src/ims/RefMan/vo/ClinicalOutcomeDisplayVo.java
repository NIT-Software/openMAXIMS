// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.ClinicalOutcome business object (ID: 1072100092).
 */
public class ClinicalOutcomeDisplayVo extends ims.RefMan.vo.ClinicalOutcomeLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeDisplayVo()
	{
	}
	public ClinicalOutcomeDisplayVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalOutcomeDisplayVo(ims.RefMan.vo.beans.ClinicalOutcomeDisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
		this.code = bean.getCode();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ClinicalOutcomeDisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
		this.code = bean.getCode();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ClinicalOutcomeDisplayVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ClinicalOutcomeDisplayVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ClinicalOutcomeDisplayVoBean();
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
		if(fieldName.equals("CODE"))
			return getCode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCodeIsNotNull()
	{
		return this.code != null;
	}
	public String getCode()
	{
		return this.code;
	}
	public static int getCodeMaxLength()
	{
		return 255;
	}
	public void setCode(String value)
	{
		this.isValidated = false;
		this.code = value;
	}
	/**
	* Constructor from LiteVo
	*/
		public ClinicalOutcomeDisplayVo(ims.RefMan.vo.ClinicalOutcomeLiteVo value)
		{
			this.id = value.getID_ClinicalOutcome();
			this.version = value.getVersion_ClinicalOutcome();
			this.clinicaloutcome = value.getClinicalOutcome();
			this.date = value.getDate();
			this.procedure = value.getProcedure();
			this.clinicaloutcomecontext = value.getClinicalOutcomeContext();
			this.code = null;
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
		if(this.clinicaloutcome == null)
			listOfErrors.add("Clinical Outcome is mandatory");
		if(this.date == null)
			listOfErrors.add("Clinical Outcome Date is mandatory");
		if(this.clinicaloutcomecontext == null)
			listOfErrors.add("Clinical Outcome Context is mandatory");
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
	
		ClinicalOutcomeDisplayVo clone = new ClinicalOutcomeDisplayVo(this.id, this.version);
		
		if(this.clinicaloutcome == null)
			clone.clinicaloutcome = null;
		else
			clone.clinicaloutcome = (ims.clinicaladmin.vo.ClinicalOutcomeConfigLiteVo)this.clinicaloutcome.clone();
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.RefMan.vo.ClinicalOutcomeProcedureVo)this.procedure.clone();
		if(this.clinicaloutcomecontext == null)
			clone.clinicaloutcomecontext = null;
		else
			clone.clinicaloutcomecontext = (ims.RefMan.vo.lookups.ClinicalOutcomeContext)this.clinicaloutcomecontext.clone();
		clone.code = this.code;
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
		if (!(ClinicalOutcomeDisplayVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalOutcomeDisplayVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalOutcomeDisplayVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalOutcomeDisplayVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.code != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected String code;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
