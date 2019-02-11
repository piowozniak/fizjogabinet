package pl.fizjogabinet.model.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.FizjoGabinetObject;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.Visit;
import pl.fizjogabinet.model.enums.FizjoGabinetFactoryE;
import pl.fizjogabinet.model.repository.HypothesisRepository;
import pl.fizjogabinet.model.repository.TherapistRepository;
import pl.fizjogabinet.model.repository.VisitRepository;
import pl.fizjogabinet.model.service.CrudService;
@Service("visit")
public class VisitServiceImpl implements CrudService<Object> {
	
	@Autowired
	private VisitRepository visitRepository;
	@Autowired 
	private TherapistRepository therapistRepository;
	private final static String[] TYPE_OF_VISIT = new String[] { "Domowa", "Gabinet" };
	private final static String VISIT = "visit";
	private final static String PATIENT = "patient";
	
	@Override
	public String addForm(Model model, Long id) {
		FizjoGabinetObject<Visit> visitObject = new FizjoGabinetObject<Visit>(FizjoGabinetFactoryE.objectFactory(VISIT));
		FizjoGabinetObject<Patient> patientObject = new FizjoGabinetObject<Patient>(FizjoGabinetFactoryE.objectFactory(PATIENT));
		Visit visit = visitObject.getFizjoObject();
		Patient patient = patientObject.getFizjoObject();
		patient.setId(id);
		visit.setPatient(patient);
		List<Therapist> therapists = therapistRepository.findAll();
		model.addAttribute("therapists", therapists);
		model.addAttribute("visit", visit);
		model.addAttribute("typeOfVisit", TYPE_OF_VISIT);
		return "addvisit";
	}

	@Override
	public String addFormConfirmation(Model model, Object o) {
		FizjoGabinetObject<Visit> visitObject = new FizjoGabinetObject<Visit>(o);
		Visit visit = visitObject.getFizjoObject();
		visit = ifIdNullGetNewMedicalHistory_orEditExisting(visit);
		visitRepository.save(visit);
		return "redirect:/displaypatientscard/" + visit.getPatient().getId();
	}

	@Override
	public String editForm(Model model, Long id) {
		Visit visit = visitRepository.findOne(id);
		List<Therapist> therapists = therapistRepository.findAll();
		model.addAttribute("therapists", therapists);
		model.addAttribute("visit", visit);
		model.addAttribute("typeOfVisit", TYPE_OF_VISIT);
		return "addvisit";
	}

	@Override
	public String deleteForm(Model model, Long id) {
		Visit visit = visitRepository.findOne(id);
		model.addAttribute("visit", visit);
		return "deleteconfirmation";
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		Visit visit = visitRepository.findOne(id);
		visitRepository.delete(visit);
		return "redirect:/displaypatientscard/"+visit.getPatient().getId();
	}
	
	private Visit ifIdNullGetNewMedicalHistory_orEditExisting(Visit visit) {
		Optional<Long> visitId = Optional.ofNullable(visit.getId());
		if (visitId.isPresent()) {
			Visit existingVisit = visitRepository.findOne(visit.getId());
			existingVisit.setDate(visit.getDate());
			existingVisit.setPatient(visit.getPatient());
			existingVisit.setTherapist(visit.getTherapist());
			existingVisit.setType(visit.getType());
			return existingVisit;
		}
		return visit;
	}
}
