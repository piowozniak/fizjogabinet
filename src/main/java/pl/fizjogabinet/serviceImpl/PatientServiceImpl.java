package pl.fizjogabinet.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.entity.Visit;
import pl.fizjogabinet.repository.PatientRepository;
import pl.fizjogabinet.repository.TherapistRepository;
import pl.fizjogabinet.repository.VisitRepository;
import pl.fizjogabinet.service.CrudService;

@Service("patient")
public class PatientServiceImpl implements CrudService {
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	private VisitRepository visitRepository;
	@Autowired 
	private TherapistRepository therapistRepository;
	private final static String[] TYPE_OF_VISIT = new String[] { "Domowa", "Gabinet" };

	@Override
	public String addForm(Model model, Long id) {
		PatientDTO patient = new PatientDTO(new Patient(), new Visit());
		List<Therapist> therapists = therapistRepository.findAll();
		model.addAttribute("therapists", therapists);
		model.addAttribute("typeOfVisit", TYPE_OF_VISIT);
		model.addAttribute("patient", patient);
		return "registerpatientform";
	}

	@Override
	public String addFormConfirmation(Model model, Object o) {
		PatientDTO patientDTO = (PatientDTO) o;
		Patient patient = patientDTO.getPatient();
		patient.setVisits(new ArrayList<>());
		patient.getVisits().add(patientDTO.getVisit());
		patientRepository.save(patient);
		Visit visit = patientDTO.getVisit();
		visit.setPatient(patient);
		visitRepository.save(visit);
		return "redirect:/patientspage";
	}

}
