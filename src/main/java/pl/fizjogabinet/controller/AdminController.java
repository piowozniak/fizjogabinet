package pl.fizjogabinet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.service.AdminService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class AdminController {
	
		
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@RequestMapping(path="/patientspage")
	public String displayPatientsPage(Model model) {
		return adminService.displayPatients(model);
	}
	
	@RequestMapping(path="/addpatient")
	public String addPatientForm(Model model) {
		return adminService.addPatient(model);
	}
	
	@RequestMapping(path="/addpatientconfirmation")
	public String addPatientConfirmation(Model model, @ModelAttribute("patient") PatientDTO patient) {
		return adminService.confirmPatient(model, patient);
	}
//	@RequestMapping(path="/activateuser/{id}", method = RequestMethod.GET)
//	public String activateUser(@PathVariable(value="id", required=false) long id, Model model ) {
//		return adminService.dislayUserToActivateOrDeactivate(model, id);
//	}
//	@PostMapping(path="/confirmuseractivation")
//	public String confirmUser(Model model, @ModelAttribute("user") User user ) {
//		return adminService.confirmUser(model, user);
//	}
//	@RequestMapping(path="/edituser/{id}", method = RequestMethod.GET)
//	public String editUserDetails(@PathVariable("id") long id, Model model) {
//		System.out.println(id);
//		return adminService.editUser(model, id);		 
//	}
//	@PostMapping(path="/edituserconfirmation")
//	public String editUserConfirmation(@ModelAttribute("user") User user,  Model model) {
//		System.out.println(model.containsAttribute("user"));
//		return adminService.editUserConfirmation(model, user);
//	}
//	@PostMapping(path="/giverole/{id}")
//	public String giveOrganizerRole(Model model, @PathVariable("id") long id) {
//		return adminService.giveOrganizerRole(model, id);
//	}
	

}
