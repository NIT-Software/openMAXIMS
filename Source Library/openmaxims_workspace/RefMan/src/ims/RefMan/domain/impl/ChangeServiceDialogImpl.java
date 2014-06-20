// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.65 build 3169.24390)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.RefMan.domain.ReferralDetailsComponent;
import ims.RefMan.domain.base.impl.BaseChangeServiceDialogImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.ChangeOfService;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.CatsReferralVo;
import ims.RefMan.vo.ChangeOfServiceVo;
import ims.RefMan.vo.ReferralServiceFullVo;
import ims.RefMan.vo.domain.CatsReferralListVoAssembler;
import ims.RefMan.vo.domain.CatsReferralVoAssembler;
import ims.RefMan.vo.domain.ChangeOfServiceVoAssembler;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

public class ChangeServiceDialogImpl extends BaseChangeServiceDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ReferralServiceFullVo getReferralServices() 
	{
		ReferralDetailsComponent doServices = (ReferralDetailsComponent)getDomainImpl(ReferralDetailsComponentImpl.class);
		return doServices.getReferralServices();
	}

	public void saveChangeOfServiceVo(ChangeOfServiceVo voCOS) throws DomainInterfaceException, StaleObjectException 
	{
		if(voCOS == null)
			throw new DomainRuntimeException("Invalid ChangeOfServiceVo to save");
		if(!voCOS.isValidated())
			throw new DomainRuntimeException("Record not validated before save");

		DomainFactory factory = getDomainFactory();
		ChangeOfService doCOS = ChangeOfServiceVoAssembler.extractChangeOfService(factory, voCOS);		
		factory.save(doCOS);
		
		CatsReferralVo voCats = CatsReferralVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCOS.getCatsReferral().getID_CatsReferral()));
		voCats.getReferralDetails().setService(voCOS.getNewService());
		CatsReferral doCats = CatsReferralVoAssembler.extractCatsReferral(factory, voCats);		
		factory.save(doCats);
	}

	public MemberOfStaffShortVoCollection listMembersOfStaff(MemberOfStaffShortVo filter) 
	{
       MosAdmin mosAdminIml = (MosAdmin)getDomainImpl(MosAdminImpl.class);
       return mosAdminIml.listMembersOfStaff(filter);
	}

}
