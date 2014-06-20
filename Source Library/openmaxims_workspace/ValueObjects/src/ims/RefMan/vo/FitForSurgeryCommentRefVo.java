// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.FitForSurgeryComment business object (ID: 1096100042).
 */
public class FitForSurgeryCommentRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public FitForSurgeryCommentRefVo()
	{
	}
	public FitForSurgeryCommentRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_FitForSurgeryCommentIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_FitForSurgeryComment()
	{
		return this.id;
	}
	public final void setID_FitForSurgeryComment(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_FitForSurgeryComment()
	{
		return this.version;
	}
	public Object clone()
	{
		return new FitForSurgeryCommentRefVo(this.id, this.version);
	}
	public final FitForSurgeryCommentRefVo toFitForSurgeryCommentRefVo()
	{
		if(this.id == null)
			return this;
		return new FitForSurgeryCommentRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof FitForSurgeryCommentRefVo))
			return false;
		FitForSurgeryCommentRefVo compareObj = (FitForSurgeryCommentRefVo)obj;
		if(this.id != null && compareObj.getBoId() != null)
			return this.id.equals(compareObj.getBoId());
		if(this.id != null && compareObj.getBoId() == null)
			return false;
		if(this.id == null && compareObj.getBoId() != null)
			return false;
		return super.equals(obj);
	}
	public int hashCode()
	{
		if(this.id != null)
			return this.id.intValue();
		return super.hashCode();
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.FitForSurgeryComment";
	}
	public Class getDomainClass()
	{
		return ims.RefMan.domain.objects.FitForSurgeryComment.class;
	}
	public String getIItemText()
	{
		return toString();
	}
	public String toString()
	{
		return this.getClass().toString() + " (ID: " + (this.id == null ? "null" : this.id.toString()) + ")";
	}
	public int compareTo(Object obj)
	{
		if (obj == null)
			return -1;
		if (!(obj instanceof FitForSurgeryCommentRefVo))
			throw new ClassCastException("A FitForSurgeryCommentRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((FitForSurgeryCommentRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((FitForSurgeryCommentRefVo)obj).getBoId());
	}
	// this method is not needed. It is here for compatibility purpose only.
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if(caseInsensitive); // this is to avoid Eclipse warning
		return compareTo(obj);
	}

	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ID_FITFORSURGERYCOMMENT"))
			return getID_FitForSurgeryComment();
		return super.getFieldValueByFieldName(fieldName);
	}
}
