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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentFlexibleLiteVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BookingAppointmentFlexibleLiteVo()
	{
	}
	public BookingAppointmentFlexibleLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public BookingAppointmentFlexibleLiteVo(ims.scheduling.vo.beans.BookingAppointmentFlexibleLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.requiresrebook = bean.getRequiresRebook();
		this.donotmove = bean.getDoNotMove();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.BookingAppointmentFlexibleLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.requiresrebook = bean.getRequiresRebook();
		this.donotmove = bean.getDoNotMove();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.BookingAppointmentFlexibleLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.BookingAppointmentFlexibleLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.BookingAppointmentFlexibleLiteVoBean();
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
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REQUIRESREBOOK"))
			return getRequiresRebook();
		if(fieldName.equals("DONOTMOVE"))
			return getDoNotMove();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getRequiresRebookIsNotNull()
	{
		return this.requiresrebook != null;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.isValidated = false;
		this.requiresrebook = value;
	}
	public boolean getDoNotMoveIsNotNull()
	{
		return this.donotmove != null;
	}
	public Boolean getDoNotMove()
	{
		return this.donotmove;
	}
	public void setDoNotMove(Boolean value)
	{
		this.isValidated = false;
		this.donotmove = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		BookingAppointmentFlexibleLiteVo clone = new BookingAppointmentFlexibleLiteVo(this.id, this.version);
		
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityLiteVo)this.activity.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientListVo)this.patient.clone();
		clone.requiresrebook = this.requiresrebook;
		clone.donotmove = this.donotmove;
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
		if (!(BookingAppointmentFlexibleLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookingAppointmentFlexibleLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BookingAppointmentFlexibleLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BookingAppointmentFlexibleLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.activity != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.requiresrebook != null)
			count++;
		if(this.donotmove != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ActivityLiteVo activity;
	protected ims.core.vo.PatientListVo patient;
	protected Boolean requiresrebook;
	protected Boolean donotmove;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
