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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.65 build 3218.18820)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.dmdadmin;

import ims.admin.helper.AMPLoader;
import ims.admin.helper.VMPLoader;
import ims.admin.helper.VTMLoader;
import ims.clinical.configuration.vo.VTMRefVo;
import ims.clinical.vo.VTMVo;
import ims.clinical.vo.VTMVoCollection;
import ims.configuration.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;	

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Admin.DMDVTMSelection) && result == DialogResult.OK)
		{
			addSelectedItemsToHotlist();
		}
	}	
	private String getBaseName(String fullFileName)
	{
		int ind = fullFileName.lastIndexOf("/");
		if (ind == -1)
		{
			ind = fullFileName.lastIndexOf("\\");			
		}
		if (ind == -1)
			return fullFileName; 
		
		if (ind + 1 == fullFileName.length())
			return "";
		
		return fullFileName.substring(ind + 1);
	}

	@Override
	protected void onfileupldAMPFileUploaded(String fileName) 
	{
		form.getLocalContext().setVTMFilename(fileName);
		form.imbLoadAMP().setEnabled(true);
		form.lblAMP().setValue(fileName + " ready to be loaded. Please click the Upload Arrow Button to continue.");		
	}
	@Override
	protected void onfileupldVMPFileUploaded(String fileName) 
	{		
		form.getLocalContext().setVTMFilename(fileName);
		form.imbLoadVMP().setEnabled(true);	
		form.lblVMP().setValue(fileName + " ready to be loaded. Please click the Upload Arrow Button to continue.");		
	}
	
	@Override
	protected void onfileupldVTMFileUploaded(String fileName) 
	{
		form.getLocalContext().setVTMFilename(fileName);
		form.imbLoadVTM().setEnabled(true);	
		form.lblVTM().setValue(fileName + " ready to be loaded. Please click the Upload Arrow Button to continue.");
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		initalise();		
	}
	
	private void initalise() 
	{
		form.imbLoadVTM().setEnabled(false);
		form.imbLoadVMP().setEnabled(false);
		form.imbLoadAMP().setEnabled(false);
		engine.setUploadUrl(ConfigFlag.GEN.UPLOAD_URL.getValue());
	}
	
	@Override
	protected void onImbLoadAMPClick() throws PresentationLogicException 
	{
		String uploadFileName = getBaseName(form.getLocalContext().getVTMFilename());

		AMPLoader ampload = new AMPLoader();
		String tempDir = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue();
		try {
			ampload.loadFile(domain,tempDir + "/" + uploadFileName);
		} catch (ParserConfigurationException e) {
			engine.showMessage(e.getMessage());
		} catch (SAXException e) {
			engine.showMessage(e.getMessage());
		} catch (IOException e) {
			try {
				ampload.loadFile(domain,tempDir + "/ObjectImports/" + uploadFileName);
			} catch (ParserConfigurationException e1) {
				engine.showMessage(e1.getMessage());
			} catch (SAXException e1) {
				engine.showMessage(e1.getMessage());
			} catch (IOException e1) {
				engine.showMessage(e1.getMessage());
			}
		}
	}

	@Override
	protected void onImbLoadVMPClick() throws PresentationLogicException 
	{
		String uploadFileName = getBaseName(form.getLocalContext().getVTMFilename());

		VMPLoader vmpload = new VMPLoader();
		String tempDir = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue();
		try {
			vmpload.loadFile(domain,tempDir + "/" + uploadFileName);
		} catch (ParserConfigurationException e) {
			engine.showMessage(e.getMessage());
		} catch (SAXException e) {
			engine.showMessage(e.getMessage());
		} catch (IOException e) {
			
			//try ObjectImports dir for xml files
			try {
				vmpload.loadFile(domain,tempDir + "/ObjectImports/" + uploadFileName);
			} catch (ParserConfigurationException e1) {
				engine.showMessage(e.getMessage());
			} catch (SAXException e1) {
				engine.showMessage(e1.getMessage());
			} catch (IOException e1) {
				engine.showMessage(e1.getMessage());
			}			
		}
	}

	@Override
	protected void onImbLoadVTMClick() throws PresentationLogicException 
	{
		String uploadFileName = getBaseName(form.getLocalContext().getVTMFilename());

		VTMLoader vtmload = new VTMLoader();
		String tempDir = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue();
		try {
			vtmload.loadFile(domain,tempDir + "/" + uploadFileName);
		} catch (ParserConfigurationException e) {
			engine.showMessage(e.getMessage());			
		} catch (SAXException e) {
			engine.showMessage(e.getMessage());
		} catch (IOException e) {
			try {
				vtmload.loadFile(domain,tempDir + "/ObjectImports/" + uploadFileName);
			} catch (ParserConfigurationException e1) {
				engine.showMessage(e1.getMessage());
			} catch (SAXException e1) {
				engine.showMessage(e1.getMessage());
			} catch (IOException e1) {
				engine.showMessage(e1.getMessage());
			}
		}
	}

	@Override
	protected void onCmbSpecialtyValueChanged() throws PresentationLogicException 
	{
		populateHotlist();
	}

	private void populateHotlist() 
	{
		populateVTMHotlist(form.lyrBrowser().tabHotlist().cmbSpecialty().getValue());
		updateHotlistControlsState();
	}

	private void populateVTMHotlist(Specialty specialty) 
	{
		form.lyrBrowser().tabHotlist().grdVTMHotlist().getRows().clear();
		
		if(specialty != null)
		{
			try 
			{
				VTMVoCollection list = domain.listVTMHotlist(specialty);
				
				if(list != null)
				{
					for(int x = 0; x < list.size(); x++)
					{
						addVTMHotlistItem(list.get(x));
					}
				}					
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
			}
		}
	}

	private void addVTMHotlistItem(VTMVo item) 
	{
		if(item != null)
		{
			GenForm.lyrBrowserLayer.tabHotlistContainer.grdVTMHotlistRow row = form.lyrBrowser().tabHotlist().grdVTMHotlist().getRows().newRow();
			
			row.setcolName(item.getName());
			row.setValue(item);
		}
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.AdminNamespace.DMD_VTM.ADD:
				addToHotlist();
				break;
			case GenForm.ContextMenus.AdminNamespace.DMD_VTM.REMOVE:
				removeFromHotlist();
				break;
		}
	}

	private void removeFromHotlist() 
	{
		try 
		{
			domain.removeFromHotlist(form.lyrBrowser().tabHotlist().cmbSpecialty().getValue(), (VTMRefVo)form.lyrBrowser().tabHotlist().grdVTMHotlist().getValue());
			form.lyrBrowser().tabHotlist().grdVTMHotlist().getRows().remove(form.lyrBrowser().tabHotlist().grdVTMHotlist().getSelectedRowIndex());
			updateHotlistControlsState();
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateHotlist();
		}
		
	}
	private void addToHotlist() 
	{
		VTMVoCollection list = new VTMVoCollection();
		for(int x = 0; x < form.lyrBrowser().tabHotlist().grdVTMHotlist().getRows().size(); x++)
		{
			list.add((VTMVo)form.lyrBrowser().tabHotlist().grdVTMHotlist().getRows().get(x).getValue());
		}
		form.getGlobalContext().Admin.DMDVTMSelection.setAlreadySelectedItems(list);
		engine.open(form.getForms().Admin.DMDVTMSelection);
	}

	@Override
	protected void onGrdVTMHotlistSelectionChanged() throws PresentationLogicException 
	{
		updateHotlistControlsState();
	}
	
	private void updateHotlistControlsState()
	{
		boolean hasSpecialty = form.lyrBrowser().tabHotlist().cmbSpecialty().getValue() != null;		
		
		form.lyrBrowser().tabHotlist().grdVTMHotlist().setEnabled(hasSpecialty);		
		form.getContextMenus().Admin.getDMD_VTMADDItem().setVisible(hasSpecialty);
		form.getContextMenus().Admin.getDMD_VTMREMOVEItem().setVisible(form.lyrBrowser().tabHotlist().grdVTMHotlist().getValue() != null);
	}
	private void addSelectedItemsToHotlist() 
	{
		try 
		{	
			if(form.getGlobalContext().Admin.DMDVTMSelection.getSelectedItems() != null)
			{
				domain.addToHotlist(form.lyrBrowser().tabHotlist().cmbSpecialty().getValue(), form.getGlobalContext().Admin.DMDVTMSelection.getSelectedItems());
				
				for(int x = 0; x < form.getGlobalContext().Admin.DMDVTMSelection.getSelectedItems().size(); x++)
				{
					addVTMHotlistItem(form.getGlobalContext().Admin.DMDVTMSelection.getSelectedItems().get(x));
				}
			}
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateHotlist();
		}			
	}
}
