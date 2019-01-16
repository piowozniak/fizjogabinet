package pl.fizjogabinet.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.User;

@Service
public interface AdminService {
	
	String displayPatients(Model model); 
	String addPatient(Model model);
	String confirmPatient(Model model, PatientDTO patient);
	String editPatient(Model model, long id ) ;
	String editPatientConfirmation(Model model, Patient patient);
	String displayPatientsCard(Long id, Model model);
	String displayMedicalHistory(Model model, Long id);

}
