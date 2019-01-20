package pl.fizjogabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.service.CrudService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class MedicalHistoryController {
	
	private final CrudService medicalHistoryService;
	
	@Autowired
	public MedicalHistoryController(@Qualifier("medicalhistory") CrudService medicalHistoryService) {
		super();
		this.medicalHistoryService = medicalHistoryService;
	}

	@GetMapping(path="/addmedicalhistory/{id}")
	public String addMedicalHistoryForm(Model model, @PathVariable("id") Long id) {
		return medicalHistoryService.addForm(model, id);
	}
	
	@PostMapping(path="/addmedicalhistory")
	public String addMedicalHistory(Model model, @ModelAttribute("medicalHistory") MedicalHistory medicalHistory) {
		return medicalHistoryService.addFormConfirmation(model, medicalHistory);
	}

}
