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

package ims.assessment.forms.findingquestions;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
		Core = new CoreContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedImageIsNotNull()
		{
			return !cx_AdminSelectedImage.getValueIsNull(context);
		}
		public ims.admin.vo.AppImageVo getSelectedImage()
		{
			return (ims.admin.vo.AppImageVo)cx_AdminSelectedImage.getValue(context);
		}
		public void setSelectedImage(ims.admin.vo.AppImageVo value)
		{
			cx_AdminSelectedImage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedImage = new ims.framework.ContextVariable("Admin.SelectedImage", "_cv_Admin.SelectedImage");
		public boolean getSelectedQuestionsIsNotNull()
		{
			return !cx_AdminSelectedQuestions.getValueIsNull(context);
		}
		public ims.core.vo.QuestionInformationShortVoCollection getSelectedQuestions()
		{
			return (ims.core.vo.QuestionInformationShortVoCollection)cx_AdminSelectedQuestions.getValue(context);
		}
		public void setSelectedQuestions(ims.core.vo.QuestionInformationShortVoCollection value)
		{
			cx_AdminSelectedQuestions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedQuestions = new ims.framework.ContextVariable("Admin.SelectedQuestions", "_cv_Admin.SelectedQuestions");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedDrawingGraphicFindingVoIsNotNull()
		{
			return !cx_CoreSelectedDrawingGraphicFindingVo.getValueIsNull(context);
		}
		public ims.core.vo.DrawingGraphicFindingVo getSelectedDrawingGraphicFindingVo()
		{
			return (ims.core.vo.DrawingGraphicFindingVo)cx_CoreSelectedDrawingGraphicFindingVo.getValue(context);
		}
		public void setSelectedDrawingGraphicFindingVo(ims.core.vo.DrawingGraphicFindingVo value)
		{
			cx_CoreSelectedDrawingGraphicFindingVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedDrawingGraphicFindingVo = new ims.framework.ContextVariable("Core.SelectedDrawingGraphicFindingVo", "_cv_Core.SelectedDrawingGraphicFindingVo");
		public boolean getQuestionTypeIsNotNull()
		{
			return !cx_CoreQuestionType.getValueIsNull(context);
		}
		public ims.core.vo.lookups.QuestionType getQuestionType()
		{
			return (ims.core.vo.lookups.QuestionType)cx_CoreQuestionType.getValue(context);
		}
		public void setQuestionType(ims.core.vo.lookups.QuestionType value)
		{
			cx_CoreQuestionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreQuestionType = new ims.framework.ContextVariable("Core.QuestionType", "_cv_Core.QuestionType");
		public boolean getQuestionFormModeIsNotNull()
		{
			return !cx_CoreQuestionFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getQuestionFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreQuestionFormMode.getValue(context);
		}
		public void setQuestionFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_CoreQuestionFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreQuestionFormMode = new ims.framework.ContextVariable("Core.QuestionFormMode", "_cv_Core.QuestionFormMode");
		public boolean getSelectedQuestionIsNotNull()
		{
			return !cx_CoreSelectedQuestion.getValueIsNull(context);
		}
		public ims.core.vo.QuestionInformationShortVo getSelectedQuestion()
		{
			return (ims.core.vo.QuestionInformationShortVo)cx_CoreSelectedQuestion.getValue(context);
		}
		public void setSelectedQuestion(ims.core.vo.QuestionInformationShortVo value)
		{
			cx_CoreSelectedQuestion.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedQuestion = new ims.framework.ContextVariable("Core.SelectedQuestion", "_cv_Core.SelectedQuestion");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
	public CoreContext Core;
}
