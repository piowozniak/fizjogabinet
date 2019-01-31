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

import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.service.CrudService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class HypothesisController {
		
	private final CrudService hypothesisService;
	
	@Autowired
	public HypothesisController(@Qualifier("hypothesis") CrudService hypothesisService) {
		super();
		this.hypothesisService = hypothesisService;
	}
	@GetMapping(path="/addhypothesis/{id}")
	public String addHypothesisForm(Model model, @PathVariable("id") Long id) {
		System.out.println(model.containsAttribute("medicalHistory"));
		return hypothesisService.addForm(model, id);
	}
	@PostMapping(path="/addhypothesis")
	public String addHypothesisConfirmation(Model model, @ModelAttribute("hypothesis") Hypothesis hypothesis) throws SerialException, SQLException {
		return hypothesisService.addFormConfirmation(model, hypothesis);
	}
	
	@GetMapping(path="/edithypothesis/{id}")
	public String editHypothesisForm(@PathVariable("id") Long id, Model model) {
		return hypothesisService.editForm(model, id);
	}
	
	@GetMapping(path="/deletehypothesis/{id}")
	public String deleteHyphesisForm(@PathVariable("id") Long id, Model model) {
		return hypothesisService.deleteForm(model, id);
	}
	
	@PostMapping(path="/deletehypothesis/{id}")
	public String deleteHyphesisFormConfirmation(@PathVariable("id") Long id, Model model) {
		return hypothesisService.deleteFormConfirmation(model, id);
	}

}
