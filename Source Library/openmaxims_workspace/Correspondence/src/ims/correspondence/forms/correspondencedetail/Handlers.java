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

package ims.correspondence.forms.correspondencedetail;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTypeLookup();
	abstract protected void defaultcmbTypeLookupValue();
	abstract protected void bindgrdCategoriesCategoryLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDocStatHistClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnResetTemplateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEMailClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSupplementaryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPrintLetterClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrCorrespondenceDetailTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onQmbEnquireToTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbTypedByValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbTypedByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbDictatedByValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbDictatedByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAdresseeSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTypeValueSet(Object value);
	abstract protected void onChkSpecialInterestValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbSignedByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdCategoriesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.btnPreview().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviewClick();
			}
		});
		this.form.btnDocStatHist().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDocStatHistClick();
			}
		});
		this.form.btnResetTemplate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnResetTemplateClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
			}
		});
		this.form.btnEMail().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEMailClick();
			}
		});
		this.form.btnSupplementary().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSupplementaryClick();
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnPrintLetter().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPrintLetterClick();
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrCorrespondenceDetailtabRecipientsActivated();
			}
		});
		this.form.lyrCorrespondenceDetail().tabCorrespondence().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrCorrespondenceDetailtabCorrespondenceActivated();
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().qmbEnquiriesTo().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbEnquireToTextSubmited(value);
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().qmbTypedBy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbTypedByValueChanged();
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().qmbTypedBy().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbTypedByTextSubmited(value);
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().qmbDictatedBy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbDictatedByValueChanged();
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().qmbDictatedBy().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbDictatedByTextSubmited(value);
			}
		});
		this.form.lyrCorrespondenceDetail().tabRecipients().grdAdressee().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAdresseeSelectionChanged();
			}
		});
		this.form.lyrCorrespondenceDetail().tabCorrespondence().cmbType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeValueSet(value);
			}
		});
		this.form.lyrCorrespondenceDetail().tabCorrespondence().chkSpecialInterest().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkSpecialInterestValueChanged();
			}
		});
		this.form.lyrCorrespondenceDetail().tabCorrespondence().qmbSignedBy().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbSignedByTextSubmited(value);
			}
		});
		this.form.lyrCorrespondenceDetail().tabCorrespondence().grdCategories().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdCategoriesSelectionChanged();
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeADD_PATIENT_GPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.ADD_PATIENT_GP, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeADD_REFERRER_GPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.ADD_REFERRER_GP, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeADD_PATIENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.ADD_PATIENT, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeAddGpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.AddGp, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeAddNonGpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.AddNonGp, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeRemoveRecipientItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.RemoveRecipient, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.MoveUp, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddresseeMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsAddressee.MoveDown, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesAddTextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.AddText, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesRemoveTextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.RemoveText, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesViewTextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.ViewText, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesUpdateTextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.UpdateText, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.MoveUp, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsCategoriesMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetailsCategories.MoveDown, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTypeLookup();
		bindgrdCategoriesCategoryLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTypeLookup();
		bindgrdCategoriesCategoryLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTypeLookupValue();
	}
	private void onlyrCorrespondenceDetailtabRecipientsActivated()
	{
		this.form.lyrCorrespondenceDetail().showtabRecipients();
		onlyrCorrespondenceDetailTabChanged(this.form.lyrCorrespondenceDetail().tabRecipients());
	}
	private void onlyrCorrespondenceDetailtabCorrespondenceActivated()
	{
		this.form.lyrCorrespondenceDetail().showtabCorrespondence();
		onlyrCorrespondenceDetailTabChanged(this.form.lyrCorrespondenceDetail().tabCorrespondence());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}