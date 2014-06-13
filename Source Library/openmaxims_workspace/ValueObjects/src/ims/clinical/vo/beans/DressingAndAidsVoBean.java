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

package ims.clinical.vo.beans;

public class DressingAndAidsVoBean extends ims.vo.ValueObjectBean
{
	public DressingAndAidsVoBean()
	{
	}
	public DressingAndAidsVoBean(ims.clinical.vo.DressingAndAidsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dressingsandaids = vo.getDressingsAndAids() == null ? null : (ims.vo.LookupInstanceBean)vo.getDressingsAndAids().getBean();
		this.periodvalue = vo.getPeriodValue();
		this.periodinterval = vo.getPeriodInterval() == null ? null : (ims.vo.LookupInstanceBean)vo.getPeriodInterval().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DressingAndAidsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dressingsandaids = vo.getDressingsAndAids() == null ? null : (ims.vo.LookupInstanceBean)vo.getDressingsAndAids().getBean();
		this.periodvalue = vo.getPeriodValue();
		this.periodinterval = vo.getPeriodInterval() == null ? null : (ims.vo.LookupInstanceBean)vo.getPeriodInterval().getBean();
	}

	public ims.clinical.vo.DressingAndAidsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DressingAndAidsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DressingAndAidsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DressingAndAidsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DressingAndAidsVo();
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
	public ims.vo.LookupInstanceBean getDressingsAndAids()
	{
		return this.dressingsandaids;
	}
	public void setDressingsAndAids(ims.vo.LookupInstanceBean value)
	{
		this.dressingsandaids = value;
	}
	public Integer getPeriodValue()
	{
		return this.periodvalue;
	}
	public void setPeriodValue(Integer value)
	{
		this.periodvalue = value;
	}
	public ims.vo.LookupInstanceBean getPeriodInterval()
	{
		return this.periodinterval;
	}
	public void setPeriodInterval(ims.vo.LookupInstanceBean value)
	{
		this.periodinterval = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean dressingsandaids;
	private Integer periodvalue;
	private ims.vo.LookupInstanceBean periodinterval;
}