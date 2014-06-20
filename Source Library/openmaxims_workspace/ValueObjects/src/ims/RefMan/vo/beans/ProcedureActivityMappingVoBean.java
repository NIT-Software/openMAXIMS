// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ProcedureActivityMappingVoBean extends ims.vo.ValueObjectBean
{
	public ProcedureActivityMappingVoBean()
	{
	}
	public ProcedureActivityMappingVoBean(ims.RefMan.vo.ProcedureActivityMappingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activitycode = vo.getActivityCode();
		if(vo.getProcedures() != null)
		{
			this.procedures = new ims.vo.RefVoBean[vo.getProcedures().size()];
			for(int procedures_i = 0; procedures_i < vo.getProcedures().size(); procedures_i++)
			{
				this.procedures[procedures_i] = new ims.vo.RefVoBean(vo.getProcedures().get(procedures_i).getBoId(),vo.getProcedures().get(procedures_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ProcedureActivityMappingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activitycode = vo.getActivityCode();
		if(vo.getProcedures() != null)
		{
			this.procedures = new ims.vo.RefVoBean[vo.getProcedures().size()];
			for(int procedures_i = 0; procedures_i < vo.getProcedures().size(); procedures_i++)
			{
				this.procedures[procedures_i] = new ims.vo.RefVoBean(vo.getProcedures().get(procedures_i).getBoId(),vo.getProcedures().get(procedures_i).getBoVersion());
			}
		}
	}

	public ims.RefMan.vo.ProcedureActivityMappingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ProcedureActivityMappingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ProcedureActivityMappingVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ProcedureActivityMappingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ProcedureActivityMappingVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getActivityCode()
	{
		return this.activitycode;
	}
	public void setActivityCode(String value)
	{
		this.activitycode = value;
	}
	public ims.vo.RefVoBean[] getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.vo.RefVoBean[] value)
	{
		this.procedures = value;
	}

	private Integer id;
	private int version;
	private String activitycode;
	private ims.vo.RefVoBean[] procedures;
}
