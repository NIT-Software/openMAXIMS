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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.List;

import ims.RefMan.domain.base.impl.BaseAppointmentOutcomeProcedureDialogImpl;
import ims.RefMan.vo.domain.CareContextForAppointmentOutcomeVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.domain.DomainFactory;

public class AppointmentOutcomeProcedureDialogImpl extends BaseAppointmentOutcomeProcedureDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.CareContextForAppointmentOutcomeVo getCareContext(ims.scheduling.vo.Booking_AppointmentRefVo bookAppt)
	{
		if(bookAppt == null || bookAppt.getID_Booking_Appointment() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select cats.careContext from CatsReferral as cats left join cats.appointments as appt where appt.id = :ApptId";
		
		List<?> careContextList = factory.find(query, new String[] {"ApptId"}, new Object[] {bookAppt.getID_Booking_Appointment()});
		
		if(careContextList != null && careContextList.size() > 0)
			return CareContextForAppointmentOutcomeVoAssembler.create((CareContext) careContextList.get(0));
		
		return null;
	}
}
