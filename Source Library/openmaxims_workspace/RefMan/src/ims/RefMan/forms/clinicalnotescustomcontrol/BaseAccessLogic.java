// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.clinicalnotescustomcontrol;

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
		if(!form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;
		if(!form.getGlobalContext().RefMan.getCatsReferralIsNotNull())
			return false;

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
			RefMan = new RefManForms();
			Core = new CoreForms();
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				ClinicalNoteDialog = new LocalFormName(134195);
				PatientDiagnosisDialog = new LocalFormName(134201);
				PatientProcedureDialog = new LocalFormName(134202);
				PreviousReferralsDialog = new LocalFormName(134204);
				AppointmentPatientDiagnosisDialog = new LocalFormName(134211);
				AppointmentPatientProcedureDialog = new LocalFormName(134212);
				ClinicalNotesCustomControl = new LocalFormName(134213);
				PrintCorrespondenceNoteDialog = new LocalFormName(134182);
			}
			public final FormName ClinicalNoteDialog;
			public final FormName PatientDiagnosisDialog;
			public final FormName PatientProcedureDialog;
			public final FormName PreviousReferralsDialog;
			public final FormName AppointmentPatientDiagnosisDialog;
			public final FormName AppointmentPatientProcedureDialog;
			public final FormName ClinicalNotesCustomControl;
			public final FormName PrintCorrespondenceNoteDialog;
		}
		public final class CoreForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CoreForms()
			{
				PatientDocumentView = new LocalFormName(102335);
				RieConfirmationDialog = new LocalFormName(102370);
			}
			public final FormName PatientDocumentView;
			public final FormName RieConfirmationDialog;
		}

		public RefManForms RefMan;
		public CoreForms Core;
	}
}