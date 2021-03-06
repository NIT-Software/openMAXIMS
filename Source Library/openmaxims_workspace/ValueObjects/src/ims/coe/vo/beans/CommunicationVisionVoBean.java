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

package ims.coe.vo.beans;

public class CommunicationVisionVoBean extends ims.vo.ValueObjectBean
{
	public CommunicationVisionVoBean()
	{
	}
	public CommunicationVisionVoBean(ims.coe.vo.CommunicationVisionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.visualimpairment = vo.getVisualImpairment() == null ? null : (ims.vo.LookupInstanceBean)vo.getVisualImpairment().getBean();
		this.effectedeyes = vo.getEffectedEyes() == null ? null : (ims.vo.LookupInstanceBean)vo.getEffectedEyes().getBean();
		this.wearglasses = vo.getWearGlasses() == null ? null : (ims.vo.LookupInstanceBean)vo.getWearGlasses().getBean();
		this.numberofglasses = vo.getNumberOfGlasses();
		this.wearlenses = vo.getWearLenses() == null ? null : (ims.vo.LookupInstanceBean)vo.getWearLenses().getBean();
		this.other = vo.getOther();
		this.yearlasteyetest = vo.getYearLastEyeTest();
		this.registeredblind = vo.getRegisteredBlind() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegisteredBlind().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.CommunicationVisionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.visualimpairment = vo.getVisualImpairment() == null ? null : (ims.vo.LookupInstanceBean)vo.getVisualImpairment().getBean();
		this.effectedeyes = vo.getEffectedEyes() == null ? null : (ims.vo.LookupInstanceBean)vo.getEffectedEyes().getBean();
		this.wearglasses = vo.getWearGlasses() == null ? null : (ims.vo.LookupInstanceBean)vo.getWearGlasses().getBean();
		this.numberofglasses = vo.getNumberOfGlasses();
		this.wearlenses = vo.getWearLenses() == null ? null : (ims.vo.LookupInstanceBean)vo.getWearLenses().getBean();
		this.other = vo.getOther();
		this.yearlasteyetest = vo.getYearLastEyeTest();
		this.registeredblind = vo.getRegisteredBlind() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegisteredBlind().getBean();
	}

	public ims.coe.vo.CommunicationVisionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.CommunicationVisionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.CommunicationVisionVo vo = null;
		if(map != null)
			vo = (ims.coe.vo.CommunicationVisionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.CommunicationVisionVo();
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
	public ims.vo.LookupInstanceBean getVisualImpairment()
	{
		return this.visualimpairment;
	}
	public void setVisualImpairment(ims.vo.LookupInstanceBean value)
	{
		this.visualimpairment = value;
	}
	public ims.vo.LookupInstanceBean getEffectedEyes()
	{
		return this.effectedeyes;
	}
	public void setEffectedEyes(ims.vo.LookupInstanceBean value)
	{
		this.effectedeyes = value;
	}
	public ims.vo.LookupInstanceBean getWearGlasses()
	{
		return this.wearglasses;
	}
	public void setWearGlasses(ims.vo.LookupInstanceBean value)
	{
		this.wearglasses = value;
	}
	public Integer getNumberOfGlasses()
	{
		return this.numberofglasses;
	}
	public void setNumberOfGlasses(Integer value)
	{
		this.numberofglasses = value;
	}
	public ims.vo.LookupInstanceBean getWearLenses()
	{
		return this.wearlenses;
	}
	public void setWearLenses(ims.vo.LookupInstanceBean value)
	{
		this.wearlenses = value;
	}
	public String getOther()
	{
		return this.other;
	}
	public void setOther(String value)
	{
		this.other = value;
	}
	public Integer getYearLastEyeTest()
	{
		return this.yearlasteyetest;
	}
	public void setYearLastEyeTest(Integer value)
	{
		this.yearlasteyetest = value;
	}
	public ims.vo.LookupInstanceBean getRegisteredBlind()
	{
		return this.registeredblind;
	}
	public void setRegisteredBlind(ims.vo.LookupInstanceBean value)
	{
		this.registeredblind = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean visualimpairment;
	private ims.vo.LookupInstanceBean effectedeyes;
	private ims.vo.LookupInstanceBean wearglasses;
	private Integer numberofglasses;
	private ims.vo.LookupInstanceBean wearlenses;
	private String other;
	private Integer yearlasteyetest;
	private ims.vo.LookupInstanceBean registeredblind;
}
