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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.oncology.forms.histopathologyreport;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Oncology = new OncologyContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getGraphicAssessmentsSelectableIsNotNull()
		{
			return !cx_CoreGraphicAssessmentsSelectable.getValueIsNull(context);
		}
		public Boolean getGraphicAssessmentsSelectable()
		{
			return (Boolean)cx_CoreGraphicAssessmentsSelectable.getValue(context);
		}
		public void setGraphicAssessmentsSelectable(Boolean value)
		{
			cx_CoreGraphicAssessmentsSelectable.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGraphicAssessmentsSelectable = new ims.framework.ContextVariable("Core.GraphicAssessmentsSelectable", "_cv_Core.GraphicAssessmentsSelectable");
		public boolean getStructuredAssessmentsSelectableIsNotNull()
		{
			return !cx_CoreStructuredAssessmentsSelectable.getValueIsNull(context);
		}
		public Boolean getStructuredAssessmentsSelectable()
		{
			return (Boolean)cx_CoreStructuredAssessmentsSelectable.getValue(context);
		}
		public void setStructuredAssessmentsSelectable(Boolean value)
		{
			cx_CoreStructuredAssessmentsSelectable.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreStructuredAssessmentsSelectable = new ims.framework.ContextVariable("Core.StructuredAssessmentsSelectable", "_cv_Core.StructuredAssessmentsSelectable");
		public boolean getSelectedUserAssessmentVoIsNotNull()
		{
			return !cx_CoreSelectedUserAssessmentVo.getValueIsNull(context);
		}
		public ims.assessment.vo.UserAssessmentVo getSelectedUserAssessmentVo()
		{
			return (ims.assessment.vo.UserAssessmentVo)cx_CoreSelectedUserAssessmentVo.getValue(context);
		}
		public void setSelectedUserAssessmentVo(ims.assessment.vo.UserAssessmentVo value)
		{
			cx_CoreSelectedUserAssessmentVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedUserAssessmentVo = new ims.framework.ContextVariable("Core.SelectedUserAssessmentVo", "_cv_Core.SelectedUserAssessmentVo");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedPrimaryTumourDetailIsNotNull()
		{
			return !cx_OncologySelectedPrimaryTumourDetail.getValueIsNull(context);
		}
		public ims.oncology.vo.PrimaryTumourDetailsShortVo getSelectedPrimaryTumourDetail()
		{
			return (ims.oncology.vo.PrimaryTumourDetailsShortVo)cx_OncologySelectedPrimaryTumourDetail.getValue(context);
		}
		public void setSelectedPrimaryTumourDetail(ims.oncology.vo.PrimaryTumourDetailsShortVo value)
		{
			cx_OncologySelectedPrimaryTumourDetail.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologySelectedPrimaryTumourDetail = new ims.framework.ContextVariable("Oncology.SelectedPrimaryTumourDetail", "_cv_Oncology.SelectedPrimaryTumourDetail");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public OncologyContext Oncology;
}
