package pl.fizjogabinet.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.service.CrudService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class TherapistController {
	
	private final CrudService<Therapist> therapistService;

	public TherapistController(@Qualifier("therapist") CrudService therapistService) {
		super();
		this.therapistService = therapistService;
	}
	
	@GetMapping(path="/addtherapist")
	public String addTherapist(Model model) {
		return therapistService.addForm(model, null);
	}
	
	@PostMapping(path="/addtherapist")
	public String addTherapistConfirmation(@ModelAttribute("therapist") Therapist therapist, Model model) {
		return therapistService.addFormConfirmation(model, therapist);
	}
	
	

}
