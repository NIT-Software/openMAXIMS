// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class TLTContactTimeVoBean extends ims.vo.ValueObjectBean
{
	public TLTContactTimeVoBean()
	{
	}
	public TLTContactTimeVoBean(ims.RefMan.vo.TLTContactTimeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttherapist = vo.getStartTherapist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getStartTherapist().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.endtherapist = vo.getEndTherapist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getEndTherapist().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.TLTContactTimeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttherapist = vo.getStartTherapist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getStartTherapist().getBean(map);
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.endtherapist = vo.getEndTherapist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getEndTherapist().getBean(map);
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
	}

	public ims.RefMan.vo.TLTContactTimeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.TLTContactTimeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.TLTContactTimeVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.TLTContactTimeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.TLTContactTimeVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getStartTherapist()
	{
		return this.starttherapist;
	}
	public void setStartTherapist(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.starttherapist = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getEndTherapist()
	{
		return this.endtherapist;
	}
	public void setEndTherapist(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.endtherapist = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.enddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean starttherapist;
	private ims.framework.utils.beans.DateTimeBean startdatetime;
	private ims.core.vo.beans.HcpLiteVoBean endtherapist;
	private ims.framework.utils.beans.DateTimeBean enddatetime;
}
