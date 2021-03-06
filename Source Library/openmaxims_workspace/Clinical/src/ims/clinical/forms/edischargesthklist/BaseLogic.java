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

package ims.clinical.forms.edischargesthklist;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.EDischargeSTHKList.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.EDischargeSTHKList domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTTAValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTTA().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TTAStatus existingInstance = (ims.clinical.vo.lookups.TTAStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTTALookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.TTAStatus)
		{
			ims.clinical.vo.lookups.TTAStatus instance = (ims.clinical.vo.lookups.TTAStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTTALookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TTAStatus existingInstance = (ims.clinical.vo.lookups.TTAStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTTA().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTTALookup()
	{
		this.form.cmbTTA().clear();
		ims.clinical.vo.lookups.TTAStatusCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getTTAStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTTA().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTTALookupValue(int id)
	{
		ims.clinical.vo.lookups.TTAStatus instance = ims.clinical.vo.lookups.LookupHelper.getTTAStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTTA().setValue(instance);
	}
	protected final void defaultcmbTTALookupValue()
	{
		this.form.cmbTTA().setValue((ims.clinical.vo.lookups.TTAStatus)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.TTAStatus.class, engine.getFormName().getID(), ims.clinical.vo.lookups.TTAStatus.TYPE_ID));
	}
	protected final void oncmbSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyLookup()
	{
		this.form.cmbSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialty().setValue(instance);
	}
	protected final void defaultcmbSpecialtyLookupValue()
	{
		this.form.cmbSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DischargeLetterStatus existingInstance = (ims.clinical.vo.lookups.DischargeLetterStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.DischargeLetterStatus)
		{
			ims.clinical.vo.lookups.DischargeLetterStatus instance = (ims.clinical.vo.lookups.DischargeLetterStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DischargeLetterStatus existingInstance = (ims.clinical.vo.lookups.DischargeLetterStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.clinical.vo.lookups.DischargeLetterStatusCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getDischargeLetterStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.clinical.vo.lookups.DischargeLetterStatus instance = ims.clinical.vo.lookups.LookupHelper.getDischargeLetterStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.clinical.vo.lookups.DischargeLetterStatus)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.DischargeLetterStatus.class, engine.getFormName().getID(), ims.clinical.vo.lookups.DischargeLetterStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.EDischargeSTHKList domain;
}
