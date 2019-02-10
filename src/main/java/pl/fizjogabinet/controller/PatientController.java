package pl.fizjogabinet.controller;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.fizjogabinet.model.dto.PatientDTO;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.service.CrudService;

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
	public String addPatientConfirmation(Model model, @ModelAttribute("patient") Patient patient) throws SerialException, SQLException {
		return patientService.addFormConfirmation(model, patient);
	}
	
	@GetMapping(path="/editpatient/{id}")
	public String editPatientForm(@PathVariable("id") Long id, Model model) {
		return patientService.editForm(model, id);
	}
	
	@GetMapping(path="/deletepatient/{id}")
	public String deletePatientForm(@PathVariable("id") Long id, Model model) {
		return patientService.deleteForm(model, id);
	}
	
	@PostMapping(path="/deletepatient/{id}")
	public String deletePatientFormConfirmation(@PathVariable("id") Long id, Model model) {
		return patientService.deleteFormConfirmation(model, id);
	}
}
