package pl.fizjogabinet.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.Visit;
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

	@Override
	public String editForm(Model model, Long id) {
		Visit visit = visitRepository.findOne(id);
		model.addAttribute("visit", visit);
		return "addvisit";
	}
}
