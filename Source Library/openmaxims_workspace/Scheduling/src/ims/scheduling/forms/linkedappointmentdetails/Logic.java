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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.linkedappointmentdetails;

import java.util.ArrayList;
import java.util.List;

import ims.RefMan.vo.FutureAppointmentStatusVo;
import ims.RefMan.vo.FutureAppointmentStatusVoCollection;
import ims.RefMan.vo.LinkedAppointmentVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.lookups.ServiceFunction;
import ims.core.vo.lookups.TimeUnitsSecondsToMonths;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.forms.linkedappointmentdetails.GenForm.GroupSameDayEnumeration;
import ims.scheduling.forms.linkedappointmentdetails.GenForm.GroupSameServiceEnumeration;
import ims.scheduling.forms.linkedappointmentdetails.GenForm.GroupSeqEnumeration;
import ims.scheduling.vo.FutureAppointmentDetailsVo;
import ims.scheduling.vo.lookups.FutureAppointmentSource;
import ims.scheduling.vo.lookups.FutureAppointmentStatus;
import ims.scheduling.vo.lookups.RequestToSchedule;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof Integer)
			{
				form.getLocalContext().setNumberOfLinkedAppointments((Integer) args[0]);
			}
			
			if(args.length > 1)
			{
				if(args[1] instanceof ServiceLiteVo)
				{
					form.getLocalContext().setOriginalService((ServiceLiteVo) args[1]);
				}
				
				if(args.length > 2)
				{
					if(args[2] instanceof ServiceFunction)
					{
						form.getLocalContext().setOriginalFunction((ServiceFunction) args[2]);
					}
				}
				
				if(args.length > 3)
				{
					if(args[3] instanceof FormMode)
					{
						form.getLocalContext().setFormMode((FormMode) args[3]);
					}
				}
				
				if(args.length > 4)
				{
					if(args[4] instanceof Boolean)
					{
						form.getLocalContext().setIsFromAppointmentOutcome((Boolean) args[4]);
					}
				}
			}
		}
		
		initialise();
		open();
	}
	
	private void open()
	{
		populateScreenFromData(form.getGlobalContext().Scheduling.getLinkedOPA());
		
		form.setMode(form.getLocalContext().getFormMode() != null ? form.getLocalContext().getFormMode() : FormMode.EDIT);
	}

	private void populateScreenFromData(FutureAppointmentDetailsVo linkedOPA)
	{
		clear();
		
		if(linkedOPA == null)
			return;
		
		form.getLocalContext().setNumberOfLinkedAppointments(linkedOPA.getNumberOfLinkedRecurringApptsToBook());
		form.GroupSeq().setValue(getNumberOfLinkedAppointments(linkedOPA.getNumberOfLinkedRecurringApptsToBook()));
		form.GroupSameService().setValue(Boolean.TRUE.equals(linkedOPA.getSameService()) ? GroupSameServiceEnumeration.rdoYes : GroupSameServiceEnumeration.rdoNo);
		form.GroupSameDay().setValue(Boolean.TRUE.equals(linkedOPA.getSameDay()) ? GroupSameDayEnumeration.rdoYesSameDay : GroupSameDayEnumeration.rdoNoSameDay);
		
		if(GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()))
		{
			form.intValue().setValue(linkedOPA.getFirstApptPeriodValue());
			form.cmbPeriod().setValue(linkedOPA.getFirstApptPeriodType());
			form.dteApptDate().setValue(linkedOPA.getFirstApptFutureApptByDate());
		}
		if(linkedOPA.getNumberOfLinkedRecurringApptsToBookIsNotNull())//WDEV-23839
		{
			if(linkedOPA.getNumberOfLinkedRecurringApptsToBook() >= 1)
			{
				form.cc1().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 1, (GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalService() : null), (GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalFunction() : null), getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
				form.cc1().setValue(getLinkedAppointment(linkedOPA, 1));
			}
			if(linkedOPA.getNumberOfLinkedRecurringApptsToBook() >= 2)
			{
				form.cc2().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 2, GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalService() : null, GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalFunction() : null, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
				form.cc2().setValue(getLinkedAppointment(linkedOPA, 2));
			}
			if(linkedOPA.getNumberOfLinkedRecurringApptsToBook() >= 3)
			{
				form.cc3().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 3, GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalService() : null, GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? form.getLocalContext().getOriginalFunction() : null, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
				form.cc3().setValue(getLinkedAppointment(linkedOPA, 3));
			}
		}
		
		form.txtComments().setValue(linkedOPA.getComments());
	}

	private LinkedAppointmentVo getLinkedAppointment(FutureAppointmentDetailsVo linkedOPA, int sequence)
	{
		if(linkedOPA == null)
			return null;
		
		LinkedAppointmentVo appt = new LinkedAppointmentVo();
		appt.setSequence(sequence);
		
		if(sequence == 1)
		{
			appt.setApptDate(linkedOPA.getFirstApptFutureApptByDate());
			appt.setPeriodValue(linkedOPA.getFirstApptPeriodValue());
			appt.setPeriodType(linkedOPA.getFirstApptPeriodType());
			appt.setService(linkedOPA.getFirstApptService());
			appt.setFunction(linkedOPA.getFirstApptFunction());
			appt.setOPA(linkedOPA.getFirstApptToSee());
		}
		else if(sequence == 2)
		{
			appt.setApptDate(linkedOPA.getSecondApptFutureApptByDate());
			appt.setPeriodValue(linkedOPA.getSecondApptPeriodValue());
			appt.setPeriodType(linkedOPA.getSecondApptPeriodType());
			appt.setService(linkedOPA.getSecondApptService());
			appt.setFunction(linkedOPA.getSecondApptFunction());
			appt.setOPA(linkedOPA.getSecondApptToSee());
		}
		else if(sequence == 3)
		{
			appt.setApptDate(linkedOPA.getThirdApptFutureApptByDate());
			appt.setPeriodValue(linkedOPA.getThirdApptPeriodValue());
			appt.setPeriodType(linkedOPA.getThirdApptPeriodType());
			appt.setService(linkedOPA.getThirdApptService());
			appt.setFunction(linkedOPA.getThirdApptFunction());
			appt.setOPA(linkedOPA.getThirdAppToSee());
		}
		
		return appt;
	}

	private void clear()
	{
		form.txtComments().setValue(null);
		form.intValue().setValue(null);
		form.cmbPeriod().setValue(null);
		form.dteApptDate().setValue(null);
	}

	private GroupSeqEnumeration getNumberOfLinkedAppointments(Integer numberOfLinkedAppointments)
	{
		if(numberOfLinkedAppointments == null)
			return null;
		
		if(numberOfLinkedAppointments == 2)
			return GroupSeqEnumeration.rdo2;
		else if(numberOfLinkedAppointments == 3)
			return GroupSeqEnumeration.rdo3;
		
		return null;
	}

	private void initialise()
	{
		if(form.getGlobalContext().Scheduling.getLinkedOPA() == null)
		{
			form.GroupSeq().setValue(getNumberOfLinkedAppointments(form.getLocalContext().getNumberOfLinkedAppointments()));
		
			form.GroupSameService().setValue(GroupSameServiceEnumeration.rdoYes);
			form.GroupSameDay().setValue(GroupSameDayEnumeration.rdoYesSameDay);
		
			form.cc1().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 1, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), false, null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
			form.cc2().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 2, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), false, null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
			form.cc3().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 3, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), false, null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
			
		}
		
		form.cc1().setMode(form.getLocalContext().getFormMode() != null ? form.getLocalContext().getFormMode() : FormMode.EDIT);
		form.cc2().setMode(form.getLocalContext().getFormMode() != null ? form.getLocalContext().getFormMode() : FormMode.EDIT);
		form.cc3().setMode(form.getLocalContext().getFormMode() != null ? form.getLocalContext().getFormMode() : FormMode.EDIT);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		FutureAppointmentDetailsVo linkedOPA = populateDataFromScreen();
		
		String[] errors = linkedOPA.validate(validateUIRules());
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		form.getGlobalContext().Scheduling.setLinkedOPA(linkedOPA);
		
		engine.close(DialogResult.OK);
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if (form.intValue().isVisible() && form.cmbPeriod().getVisible() && (form.intValue().getValue() == null || form.cmbPeriod().getValue() == null))
		{
			uiErrors.add("To be Scheduled For is mandatory.");
		}
		
		uiErrors.addAll(form.cc1().getErrors());
		uiErrors.addAll(form.cc2().getErrors());
		uiErrors.addAll(form.cc3().getErrors());
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private FutureAppointmentDetailsVo populateDataFromScreen()
	{
		FutureAppointmentDetailsVo record = null;
		
		if(form.getGlobalContext().Scheduling.getLinkedOPA() != null)
		{
			record = (FutureAppointmentDetailsVo) form.getGlobalContext().Scheduling.getLinkedOPA().clone();
		}
		else
		{
			record = new FutureAppointmentDetailsVo();
			record.setReferral(form.getGlobalContext().RefMan.getCatsReferral());
			record.setSource(Boolean.TRUE.equals(form.getLocalContext().getIsFromAppointmentOutcome()) ? FutureAppointmentSource.APPOINTMENT_OUTCOME : FutureAppointmentSource.TRIAGE);
			record.setRequestToSchedule(RequestToSchedule.LINKED_OPA);
		}
		
		record.setNumberOfLinkedRecurringApptsToBook(getNumberOfLinkedAppointmentsFromScrren());
		
		if(form.getLocalContext().getNumberOfLinkedAppointmentsIsNotNull())//WDEV-23839
		{
			if(form.getLocalContext().getNumberOfLinkedAppointments() >= 1)
			{
				populateLinkedAppointmentsFromScreen(record, form.cc1().getValue(), 1);
			}
			if(form.getLocalContext().getNumberOfLinkedAppointments() >= 2)
			{
				populateLinkedAppointmentsFromScreen(record, form.cc2().getValue(), 2);
			}
			if(form.getLocalContext().getNumberOfLinkedAppointments() >= 3)
			{
				populateLinkedAppointmentsFromScreen(record, form.cc3().getValue(), 3);
			}
		}
		
		if(GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()))
		{
			record.setFirstApptFutureApptByDate(form.dteApptDate().getValue());
			record.setFirstApptPeriodType(form.cmbPeriod().getValue());
			record.setFirstApptPeriodValue(form.intValue().getValue());
			record.setSecondApptFutureApptByDate(form.dteApptDate().getValue());
			record.setSecondApptPeriodType(form.cmbPeriod().getValue());
			record.setSecondApptPeriodValue(form.intValue().getValue());
			record.setThirdApptFutureApptByDate(form.dteApptDate().getValue());
			record.setThirdApptPeriodType(form.cmbPeriod().getValue());
			record.setThirdApptPeriodValue(form.intValue().getValue());
		}
		
		FutureAppointmentStatusVo status = new FutureAppointmentStatusVo();
		status.setPendingStatus(FutureAppointmentStatus.OPEN);
		status.setStatusDateTime(new DateTime());
		
		Object user = domain.getMosUser();
		if(user instanceof MemberOfStaffRefVo)
		{
			status.setAuthoringUser((MemberOfStaffRefVo) user);
		}
		
		record.setCurrentStatus(status);
		
		if(record.getStatusHistory() == null)
			record.setStatusHistory(new FutureAppointmentStatusVoCollection());
		
		record.getStatusHistory().add(status);
		
		record.setSameDay(GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()) ? true : false);
		record.setSameService(GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? true : false);
		record.setComments(form.txtComments().getValue());
		
		return record;
	}

	private void populateLinkedAppointmentsFromScreen(FutureAppointmentDetailsVo record, LinkedAppointmentVo linkedAppt, int sequence)
	{
		if(record == null)
			record = new FutureAppointmentDetailsVo();
		
		if(sequence == 1 && linkedAppt != null)
		{
			record.setFirstApptFunction(linkedAppt.getFunction());
			record.setFirstApptFutureApptByDate(linkedAppt.getApptDate());
			record.setFirstApptPeriodType(linkedAppt.getPeriodType());
			record.setFirstApptPeriodValue(linkedAppt.getPeriodValue());
			record.setFirstApptService(linkedAppt.getService());
			record.setFirstApptToSee(linkedAppt.getOPA());
		}
		
		if(sequence == 2 && linkedAppt != null)
		{
			record.setSecondApptFunction(linkedAppt.getFunction());
			record.setSecondApptFutureApptByDate(linkedAppt.getApptDate());
			record.setSecondApptPeriodType(linkedAppt.getPeriodType());
			record.setSecondApptPeriodValue(linkedAppt.getPeriodValue());
			record.setSecondApptService(linkedAppt.getService());
			record.setSecondApptToSee(linkedAppt.getOPA());
		}
		
		if(sequence == 3 && linkedAppt != null)
		{
			record.setThirdApptFunction(linkedAppt.getFunction());
			record.setThirdApptFutureApptByDate(linkedAppt.getApptDate());
			record.setThirdApptPeriodType(linkedAppt.getPeriodType());
			record.setThirdApptPeriodValue(linkedAppt.getPeriodValue());
			record.setThirdApptService(linkedAppt.getService());
			record.setThirdAppToSee(linkedAppt.getOPA());
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.cc1().setVisible(form.getLocalContext().getNumberOfLinkedAppointments() != null && form.getLocalContext().getNumberOfLinkedAppointments() >= 1);
		form.cc2().setVisible(form.getLocalContext().getNumberOfLinkedAppointments() != null && form.getLocalContext().getNumberOfLinkedAppointments() >= 2);
		form.cc3().setVisible(form.getLocalContext().getNumberOfLinkedAppointments() != null && form.getLocalContext().getNumberOfLinkedAppointments() >= 3);
		
		form.lblToBeScheduled().setVisible(Boolean.TRUE.equals(form.getLocalContext().getIsFromAppointmentOutcome()) && GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()));
		form.intValue().setVisible(Boolean.TRUE.equals(form.getLocalContext().getIsFromAppointmentOutcome()) && GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()));
		form.intValue().setEnabled(FormMode.EDIT.equals(form.getMode()));
		
		form.cmbPeriod().setVisible(Boolean.TRUE.equals(form.getLocalContext().getIsFromAppointmentOutcome()) && GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()));
		form.cmbPeriod().setEnabled(FormMode.EDIT.equals(form.getMode()));
		
		form.dteApptDate().setVisible(Boolean.TRUE.equals(form.getLocalContext().getIsFromAppointmentOutcome()) && GroupSameDayEnumeration.rdoYesSameDay.equals(form.GroupSameDay().getValue()));
		form.dteApptDate().setEnabled(false);
		
		form.btnClose().setVisible(FormMode.VIEW.equals(form.getMode()));
		
	}

	@Override
	protected void onRadioButtonGroupSameServiceValueChanged() throws PresentationLogicException
	{
		if(form.GroupSameService().getValue().equals(GroupSameServiceEnumeration.rdoYes))
		{
			form.cc1().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 1, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
			form.cc2().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 2, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
			form.cc3().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 3, form.getLocalContext().getOriginalService(), form.getLocalContext().getOriginalFunction(), getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), false);
		}
		else if(form.GroupSameService().getValue().equals(GroupSameServiceEnumeration.rdoNo))
		{
			form.cc1().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 1, form.getLocalContext().getOriginalService(), null, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), true);
			form.cc2().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 2, null, null, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), true);
			form.cc3().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 3, null, null, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), true);
		}
	}

	private Boolean getOtherDayValue()
	{
		if(GroupSameDayEnumeration.rdoNoSameDay.equals(form.GroupSameDay().getValue()))
			return true;
		
		return false;
	}

	@Override
	protected void onRadioButtonGroupSameDayValueChanged() throws PresentationLogicException
	{
		form.intValue().setValue(null);
		form.cmbPeriod().setValue(null);
		form.dteApptDate().setValue(null);
		
		ServiceLiteVo originalService = null;
		ServiceFunction originalFunction = null;
		if(form.GroupSameService().getValue().equals(GroupSameServiceEnumeration.rdoYes))
		{
			originalService = form.getLocalContext().getOriginalService();
			originalFunction = form.getLocalContext().getOriginalFunction();
		}
		
		form.cc1().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 1, form.getLocalContext().getOriginalService(), originalFunction, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
		form.cc2().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 2, originalService, originalFunction, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
		form.cc3().initialise(form.getGlobalContext().RefMan.getCatsReferral(), false, 3, originalService, originalFunction, getOtherDayValue(), null, form.getLocalContext().getIsFromAppointmentOutcome(), GroupSameServiceEnumeration.rdoYes.equals(form.GroupSameService().getValue()) ? false : true);
		
		updateControlsState();
	}

	@Override
	protected void onRadioButtonGroupSeqValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setNumberOfLinkedAppointments(getNumberOfLinkedAppointmentsFromScrren());
		form.getGlobalContext().Scheduling.setLinkedOPA(null);
		
		initialise();
		open();
	}

	private Integer getNumberOfLinkedAppointmentsFromScrren()
	{
		if(GroupSeqEnumeration.rdo2.equals(form.GroupSeq().getValue()))
		{
			return 2;
		}
		else if(GroupSeqEnumeration.rdo3.equals(form.GroupSeq().getValue()))
		{
			return 3;
		}
		
		return null;
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
		
	}

	@Override
	protected void onCmbPeriodValueChanged() throws PresentationLogicException
	{
		form.dteApptDate().setValue(calculateAppointmentDate(form.intValue().getValue(), form.cmbPeriod().getValue()));
		
	}
	
	@Override
	protected void onIntValueValueChanged() throws PresentationLogicException
	{
		form.dteApptDate().setValue(calculateAppointmentDate(form.intValue().getValue(), form.cmbPeriod().getValue()));
		
	}
	
	private Date calculateAppointmentDate(Integer value , TimeUnitsSecondsToMonths unit)
	{
		if(value == null || unit == null)
			return null;
		
		Date futureDate = new Date();

		if (unit.equals(TimeUnitsSecondsToMonths.DAYS))
			futureDate.addDay(value);
		if (unit.equals(TimeUnitsSecondsToMonths.WEEKS))
			futureDate.addDay(value * 7);
		if (unit.equals(TimeUnitsSecondsToMonths.MONTHS))
			futureDate.addMonth(value);
		
		return futureDate;
	}

	@Override
	protected void onCc1ValueChanged() throws PresentationLogicException
	{
		onCc2ValueChanged();
		
	}

	@Override
	protected void onCc2ValueChanged() throws PresentationLogicException
	{
		form.cc2().setPreviousApptDate(form.cc1().getScheduledForDate());
		
		if (form.getLocalContext().getNumberOfLinkedAppointmentsIsNotNull() && form.getLocalContext().getNumberOfLinkedAppointments() == 3)
		{
			onCc3ValueChanged();
		}
		
	}

	@Override
	protected void onCc3ValueChanged() throws PresentationLogicException
	{
		form.cc3().setPreviousApptDate(form.cc2().getScheduledForDate());
		
	}
}
