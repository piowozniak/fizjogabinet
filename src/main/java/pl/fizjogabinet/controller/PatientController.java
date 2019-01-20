package pl.fizjogabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.service.CrudService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class PatientController {
	
	private CrudService patientService;
	 
	@Autowired
	public PatientController(@Qualifier("patient") CrudService patientService) {
		super();
		this.patientService = patientService;
	}

	@RequestMapping(path="/addpatient")
	public String addPatientForm(Model model) {		
		return patientService.addForm(model, null);
	}
	
	@RequestMapping(path="/addpatientconfirmation")
	public String addPatientConfirmation(Model model, @ModelAttribute("patient") PatientDTO patient) {
		return patientService.addFormConfirmation(model, patient);
	}
}
