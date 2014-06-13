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

package ims.core.domain;

// Generated from form domain impl
public interface VitalSignsPulse extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves a list of Pulses for episode and Date Range
	*/
	public ims.core.vo.VitalSignsVoCollection listPulse(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, ims.core.admin.vo.CareContextRefVo refCareContext);

	// Generated from form domain interface definition
	/**
	* Save a Pulse
	*/
	public ims.core.vo.VitalSignsVo modifyPulse(ims.core.vo.VitalSignsVo vitalSign) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get a Pulse
	*/
	public ims.core.vo.VitalSignsVo getPulse(ims.core.vo.VitalSignsVo vitalSign);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of Pulses for an Episode and a specific Day
	*/
	public ims.core.vo.VitalSignsVoCollection listPulse(ims.framework.utils.Date dateOneDay, ims.core.admin.vo.CareContextRefVo refCareContext);
}