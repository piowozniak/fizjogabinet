package pl.fizjogabinet.model.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.MedicalHistoryDTO;
import pl.fizjogabinet.model.dto.PatientDTO;
import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.User;

@Service
public interface AdminService {
	
	String displayPatients(Model model); 
	String displayPatientsCard(Long id, Model model);
	String displayVisits(Model model);
	String displayMedicalHistory(Model model, Long id);
	String searchPatient(Model model, String search);
	String displayControlPanel(Model model);

}
