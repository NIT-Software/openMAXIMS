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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.25 build 1941.21062)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.reports;

import ims.admin.vo.ReportSeedVo;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportVo;
import ims.admin.vo.ReportVoCollection;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}

	protected void onBtnBuildClick() throws ims.framework.exceptions.PresentationLogicException
	{
		TreeNode node = form.treTemplate().getSelectedNode();

		if (node == null || node.getParent() == null)
		{
			engine.showMessage("Please select at template !");
			return;
		}

		form.getGlobalContext().Core.setCurrentFormName(engine.getPreviousNonDialogFormName());

		form.getGlobalContext().Core.setReportID(((ReportVo) node.getParent().getValue()).getID_ReportBo());
		form.getGlobalContext().Core.setTemplateID(((ReportTemplateVo) node.getValue()).getID_TemplateBo());

		if (form.getGlobalContext().Core.getAutoOpenViewReportIsNotNull() && form.getGlobalContext().Core.getAutoOpenViewReport().equals(Boolean.TRUE))
			engine.open(form.getForms().Core.ViewReport);

		engine.close(DialogResult.OK);
	}

	private void open()
	{
		int id = 0;
		
		if(engine.getParentDialogFormName() != null)
			id = engine.getParentDialogFormName().getID();
		else
			id = engine.getPreviousNonDialogFormName().getID();
		
		ReportVoCollection coll = domain.listAssignedReports(new Integer(id));
		ims.framework.controls.TreeNode lastTemplate = null;
		int nTemplateCount = 0;

		for (int i = 0; i < coll.size(); i++)
		{
			ReportVo rep = coll.get(i);

			if(canBeSeeded(rep))
			{
				ims.framework.controls.TreeNode node = form.treTemplate().getNodes().add(rep, rep.getReportName());
				node.setExpanded(true);
				node.setExpandedImage(form.getImages().Core.Report);
				node.setCollapsedImage(form.getImages().Core.Report);

				if (rep.getTemplatesIsNotNull())
				{
					for (int j = 0; j < rep.getTemplates().size(); j++)
					{
						ims.framework.controls.TreeNode child = node.getNodes().add(rep.getTemplates().get(j), rep.getTemplates().get(j).getName());
						child.setExpandedImage(form.getImages().Core.ReportTemplate);
						child.setCollapsedImage(form.getImages().Core.ReportTemplate);
	
						lastTemplate = child;
						nTemplateCount++;
					}
				}
			}
		}

		if (nTemplateCount == 1)
		{
			form.treTemplate().setValue(lastTemplate.getValue());
			try
			{
				onBtnBuildClick();
			}
			catch (PresentationLogicException e)
			{
				engine.showMessage("Error selecting the template: " + e.toString());
			}
		}
	}
	
	private boolean canBeSeeded(ReportVo report)
	{
		//reports without seeds can always be printed
		if(!report.getSeedsIsNotNull())
			return true;
		
		if(report.getSeeds().size() == 0)
			return true;

		ReportSeedVo voReportSeed = new ReportSeedVo();
		
		return engine.formHasData(engine.getPreviousNonDialogFormName(), voReportSeed.getIseeds(report.getSeeds()));
	}
	
}
