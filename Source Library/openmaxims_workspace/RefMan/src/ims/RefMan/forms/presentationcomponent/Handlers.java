// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.presentationcomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindgrdMedicationcolFrequencyLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMedicationSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onbtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onbtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEdit() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onbtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdCoMorbiditiesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdCoMorbitiesMutableComboBoxSelected(int column, GenForm.grdCoMorbitiesRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdCoMorbiditiesTxtSubmitted(int column, GenForm.grdCoMorbitiesRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onAllergyGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAlergiesMutableComboBoxSelected(int column, GenForm.grdAlergiesRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onAllergyGridComboBoxTextSubmited(int column, GenForm.grdAlergiesRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCoMorbitiesIndicatedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkComplaintsNonIndicatedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkMedicationsIndicatedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkAllergiesIndicatedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDtimAuthoringDateTimeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbAuthorValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbAuthorTextSubmitted(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIssueGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdIssuesMutableComboBoxSelected(int column, GenForm.grdIssuesRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIssuesComboBoxTextBoxSubmitted(int column, GenForm.grdIssuesRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				// Checking lookups usage
				if(getLookupUsageErrors() != null && getLookupUsageErrors().length > 0)
					throw new ims.framework.exceptions.FormMandatoryLookupMissingException(ims.framework.exceptions.FormMandatoryLookupMissingException.getError(getLookupUsageErrors()));
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
		this.form.grdMedication().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMedicationSelectionChanged();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onbtnCancelClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onbtnSaveClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEdit();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onbtnNewClick();
			}
		});
		this.form.grdCoMorbities().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdCoMorbiditiesSelectionChanged();
			}
		});
		this.form.grdCoMorbities().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdCoMorbitiesMutableComboBoxSelected(column, new GenForm.grdCoMorbitiesRow(row), value);
			}
		});
		this.form.grdCoMorbities().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdCoMorbiditiesTxtSubmitted(column, new GenForm.grdCoMorbitiesRow(row), text);
			}
		});
		this.form.grdAlergies().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onAllergyGridSelectionChanged();
			}
		});
		this.form.grdAlergies().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAlergiesMutableComboBoxSelected(column, new GenForm.grdAlergiesRow(row), value);
			}
		});
		this.form.grdAlergies().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onAllergyGridComboBoxTextSubmited(column, new GenForm.grdAlergiesRow(row), text);
			}
		});
		this.form.chkCoMorbitiesIndicated().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCoMorbitiesIndicatedValueChanged();
			}
		});
		this.form.chkComplaintsIndicated().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkComplaintsNonIndicatedValueChanged();
			}
		});
		this.form.chkMedicationsIndicated().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkMedicationsIndicatedValueChanged();
			}
		});
		this.form.chkAllergiesIndicated().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkAllergiesIndicatedValueChanged();
			}
		});
		this.form.dtimAuthoringDateTime().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDtimAuthoringDateTimeValueChanged();
			}
		});
		this.form.qmbAuthor().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbAuthorValueChanged();
			}
		});
		this.form.qmbAuthor().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbAuthorTextSubmitted(value);
			}
		});
		this.form.grdIssues().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onIssueGridSelectionChanged();
			}
		});
		this.form.grdIssues().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdIssuesMutableComboBoxSelected(column, new GenForm.grdIssuesRow(row), value);
			}
		});
		this.form.grdIssues().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onIssuesComboBoxTextBoxSubmitted(column, new GenForm.grdIssuesRow(row), text);
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
		this.form.getContextMenus().RefMan.getCoMorbidityaddItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.CoMorbidity.addItem, sender);
			}
		});
		this.form.getContextMenus().RefMan.getCoMorbidityremoveItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.CoMorbidity.removeItem, sender);
			}
		});
		this.form.getContextMenus().RefMan.getallergyMenuaddItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.allergyMenu.addItem, sender);
			}
		});
		this.form.getContextMenus().RefMan.getallergyMenuremoveItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.allergyMenu.removeItem, sender);
			}
		});
		this.form.getContextMenus().RefMan.getDetailsMenuAddItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.DetailsMenu.AddItem, sender);
			}
		});
		this.form.getContextMenus().RefMan.getDetailsMenuremoveItemItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.DetailsMenu.removeItem, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdMedicationcolFrequencyLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdMedicationcolFrequencyLookup();
	}
	protected void defaultAllLookupValues()
	{
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
