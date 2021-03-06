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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.70 build 3338.22887)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.taxonomycodeadmin;

import ims.admin.helper.TaxonomyLoaderHelper;
import ims.admin.vo.TaxonomyUploadVo;
import ims.admin.vo.lookups.FileFormatType;
import ims.configuration.EnvironmentConfig;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		initalise();
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		form.txtDefinitionFileMandatory().setVisible(!TaxonomyType.SNOMED.equals(form.cmbExternalCodeType().getValue()));
		form.txtDefinitionFileMandatory().setEnabled(FormMode.EDIT.equals(form.getMode()));
	}

	private void initalise() 
	{
		form.imbUpload().setEnabled(false);
		form.imbUpdate().setEnabled(false);
		form.imbValidateColMap().setEnabled(false);
		form.getLocalContext().setPasswordEntered(false);
		form.getLocalContext().setbUpload(false);
	}

	@Override
	protected void onImbUploadClick() throws PresentationLogicException 
	{
				
		TaxonomyUploadVo vo = null;
		
		//First check a definition is set up
		if (form.getLocalContext().getcodeLoaderDefIsNotNull())
		{
			//do a get again to make sure the loader def is up to date
			try {
				vo = domain.getCodeLoaderDef(form.getLocalContext().getcodeLoaderDef());
			} catch (DomainInterfaceException e) 
			{
				
			}
			if (vo != null)
			{
				form.getLocalContext().setcodeLoaderDef(vo);		
				//Upload Taxonomy
				uploadTaxonomy();
			}
			else
				engine.showMessage("Error getting Code Loader Definition.");
				return;
		
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
	protected void onImbUpdateClick() throws PresentationLogicException 
	{
		form.getLocalContext().setPasswordEntered(Boolean.TRUE);
		form.setMode(FormMode.EDIT);
		form.imbUpload().setEnabled(false);
	}

	@Override
	protected void onImbValidateClick() throws PresentationLogicException 
	{
		if (form.getLocalContext().getcodeLoaderDefIsNotNull())
		{
			if (form.getLocalContext().getcodeLoaderDef().getTaxonomyFilenameIsNotNull() && form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilenameIsNotNull())
			{
				TaxonomyLoaderHelper codeLoader = new TaxonomyLoaderHelper();		
				try {
					codeLoader.validateTaxonomyFile(form.getLocalContext().getcodeLoaderDef().getTaxonomyFilename(), form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilename());
				} catch (IOException e) 
				{
					engine.showMessage(e.getMessage());
				}
				
				engine.showMessage("Taxonomy Code File is Valid.");
			}
		}
	}

	@Override
	protected void onImbValidateColMapClick() throws PresentationLogicException 
	{		
		validateColMapFile(true);
	}

	private void validateColMapFile(boolean showMessage)
	{
		if (form.getLocalContext().getcodeLoaderDefIsNotNull() && form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilenameIsNotNull())
		{
			ims.admin.helper.TaxonomyLoaderHelper tl = new TaxonomyLoaderHelper();
			try {
				tl.validateXMLFIle(form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilename());
			} catch (ParserConfigurationException e) {
				engine.showMessage(e.getMessage());
			} catch (SAXException e) {
				engine.showMessage(e.getMessage());
			} catch (IOException e) {
				engine.showMessage(e.getMessage());
			}
			if (showMessage)
				engine.showMessage("Column Map is valid.");
		}
		else
			engine.showMessage("Please upload or select an external code type.");

	}
	
	@Override
	protected void onfileupldNameFileUploaded(String fileName) 
	{		
		form.lblUploadedTaxonomy().setValue("File Uploaded");
		String basedir = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue();
		
		String baseFilename = getBaseName(fileName);
		
		boolean baseDirIsEndingWithSlash = basedir.endsWith("/") || basedir.endsWith("\\");
		
		String ext = baseFilename.substring(baseFilename.indexOf("."), baseFilename.length());
		if (ext.equals(".xml"))
		{
			form.txtTaxonomyFile().setValue(basedir + (baseDirIsEndingWithSlash ? "" : "/") + "ObjectImports/" + baseFilename);
			form.getLocalContext().settaxonomyFilename(basedir + (baseDirIsEndingWithSlash ? "" : "/") + "ObjectImports/" + baseFilename);
		}
		else
		{
			form.txtTaxonomyFile().setValue(basedir + (baseDirIsEndingWithSlash ? "" : "/") + baseFilename);
			form.getLocalContext().settaxonomyFilename(basedir + (baseDirIsEndingWithSlash ? "" : "/") + baseFilename);
		}
	}

	@Override
	protected void onfileupldColumnMapFileUploaded(String fileName) 
	{
		TaxonomyLoaderHelper codeLoader = new TaxonomyLoaderHelper();
				
		form.lblUploadedColMap().setValue("File Uploaded :");
		
		String basedir = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue();
		
		boolean baseDirIsEndingWithSlash = basedir.endsWith("/") || basedir.endsWith("\\");
		
		String baseFilename = getBaseName(fileName);
		
		String ext = baseFilename.substring(baseFilename.indexOf("."), baseFilename.length());
		if (ext.equals(".xml"))
		{
			form.txtDefinitionFile().setValue(basedir + (baseDirIsEndingWithSlash ? "" : "/") + "ObjectImports/" + baseFilename);
			form.getLocalContext().setmapFilename(basedir + (baseDirIsEndingWithSlash ? "" : "/") + "ObjectImports/" + baseFilename);
		}
		else
		{
			form.txtDefinitionFile().setValue(basedir + (baseDirIsEndingWithSlash ? "" : "/") + baseFilename);
			form.getLocalContext().setmapFilename(basedir + (baseDirIsEndingWithSlash ? "" : "/") + baseFilename);
		}
		
		try {
			form.txtcolMapFile().setValue(codeLoader.getLocalColMapFileContent(form.getLocalContext().getmapFilename()));
		} catch (FileNotFoundException e) 
		{
			engine.showMessage(e.getMessage());
		} catch (IOException e) 
		{
			engine.showMessage(e.getMessage());
		}		
	}

	protected void onCmbExternalCodeTypeValueChanged() throws PresentationLogicException 
	{
		clearscreenData();
		form.cmbTaxonomyElement().setValue(null);
		
		updateControlsState();
	}

	private void clearscreenData() 
	{
		form.txtcolMapFile().setValue("");
		form.txtcolMapFile().setValue("");
		form.txtDefinitionFile().setValue("");
		form.txtTaxonomyFile().setValue("");
		form.txtDelimiter().setValue("");
		form.txtQualifier().setValue("");		
		form.cmbFileType().setValue(null);
	}

	protected void onCmbTaxonomyElementValueChanged() throws PresentationLogicException 
	{		
		if (form.cmbExternalCodeType().getValue() != null && form.cmbTaxonomyElement().getValue() != null)
		{
			try {
				form.getLocalContext().setcodeLoaderDef((domain.getCodeLoaderDef(form.cmbExternalCodeType().getValue().getID(),form.cmbTaxonomyElement().getValue().getID())));
				populateScreenwithData();
				form.imbUpdate().setEnabled(true);
			} catch (DomainInterfaceException e) 
			{
				form.imbUpload().setEnabled(false);
				engine.showMessage(e.getMessage());
			}
		}
		else
			form.imbUpload().setEnabled(false);//WDEV-17059
	}
	
	private void populateScreenwithData() 
	{
		clearscreenData();
		
		TaxonomyLoaderHelper codeLoader = new TaxonomyLoaderHelper();
		form.txtcolMapFile().setValue(null);
		form.txtDefinitionFile().setValue(null);
		form.lblUploadedColMap().setValue(null);
		form.lblUploadedTaxonomy().setValue(null);
		form.imbValidateColMap().setEnabled(false);
		
		if (form.getLocalContext().getcodeLoaderDefIsNotNull())
		{
			try {
				 if (form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilenameIsNotNull())
				 {
					String str = codeLoader.getColMapFileContent(form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilename());
					form.txtcolMapFile().setValue(str);
				 }
				 
				//update local context var
				form.getLocalContext().settaxonomyFilename(form.getLocalContext().getcodeLoaderDef().getTaxonomyFilename());
				
				if (form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilenameIsNotNull())
				{
					form.lblUploadedColMap().setValue("File Uploaded : ");
					form.txtDefinitionFile().setValue(form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilename());
					form.imbValidateColMap().setEnabled(true);
				}
				else
				{
					form.lblUploadedColMap().setValue("No codemap file uploaded.");					
				}
				if (form.getLocalContext().getcodeLoaderDef().getTaxonomyFilenameIsNotNull())
				{
					form.lblUploadedTaxonomy().setValue("File Uploaded : ");
					form.txtTaxonomyFile().setValue(form.getLocalContext().getcodeLoaderDef().getTaxonomyFilename());
				}
				else
				{					
					form.lblUploadedTaxonomy().setValue("No taxonomy file uploaded.");
				}
				
				form.cmbFileType().setValue(form.getLocalContext().getcodeLoaderDef().getFileType());
				
				form.txtDelimiter().setValue(form.getLocalContext().getcodeLoaderDef().getDelimeter());
				
				form.txtQualifier().setValue(form.getLocalContext().getcodeLoaderDef().getQualifier());
				
			} 
			catch (FileNotFoundException e) 
			{
				form.imbUpload().setEnabled(false); //WDEV-17059
				engine.showMessage(e.getMessage());
				return;
			} 
			catch (IOException e) 
			{
				form.imbUpload().setEnabled(false); //WDEV-17059
				engine.showMessage(e.getMessage());
				return;
			}
			
			form.imbUpload().setEnabled(true);
		}
		else
		{
			form.imbUpload().setEnabled(false);
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		//no password screen needed
	}

	private void uploadTaxonomy() 
	{
		StringBuffer strDelimiter = new StringBuffer();
		StringBuffer strQual = new StringBuffer();
		
		if (form.txtDelimiter().getValue() != null)
			strDelimiter.append(form.txtDelimiter().getValue());

		if (form.txtQualifier().getValue() != null)
			strQual.append(form.txtQualifier().getValue());
		
		TaxonomyLoaderHelper codeLoader = new TaxonomyLoaderHelper(domain,form.getLocalContext().getcodeLoaderDef().getTaxonomyCode(),form.getLocalContext().getcodeLoaderDef().getFileType(),form.getLocalContext().getcodeLoaderDef().getTaxonomyElement());
		try {
			codeLoader.load(form.getLocalContext().gettaxonomyFilename(), form.getLocalContext().getcodeLoaderDef().getTaxonomyColumnMapFilename(),strDelimiter,strQual);
			form.htmLoadReport().setHTML(codeLoader.getLoadReport(form.getLocalContext().getcodeLoaderDef().getTaxonomyCode()));
		} catch (IOException e) {
			engine.showMessage(e.getMessage());
			return;
		}
		
		engine.showMessage(form.getLocalContext().gettaxonomyFilename() + " loaded sucessfully.","Information",ims.framework.MessageButtons.OK,ims.framework.MessageIcon.INFORMATION);
	}

	private boolean saveCodeLoaderDef()
	{
		TaxonomyLoaderHelper codeLoader = new TaxonomyLoaderHelper();
		
		//WDEV-17053 
		if (!TaxonomyType.SNOMED.equals(form.cmbExternalCodeType().getValue()) && (form.txtDefinitionFile().getValue() == null ||form.txtDefinitionFile().getValue().length() == 0))
		{
			engine.showMessage("The path to taxonomy definition file is empty. \nPlease enter a valid full path and try again");
			form.fileupldColumnMap().setFocus();
			return false;
		}
		if (form.txtcolMapFile().getValue() != null && form.txtDefinitionFile().getValue() != null) //WDEV-17053
		{
			
			try {
				codeLoader.saveColMapToFile(form.txtDefinitionFile().getValue(),form.txtcolMapFile().getValue());
			} catch (FileNotFoundException e) {
				engine.showMessage(e.getMessage());
				return false;
			} catch (IOException e) {
				engine.showMessage(e.getMessage());
				return false;
			}
		}
		
		if (form.cmbExternalCodeType().getValue() == null)
		{
			engine.showMessage("Please select an External Code Type");
			form.cmbExternalCodeType().setFocus();
			return false;
		}
		
		if (form.cmbFileType().getValue() == null)
		{
			engine.showMessage("Please select a Taxonomy File Type");
			form.cmbFileType().setFocus();
			return false;
		}

		if (form.cmbTaxonomyElement().getValue() == null)
		{
			engine.showMessage("Please select a Taxonomy Element");
			form.cmbTaxonomyElement().setFocus();
			return false;
		}
		
				
		if (form.txtTaxonomyFile().getValue() == null ||form.txtTaxonomyFile().getValue().length() ==0)
		{
			engine.showMessage("The path to taxonomy file is empty. \nPlease enter a valid full path and try again");
			form.fileupldColumnMap().setFocus();
			return false;
		}
		
		if (form.cmbFileType().getValue().equals(FileFormatType.DELIMITED) && ((form.txtDelimiter().getValue() == null) || (form.txtDelimiter().getValue().equals(""))))			
		{
			engine.showMessage("Please enter a delimeter for delimited file format type.");
			form.txtDelimiter().setFocus();
			return false;			
		}
		
		TaxonomyUploadVo voColMap = null;
		try {
			voColMap = domain.getCodeLoaderDef(form.cmbExternalCodeType().getValue().getID(),form.cmbTaxonomyElement().getValue().getID());			
		} catch (DomainInterfaceException e1) {
			engine.showMessage(e1.getMessage());
		}
		
		String codeDefFileName = "";
		String codeFilename = "";
		
		//update db
		if (voColMap == null)
			voColMap = new TaxonomyUploadVo();
		
		
		if (form.txtDefinitionFile().getValue() != null)
			codeDefFileName = form.txtDefinitionFile().getValue();

		if (form.txtTaxonomyFile().getValue() != null)
			codeFilename = form.txtTaxonomyFile().getValue(); 		
			
		voColMap.setTaxonomyCode(form.cmbExternalCodeType().getValue());
		//code definition file
		voColMap.setTaxonomyColumnMapFilename(codeDefFileName);
		voColMap.setFileType(form.cmbFileType().getValue());
		voColMap.setTaxonomyElement(form.cmbTaxonomyElement().getValue());	
		//code file
		voColMap.setTaxonomyFilename(codeFilename);		

		//delimiter
		voColMap.setDelimeter(form.txtDelimiter().getValue());

		//qualifier
		voColMap.setQualifier(form.txtQualifier().getValue());
		
		String[] arrErrors = voColMap.validate();
		if (arrErrors != null)
		{
			engine.showMessage(arrErrors.toString());
			return false;
		}
		
		try {
			form.getLocalContext().setcodeLoaderDef(domain.saveCodeLoaderDef(voColMap));
		} catch (DomainInterfaceException e) {
			engine.showMessage(e.getMessage());
			return false;
		} catch (StaleObjectException e) {
			engine.showMessage(e.getMessage());
			return false;
		} catch (ForeignKeyViolationException e) {
			engine.showMessage(e.getMessage());
			return false;
		}
		
		form.setMode(FormMode.VIEW);		
		populateScreenwithData();
				
		return true;

	}

	protected void onCmbFileTypeValueChanged() throws PresentationLogicException 
	{
		//WDEV-17053 
		if (form.cmbFileType().getValue()!= null && form.cmbFileType().getValue().equals(FileFormatType.DELIMITED))
		{
			form.txtDelimiter().setRequired(Boolean.TRUE);
		}
		else
		{	
			form.txtDelimiter().setRequired(Boolean.FALSE);
		}	
		if (form.getLocalContext().getcodeLoaderDefIsNotNull())
			form.getLocalContext().getcodeLoaderDef().setFileType(form.cmbFileType().getValue());
	}

	@Override
	protected void onImbSaveCodeLoaderDefClick() throws PresentationLogicException 
	{
		saveCodeLoaderDef();
	}

	@Override
	protected void onImbCancelClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.VIEW);
		populateScreenwithData();
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
}
