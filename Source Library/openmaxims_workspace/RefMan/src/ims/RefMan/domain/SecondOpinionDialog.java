// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface SecondOpinionDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.MemberOfStaffVo getMemberOfStaff(ims.core.vo.MemberOfStaffShortVo mos);

	// Generated from form domain interface definition
	/**
	* Returns a HcpLiteVo
	*/
	public ims.core.vo.HcpLiteVo getHcpLiteById(ims.core.resource.people.vo.HcpRefVo refId);
}
