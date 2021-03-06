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

package ims.RefMan.forms.allocatetasksdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReferralStatusListFilterIsNotNull()
		{
			return !cx_RefManReferralStatusListFilter.getValueIsNull(context);
		}
		public ims.RefMan.vo.CATSReferralFilterVo getReferralStatusListFilter()
		{
			return (ims.RefMan.vo.CATSReferralFilterVo)cx_RefManReferralStatusListFilter.getValue(context);
		}
		public void setReferralStatusListFilter(ims.RefMan.vo.CATSReferralFilterVo value)
		{
			cx_RefManReferralStatusListFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralStatusListFilter = new ims.framework.ContextVariable("RefMan.ReferralStatusListFilter", "_cvp_RefMan.ReferralStatusListFilter");
		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_RefManReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_RefManReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_RefManReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralContractTypeForPatient = new ims.framework.ContextVariable("RefMan.ReferralContractTypeForPatient", "_cvp_RefMan.ReferralContractTypeForPatient");
		public boolean getDiagnosticReferralForApplicationIsNotNull()
		{
			return !cx_RefManDiagnosticReferralForApplication.getValueIsNull(context);
		}
		public Boolean getDiagnosticReferralForApplication()
		{
			return (Boolean)cx_RefManDiagnosticReferralForApplication.getValue(context);
		}
		public void setDiagnosticReferralForApplication(Boolean value)
		{
			cx_RefManDiagnosticReferralForApplication.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManDiagnosticReferralForApplication = new ims.framework.ContextVariable("RefMan.DiagnosticReferralForApplication", "_cvp_RefMan.DiagnosticReferralForApplication");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
