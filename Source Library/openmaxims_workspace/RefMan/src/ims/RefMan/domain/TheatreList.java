// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface TheatreList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List active locations where the location type is hospital
	*/
	public ims.core.vo.LocShortMappingsVoCollection listActiveHospitals(ims.core.resource.people.vo.MemberOfStaffRefVo memberOfStaff);

	// Generated from form domain interface definition
	public ims.core.vo.LocShortMappingsVoCollection listTheatresForHospital(ims.core.resource.place.vo.LocationRefVo hospital);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionShortVoCollection listSession(ims.framework.utils.Date sessionDate, ims.core.resource.people.vo.HcpRefVo listOwner, ims.core.resource.place.vo.LocationRefVo hospital, ims.scheduling.vo.lookups.TheatreType theatreType);

	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.RefMan.vo.TheatreListBookingAppointmentVoCollection listAppointments(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.RefMan.vo.TheatreListBookingAppointmentVoCollection listAppointments(ims.core.resource.people.vo.HcpRefVo hcp, ims.core.resource.people.vo.MemberOfStaffRefVo mosUser, ims.framework.utils.Date date);

	// Generated from form domain interface definition
	/**
	* Get PatientShort
	*/
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo voPatientRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getBookingAppt(ims.scheduling.vo.Booking_AppointmentRefVo bookingApptRefVo);

	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.RefMan.vo.TheatreListBookingAppointmentVoCollection listAllAppointments(ims.RefMan.vo.TheatreListFilterVo filterVo);

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureVo getProcedureLOS(ims.core.clinical.vo.ProcedureRefVo procedureRefVo);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Sch_Session_Appointment_OrderVo getSessionOrder(ims.scheduling.vo.Sch_SessionRefVo schSessionRefVo);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo voBookingRefVo);

	// Generated from form domain interface definition
	public Boolean isReferralAccepted(ims.scheduling.vo.Booking_AppointmentRefVo voBookingRefVo);

	// Generated from form domain interface definition
	public Boolean isNotACurrentInpatient(ims.core.patient.vo.PatientRefVo voPatRef);

	// Generated from form domain interface definition
	/**
	* saveTheatreAppointment
	*/
	public void saveTheatreAppointment(ims.RefMan.vo.TheatreListBookingAppointmentVo appt, ims.RefMan.vo.CatsReferralWizardVo voCatsReferral, ims.scheduling.vo.SessionTheatreTCISlotLiteVo sessionSlot, ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo electiveList) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionTheatreTCISlotLiteVo getSessionSlot(ims.scheduling.vo.SessionTheatreTCISlotRefVo sessionSlot);

	// Generated from form domain interface definition
	public ims.RefMan.vo.TrackingStatusConfigVo getTrackingStatus();

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferralRef(ims.scheduling.vo.Booking_AppointmentRefVo voBookingRefVo);

	// Generated from form domain interface definition
	public ims.RefMan.vo.TheatreTrackingIdleConfigVo getTheatreTrackingIdleConfig();

	// Generated from form domain interface definition
	public ims.core.vo.InpatientEpisodeVo getInpatientEpisode(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo getTheatreServiceProcedureAndConsultant(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void updateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void updateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForTheatreListVo getCatsReferralForCancel(ims.scheduling.vo.Booking_AppointmentRefVo appointmentRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentTheatreVo getBookingAppointmentTheatre(ims.scheduling.vo.Booking_AppointmentRefVo appRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralRttDateForTheatreListVo getReferralWithRttDate(ims.scheduling.vo.Booking_AppointmentRefVo appRef);

	// Generated from form domain interface definition
	public void cancelTCIAndReferralEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo apptRef, Boolean isProviderCancellation, Boolean isPatientCancellation, Boolean cancelledfornonmedicalreason) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean hasTCI(ims.scheduling.vo.Booking_AppointmentRefVo appointment);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo getPatientElectiveList(ims.scheduling.vo.Booking_AppointmentRefVo appointment);
}
