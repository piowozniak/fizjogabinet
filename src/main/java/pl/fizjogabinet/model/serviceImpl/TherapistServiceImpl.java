package pl.fizjogabinet.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.Visit;
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
		therapist = ifIdNullGetNewMedicalHistory_orEditExisting(therapist);
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
		Therapist therapist = therapistRepository.findOne(id);
		model.addAttribute("therapist", therapist);
		return "deleteconfirmation";
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		Therapist therapist = therapistRepository.findOne(id);
		therapistRepository.delete(therapist);
		return "redirect:/controlpanel";
	}
	
	private Therapist ifIdNullGetNewMedicalHistory_orEditExisting(Therapist therapist) {
		if (therapist.getId() != null) {
			Therapist existingTherapist = therapistRepository.findOne(therapist.getId());
			existingTherapist.setFirstName(therapist.getFirstName());
			existingTherapist.setLastName(therapist.getLastName());
			existingTherapist.setEmail(therapist.getEmail());
			existingTherapist.setPhoneNumber(therapist.getPhoneNumber());
			return existingTherapist;
		}
		return therapist;
	}

}
