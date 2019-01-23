package pl.fizjogabinet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.repository.TherapistRepository;
import pl.fizjogabinet.service.CrudService;

@Service("therapist")
public class TherapistServiceImpl implements CrudService<Object> {
	
	@Autowired
	private TherapistRepository therapistRepository;

	@Override
	public String addForm(Model model, Long id) {
		model.addAttribute("therapist", new Therapist());
		return "addtherapist";
	}

	@Override
	public String addFormConfirmation(Model model, Object t) {
		Therapist therapist = (Therapist) t;
		therapistRepository.save(therapist);
		return "redirect:/controlpanel";
	}

}
