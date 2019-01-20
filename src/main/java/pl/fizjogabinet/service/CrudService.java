package pl.fizjogabinet.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.Visit;

@Service
public interface CrudService {
	
	String addForm(Model model, Long id);
	String addFormConfirmation(Model model, Object o);

	
}