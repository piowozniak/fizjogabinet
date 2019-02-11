package pl.fizjogabinet.model.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.FizjoGabinetObject;
import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.Visit;
import pl.fizjogabinet.model.enums.FizjoGabinetFactoryE;
import pl.fizjogabinet.model.repository.TherapistRepository;
import pl.fizjogabinet.model.service.CrudService;

@Service("therapist")
public class TherapistServiceImpl implements CrudService<Object> {
	
	@Autowired
	private TherapistRepository therapistRepository;
	private final static String THERAPIST = "therapist";

	@Override
	public String addForm(Model model, Long id) {
		FizjoGabinetObject<Therapist> therapistObject = new FizjoGabinetObject<Therapist>(FizjoGabinetFactoryE.objectFactory(THERAPIST));
		model.addAttribute("therapist", therapistObject.getFizjoObject());
		return "addtherapist";
	}

	@Override
	public String addFormConfirmation(Model model, Object t) {
		FizjoGabinetObject<Therapist> therapistObject = new FizjoGabinetObject<Therapist>(t);
		Therapist therapist = therapistObject.getFizjoObject();
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
		if (Optional.ofNullable(therapist.getId()).isPresent()) {
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
