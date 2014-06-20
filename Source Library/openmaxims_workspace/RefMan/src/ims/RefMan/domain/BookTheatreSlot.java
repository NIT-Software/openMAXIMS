// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface BookTheatreSlot extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listActiveCanBeScheduledService
	*/
	public ims.core.vo.ServiceLiteVoCollection listActiveCanBeScheduledService();

	// Generated from form domain interface definition
	/**
	* list sessions for scheduling
	*/
	public ims.scheduling.vo.SessionTheatreVoCollection listSession(ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.vo.interfaces.IMos consultant, ims.vo.interfaces.IGenericItem procedure, ims.scheduling.vo.lookups.TheatreType theatreType, Integer timeRequired, Boolean allowOverBook, ims.clinical.vo.lookups.AnaestheticType anaestheticType);

	// Generated from form domain interface definition
	/**
	* list Booking appointments for a session
	*/
	public ims.scheduling.vo.BookingAppointmentTheatreVoCollection listBookingAppointment(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* check Booking Rights for this Role and Session
	*/
	public Boolean hasBookingRights(ims.framework.interfaces.IAppRole role, ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* listLocationLite
	*/
	public ims.core.vo.LocationLiteVoCollection listLocationLite();

	// Generated from form domain interface definition
	/**
	* getReferralDetail
	*/
	public ims.RefMan.vo.ReferralBookingVo getReferralDetail(ims.RefMan.vo.CatsReferralRefVo catsReferral);

	// Generated from form domain interface definition
	/**
	* for rebooking used same Sch_booking
	*/
	public ims.scheduling.vo.Sch_BookingTheatreVo getSch_BookingByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* getBookingAppointment
	*/
	public ims.scheduling.vo.BookingAppointmentTheatreVo getBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* Runs a search based on a given filter string, CciType and Boolean. Returns the results as a collection of IGenericItem interfaces
	*/
	public ims.vo.interfaces.IGenericItem[] listProcedures(String filter);

	// Generated from form domain interface definition
	public ims.icp.vo.PatientICPFullVo getPatientICP(ims.core.admin.vo.CareContextRefVo careCOntextRefVo);

	// Generated from form domain interface definition
	public ims.icp.vo.PatientICPFullVo savePatientICP(ims.icp.vo.PatientICPFullVo pateintICPVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getSuitableForSurgeryAssessmentByCareContext
	*/
	public ims.RefMan.vo.SuitableForSurgeryAssessmentMinVo getSuitableForSurgeryAssessmentByCareContext(ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	public ims.RefMan.vo.FitForSurgeryAssessmentLiteVo getLatestFitForSurgeryAssessment(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	/**
	* countNonCancelledAppointmentsForSession
	*/
	public Integer countNonCancelledAppointmentsForSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* addSlotToSession
	*/
	public void addSlotToSession(ims.scheduling.vo.SessionTheatreVo voSession, ims.scheduling.vo.SessionParentChildSlotVo voSlot) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentTheatreLiteVo getBookingAppointmentTheatre(ims.scheduling.vo.Booking_AppointmentRefVo recordRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.ReferralERODVo getLastTheatreEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral);
}
