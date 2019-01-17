package pl.fizjogabinet.service;

import org.springframework.ui.Model;

public interface MedicalHistoryService {
	
	String displayMedicalHistory(Model model, Long id);
	String addMedicalHistory(Model model);

}
