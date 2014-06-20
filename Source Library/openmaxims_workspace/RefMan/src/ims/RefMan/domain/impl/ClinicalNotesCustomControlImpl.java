// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ReferralWizard;
import ims.RefMan.domain.base.impl.BaseClinicalNotesCustomControlImpl;
import ims.RefMan.domain.objects.AppointmentClinicalNotes;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientDiagnosisApptDetail;
import ims.RefMan.domain.objects.PatientProcedureApptDetail;
import ims.RefMan.domain.objects.ReferralClinicalNotes;
import ims.RefMan.vo.AppointmentClinicalNotesRefVo;
import ims.RefMan.vo.AppointmentClinicalNotesVo;
import ims.RefMan.vo.BookingAppointmentForClinicalNotesVoCollection;
import ims.RefMan.vo.CatsReferralForClinicalNotesVo;
import ims.RefMan.vo.CatsReferralForClinicalNotesVoCollection;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.PatientDiagnosisApptDetailVo;
import ims.RefMan.vo.PatientProcedureApptDetailVo;
import ims.RefMan.vo.ReferralClinicalNotesVo;
import ims.RefMan.vo.ReportsRequiredForPrintingVoCollection;
import ims.RefMan.vo.domain.AppointmentClinicalNotesVoAssembler;
import ims.RefMan.vo.domain.BookingAppointmentForClinicalNotesVoAssembler;
import ims.RefMan.vo.domain.CatsReferralForClinicalNotesVoAssembler;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.domain.PatientDiagnosisApptDetailVoAssembler;
import ims.RefMan.vo.domain.PatientProcedureApptDetailVoAssembler;
import ims.RefMan.vo.domain.ReferralClinicalNotesVoAssembler;
import ims.RefMan.vo.lookups.ReportNoteType;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientDocumentLiteVoCollection;
import ims.core.vo.domain.PatientDocumentLiteVoAssembler;
import ims.core.vo.lookups.DocumentCategory;
import ims.domain.DomainFactory;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.ValueObject;

import java.util.List;

public class ClinicalNotesCustomControlImpl extends BaseClinicalNotesCustomControlImpl
{
	private static final long serialVersionUID = 1L;

