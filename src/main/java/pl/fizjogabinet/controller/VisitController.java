package pl.fizjogabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.fizjogabinet.entity.Visit;
import pl.fizjogabinet.service.CrudService;

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
	public String addVisitFormConfirmation(Model model, @ModelAttribute("visit") Visit visit) {
		return visitService.addFormConfirmation(model, visit);
	}
	

}
