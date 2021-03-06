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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.42 build 2196.26417)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.balanceactivities;

import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.therapies.vo.BalanceActivitiesVo;
import ims.therapies.vo.BalanceActivitiesVoCollection;
import ims.therapies.vo.lookups.BalanceActivities;
import ims.therapies.vo.lookups.BalanceActivitiesCollection;
import ims.therapies.vo.lookups.LookupHelper;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	private void open()
	{
		form.setMode(FormMode.VIEW);
		
		fillRecordBrowser(domain.getBalanceActivitiesByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
		
	}
	private void fillRecordBrowser(BalanceActivitiesVoCollection voBalanceActivitiesColl)
	{
		form.recbrBalance().clear();
		boolean selectedClinicalContactFound = false;
		CareContextShortVo voSelectedCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		form.recbrBalance().newRow(voSelectedCareContext, voSelectedCareContext.getRecordBrowserText());
		
		if(voBalanceActivitiesColl != null)
		{
			for(int i=0; i<voBalanceActivitiesColl.size(); i++)
			{
				ClinicalContactShortVo voClinicalContact = voBalanceActivitiesColl.get(i).getClinicalContact();
				if(voSelectedClinicalContact != null && voClinicalContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
				{
					selectedClinicalContactFound = true;
					form.recbrBalance().newRow(voClinicalContact, "\t\t\t\tClinical Contact: " + voClinicalContact.getStartDateTime().toString() + " - " + voClinicalContact.getSeenBy().toString(), Color.Green);
					form.recbrBalance().setValue(voClinicalContact);
				}
				else
				{
					form.recbrBalance().newRow(voClinicalContact, "\t\t\t\tClinical Contact: " + voClinicalContact.getStartDateTime().toString() + " - " + voClinicalContact.getSeenBy().toString());
				}
			}
		}
		
		if(!selectedClinicalContactFound && voSelectedClinicalContact != null)
		{
			form.recbrBalance().newRow(voSelectedClinicalContact, "\t\t\t\tClinical Contact: " + voSelectedClinicalContact.getStartDateTime().toString() + " - " + voSelectedClinicalContact.getSeenBy().toString(), Color.Green);
			form.recbrBalance().setValue(voSelectedClinicalContact);
		}
		browseRecord();
		
		
	}
	private void isRecordEditable()
	{		
		boolean isEditable = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			if(form.recbrBalance().getValue() instanceof ClinicalContactShortVo)
			{
				ClinicalContactShortVo voContact = (ClinicalContactShortVo) form.recbrBalance().getValue();
				if(voContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
					isEditable = true;
			}
		}
		
		form.btnNew().setVisible(isEditable);
		form.btnUpdate().setVisible(isEditable);
		
		if(isEditable)
		{
			if(form.getLocalContext().getvoBalanceActIsNotNull())
			{
				form.btnNew().setVisible(false);
				form.btnUpdate().setEnabled(true);
				form.btnUpdate().setVisible(true);
			}
			else
			{
				form.btnNew().setEnabled(true);
				form.btnNew().setVisible(true);
				form.btnUpdate().setVisible(false);
			}
		}
	}
	private void browseRecord()
	{
		clearInstanceControls();
		prePopulateActivities();
		updateBrowseInformation();
		
		if(form.recbrBalance().getValue() instanceof ClinicalContactShortVo)
		{
			ClinicalContactShortVo voClinicalContact = (ClinicalContactShortVo) form.recbrBalance().getValue();
			form.getLocalContext().setvoBalanceAct(domain.getBalanceActivitiesByClinicalContact(voClinicalContact));
			populateScreen();
		}
		isRecordEditable();
	}
	private void clearInstanceControls()
	{
		form.qmbAuthoring().clear();
		form.dtimAuthoring().setValue(null);
		form.txtDetails().setValue(null);
		form.gridActivities().getRows().clear();
	}
	private void updateBrowseInformation()
	{
		form.lblBrowserStatus().setValue(form.recbrBalance().getRecordState("Assessment", "Assessments"));
	}
	private void prePopulateActivities()
	{
		form.gridActivities().populateTree(LookupHelper.getBalanceActivities(domain.getLookupService()));
		form.gridActivities().expandAll();
	}
	private void populateScreen()
	{
		BalanceActivitiesVo voBalance = form.getLocalContext().getvoBalanceAct();
		
		if(voBalance != null)
		{
			form.dtimAuthoring().setValue(voBalance.getAuthoringDateTime());
			form.qmbAuthoring().newRow(voBalance.getAuthoringHCP(), voBalance.getAuthoringHCP().toString());
			form.qmbAuthoring().setValue(voBalance.getAuthoringHCP());
			form.txtDetails().setValue(voBalance.getDetails());
			if(voBalance.getBalanceActivitiesIsNotNull())
				populateActivitiesGrid(voBalance.getBalanceActivities());
		}
	}
		
	void populateActivitiesGrid(BalanceActivitiesCollection balActivitiesColl)
	{		
			BalanceActivitiesCollection coll = balActivitiesColl;
			BalanceActivitiesCollection collInactive = new BalanceActivitiesCollection();
			GenForm.gridActivitiesRow row = null;
			for(int i=0;i<coll.size();i++)
			{
				int r=0;
				for (r=0; r<form.gridActivities().getAllRows().length; r++)
				{
					row = form.gridActivities().getAllRows()[r];
					if(coll.get(i).equals(row.getColActivities()))
					{
						row.setValue(coll.get(i));
						row.setColActivities(coll.get(i));
						row.setColSelected(true);
						break;
					}
				}
				if(r == form.gridActivities().getAllRows().length)
				{
					collInactive.add(coll.get(i));
				}
			}
				
			//inactive record handling
			boolean inactiveParentAndChild = true;
			BalanceActivities bal = null;
			BalanceActivities balParent = null;
			for(int i=0;i<collInactive.size();i++)
			{
				bal = collInactive.get(i);
				balParent = bal.getParent();
				if(balParent != null)
				{
					GenForm.gridActivitiesRow rowChild = null;
					int j=0;
					for(j=0;j<form.gridActivities().getRows().size();j++)
					{
						row = form.gridActivities().getRows().get(j);
						if(row.getColActivities().equals(balParent))
						{
							rowChild = row.getRows().newRow();
							rowChild.setValue(bal);
							rowChild.setColActivities(bal);
							rowChild.setColSelected(true);
							inactiveParentAndChild = false;
							break;
						}
					}
					if(inactiveParentAndChild == true)
						displayInactiveParentAndChild(bal);
					
					if(j == form.gridActivities().getAllRows().length)
					{
						row = row.getRows().newRow();
						row.setValue(bal);
						row.setColActivities(bal);
						row.setColSelected(true);
					}
					
				}
				else
				{
					//display inactive parent
					row = form.gridActivities().getRows().newRow();
					row.setValue(bal);
					row.setColActivities(bal);
					row.setColSelected(true);			
				}
			}	
		
	}
	
	private void displayInactiveParentAndChild(BalanceActivities item)
	{
		GenForm.gridActivitiesRow row = form.gridActivities().getRows().newRow();
		row.setValue(item.getParent());
		row.setColActivities(item.getParent());
		row.setExpanded(true);
		
		GenForm.gridActivitiesRow rowChild = row.getRows().newRow();
		rowChild.setColActivities(item);
		rowChild.setColSelected(true);
		
	}
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnNew().setVisible(false);
		form.btnUpdate().setVisible(false);
		form.dtimAuthoring().setValue(new DateTime());
		loadHcps();
	}
	private void loadHcps()
	{
		form.qmbAuthoring().setValue(null);

		Hcp hcp = (Hcp) domain.getHcpUser();
		if(hcp != null)
		{
			form.qmbAuthoring().newRow(hcp, hcp.toString());
			form.qmbAuthoring().setValue(hcp);
		}
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		form.dtimAuthoring().setValue(null);
		form.qmbAuthoring().setValue(null);
		open();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		BalanceActivitiesVo voAct = null;
		if(form.getLocalContext().getvoBalanceActIsNotNull())
			voAct = form.getLocalContext().getvoBalanceAct();
		else
			voAct = new BalanceActivitiesVo();
		voAct.setAuthoringDateTime(form.dtimAuthoring().getValue());
		voAct.setAuthoringHCP(form.qmbAuthoring().getValue());
		voAct.setDetails(form.txtDetails().getValue());
		if(form.getGlobalContext().Core.getCurrentClinicalContact()!= null)
			voAct.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		voAct.setBalanceActivities(populateBalActivitiesFromGrd());
		
		String[] errors = voAct.validate();
		if (errors != null)
		{
			engine.showErrors("Validation Errors", errors);
			return;
		}
		try
		{
			domain.saveBalanceActivities(voAct);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Balance Activity record already exists. " + e.getMessage());
			open();
			return;
		}
		open();
	}
	private BalanceActivitiesCollection populateBalActivitiesFromGrd()
	{
		BalanceActivitiesCollection balColl = new BalanceActivitiesCollection();
		for (int i = 0; i < form.gridActivities().getRows().size(); i++)
		{
			GenForm.gridActivitiesRow rowPar = form.gridActivities().getRows().get(i);
			if(rowPar.getColSelected())
				balColl.add(rowPar.getValue());
	
			for(int x=0; x<form.gridActivities().getRows().get(i).getRows().size(); x++)
			{
				GenForm.gridActivitiesRow rowAct = form.gridActivities().getRows().get(i).getRows().get(x);
				if(rowAct.getColSelected())
					balColl.add(rowAct.getValue());
			}
		}
		return balColl;	
		
	}
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnNew().setVisible(false);
		form.btnUpdate().setVisible(false);
	}
	protected void onQmbAuthoringTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbAuthoring().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbAuthoring().newRow(med, med.toString());			
		}
		
		if (coll.size() == 1)
			form.qmbAuthoring().setValue(coll.get(0));
		else if (coll.size() > 1)
			form.qmbAuthoring().showOpened();	
		
	}
	protected void onRecbrBalanceValueChanged() throws PresentationLogicException 
	{
		browseRecord();
	}
}
