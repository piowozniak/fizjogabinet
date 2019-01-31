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

import pl.fizjogabinet.model.entity.Visit;
import pl.fizjogabinet.model.service.CrudService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class VisitController {
	
	
	private final CrudService<Visit> visitService;
	
	@Autowired
	public VisitController(@Qualifier("visit") CrudService visitService) {
		super();
		this.visitService = visitService;
	}

	@RequestMapping(path="/addvisit/{id}")
	public String addVisitForm(Model model, @PathVariable("id") Long id) {
		return visitService.addForm(model, id);
	}
	
	@RequestMapping(path="/addvisit")
	public String addVisitFormConfirmation(Model model, @ModelAttribute("visit") Visit visit) throws SerialException, SQLException {
		return visitService.addFormConfirmation(model, visit);
	}
	
	@GetMapping(path="/editvisit/{id}")
	public String editVisitForm(@PathVariable("id") Long id, Model model) {
		return visitService.editForm(model, id);
	}
	
	@GetMapping(path="/deletevisit/{id}")
	public String deleteVisitForm(@PathVariable("id") Long id, Model model) {
		return visitService.deleteForm(model, id);
	}
	
	@PostMapping(path="/deletevisit/{id}")
	public String deleteVisitFormConfirmation(@PathVariable("id") Long id, Model model) {
		return visitService.deleteFormConfirmation(model, id);
	}

}
