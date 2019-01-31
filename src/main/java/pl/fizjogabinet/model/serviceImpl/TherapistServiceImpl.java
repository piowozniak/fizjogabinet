package pl.fizjogabinet.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.repository.TherapistRepository;
import pl.fizjogabinet.model.service.CrudService;

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

	@Override
	public String editForm(Model model, Long id) {
		Therapist therapist = therapistRepository.findOne(id);
		model.addAttribute("therapist", therapist);
		return "addtherapist";
	}

	@Override
	public String deleteForm(Model model, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
