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

package ims.dtomove.vo;

/**
 * Linked to dto_move.Appointment business object (ID: 1105100030).
 */
public class AppointmentVo extends ims.dto_move.vo.AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppointmentVo()
	{
	}
	public AppointmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppointmentVo(ims.dtomove.vo.beans.AppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pkey = bean.getPkey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.numcancelled = bean.getNumCancelled();
		this.numdna = bean.getNumDNA();
		this.bookingsystype = bean.getBookingSysType();
		this.relatedappointment = bean.getRelatedAppointment() == null ? null : new ims.dto_move.vo.AppointmentRefVo(new Integer(bean.getRelatedAppointment().getId()), bean.getRelatedAppointment().getVersion());
		this.patientletter = bean.getPatientLetter();
		this.gpletter = bean.getGpLetter();
		this.comments = bean.getComments();
		this.hcpbooking = bean.getHcpBooking() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getHcpBooking().getId()), bean.getHcpBooking().getVersion());
		this.datebooked = bean.getDateBooked() == null ? null : bean.getDateBooked().buildDate();
		this.priordateoffered = bean.getPriorDateOffered() == null ? null : bean.getPriorDateOffered().buildDate();
		this.headstatus = bean.getHeadStatus();
		this.transportrequired = bean.getTransportRequired();
		this.transportcomment = bean.getTransportComment();
		this.patstat = bean.getPatStat();
		this.episode = bean.getEpisode();
		if(bean.getApptDetail() != null)
		{
			this.apptdetail = new ims.dto_move.vo.AppointmentDetailRefVoCollection();
			for(int apptdetail_i = 0; apptdetail_i < bean.getApptDetail().length; apptdetail_i++)
			{
				this.apptdetail.add(new ims.dto_move.vo.AppointmentDetailRefVo(new Integer(bean.getApptDetail()[apptdetail_i].getId()), bean.getApptDetail()[apptdetail_i].getVersion()));
			}
		}
		this.treatplanactionid = bean.getTreatPlanActionId();
		this.firstapptid = bean.getFirstApptId();
		this.lastapptid = bean.getLastApptId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.beans.AppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pkey = bean.getPkey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.numcancelled = bean.getNumCancelled();
		this.numdna = bean.getNumDNA();
		this.bookingsystype = bean.getBookingSysType();
		this.relatedappointment = bean.getRelatedAppointment() == null ? null : new ims.dto_move.vo.AppointmentRefVo(new Integer(bean.getRelatedAppointment().getId()), bean.getRelatedAppointment().getVersion());
		this.patientletter = bean.getPatientLetter();
		this.gpletter = bean.getGpLetter();
		this.comments = bean.getComments();
		this.hcpbooking = bean.getHcpBooking() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getHcpBooking().getId()), bean.getHcpBooking().getVersion());
		this.datebooked = bean.getDateBooked() == null ? null : bean.getDateBooked().buildDate();
		this.priordateoffered = bean.getPriorDateOffered() == null ? null : bean.getPriorDateOffered().buildDate();
		this.headstatus = bean.getHeadStatus();
		this.transportrequired = bean.getTransportRequired();
		this.transportcomment = bean.getTransportComment();
		this.patstat = bean.getPatStat();
		this.episode = bean.getEpisode();
		if(bean.getApptDetail() != null)
		{
			this.apptdetail = new ims.dto_move.vo.AppointmentDetailRefVoCollection();
			for(int apptdetail_i = 0; apptdetail_i < bean.getApptDetail().length; apptdetail_i++)
			{
				this.apptdetail.add(new ims.dto_move.vo.AppointmentDetailRefVo(new Integer(bean.getApptDetail()[apptdetail_i].getId()), bean.getApptDetail()[apptdetail_i].getVersion()));
			}
		}
		this.treatplanactionid = bean.getTreatPlanActionId();
		this.firstapptid = bean.getFirstApptId();
		this.lastapptid = bean.getLastApptId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.beans.AppointmentVoBean bean = null;
		if(map != null)
			bean = (ims.dtomove.vo.beans.AppointmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.dtomove.vo.beans.AppointmentVoBean();
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
		if(fieldName.equals("PKEY"))
			return getPkey();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("NUMCANCELLED"))
			return getNumCancelled();
		if(fieldName.equals("NUMDNA"))
			return getNumDNA();
		if(fieldName.equals("BOOKINGSYSTYPE"))
			return getBookingSysType();
		if(fieldName.equals("RELATEDAPPOINTMENT"))
			return getRelatedAppointment();
		if(fieldName.equals("PATIENTLETTER"))
			return getPatientLetter();
		if(fieldName.equals("GPLETTER"))
			return getGpLetter();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("HCPBOOKING"))
			return getHcpBooking();
		if(fieldName.equals("DATEBOOKED"))
			return getDateBooked();
		if(fieldName.equals("PRIORDATEOFFERED"))
			return getPriorDateOffered();
		if(fieldName.equals("HEADSTATUS"))
			return getHeadStatus();
		if(fieldName.equals("TRANSPORTREQUIRED"))
			return getTransportRequired();
		if(fieldName.equals("TRANSPORTCOMMENT"))
			return getTransportComment();
		if(fieldName.equals("PATSTAT"))
			return getPatStat();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("APPTDETAIL"))
			return getApptDetail();
		if(fieldName.equals("TREATPLANACTIONID"))
			return getTreatPlanActionId();
		if(fieldName.equals("FIRSTAPPTID"))
			return getFirstApptId();
		if(fieldName.equals("LASTAPPTID"))
			return getLastApptId();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPkeyIsNotNull()
	{
		return this.pkey != null;
	}
	public Integer getPkey()
	{
		return this.pkey;
	}
	public void setPkey(Integer value)
	{
		this.isValidated = false;
		this.pkey = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getNumCancelledIsNotNull()
	{
		return this.numcancelled != null;
	}
	public Integer getNumCancelled()
	{
		return this.numcancelled;
	}
	public void setNumCancelled(Integer value)
	{
		this.isValidated = false;
		this.numcancelled = value;
	}
	public boolean getNumDNAIsNotNull()
	{
		return this.numdna != null;
	}
	public Integer getNumDNA()
	{
		return this.numdna;
	}
	public void setNumDNA(Integer value)
	{
		this.isValidated = false;
		this.numdna = value;
	}
	public boolean getBookingSysTypeIsNotNull()
	{
		return this.bookingsystype != null;
	}
	public Integer getBookingSysType()
	{
		return this.bookingsystype;
	}
	public void setBookingSysType(Integer value)
	{
		this.isValidated = false;
		this.bookingsystype = value;
	}
	public boolean getRelatedAppointmentIsNotNull()
	{
		return this.relatedappointment != null;
	}
	public ims.dto_move.vo.AppointmentRefVo getRelatedAppointment()
	{
		return this.relatedappointment;
	}
	public void setRelatedAppointment(ims.dto_move.vo.AppointmentRefVo value)
	{
		this.isValidated = false;
		this.relatedappointment = value;
	}
	public boolean getPatientLetterIsNotNull()
	{
		return this.patientletter != null;
	}
	public String getPatientLetter()
	{
		return this.patientletter;
	}
	public static int getPatientLetterMaxLength()
	{
		return 1;
	}
	public void setPatientLetter(String value)
	{
		this.isValidated = false;
		this.patientletter = value;
	}
	public boolean getGpLetterIsNotNull()
	{
		return this.gpletter != null;
	}
	public String getGpLetter()
	{
		return this.gpletter;
	}
	public static int getGpLetterMaxLength()
	{
		return 1;
	}
	public void setGpLetter(String value)
	{
		this.isValidated = false;
		this.gpletter = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getHcpBookingIsNotNull()
	{
		return this.hcpbooking != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getHcpBooking()
	{
		return this.hcpbooking;
	}
	public void setHcpBooking(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.hcpbooking = value;
	}
	public boolean getDateBookedIsNotNull()
	{
		return this.datebooked != null;
	}
	public ims.framework.utils.Date getDateBooked()
	{
		return this.datebooked;
	}
	public void setDateBooked(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datebooked = value;
	}
	public boolean getPriorDateOfferedIsNotNull()
	{
		return this.priordateoffered != null;
	}
	public ims.framework.utils.Date getPriorDateOffered()
	{
		return this.priordateoffered;
	}
	public void setPriorDateOffered(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.priordateoffered = value;
	}
	public boolean getHeadStatusIsNotNull()
	{
		return this.headstatus != null;
	}
	public Integer getHeadStatus()
	{
		return this.headstatus;
	}
	public void setHeadStatus(Integer value)
	{
		this.isValidated = false;
		this.headstatus = value;
	}
	public boolean getTransportRequiredIsNotNull()
	{
		return this.transportrequired != null;
	}
	public String getTransportRequired()
	{
		return this.transportrequired;
	}
	public static int getTransportRequiredMaxLength()
	{
		return 1;
	}
	public void setTransportRequired(String value)
	{
		this.isValidated = false;
		this.transportrequired = value;
	}
	public boolean getTransportCommentIsNotNull()
	{
		return this.transportcomment != null;
	}
	public String getTransportComment()
	{
		return this.transportcomment;
	}
	public static int getTransportCommentMaxLength()
	{
		return 500;
	}
	public void setTransportComment(String value)
	{
		this.isValidated = false;
		this.transportcomment = value;
	}
	public boolean getPatStatIsNotNull()
	{
		return this.patstat != null;
	}
	public Integer getPatStat()
	{
		return this.patstat;
	}
	public void setPatStat(Integer value)
	{
		this.isValidated = false;
		this.patstat = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public Integer getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(Integer value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getApptDetailIsNotNull()
	{
		return this.apptdetail != null;
	}
	public ims.dto_move.vo.AppointmentDetailRefVoCollection getApptDetail()
	{
		return this.apptdetail;
	}
	public void setApptDetail(ims.dto_move.vo.AppointmentDetailRefVoCollection value)
	{
		this.isValidated = false;
		this.apptdetail = value;
	}
	public boolean getTreatPlanActionIdIsNotNull()
	{
		return this.treatplanactionid != null;
	}
	public Integer getTreatPlanActionId()
	{
		return this.treatplanactionid;
	}
	public void setTreatPlanActionId(Integer value)
	{
		this.isValidated = false;
		this.treatplanactionid = value;
	}
	public boolean getFirstApptIdIsNotNull()
	{
		return this.firstapptid != null;
	}
	public Integer getFirstApptId()
	{
		return this.firstapptid;
	}
	public void setFirstApptId(Integer value)
	{
		this.isValidated = false;
		this.firstapptid = value;
	}
	public boolean getLastApptIdIsNotNull()
	{
		return this.lastapptid != null;
	}
	public Integer getLastApptId()
	{
		return this.lastapptid;
	}
	public void setLastApptId(Integer value)
	{
		this.isValidated = false;
		this.lastapptid = value;
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
		if(this.patientletter != null)
			if(this.patientletter.length() > 1)
				listOfErrors.add("The length of the field [patientletter] in the value object [ims.dtomove.vo.AppointmentVo] is too big. It should be less or equal to 1");
		if(this.gpletter != null)
			if(this.gpletter.length() > 1)
				listOfErrors.add("The length of the field [gpletter] in the value object [ims.dtomove.vo.AppointmentVo] is too big. It should be less or equal to 1");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.dtomove.vo.AppointmentVo] is too big. It should be less or equal to 255");
		if(this.transportrequired != null)
			if(this.transportrequired.length() > 1)
				listOfErrors.add("The length of the field [transportrequired] in the value object [ims.dtomove.vo.AppointmentVo] is too big. It should be less or equal to 1");
		if(this.transportcomment != null)
			if(this.transportcomment.length() > 500)
				listOfErrors.add("The length of the field [transportcomment] in the value object [ims.dtomove.vo.AppointmentVo] is too big. It should be less or equal to 500");
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
	
		AppointmentVo clone = new AppointmentVo(this.id, this.version);
		
		clone.pkey = this.pkey;
		clone.patient = this.patient;
		clone.numcancelled = this.numcancelled;
		clone.numdna = this.numdna;
		clone.bookingsystype = this.bookingsystype;
		clone.relatedappointment = this.relatedappointment;
		clone.patientletter = this.patientletter;
		clone.gpletter = this.gpletter;
		clone.comments = this.comments;
		clone.hcpbooking = this.hcpbooking;
		if(this.datebooked == null)
			clone.datebooked = null;
		else
			clone.datebooked = (ims.framework.utils.Date)this.datebooked.clone();
		if(this.priordateoffered == null)
			clone.priordateoffered = null;
		else
			clone.priordateoffered = (ims.framework.utils.Date)this.priordateoffered.clone();
		clone.headstatus = this.headstatus;
		clone.transportrequired = this.transportrequired;
		clone.transportcomment = this.transportcomment;
		clone.patstat = this.patstat;
		clone.episode = this.episode;
		clone.apptdetail = this.apptdetail;
		clone.treatplanactionid = this.treatplanactionid;
		clone.firstapptid = this.firstapptid;
		clone.lastapptid = this.lastapptid;
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
		if (!(AppointmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppointmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppointmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppointmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pkey != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.numcancelled != null)
			count++;
		if(this.numdna != null)
			count++;
		if(this.bookingsystype != null)
			count++;
		if(this.relatedappointment != null)
			count++;
		if(this.patientletter != null)
			count++;
		if(this.gpletter != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.hcpbooking != null)
			count++;
		if(this.datebooked != null)
			count++;
		if(this.priordateoffered != null)
			count++;
		if(this.headstatus != null)
			count++;
		if(this.transportrequired != null)
			count++;
		if(this.transportcomment != null)
			count++;
		if(this.patstat != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.apptdetail != null)
			count++;
		if(this.treatplanactionid != null)
			count++;
		if(this.firstapptid != null)
			count++;
		if(this.lastapptid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 21;
	}
	protected Integer pkey;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected Integer numcancelled;
	protected Integer numdna;
	protected Integer bookingsystype;
	protected ims.dto_move.vo.AppointmentRefVo relatedappointment;
	protected String patientletter;
	protected String gpletter;
	protected String comments;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo hcpbooking;
	protected ims.framework.utils.Date datebooked;
	protected ims.framework.utils.Date priordateoffered;
	protected Integer headstatus;
	protected String transportrequired;
	protected String transportcomment;
	protected Integer patstat;
	protected Integer episode;
	protected ims.dto_move.vo.AppointmentDetailRefVoCollection apptdetail;
	protected Integer treatplanactionid;
	protected Integer firstapptid;
	protected Integer lastapptid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}