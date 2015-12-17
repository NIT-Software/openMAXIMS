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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseAnaestheticSignInDialogImpl extends DomainImpl implements ims.clinical.domain.AnaestheticSignInDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetAnaestheticSignInByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveAnaestheticSignInDetails(ims.clinical.vo.AnaestheticSignInVo anaestheticSignIn, ims.clinical.vo.PeriOpAnaesthticSignInTimVo signInTime, ims.scheduling.vo.TheatreBookingRefVo theatreBooking)
	{
		if(anaestheticSignIn == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'anaestheticSignIn' of type 'ims.clinical.vo.AnaestheticSignInVo' cannot be null.");
		if(signInTime == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'signInTime' of type 'ims.clinical.vo.PeriOpAnaesthticSignInTimVo' cannot be null.");
		if(theatreBooking == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'theatreBooking' of type 'ims.scheduling.vo.TheatreBookingRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPeriOpAnaestheticSignInByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistIntraOpPlannedProcedureByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateisNoAnaesthetistPresentForLACases(ims.scheduling.vo.Sch_SessionRefVo theatreSession)
	{
		if(theatreSession == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'theatreSession' of type 'ims.scheduling.vo.Sch_SessionRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateisAnaesthetistValueInCase(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateisDiabeticFromPreAssessmentOutcome(ims.scheduling.vo.Booking_AppointmentRefVo booking_AppointmentRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListByTheatreAppt(ims.scheduling.vo.Booking_AppointmentRefVo theatreApptRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTheatreBooking(ims.scheduling.vo.Booking_AppointmentRefVo theatreApptRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAnaestheticSignIn(ims.clinical.vo.PeriOpAnaesthticSignInTimVo signIn, ims.scheduling.vo.TheatreBookingRefVo theatreBooking)
	{
	}
}