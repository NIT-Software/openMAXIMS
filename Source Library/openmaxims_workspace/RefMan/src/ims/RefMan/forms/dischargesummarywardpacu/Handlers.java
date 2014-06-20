// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.dischargesummarywardpacu;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdAppointmentscolStatusLookup();
	abstract protected void bindcmbFollowUpTypeLookup();
	abstract protected void defaultcmbFollowUpTypeLookupValue();
	abstract protected void bindcmbDischargeTypeLookup();
	abstract protected void defaultcmbDischargeTypeLookupValue();
	abstract protected void bindgrdMedicationscolFrequencyLookup();
	abstract protected void bindgrdDressingAndAidscolDressingAidLookup();
	abstract protected void bindgrdDressingAndAidscolPeriodIntervalLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecBrowserValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnTTOPrintClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDischargeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookAppointmentClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAppointmentsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAppointmentsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbFollowUpTypeValueSet(Object value);
	abstract protected void oncmbDischargeTypeValueSet(Object value);
	abstract protected void onGrdMedicationsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMedicationsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDressingAndAidsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDressingAndAidsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPrintDischargeReportClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPrintDischargeSummaryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.recBrowser().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecBrowserValueChanged();
			}
		});
		this.form.btnTTOPrint().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnTTOPrintClick();
			}
		});
		this.form.btnDischarge().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDischargeClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.lyrContent().tabDischargeDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrContenttabDischargeDetailsActivated();
			}
		});
		this.form.lyrContent().tabNursing().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrContenttabNursingActivated();
			}
		});
		this.form.lyrContent().tabDischargeSummary().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrContenttabDischargeSummaryActivated();
			}
		});
		this.form.lyrContent().tabDischargeDetails().btnBookAppointment().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookAppointmentClick();
			}
		});
		this.form.lyrContent().tabDischargeDetails().grdAppointments().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAppointmentsSelectionChanged();
			}
		});
		this.form.lyrContent().tabDischargeDetails().grdAppointments().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAppointmentsSelectionCleared();
			}
		});
		this.form.lyrContent().tabDischargeDetails().cmbFollowUpType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbFollowUpTypeValueSet(value);
			}
		});
		this.form.lyrContent().tabDischargeDetails().cmbDischargeType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDischargeTypeValueSet(value);
			}
		});
		this.form.lyrContent().tabNursing().grdMedications().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMedicationsSelectionChanged();
			}
		});
		this.form.lyrContent().tabNursing().grdMedications().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMedicationsSelectionCleared();
			}
		});
		this.form.lyrContent().tabNursing().grdDressingAndAids().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDressingAndAidsSelectionChanged();
			}
		});
		this.form.lyrContent().tabNursing().grdDressingAndAids().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDressingAndAidsSelectionCleared();
			}
		});
		this.form.lyrContent().tabDischargeSummary().btnPrintDischargeReport().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPrintDischargeReportClick();
			}
		});
		this.form.lyrContent().tabDischargeSummary().btnPrintDischargeSummary().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPrintDischargeSummaryClick();
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentBOOK_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.BOOK_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentCANCEL_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.CANCEL_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentREBOOK_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.REBOOK_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentORDER_INVESTIGATIONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.ORDER_INVESTIGATION, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentBOOK_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.BOOK_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentCANCEL_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.CANCEL_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentREBOOK_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.REBOOK_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getReferralAppointmentDetailsComponentVIEW_APPT_HISTORYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.ReferralAppointmentDetailsComponent.VIEW_APPT_HISTORY, sender);
			}
		});
		this.form.getContextMenus().RefMan.getmedicationsMenuaddMedicationItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.medicationsMenu.addMedication, sender);
			}
		});
		this.form.getContextMenus().RefMan.getmedicationsMenuremoveMedicationItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.medicationsMenu.removeMedication, sender);
			}
		});
		this.form.getContextMenus().RefMan.getmedicationsMenueditMedicationItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.medicationsMenu.editMedication, sender);
			}
		});
		this.form.getContextMenus().RefMan.getDischargeSummaryWardPacuADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.DischargeSummaryWardPacu.ADD, sender);
			}
		});
		this.form.getContextMenus().RefMan.getDischargeSummaryWardPacuREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.DischargeSummaryWardPacu.REMOVE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdAppointmentscolStatusLookup();
		bindcmbFollowUpTypeLookup();
		bindcmbDischargeTypeLookup();
		bindgrdMedicationscolFrequencyLookup();
		bindgrdDressingAndAidscolDressingAidLookup();
		bindgrdDressingAndAidscolPeriodIntervalLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdAppointmentscolStatusLookup();
		bindcmbFollowUpTypeLookup();
		bindcmbDischargeTypeLookup();
		bindgrdMedicationscolFrequencyLookup();
		bindgrdDressingAndAidscolDressingAidLookup();
		bindgrdDressingAndAidscolPeriodIntervalLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbFollowUpTypeLookupValue();
		defaultcmbDischargeTypeLookupValue();
	}
	private void onlyrContenttabDischargeDetailsActivated()
	{
		this.form.lyrContent().showtabDischargeDetails();
	}
	private void onlyrContenttabNursingActivated()
	{
		this.form.lyrContent().showtabNursing();
	}
	private void onlyrContenttabDischargeSummaryActivated()
	{
		this.form.lyrContent().showtabDischargeSummary();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
