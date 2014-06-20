// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3763.19232)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.awaitingclinicalinformationdialog;

import ims.RefMan.vo.AwaitingClinicalInfoVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.lookups.AwaitingClinicalInformationType;
import ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection;
import ims.RefMan.vo.lookups.LookupHelper;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.delegates.CancelArgs;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	// Dynamic grid columns
	public static final Integer COLTYPE = Integer.valueOf(-1);
	public static final Integer COLAWAIT = Integer.valueOf(-2);
	public static final Integer COLREC = Integer.valueOf(-3);

	private enum SaveMode
	{
		SAVE, SAVE_ALL_RECEIVED, REMOVE_FROM_LIST
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	// Event Handlers
	// ----------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();

		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onBtnAllInformationReceivedClick() throws PresentationLogicException
	{
		if (save(SaveMode.SAVE_ALL_RECEIVED))
		{
			form.getGlobalContext().RefMan.setAwaitingClinicalInfo(form.getLocalContext().getAwaitingClinicalInfo());
			form.getGlobalContext().RefMan.setAwaitingClinicalInfoBoolean(form.getLocalContext().getIsAwaitingClinicalInfo());

			form.getGlobalContext().RefMan.setCatsReferral(form.getLocalContext().getCatsReferralWizzard());
			form.getGlobalContext().RefMan.setCatsReferralWizard(form.getLocalContext().getCatsReferralWizzard());

			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onBtnRemoveFromWaitingListClick() throws PresentationLogicException
	{
		if (save(SaveMode.REMOVE_FROM_LIST))
		{
			form.getGlobalContext().RefMan.setAwaitingClinicalInfo(form.getLocalContext().getAwaitingClinicalInfo());
			form.getGlobalContext().RefMan.setAwaitingClinicalInfoBoolean(form.getLocalContext().getIsAwaitingClinicalInfo());

			form.getGlobalContext().RefMan.setCatsReferral(form.getLocalContext().getCatsReferralWizzard());
			form.getGlobalContext().RefMan.setCatsReferralWizard(form.getLocalContext().getCatsReferralWizzard());

			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save(SaveMode.SAVE))
		{
			form.getGlobalContext().RefMan.setAwaitingClinicalInfo(form.getLocalContext().getAwaitingClinicalInfo());
			form.getGlobalContext().RefMan.setAwaitingClinicalInfoBoolean(form.getLocalContext().getIsAwaitingClinicalInfo());
			
			form.getGlobalContext().RefMan.setCatsReferral(form.getLocalContext().getCatsReferralWizzard());
			form.getGlobalContext().RefMan.setCatsReferralWizard(form.getLocalContext().getCatsReferralWizzard());

			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onDtimAwaitingInformationValueChanged() throws PresentationLogicException
	{
		updateControlsState();
	}

	@Override
	protected void onDyngrdClinINfoCellButtonClicked(DynamicGridCell cell)
	{
		if (cell.getColumn().equals(getColumn(COLAWAIT)))
		{
			if (cell.getValue().equals(form.getImages().Core.GrayStar))
			{
				cell.setValue(form.getImages().Core.Tick);

				DynamicGridCell otherCell = cell.getRow().getCells().get(getColumn(COLREC));
				otherCell.setValue(form.getImages().Core.GrayStar);

				// Reset all clinical information received date control
				form.dtimInformationReceived().setValue(null);
			}
			else
				cell.setValue(form.getImages().Core.GrayStar);
		}

		if (cell.getColumn().equals(getColumn(COLREC)))
		{
			if (cell.getValue().equals(form.getImages().Core.GrayStar))
			{
				cell.setValue(form.getImages().Core.Tick);

				DynamicGridCell otherCell = cell.getRow().getCells().get(getColumn(COLAWAIT));
				otherCell.setValue(form.getImages().Core.GrayStar);
			}
			else
				cell.setValue(form.getImages().Core.GrayStar);
		}
	}

	@Override
	protected void onFormClosing(CancelArgs args) throws PresentationLogicException
	{
		form.getGlobalContext().RefMan.setAwaitingClinicalInfo(form.getLocalContext().getAwaitingClinicalInfo());
		form.getGlobalContext().RefMan.setAwaitingClinicalInfoBoolean(form.getLocalContext().getIsAwaitingClinicalInfo());
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	// Form logic functions
	// ----------------------------------------------------------------------------------------------------------------------------------------------------

	private void initialize()
	{
		form.btnAllInformationReceived().setVisible(false);
		form.btnRemoveFromWaitingList().setVisible(false);

		initializeDynamicGrid();
	}

	private void initializeDynamicGrid()
	{
		// Clear dynamic grid
		form.dyngrdClinInfo().clear();

		form.dyngrdClinInfo().setSelectable(true);

		// Set dynamic grid columns
		initializeDynamicGridColumns();

		// Set dynamic grid lookup value
		initializeDynamicGridValues();
	}

	private void initializeDynamicGridColumns()
	{
		DynamicGridColumn cabType = form.dyngrdClinInfo().getColumns().newColumn("Clinical Info", COLTYPE);
		cabType.setWidth(300);
		cabType.setReadOnly(true);

		DynamicGridColumn recAwait = form.dyngrdClinInfo().getColumns().newColumn("Awaiting", COLAWAIT);
		recAwait.setWidth(60);
		recAwait.setAlignment(Alignment.CENTER);

		DynamicGridColumn colRecieve = form.dyngrdClinInfo().getColumns().newColumn("Received", COLREC);
		colRecieve.setWidth(-1);
		colRecieve.setAlignment(Alignment.CENTER);
	}

	private void initializeDynamicGridValues()
	{
		AwaitingClinicalInformationTypeCollection lkupInstancesCollection = LookupHelper.getAwaitingClinicalInformationType(domain.getLookupService());

		for (int i = 0; i < lkupInstancesCollection.size(); i++)
		{
			AwaitingClinicalInformationType lookupValue = lkupInstancesCollection.get(i);

			DynamicGridRow row = form.dyngrdClinInfo().getRows().newRow();

			DynamicGridCell cell = row.getCells().newCell(getColumn(COLTYPE), DynamicCellType.LABEL);
			cell.setValue(lookupValue.getText());
			cell.setIdentifier(lkupInstancesCollection.get(i));
			cell.setReadOnly(true);

			cell = row.getCells().newCell(getColumn(COLAWAIT), DynamicCellType.IMAGEBUTTON);
			cell.setValue(form.getImages().Core.GrayStar);
			cell.setAutoPostBack(true);

			cell = row.getCells().newCell(getColumn(COLREC), DynamicCellType.IMAGEBUTTON);
			cell.setValue(form.getImages().Core.GrayStar);
			cell.setAutoPostBack(true);

			row.setValue(lookupValue);
		}
	}

	private void open() throws PresentationLogicException
	{
		// Get current CATS Referral from domain into local context
		form.getLocalContext().setCatsReferralWizzard(domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral()));
		// WDEV-12835
		// Get full CATS Referral from domain - needed for appointments
		form.getLocalContext().setCatsReferralVo(domain.getCatsReferraFull(form.getGlobalContext().RefMan.getCatsReferral()));

		// Get AwaitingClinicalInfo from global context into local context
		form.getLocalContext().setAwaitingClinicalInfo(form.getGlobalContext().RefMan.getAwaitingClinicalInfo());
		// Get AwaitingClinicalInfoBoolean from global context into local context
		form.getLocalContext().setIsAwaitingClinicalInfo(form.getGlobalContext().RefMan.getAwaitingClinicalInfoBoolean());
		
		// If the CATS Referral is not null then check for a newer version of the AwaitingClinicalInfo
		if (form.getLocalContext().getCatsReferralWizzardIsNotNull())
		{
			AwaitingClinicalInfoVo clinicalInfo = form.getLocalContext().getCatsReferralWizzard().getAwaitingClinicalInfo();
			Boolean isAwaitingClinicalInfo = form.getLocalContext().getCatsReferralWizzard().getIsAwaitingClinicalInfo();
			
			if (clinicalInfo != null &&
					((form.getLocalContext().getAwaitingClinicalInfoIsNotNull() && clinicalInfo.getVersion_AwaitingClinicalInfo() >= form.getLocalContext().getAwaitingClinicalInfo().getVersion_AwaitingClinicalInfo())
						|| !form.getLocalContext().getAwaitingClinicalInfoIsNotNull()))
			{
				form.getLocalContext().setAwaitingClinicalInfo(clinicalInfo);
				form.getLocalContext().setIsAwaitingClinicalInfo(isAwaitingClinicalInfo);
			}
		}

		// Populate screen with AwaitingClinicalInformation record (if any)
		populateScreenFromData(form.getLocalContext().getAwaitingClinicalInfo());

		if (form.getGlobalContext().Core.getParentFormModeIsNotNull())
			form.setMode(form.getGlobalContext().Core.getParentFormMode());
		
		if (form.getLocalContext().getCatsReferralWizzardIsNotNull()
		    && form.getLocalContext().getCatsReferralWizzard().getAwaitingClinicalInfo() != null
			&& (form.getLocalContext().getCatsReferralWizzard().getIsAwaitingClinicalInfo() == null
			   || (form.getLocalContext().getCatsReferralWizzard().getIsAwaitingClinicalInfoIsNotNull()
					&& form.getLocalContext().getCatsReferralWizzard().getIsAwaitingClinicalInfo() == false ) )
			&& form.getLocalContext().getCatsReferralWizzard().getCurrentStatusIsNotNull() 
			&& (form.getLocalContext().getCatsReferralWizzard().getCurrentStatus().getReferralStatusIsNotNull()
				&& (form.getLocalContext().getCatsReferralWizzard().getCurrentStatus().getReferralStatus().equals(ReferralApptStatus.REFERRAL_CANCELLED_BY_PROVIDER)
				|| form.getLocalContext().getCatsReferralWizzard().getCurrentStatus().getReferralStatus().equals(ReferralApptStatus.CAB_CANCELLATION))
				|| form.getLocalContext().getCatsReferralWizzard().getCurrentStatus().getReferralStatus().equals(ReferralApptStatus.REFERRAL_REJECTED)))
				form.setMode(FormMode.VIEW);
			
			
	}

	private void populateScreenFromData(AwaitingClinicalInfoVo awaitingClinicalInfo)
	{
		clearScreen();

		if (awaitingClinicalInfo == null)
			return;

		// Populate date control for awaiting clinical information date
		form.dtimAwaitingInformation().setValue(awaitingClinicalInfo.getDateAwaitingClinicalInfo());

		// Populate dynamic grid data
		boolean checkAwaitingClinicalInfo = awaitingClinicalInfo.getClinicalInfoAwaitingIsNotNull();
		boolean checkReceivedClinicalInfo = awaitingClinicalInfo.getClinicalInfoReceivedIsNotNull();

		for (int i = 0; i < form.dyngrdClinInfo().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdClinInfo().getRows().get(i);

			if (row.getValue() == null)
				continue;

			if (checkAwaitingClinicalInfo && awaitingClinicalInfo.getClinicalInfoAwaiting().contains((AwaitingClinicalInformationType) row.getValue()))
				row.getCells().get(getColumn(COLAWAIT)).setValue(form.getImages().Core.Tick);

			if (checkReceivedClinicalInfo && awaitingClinicalInfo.getClinicalInfoReceived().contains((AwaitingClinicalInformationType) row.getValue()))
				row.getCells().get(getColumn(COLREC)).setValue(form.getImages().Core.Tick);
		}

		// Set other information text
		form.txtOther().setValue(awaitingClinicalInfo.getOtherClinicalInformation());

		// Populate date control for a all clinical information received
		form.dtimInformationReceived().setValue(awaitingClinicalInfo.getDateClinicalInfoReceived());
	}

	private void clearScreen()
	{
		form.dtimAwaitingInformation().setValue(new DateTime()); // A little cheating - this control should default to current date-time;
																 // If the AwaitingClinicalInfo is not null it will be replaced with the
																 // value that is recorded
		form.txtOther().setValue(null);
		form.dtimInformationReceived().setValue(null);

		for (int i = 0; i < form.dyngrdClinInfo().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdClinInfo().getRows().get(i);

			row.getCells().get(getColumn(COLAWAIT)).setValue(form.getImages().Core.GrayStar);
			row.getCells().get(getColumn(COLREC)).setValue(form.getImages().Core.GrayStar);
		}
	}

	private boolean save(SaveMode saveMode) throws PresentationLogicException
	{
		// Get data from screen
		// Pass a clone of the local context to the function to keep the original until saved
		AwaitingClinicalInfoVo clinicalInfo = null;
		if (form.getLocalContext().getAwaitingClinicalInfoIsNotNull())
		{
			clinicalInfo = populateDataFromScreen((AwaitingClinicalInfoVo) form.getLocalContext().getAwaitingClinicalInfo().clone(), saveMode);
		}
		else
		{
			clinicalInfo = populateDataFromScreen(null, saveMode);
		}

		// Call for validation
		String[] errors = validateUIRules();
		// Validate the VO for AwaitingClinicalInfo
		errors = clinicalInfo.validate(errors);

		// Check for validation errors
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		// Set local context for AwaitingClinicalInfo and IsAwaitingClinicalInfo
		form.getLocalContext().setAwaitingClinicalInfo(clinicalInfo);
		form.getLocalContext().setIsAwaitingClinicalInfo((clinicalInfo.getClinicalInfoAwaitingIsNotNull() && clinicalInfo.getClinicalInfoAwaiting().size() > 0)
			|| ((clinicalInfo.getOtherClinicalInformationIsNotNull() && clinicalInfo.getOtherClinicalInformation().length() > 0)
						&& !clinicalInfo.getDateClinicalInfoReceivedIsNotNull()));

		// Check if save is needed && attempt save if required
		if (form.getLocalContext().getCatsReferralWizzardIsNotNull())
		{
			try
			{
				// Create a reference to the local context of CatsReferralWizzard
				CatsReferralWizardVo catsReferral = form.getLocalContext().getCatsReferralWizzard();

				// Update AwaitingClinicalInfo data from what was read on screen
				catsReferral.setAwaitingClinicalInfo(clinicalInfo);

				// WDEV-12683
				// Update value for IsAwaitingClinicalInfo based on what was read on screen
				// If Clinical Info Awaiting records are present (grid from top of dialog checked as "Awaiting")
				// or the "Other Clinical Info" text is not null and "All Clinical Information Received" date is not present
				// then mark IsAwaitingClinicalInfo as TRUE
				// otherwise mark IsAwaitingClinicalInfo as FALSE
				if ((clinicalInfo.getClinicalInfoAwaitingIsNotNull() && clinicalInfo.getClinicalInfoAwaiting().size() > 0) 
						|| ((clinicalInfo.getOtherClinicalInformationIsNotNull() && clinicalInfo.getOtherClinicalInformation().length() > 0)
								&& !clinicalInfo.getDateClinicalInfoReceivedIsNotNull()))
				{
					catsReferral.setIsAwaitingClinicalInfo(Boolean.TRUE);
				}
				else 
				{
					// WDEV-12683 - Following the changes form WDEV-11850
					// NULL corresponds to "All Clinical Information Received" for "IsAwaitingClinicalInfo"
					catsReferral.setIsAwaitingClinicalInfo(null);
				}

				// WDEV-12055
				// If the "Remove from Worklist" button is pressed then
				// check if "All Clinical Information Received" date is completed.
				// If date value is present then set the "IsAwaitingClinicalInfo" to NULL - corresponding to "All Clinical Information Received" state
				// If date value is not present then set the "IsAwaitingClinicalInfo" to FALSE - corresponding to "Not all clinical information received,
				//																										but remove from worklist" sate
				if (saveMode.equals(SaveMode.REMOVE_FROM_LIST))
				{
					// WDEV-12835
					// If the date clinical information received is not null
					if (clinicalInfo.getDateClinicalInfoReceivedIsNotNull())
					{
						catsReferral.setIsAwaitingClinicalInfo(null);
					}
					else
					{
						catsReferral.setIsAwaitingClinicalInfo(Boolean.FALSE);
					}
				}


				if (saveMode.equals(SaveMode.SAVE_ALL_RECEIVED))
					catsReferral.setIsAwaitingClinicalInfo(null);
				
				errors = catsReferral.validate();
				if (errors != null && errors.length > 0)
				{
					engine.showErrors(errors);
					return false;
				}

				// Attempt save
				form.getLocalContext().setCatsReferralWizzard(domain.saveCatsReferral(catsReferral));
				
				// Update AwaitingClinicalInfo and IsAwaitingClinicalInfo
				form.getLocalContext().setAwaitingClinicalInfo(form.getLocalContext().getCatsReferralWizzard().getAwaitingClinicalInfo());
				form.getLocalContext().setIsAwaitingClinicalInfo(form.getLocalContext().getCatsReferralWizzard().getIsAwaitingClinicalInfo());
			}
			catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				e.printStackTrace();
				return false;
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				
				// TODO - Refresh Awaiting Information global context
				
				e.printStackTrace();
				open();
				return false;
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
				e.printStackTrace();
				return false;
			}
			catch (UniqueKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
				e.printStackTrace();
				return false;
			}
		}

		// In case of success return true
		// and the calling function will close the dialog
		return true;
	}

	/**
	 * WDEV-12835
	 * Function used to update controls state
	 * ATTENTION: Do not code controls state like: if (condition) button.setVisile(true)
	 * instead code like: buttons.setVisible(condition)
	 */
	private void updateControlsState()
	{
		form.btnCancel().setText(FormMode.EDIT.equals(form.getMode()) ? "Cancel" : "Close");

		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.dtimInformationReceived().setEnabled(form.dtimAwaitingInformation().getValue() != null);
		}
		
		// Check if the referral has arrived to an appointment (one appointment with arrival time filled in)
		boolean arrived = hasPatientArrivedForReferral();

		CatsReferralWizardVo referral = form.getLocalContext().getCatsReferralWizzard();
		
		form.btnAllInformationReceived().setVisible(referral != null && referral.getIsAwaitingClinicalInfoIsNotNull());
		form.btnAllInformationReceived().setText(referral != null && Boolean.TRUE.equals(referral.getIsAwaitingClinicalInfo()) && !arrived ?
															"All clinical information received and Remove from worklist" : "All clinical information received");
		
		form.btnRemoveFromWaitingList().setVisible(referral != null && Boolean.TRUE.equals(referral.getIsAwaitingClinicalInfo()) && !arrived);
	}

	private DynamicGridColumn getColumn(Integer identifier)
	{
		return form.dyngrdClinInfo().getColumns().getByIdentifier(identifier);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange functions
	// ----------------------------------------------------------------------------------------------------------------------------------------------------

	private AwaitingClinicalInfoVo populateDataFromScreen(AwaitingClinicalInfoVo clinicalInfo, SaveMode value)
	{
		// Check for previous data entered (if any);
		if (clinicalInfo == null)
		{
			clinicalInfo = new AwaitingClinicalInfoVo();
		}

		clinicalInfo.setClinicalInfoAwaiting(new AwaitingClinicalInformationTypeCollection());
		clinicalInfo.setClinicalInfoReceived(new AwaitingClinicalInformationTypeCollection());

		// Get AwaitingClinicalInformation from date
		clinicalInfo.setDateAwaitingClinicalInfo(form.dtimAwaitingInformation().getValue());

		// Get ClinicalInfo from dynamic grid
		for (int i = 0; i < form.dyngrdClinInfo().getRows().size(); i++)
		{
			// Create a reference to each row of the dynamic grid
			DynamicGridRow row = form.dyngrdClinInfo().getRows().get(i);

			if (form.getImages().Core.Tick.equals(row.getCells().get(getColumn(COLAWAIT)).getValue()))
			{
				if (SaveMode.SAVE_ALL_RECEIVED.equals(value) || form.dtimInformationReceived().getValue() != null)
				{
					clinicalInfo.getClinicalInfoReceived().add((AwaitingClinicalInformationType) row.getCells().get(getColumn(COLTYPE)).getIdentifier());
					clinicalInfo.getClinicalInfoAwaiting().remove((AwaitingClinicalInformationType) row.getCells().get(getColumn(COLTYPE)).getIdentifier());
				}
				else
				{
					clinicalInfo.getClinicalInfoAwaiting().add((AwaitingClinicalInformationType) row.getCells().get(getColumn(COLTYPE)).getIdentifier());
				}
			}

			if (form.getImages().Core.Tick.equals(row.getCells().get(getColumn(COLREC)).getValue()))
			{
				clinicalInfo.getClinicalInfoReceived().add((AwaitingClinicalInformationType) row.getCells().get(getColumn(COLTYPE)).getIdentifier());
			}
		}

		// Get Other Clinical Info text
		clinicalInfo.setOtherClinicalInformation(form.txtOther().getValue());

		// Get All Clinical Information Received on date
		clinicalInfo.setDateClinicalInfoReceived(form.dtimInformationReceived().getValue());

		if (SaveMode.SAVE_ALL_RECEIVED.equals(value) || ((!clinicalInfo.getClinicalInfoAwaitingIsNotNull() || clinicalInfo.getClinicalInfoAwaiting().size() == 0) && !clinicalInfo.getClinicalInfoReceivedIsNotNull()))
		{
			if (!clinicalInfo.getDateClinicalInfoReceivedIsNotNull())
				clinicalInfo.setDateClinicalInfoReceived(new DateTime());
		}

		// Return values from screen
		return clinicalInfo;
	}

	private String[] validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.dtimAwaitingInformation().getValue() != null && form.dtimAwaitingInformation().getValue().isGreaterThan(new DateTime()))
		{
			listOfErrors.add("Awaiting Clinical Information date cannot be set into the future");
		}

		if (form.dtimInformationReceived().getValue() != null && form.dtimInformationReceived().getValue().isGreaterThan(new DateTime()))
		{
			listOfErrors.add("All Clinical Information Received date cannot be set into the future");
		}
		if (form.dtimAwaitingInformation().getValue() != null && form.dtimInformationReceived().getValue() != null && 
			(form.dtimAwaitingInformation().getValue().getDate().isGreaterThan(form.dtimInformationReceived().getValue().getDate()) ||
			(form.dtimAwaitingInformation().getValue().getDate().equals(form.dtimInformationReceived().getValue().getDate()) 
			&& form.dtimAwaitingInformation().getValue().getTime().isGreaterThan(form.dtimInformationReceived().getValue().getTime()))))
		{
			listOfErrors.add("All Clinical Information Received date cannot be set before Awaiting Clinical Information date");
		}
		
		// Validate if there is something to save
		boolean okToSave = false;
		
		for (int i = 0 ; i < form.dyngrdClinInfo().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdClinInfo().getRows().get(i);
			
			if (form.getImages().Core.Tick.equals(row.getCells().get(getColumn(COLAWAIT)).getValue()))
				okToSave = true;
			
			if (form.getImages().Core.Tick.equals(row.getCells().get(getColumn(COLREC)).getValue()))
				okToSave = true;
		}
		
		if (form.txtOther().getValue() != null)
			okToSave = true;
		
		if (!okToSave)
		{
			listOfErrors.add("Nothing to save.");
		}
		
		int errorCount = listOfErrors.size();

		if (errorCount == 0)
			return null;

		String[] errors = new String[errorCount];

		for (int i = 0; i < errorCount; i++)
		{
			errors[i] = listOfErrors.get(i);
		}

		return errors;
	}

	/**
	 * WDEV-12835
	 * Function used to determine if the patient has arrived for this referral.
	 * If at least one appointment has the ArrivalTime field filled in then the patient is considered arrived for this referral
	 * @return TODO
	 */
	private boolean hasPatientArrivedForReferral()
	{
		if (form.getLocalContext().getCatsReferralVoIsNotNull() && form.getLocalContext().getCatsReferralVo().getAppointmentsIsNotNull())
		{
			for (int i = 0; i < form.getLocalContext().getCatsReferralVo().getAppointments().size(); i++)
			{
				if (form.getLocalContext().getCatsReferralVo().getAppointments().get(i).getArrivalTimeIsNotNull())
					
					// An appointment with ArrivatTime field filled in found
					return true;
			}
		}
		
		return false;
	}
}
