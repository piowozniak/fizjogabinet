package pl.fizjogabinet.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.Hypothesis;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.User;

@Service
public interface AdminService {
	
	String displayPatients(Model model); 
	String displayPatientsCard(Long id, Model model);
	String displayVisits(Model model);
	String displayMedicalHistory(Model model, Long id);

}
