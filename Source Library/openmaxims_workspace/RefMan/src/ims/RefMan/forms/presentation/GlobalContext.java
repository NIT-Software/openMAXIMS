// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.presentation;

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

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");
		public boolean getIsProviderCancellationIsNotNull()
		{
			return !cx_RefManIsProviderCancellation.getValueIsNull(context);
		}
		public Boolean getIsProviderCancellation()
		{
			return (Boolean)cx_RefManIsProviderCancellation.getValue(context);
		}
		public void setIsProviderCancellation(Boolean value)
		{
			cx_RefManIsProviderCancellation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsProviderCancellation = new ims.framework.ContextVariable("RefMan.IsProviderCancellation", "_cvp_RefMan.IsProviderCancellation");

		private ims.framework.Context context;
	}
	public boolean getPresentationReferalSummaryChangedIsNotNull()
	{
		return !cx_PresentationReferalSummaryChanged.getValueIsNull(context);
	}
	public Boolean getPresentationReferalSummaryChanged()
	{
		return (Boolean)cx_PresentationReferalSummaryChanged.getValue(context);
	}
		public void setPresentationReferalSummaryChanged(Boolean value)
		{
		cx_PresentationReferalSummaryChanged.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PresentationReferalSummaryChanged = new ims.framework.ContextVariable("PresentationReferalSummaryChanged", "_cv_PresentationReferalSummaryChanged");
	public boolean getsavedPresentationReferralSummaryIsNotNull()
	{
		return !cx_savedPresentationReferralSummary.getValueIsNull(context);
	}
	public ims.RefMan.vo.PresentationReferralSummaryVo getsavedPresentationReferralSummary()
	{
		return (ims.RefMan.vo.PresentationReferralSummaryVo)cx_savedPresentationReferralSummary.getValue(context);
	}
		public void setsavedPresentationReferralSummary(ims.RefMan.vo.PresentationReferralSummaryVo value)
		{
		cx_savedPresentationReferralSummary.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_savedPresentationReferralSummary = new ims.framework.ContextVariable("savedPresentationReferralSummary", "_cv_savedPresentationReferralSummary");

	public RefManContext RefMan;
}
