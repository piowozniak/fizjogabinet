package pl.fizjogabinet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.entity.Visit;
import pl.fizjogabinet.repository.TherapistRepository;
import pl.fizjogabinet.repository.VisitRepository;
import pl.fizjogabinet.service.CrudService;
@Service("visit")
public class VisitServiceImpl implements CrudService {
	
	@Autowired
	private VisitRepository visitRepository;
	@Autowired 
	private TherapistRepository therapistRepository;
	private final static String[] TYPE_OF_VISIT = new String[] { "Domowa", "Gabinet" };
	
	@Override
	public String addForm(Model model, Long id) {
		Visit visit = new Visit();
		Patient patient = new Patient();
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
		Visit visit = (Visit) o;
		visitRepository.save((Visit) o);
		return "redirect:/displaypatientscard/" + visit.getPatient().getId();
	}
}
