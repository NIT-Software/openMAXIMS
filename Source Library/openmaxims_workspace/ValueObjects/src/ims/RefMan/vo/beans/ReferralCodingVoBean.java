// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ReferralCodingVoBean extends ims.vo.ValueObjectBean
{
	public ReferralCodingVoBean()
	{
	}
	public ReferralCodingVoBean(ims.RefMan.vo.ReferralCodingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.codingitems = vo.getCodingItems() == null ? null : vo.getCodingItems().getBeanCollection();
		this.authoringmos = vo.getAuthoringMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringMOS().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.comments = vo.getComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralCodingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.codingitems = vo.getCodingItems() == null ? null : vo.getCodingItems().getBeanCollection();
		this.authoringmos = vo.getAuthoringMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringMOS().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.comments = vo.getComments();
	}

	public ims.RefMan.vo.ReferralCodingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralCodingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralCodingVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralCodingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralCodingVo();
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
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.RefMan.vo.beans.ReferralCodingItemVoBean[] getCodingItems()
	{
		return this.codingitems;
	}
	public void setCodingItems(ims.RefMan.vo.beans.ReferralCodingItemVoBean[] value)
	{
		this.codingitems = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAuthoringMOS()
	{
		return this.authoringmos;
	}
	public void setAuthoringMOS(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.authoringmos = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.RefMan.vo.beans.ReferralCodingItemVoBean[] codingitems;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean authoringmos;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.vo.RefVoBean pasevent;
	private String comments;
}
