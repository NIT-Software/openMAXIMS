// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.nursingnotescomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
		Core = new CoreContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedSpecialtyIsNotNull()
		{
			return !cx_RefManSelectedSpecialty.getValueIsNull(context);
		}
		public ims.core.vo.lookups.Specialty getSelectedSpecialty()
		{
			return (ims.core.vo.lookups.Specialty)cx_RefManSelectedSpecialty.getValue(context);
		}
		public void setSelectedSpecialty(ims.core.vo.lookups.Specialty value)
		{
			cx_RefManSelectedSpecialty.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSelectedSpecialty = new ims.framework.ContextVariable("RefMan.SelectedSpecialty", "_cv_RefMan.SelectedSpecialty");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			SelectMedication = new SelectMedicationContext(context);
		}
		public final class SelectMedicationContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SelectMedicationContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectedMedicationIsNotNull()
			{
				return !cx_CoreSelectMedicationSelectedMedication.getValueIsNull(context);
			}
			public ims.core.vo.MedicationVo getSelectedMedication()
			{
				return (ims.core.vo.MedicationVo)cx_CoreSelectMedicationSelectedMedication.getValue(context);
			}
		public void setSelectedMedication(ims.core.vo.MedicationVo value)
		{
				cx_CoreSelectMedicationSelectedMedication.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CoreSelectMedicationSelectedMedication = new ims.framework.ContextVariable("Core.SelectMedication.SelectedMedication", "_cv_Core.SelectMedication.SelectedMedication");
			private ims.framework.Context context;
		}

		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");

		public SelectMedicationContext SelectMedication;
		private ims.framework.Context context;
	}

	public RefManContext RefMan;
	public CoreContext Core;
}