	public BookingAppointmentForClinicalNotesVoCollection listAppointments(CatsReferralRefVo referral)
	{
		if(referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Cannot list appointments for a null Referral Id.");
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select b from CatsReferral as cats left join cats.appointments as b where cats.id = :ReferralId and b.isRIE is null and b.apptStatus.id in (:ArrivedStatus, :SeenStatus) and b.theatreBooking is null order by b.appointmentDate desc";
		List<?> list = factory.find(query, new String[] {"ReferralId", "ArrivedStatus", "SeenStatus"}, new Object[] {referral.getID_CatsReferral(), new Integer(Status_Reason.ARRIVAL.getID()), new Integer(Status_Reason.SEEN.getID())});
		
		return BookingAppointmentForClinicalNotesVoAssembler.createBookingAppointmentForClinicalNotesVoCollectionFromBooking_Appointment(list); 
	}

	public ReferralClinicalNotesVo getReferralClinicalNotes(CatsReferralRefVo referral)
	{
		if(referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Cannot get ReferralClinicalNote for a null Referral Id.");
		
		DomainFactory factory = getDomainFactory();
		
		String query = "from ReferralClinicalNotes as r where r.catsReferral.id = :ReferralId";
		List<?> doReferralClinicalNotes = factory.find(query, new String[] {"ReferralId"}, new Object[] {referral.getID_CatsReferral()});
		
		if(doReferralClinicalNotes == null || doReferralClinicalNotes.size() == 0)
			return null;
		
		return ReferralClinicalNotesVoAssembler.create((ReferralClinicalNotes) doReferralClinicalNotes.get(0));
	}

	public Boolean saveReferralClinicalNotes(ReferralClinicalNotesVo referralClinicalNotes) throws StaleObjectException
	{
		if(referralClinicalNotes == null)
			throw new CodingRuntimeException("Cannot save a null ReferralClinicalNotesVo.");
		
		if(!referralClinicalNotes.isValidated())
			throw new CodingRuntimeException("ReferralClinicalNotesVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		ReferralClinicalNotes doReferralClinicalNote = ReferralClinicalNotesVoAssembler.extractReferralClinicalNotes(factory, referralClinicalNotes);
		
		factory.save(doReferralClinicalNote);
		
		return true;
	}

	public CatsReferralForClinicalNotesVo getReferral(CatsReferralRefVo referral)
	{
		if(referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Cannot get CatsReferral on null Referral Id.");
		
		return CatsReferralForClinicalNotesVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, referral.getID_CatsReferral()));
	}

	public CatsReferralForClinicalNotesVoCollection getPreviousReferrals(CatsReferralRefVo currentReferral, PatientRefVo patient)
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot list previous CatsReferrals for a null PatientId.");
		
		String hql = "from CatsReferral as cats where cats.patient.id = :PatId and cats.id <> :CatsId and cats.providerCancellation is null and cats.rejectReferralDetail is null order by cats.referralDetails.dateOfReferral desc";//	WDEV-14006
		
		return CatsReferralForClinicalNotesVoAssembler.createCatsReferralForClinicalNotesVoCollectionFromCatsReferral(getDomainFactory().find(hql, new String[] {"PatId", "CatsId"}, new Object[] {patient.getID_Patient(), currentReferral.getID_CatsReferral()}));
	}

	public PatientDocumentLiteVoCollection listReferralLetters(CatsReferralRefVo referral)
	{
		if(referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Cannot get Referral Letters on null Referral Id.");
		
		String hql = "select pd from CatsReferral as c left join c.referralDocuments as pd where c.id = :ReferralId and pd.category.id = :ReferralLetterId order by pd.recordingDateTime desc";
		
		return PatientDocumentLiteVoAssembler.createPatientDocumentLiteVoCollectionFromPatientDocument(getDomainFactory().find(hql, new String[] {"ReferralId", "ReferralLetterId"}, new Object[] {referral.getID_CatsReferral(), DocumentCategory.GPLETTER.getID()} ));
	}

	public Boolean isStaleOnNote(AppointmentClinicalNotesRefVo note)
	{
		if(note == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> appts = factory.find("select a.id from AppointmentClinicalNotes as a where a.id = :ApptId and a.version > :ApptVersion", new String[] {"ApptId", "ApptVersion"}, new Object[] {note.getID_AppointmentClinicalNotes(), note.getVersion_AppointmentClinicalNotes()});
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}

	public PatientDiagnosisApptDetailVo savePatientDiagnosis(PatientDiagnosisApptDetailVo diagnosis) throws StaleObjectException
	{
		if(diagnosis == null)
			throw new CodingRuntimeException("Cannot save a null PatientDiagnosisApptDetailVo.");
	
		if(!diagnosis.isValidated())
			throw new CodingRuntimeException("PatientDiagnosisApptDetailVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosisApptDetail doDiagnosis = PatientDiagnosisApptDetailVoAssembler.extractPatientDiagnosisApptDetail(factory, diagnosis);
		
		//if(doDiagnosis == null)
		//	throw new StaleObjectException(doDiagnosis);
		
		factory.save(doDiagnosis);
		
		return PatientDiagnosisApptDetailVoAssembler.create(doDiagnosis);
	}

	public PatientProcedureApptDetailVo savePatientProcedure(PatientProcedureApptDetailVo procedure) throws StaleObjectException
	{

		if(procedure == null)
			throw new CodingRuntimeException("Cannot save a null PatientProcedureApptDetailVo.");
		
		if(!procedure.isValidated())
			throw new CodingRuntimeException("PatientProcedureApptDetailVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PatientProcedureApptDetail doProcedure = PatientProcedureApptDetailVoAssembler.extractPatientProcedureApptDetail(factory, procedure);
		
		//if(doProcedure == null)
		//	throw new StaleObjectException(doProcedure);
		
		factory.save(doProcedure);
		
		return PatientProcedureApptDetailVoAssembler.create(doProcedure);
	}

	public Boolean isStaleOnDiagnosis(PatientDiagnosisRefVo diagnosis)
	{
		if(diagnosis == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> appts = factory.find("select a.id from PatientDiagnosisApptDetail as a where a.id = :DiagnosisId and a.version > :DiagnosisVersion", new String[] {"DiagnosisId", "DiagnosisVersion"}, new Object[] {diagnosis.getID_PatientDiagnosis(), diagnosis.getVersion_PatientDiagnosis()});
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}

	public Boolean isStaleOnProcedure(PatientProcedureRefVo procedure)
	{
		if(procedure == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> appts = factory.find("select a.id from PatientProcedureApptDetail as a where a.id = :ProcedureId and a.version > :ProcedureVersion", new String[] {"ProcedureId", "ProcedureVersion"}, new Object[] {procedure.getID_PatientProcedure(), procedure.getVersion_PatientProcedure()});
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}

	public Boolean deleteDiagnosisOrProcedure(ReferralClinicalNotesVo referralClinicalNotes, ValueObject diagnosisOrProcedure) throws StaleObjectException, ForeignKeyViolationException
	{
		if(diagnosisOrProcedure == null)
			throw new CodingRuntimeException("Cannot delete a null diagnosis or procedure.");
		
		if(referralClinicalNotes == null)
			throw new CodingRuntimeException("Cannot save a null ReferralClinicalNotesVo.");
		
		if(!referralClinicalNotes.isValidated())
			throw new CodingRuntimeException("ReferralClinicalNotesVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		ReferralClinicalNotes doReferralClinicalNote = ReferralClinicalNotesVoAssembler.extractReferralClinicalNotes(factory, referralClinicalNotes);
		
		factory.save(doReferralClinicalNote);
		
		if(diagnosisOrProcedure instanceof PatientDiagnosisApptDetailVo)
		{
			PatientDiagnosisApptDetail doDiagnosis = PatientDiagnosisApptDetailVoAssembler.extractPatientDiagnosisApptDetail(factory, (PatientDiagnosisApptDetailVo) diagnosisOrProcedure);
			factory.delete(doDiagnosis);
		}
		else if(diagnosisOrProcedure instanceof PatientProcedureApptDetailVo)
		{
			PatientProcedureApptDetail doProcedure = PatientProcedureApptDetailVoAssembler.extractPatientProcedureApptDetail(factory, (PatientProcedureApptDetailVo) diagnosisOrProcedure);		
			factory.delete(doProcedure);
		}
		
		return true;
	}

	public void updateReferral(AppointmentClinicalNotesVo note) throws StaleObjectException
	{
		if (note.getCatsReferralIsNotNull())
		{
			ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
			CatsReferralWizardVo currentCatsReferral= impl.getCatsReferral(note.getCatsReferral());

			ReportsRequiredForPrintingVoCollection reportsRequired = currentCatsReferral.getReportsRequired();
			if(reportsRequired == null)
				reportsRequired = new ReportsRequiredForPrintingVoCollection();
			
			//should save the CatsReferralWizardVo ?
			boolean save = false;
			//if it is draft, is not new ,there are no active notes of this type and the reports require contain this type
				//remove the type
			if (note.getID_AppointmentClinicalNotesIsNotNull())
			{
				for (int j = 0 ; reportsRequired != null && j < reportsRequired.size() ; j++)
				{
					if (reportsRequired.get(j).getReportsRequired().equals(note.getNoteType()))
					{
						reportsRequired.remove(j);
						save = true;
					}
				}
			}
			
			if (save)
			{
				DomainFactory factory = getDomainFactory();
				CatsReferral catsReferral = CatsReferralWizardVoAssembler.extractCatsReferral(factory,currentCatsReferral);
				factory.save(catsReferral);
			}
		}
		

	}

	public void updateReferral(ReportNoteType removeType, Boolean bShouldRemove, AppointmentClinicalNotesVo note) throws StaleObjectException
	{
	}

	public AppointmentClinicalNotesVo getAppointmentClinicalNote(AppointmentClinicalNotesRefVo noteRefVo)
	{
		if(noteRefVo == null || noteRefVo.getID_AppointmentClinicalNotes() == null)
			throw new CodingRuntimeException("Cannot get AppointmentClinicalNotesRefVo on null Id.");
		
		return AppointmentClinicalNotesVoAssembler.create((AppointmentClinicalNotes) getDomainFactory().getDomainObject(AppointmentClinicalNotes.class, noteRefVo.getID_AppointmentClinicalNotes()));
	}
}
