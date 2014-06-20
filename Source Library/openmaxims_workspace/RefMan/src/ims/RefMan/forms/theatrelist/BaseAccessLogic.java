// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.theatrelist;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Clinical = new ClinicalForms();
			RefMan = new RefManForms();
			Scheduling = new SchedulingForms();
			ICP = new ICPForms();
		}
		public final class ClinicalForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalForms()
			{
				IntraOperativeCareRecord = new LocalFormName(134155);
			}
			public final FormName IntraOperativeCareRecord;
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				TheatreAdmissionDialog = new LocalFormName(134156);
				ArrivalSeenTimeDialog = new LocalFormName(134186);
				PatientICPForTheatreBookingDlg = new LocalFormName(134215);
				BookTheatreDialog = new LocalFormName(134159);
				BookTheatreSlot = new LocalFormName(134208);
			}
			public final FormName TheatreAdmissionDialog;
			public final FormName ArrivalSeenTimeDialog;
			public final FormName PatientICPForTheatreBookingDlg;
			public final FormName BookTheatreDialog;
			public final FormName BookTheatreSlot;
		}
		public final class SchedulingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SchedulingForms()
			{
				SortTheatreAppointments = new LocalFormName(114174);
				SortFixedTheatreAppointments = new LocalFormName(114106);
				CancelAppointmentDialog = new LocalFormName(114160);
			}
			public final FormName SortTheatreAppointments;
			public final FormName SortFixedTheatreAppointments;
			public final FormName CancelAppointmentDialog;
		}
		public final class ICPForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ICPForms()
			{
				PatientICP = new LocalFormName(118100);
			}
			public final FormName PatientICP;
		}

		public ClinicalForms Clinical;
		public RefManForms RefMan;
		public SchedulingForms Scheduling;
		public ICPForms ICP;
	}
}
