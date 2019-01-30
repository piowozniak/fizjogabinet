package pl.fizjogabinet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.fizjogabinet.model.dto.MedicalHistoryDTO;
import pl.fizjogabinet.model.dto.PatientDTO;
import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.User;
import pl.fizjogabinet.model.service.AdminService;
import pl.fizjogabinet.model.service.MedicalHistoryService;

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
	
	@RequestMapping(path="/displaypatientscard/{id}")
	public String displayPatientsCard(@PathVariable("id") Long id, Model model) {
		return adminService.displayPatientsCard(id, model);
	}
	
	@RequestMapping(path="/displaymedicalhistory/{id}")
	public String displayMedicalHistory(Model model, @PathVariable("id") Long id) {
		return adminService.displayMedicalHistory(model, id);
	}
	
	@GetMapping(path="/displayvisits")
	public String displayVisitOrHideVisits(Model model) {
		return adminService.displayVisits(model);
	}
	
	@GetMapping(path="/searchpatient")
	public String searchPatient(Model model, @RequestParam(value="search", required=false) String search) {
		return adminService.searchPatient(model, search);
	}
	
	@GetMapping(path="/controlpanel")
	public String displayControlPanel(Model model) {
		return adminService.displayControlPanel(model);
	}
	

}
