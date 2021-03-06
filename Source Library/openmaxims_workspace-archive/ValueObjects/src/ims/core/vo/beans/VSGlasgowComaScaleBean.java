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

package ims.core.vo.beans;

public class VSGlasgowComaScaleBean extends ims.vo.ValueObjectBean
{
	public VSGlasgowComaScaleBean()
	{
	}
	public VSGlasgowComaScaleBean(ims.core.vo.VSGlasgowComaScale vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.verbalresponse = vo.getVerbalResponse();
		this.motorresponse = vo.getMotorResponse();
		this.eyeopening = vo.getEyeOpening();
		this.totalglasgowcomascale = vo.getTotalGlasgowComaScale();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.VSGlasgowComaScale vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.verbalresponse = vo.getVerbalResponse();
		this.motorresponse = vo.getMotorResponse();
		this.eyeopening = vo.getEyeOpening();
		this.totalglasgowcomascale = vo.getTotalGlasgowComaScale();
	}

	public ims.core.vo.VSGlasgowComaScale buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.VSGlasgowComaScale buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.VSGlasgowComaScale vo = null;
		if(map != null)
			vo = (ims.core.vo.VSGlasgowComaScale)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.VSGlasgowComaScale();
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
	public Integer getVerbalResponse()
	{
		return this.verbalresponse;
	}
	public void setVerbalResponse(Integer value)
	{
		this.verbalresponse = value;
	}
	public Integer getMotorResponse()
	{
		return this.motorresponse;
	}
	public void setMotorResponse(Integer value)
	{
		this.motorresponse = value;
	}
	public Integer getEyeOpening()
	{
		return this.eyeopening;
	}
	public void setEyeOpening(Integer value)
	{
		this.eyeopening = value;
	}
	public Integer getTotalGlasgowComaScale()
	{
		return this.totalglasgowcomascale;
	}
	public void setTotalGlasgowComaScale(Integer value)
	{
		this.totalglasgowcomascale = value;
	}

	private Integer id;
	private int version;
	private Integer verbalresponse;
	private Integer motorresponse;
	private Integer eyeopening;
	private Integer totalglasgowcomascale;
}
