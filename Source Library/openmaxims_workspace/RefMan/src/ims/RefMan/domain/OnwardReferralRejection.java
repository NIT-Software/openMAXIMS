// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface OnwardReferralRejection extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.ReferralOutcomeVo getReferralOutcome(ims.RefMan.vo.CatsReferralRefVo voCATSRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.ReferralOutcomeVo saveCurrentOnwardReferral(ims.RefMan.vo.ReferralOutcomeVo referralOutcome) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo saveCatsReferral(ims.RefMan.vo.CatsReferralWizardVo catsReferral) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;
}