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

import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.Hypothesis;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.service.AdminService;
import pl.fizjogabinet.service.MedicalHistoryService;

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
	

}
