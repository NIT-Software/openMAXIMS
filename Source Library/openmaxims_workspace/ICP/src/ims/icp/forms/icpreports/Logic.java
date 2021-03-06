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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 3994.29771)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.icp.forms.icpreports;

import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.PatientDocumentForICPReportsVo;
import ims.core.vo.PatientDocumentForICPReportsVoCollection;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.exceptions.PresentationLogicException;
import ims.icp.forms.icpreports.GenForm.grdReportsRow;
import ims.icp.vo.ICPAssessmentVoCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	public enum Types 
	{
		PMH_CHECLKIST, MEDICATION, SOCIAL_HISTORY, BASELINE_OBSERVATIONS, URINALYSIS, WATERLOW_ASSESSMENTS,
		SUITABLE_FOR_SURGERY, FIT_FOR_SURGERY, PROC_INTRAOP_CARE_RECORD, ORDERED_INVESTIGATIONS,
		RESULTED_INVESTIGATIONS,
		APPOINTMENTS, DIAGNOSIS, PATIENT_PROBLEMS, EVALUATION_NOTES, CRITICAL_EVENTS, PATIENT_ASSESSMENTS,
		SCANNED_DOCUMENTS, CLINICAL_OUTCOME,SOP_NOTES
	};
	
	public static Integer SCORING_ASSESSMENT = new Integer(69);
	public static Integer NONSCORING_ASSESSMENT = new Integer(51);
	
	private static final Object[] reports = new Object[] 
    {
		new Object[] {Types.PMH_CHECLKIST, "PMH Checklist", new Integer(250)},
		new Object[] {Types.MEDICATION, "Medication multiple doses", new Integer(251)},
		new Object[] {Types.SOCIAL_HISTORY, "Social History", new Integer(252)},
		new Object[] {Types.BASELINE_OBSERVATIONS, "Baseline Observations", new Integer(253)},
		new Object[] {Types.URINALYSIS, "Urinalysis", new Integer(254)},
		new Object[] {Types.WATERLOW_ASSESSMENTS, "Waterlow assessments", new Integer(255)},
		new Object[] {Types.SUITABLE_FOR_SURGERY, "Suitable for Surgery", new Integer(256)},
		new Object[] {Types.FIT_FOR_SURGERY, "Fit for surgery", new Integer(257)},
		new Object[] {Types.PROC_INTRAOP_CARE_RECORD, "Procedures & Intra Operative Care Record", new Integer(258)},
		new Object[] {Types.ORDERED_INVESTIGATIONS, "Ordered Investigations", new Integer(59)},
		new Object[] {Types.RESULTED_INVESTIGATIONS, "Resulted Investigations", new Integer(75)},
		new Object[] {Types.APPOINTMENTS, "Appointments", new Integer(261)},
		new Object[] {Types.DIAGNOSIS, "Diagnosis", new Integer(262)},
		new Object[] {Types.PATIENT_PROBLEMS, "Patient problems", new Integer(263)},
		new Object[] {Types.EVALUATION_NOTES, "Evaluation notes (ICPs)", new Integer(264)},
		new Object[] {Types.CRITICAL_EVENTS, "Critical events (ICPs)", new Integer(265)},
		new Object[] {Types.PATIENT_ASSESSMENTS, "Patient Assessments", new Integer(51), new Integer(69)},
		new Object[] {Types.SCANNED_DOCUMENTS, "Scanned documents"},
		new Object[] {Types.CLINICAL_OUTCOME, "Clinical Outcome", new Integer(283)},
		new Object[] {Types.SOP_NOTES, "ICP Surgical Operation Notes", new Integer(284)}
    };
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		populatePrinterCombo();
		populateReportsGrid();
		updateControlsState();
	}
	
	private void initialize() 
	{
		form.getLocalContext().setICPReport(null);
	}
	
	@Override
	protected void onBtnSelectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		int count = form.grdReports().getRows().size();
		
		for (int i = 0; i < count; i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			
			row.setcolSelect(true);
		}
	}
	
	@Override
	protected void onBtnUnselectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		int count = form.grdReports().getRows().size();
		
		for (int i = 0; i < count; i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			
			row.setcolSelect(false);
		}
	}
	
	@Override
	protected void onBtnBuildReportClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.htmReport().setHTML("");
		form.getLocalContext().setICPReport(null);
		buildReports();
		updateControlsState();
	}
	
	private void updateControlsState() 
	{
		form.btnPrint().setEnabled(form.getLocalContext().getICPReportIsNotNull());
	}
	
	private void buildReports()
	{
		StringBuilder msg = new StringBuilder(1024);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();
		String fileName = getDownloadFolder();
		String filePart = "ICPReport_" + df.format(now) + ".pdf";
		
		if(fileName == null)
		{
			engine.showMessage("Cannot create output folder !");
			return;
		}
		
		fileName = fileName + filePart;
		//fileName = filePart;
		
		int count = form.grdReports().getRows().size();
		
		for (int i = 0; i < count; i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			Object[] rowValue = (Object[]) row.getValue();
			
			if(row.getcolSelect() && !Types.SCANNED_DOCUMENTS.equals(rowValue[0]))
			{
				buildReportForCategory(fileName, row.getValue(), msg);
			}
			else if(row.getcolSelect() && Types.SCANNED_DOCUMENTS.equals(rowValue[0]))
			{
				concatenatePatientDocumentsToFinalPDF(fileName, msg);
			}	
		}
		
		File pdf = new File(fileName);
		
		if(pdf.exists() && pdf.length() > 0)
		{
			form.getLocalContext().setICPReport(fileName);
		
			String url = "<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + engine.getRequestUrl() + "/download/" + filePart + "'></IFRAME>";
			form.htmReport().setHTML(url);
		}
		
		form.htmConsole().setHTML(msg.toString());
		
		//engine.showMessage(msg.toString());
	}
	
	private void concatenatePatientDocumentsToFinalPDF(String fileName, StringBuilder msg) 
	{
		PatientDocumentForICPReportsVoCollection patientDocuments = domain.getPatientDocuments(form.getGlobalContext().ICP.getPatientICPRecord());
		
		if(patientDocuments == null || patientDocuments.size() == 0)
		{
			msg.append("No Scanned documents found!");
			msg.append("<br>");
			return;
		}
		
		for(int i=0; i<patientDocuments.size(); i++)
		{
			PatientDocumentForICPReportsVo document = patientDocuments.get(i);
			
			if(document == null || !document.getServerDocumentIsNotNull())
				continue;
			
			String documentName = getPDFStorePath() + document.getServerDocument().getFileName();
			byte[] result = readFile(documentName);
			
			if(result != null && result.length > 0)
			{
				if(appendToFile(fileName, result) == false)
				{
					msg.append("Could not append Scanned documents!");
					msg.append("<br>");
					return;
				}
			}
			else
			{
				msg.append("Could not read Scanned document from path '" + documentName + "' !");
				msg.append("<br>");
				return;
			}
		}
	}
	
	private String getPDFStorePath()
	{ 
		String documentStore = ConfigFlag.GEN.PDF_STORE_PATH.getValue();
		
		if(!(documentStore.endsWith("/") || documentStore.endsWith("\\")))
			documentStore = documentStore + "/";
		
		return documentStore;
	}	
	
	private byte[] readFile(String filePath)
	{
		File pdf = new File(filePath);
		long size = pdf.length();

		if (size == 0)
		{
			return null;
		}

		FileInputStream fileInputStream = null;
		byte[] buffer = null;

		try
		{
			fileInputStream = new FileInputStream(pdf);
			int bytesAvailable = fileInputStream.available();
			int maxBufferSize = (int) size;
			int bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];
			int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			while (bytesRead > 0)
			{
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}

		}
		catch (IOException e)
		{
			buffer = null;
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileInputStream.close();
			}
			catch (IOException e)
			{

			}
		}

		return buffer;
	}
	
	private boolean buildReportForCategory(String fileName, Object reportType, StringBuilder msg)
	{
		boolean err;
		Object[] obj = (Object[])reportType;
		QueryBuilderClient client = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());
		CareContextRefVo careContextId = null;
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		if(obj == null)
		{
			msg.append("Cannot build report for null type.");
			msg.append("<BR>");
			
			return false;
		}
		
		if(obj.length < 3)
		{
			msg.append("No report associated for type '" + obj[1] + "' !");
			msg.append("<BR>");
			
			return false;
		}
		
		try
		{
			if(!domain.existsRecordsForType(form.getGlobalContext().ICP.getPatientICPRecord(), obj[0]))
			{
				msg.append("No records exist for type '" + obj[1] + "' !");
				msg.append("<BR>");
				
				return false;
			}
		}
		catch(DomainInterfaceException e)
		{
			e.printStackTrace();
			
			msg.append("Error checking records for type '" + obj[1] + "', " + e.toString());
			msg.append("<BR>");
			
			return false;
		}
		
		//get the current carecontext
		try
		{
			careContextId = domain.getCareContext(form.getGlobalContext().ICP.getPatientICPRecord());
		}
		catch (DomainInterfaceException e1)
		{
			e1.printStackTrace();
			
			msg.append("Error getting careContext for type '" + obj[1] + "', " + e1.toString());
			msg.append("<BR>");
			
			return false;
		}
		
		if(careContextId == null)
		{
			msg.append("No careContext found for type '" + obj[1] + "' !");
			msg.append("<BR>");
			
			return false;
			
		}
		
		//we check whether the reports are deployed for each category
		for(int i = 2; i < obj.length; i++)
		{
			err = false;

			//we might have more than 1 report/template
			String[] rep = null;
			try
			{
				rep = domain.getReportAndTemplateByImsId((Integer) obj[i]);
			}
			catch (DomainInterfaceException e)
			{
				e.printStackTrace();
				
				msg.append("Error getting report template for type '" + obj[1] + "', with imsid = '" + obj[i] + "': " + e.toString());
				msg.append("<BR>");
				
				return false;
			}
			
			if(rep[0] == null || rep[0].length() == 0) 
			{
				msg.append("Got empty report for type '" + obj[1] + "', with imsid = '" + obj[i] + "'");
				msg.append("<BR>");
				err = true;
			}
			if(rep[1] == null || rep[1].length() == 0) 
			{
				msg.append("Got empty template for type '" + obj[1] + "', with imsid = '" + obj[i] + "'");
				msg.append("<BR>");
				err = true;
			}
			
			Integer[] seeds = null;
			boolean specialReport = false;
			
			if(Types.ORDERED_INVESTIGATIONS.equals(obj[0]))
			{
				specialReport = true;
				try
				{
					seeds = domain.listOrderSpecimens(form.getGlobalContext().ICP.getPatientICPRecord());
					
					if(seeds != null)
					{
						for (int j = 0; j < seeds.length; j++)
						{
							//we can build the report now
							client.getSeeds().clear();
							
							client.addSeed(new SeedValue("OrderSpecimen_id", seeds[j], Integer.class));
							
							byte[] result = null;
							try
							{
								result = client.buildReport(rep[0], rep[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
							} 
							catch (QueryBuilderClientException e1)
							{
								e1.printStackTrace();
								msg.append("Error building report for type '" + obj[1] + "', with imsid = '" + obj[i] + "', " + e1.toString());
								msg.append("<BR>");
								
								return false;
							}
							
							if(result != null && result.length > 0)
							{
								if(appendToFile(fileName, result) == false)
								{
									engine.showMessage("Could not append report for type '" + obj[1] + "', with imsid = '" + obj[i] + "' !");
									return false;
								}
							}
						}
					}
				}
				catch (DomainInterfaceException e)
				{
					e.printStackTrace();
					msg.append("Error getting seeds for type '" + obj[1] + "', with imsid = '" + obj[i] + "'");
					msg.append("<BR>");
					err = true;
				}
				
				return err;
			}
			else if(Types.RESULTED_INVESTIGATIONS.equals(obj[0]))
			{
				specialReport = true;
				try
				{
					seeds = domain.listOrderInvestigations(form.getGlobalContext().ICP.getPatientICPRecord());
					
					if(seeds != null)
					{
						for (int j = 0; j < seeds.length; j++)
						{
							//we can build the report now
							client.getSeeds().clear();
							
							client.addSeed(new SeedValue("OrderInvestigation_id", seeds[j], Integer.class));
							
							byte[] result = null;
							try
							{
								result = client.buildReport(rep[0], rep[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
							} 
							catch (QueryBuilderClientException e1)
							{
								e1.printStackTrace();
								msg.append("Error building report for type '" + obj[1] + "', with imsid = '" + obj[i] + "', " + e1.toString());
								msg.append("<BR>");
								
								return false;
							}
							
							if(result != null && result.length > 0)
							{
								if(appendToFile(fileName, result) == false)
								{
									engine.showMessage("Could not append report for type '" + obj[1] + "', with imsid = '" + obj[i] + "' !");
									return false;
								}
							}
						}
					}
				}
				catch (DomainInterfaceException e)
				{
					e.printStackTrace();
					msg.append("Error getting seeds for type '" + obj[1] + "', with imsid = '" + obj[i] + "'");
					msg.append("<BR>");
					err = true;
				}
			
				return err;
			}
			else if(Types.PATIENT_ASSESSMENTS.equals(obj[0]))
			{
				specialReport = true;
				try
				{
					ICPAssessmentVoCollection coll = domain.listPatientAssessments(form.getGlobalContext().ICP.getPatientICPRecord());
					
					if(coll != null)
					{
						for (int j = 0; j < coll.size(); j++)
						{
							boolean buildIt = false;
							
							//we can build the report now
							client.getSeeds().clear();
							
							//scoring assessment
							if(SCORING_ASSESSMENT.equals(obj[i]) && coll.get(j).getAssessmentType() != null && UserDefinedAssessmentType.ASSESSMENTTOOL.getId() == coll.get(j).getAssessmentType().intValue())
							{
								buildIt = true;
							}
							else if(NONSCORING_ASSESSMENT.equals(obj[i]) && coll.get(j).getAssessmentType() != null && UserDefinedAssessmentType.ASSESSMENTTOOL.getId() != coll.get(j).getAssessmentType().intValue())
							{
								buildIt = true;
							}
							
							if(buildIt)
							{
								client.addSeed(new SeedValue("PatientAssessment_id", coll.get(j).getPatientAssessmentId(), Integer.class));
								
								byte[] result = null;
								try
								{
									result = client.buildReport(rep[0], rep[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
								} 
								catch (QueryBuilderClientException e1)
								{
									e1.printStackTrace();
									msg.append("Error building report for type '" + obj[1] + "', with imsid = '" + obj[i] + "', " + e1.toString());
									msg.append("<BR>");
									
									return false;
								}
								
								if(result != null && result.length > 0)
								{
									if(appendToFile(fileName, result) == false)
									{
										engine.showMessage("Could not append report for type '" + obj[1] + "', with imsid = '" + obj[i] + "' !");
										return false;
									}
								}
							}
						}
					}
				}
				catch (DomainInterfaceException e)
				{
					e.printStackTrace();
					msg.append("Error getting seeds for type '" + obj[1] + "', with imsid = '" + obj[i] + "'");
					msg.append("<BR>");
					err = true;
				}
			}
			else if(Types.APPOINTMENTS.equals(obj[0]) || Types.CRITICAL_EVENTS.equals(obj[0]) || Types.EVALUATION_NOTES.equals(obj[0]))
			{
				specialReport = true;

				//we can build the report now
				client.getSeeds().clear();
				
				client.addSeed(new SeedValue("PatientICP_id", form.getGlobalContext().ICP.getPatientICPRecord().getID_PatientICP(), Integer.class));
				
				byte[] result = null;
				try
				{
					result = client.buildReport(rep[0], rep[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
				} 
				catch (QueryBuilderClientException e1)
				{
					e1.printStackTrace();
					msg.append("Error building report for type '" + obj[1] + "', with imsid = '" + obj[i] + "', " + e1.toString());
					msg.append("<BR>");
					
					return false;
				}
				
				if(result != null && result.length > 0)
				{
					if(appendToFile(fileName, result) == false)
					{
						engine.showMessage("Could not append report for type '" + obj[1] + "', with imsid = '" + obj[i] + "' !");
						return false;
					}
				}
			}
			
			if(err == false && specialReport == false)
			{
				//we can build the report now
				client.getSeeds().clear();
				
				client.addSeed(new SeedValue("CareContext_id", careContextId.getID_CareContext(), Integer.class));
				
				byte[] result = null;
				try
				{
					result = client.buildReport(rep[0], rep[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
				} 
				catch (QueryBuilderClientException e1)
				{
					e1.printStackTrace();
					msg.append("Error building report for type '" + obj[1] + "', with imsid = '" + obj[i] + "', " + e1.toString());
					msg.append("<BR>");
					
					return false;
				}
				
				if(result != null && result.length > 0)
				{
					if(appendToFile(fileName, result) == false)
					{
						engine.showMessage("Could not append report for type '" + obj[1] + "', with imsid = '" + obj[i] + "' !");
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private boolean appendToFile(String fileName, byte[] result)
	{
		java.util.Date date = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = df.format(date);
		String err;
		
		String tempPdfFile = fileName + "." + timestamp + "_Temp.pdf";
		
		File tempFile = new File(tempPdfFile);
		
		if(tempFile.exists())
		{
			deleteFile(tempFile);
		}
		
		if(writeToFile(tempPdfFile, result) == false)
			return false;
		
		File file = new File(fileName);
		File fileNew = new File(fileName + ".tmp");

        if(fileNew.exists())
        {
            if((err = deleteFile(fileNew)) != null)
    		{
            	engine.showMessage(err);
            	return false;
    		}
        }

        if(file.exists())
        {
	        if((err = renameFile(file, fileNew)) != null)
	        {
	        	engine.showMessage(err);
	        	return false;
	        }

	        //concatenate the existing and the new PDF file
	        try 
			{
				PdfReader reader1 = new PdfReader(fileNew.getPath());
			    PdfReader reader2 = new PdfReader(tempPdfFile);
			    
			    PdfCopyFields copy = new PdfCopyFields(new FileOutputStream(fileName));
			    copy.addDocument(reader1);
			    copy.addDocument(reader2);
			    copy.close();
			    
			    if((err = deleteFile(fileNew)) != null)
			    {
	            	engine.showMessage(err);
	            	return false;
			    }
			    
			    if((err = deleteFile(tempFile)) != null)
			    {
	            	engine.showMessage(err);
	            	return false;
			    }
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				engine.showMessage(e.toString());
				return false;
			} 
			catch (DocumentException e) 
			{
				e.printStackTrace();
				engine.showMessage(e.toString());
				return false;
			}
			catch (IOException e)  
			{
				e.printStackTrace();
				engine.showMessage(e.toString());
				return false;
			}	
		}
        else
        {
        	if((err = renameFile(new File(tempPdfFile), file)) != null)
	        {
	        	engine.showMessage(err);
	        	return false;
	        }
        }

		return true;
	}
	
	private boolean writeToFile(String fileName, byte[] pdf)  
	{
		FileOutputStream fos;
		
		try 
		{
			fos = new FileOutputStream(fileName);
			fos.write(pdf);
			fos.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			engine.showMessage(e.toString());
			return false;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			engine.showMessage(e.toString());
			return false;
		}
		
		return true;
	}	
	
	private void populateReportsGrid()
	{
		form.grdReports().getRows().clear();
		
		for (int i = 0; i < reports.length; i++)
		{
			Object[] obj = (Object[])reports[i];
			
			grdReportsRow row = form.grdReports().getRows().newRow();
			row.setcolReport(obj[1].toString());
			row.setTooltip(obj[1].toString());
			row.setcolSelect(true);
			
			row.setValue(obj);
		}
	}

	private String getDownloadFolder()  
	{
		if ( EnvironmentConfig.getBaseUri() == null || EnvironmentConfig.getBaseUri().length() == 0 )
		{
			return null;				
		}
		
		String folderName = EnvironmentConfig.getBaseUri() + "download/";				
		File folder = new File(folderName);
		
		if(folder.exists() == false)
		{
			boolean bSuccess = folder.mkdir();
			
			if(bSuccess == false)
			{
				System.out.println("I could not create the folder '" + folder.getAbsolutePath() + "' !");
				return null;
			}
		}
		
		return folderName;
	}

	private String renameFile(File file, File fileNew) 
	{
		boolean success = false;
		success = file.renameTo(fileNew);
		
		if (!success)
		{
			String err = "File '" + file + "' was not successfully renamed to '" + fileNew + "' !";
		    System.out.println(err);
		    return err;
		}
		
		return null;
	}

	private String deleteFile(File tempFile) 
	{
		boolean success = false;
		
		success = tempFile.delete();

		if (!success)
		{
			String err = "File '" + tempFile + "' was not successfully deleted !";
			System.out.println(err);
			return err;
		}
		
		return null;
	}
	
	@Override
	protected void onBtnPrintClick() throws PresentationLogicException
	{
		if(form.cmbPrint().getValue() == null)
		{
			engine.showMessage("Please select a printer.");
			return;
		}
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		QueryBuilderClient cl = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
		
		try
		{
			cl.printReport(readFile(form.getLocalContext().getICPReport()), urlReportServer, form.cmbPrint().getValue(), 1);
		}
		catch (QueryBuilderClientException e)
		{
			e.printStackTrace();
		}
		
		engine.showMessage("The report has been sent to printer '" + form.cmbPrint().getValue() + "'.");
	}
	
	private void populatePrinterCombo()
	{
		if(domain.getCurrentLocation() != null)
		{
			String[] list;
			try
			{
				list = domain.listPrinters(domain.getCurrentLocation().getID());
			}
			catch (DomainInterfaceException e)
			{
				e.printStackTrace();
				engine.showMessage("Error getting printers for current location: " + e.toString());
				return;
			}
			
			form.cmbPrint().clear();
			
			if(list != null)
			{
				for (int i = 0; i < list.length; i++)
				{
					form.cmbPrint().newRow(list[i], list[i]);
				}
			}
		}
	}
}
