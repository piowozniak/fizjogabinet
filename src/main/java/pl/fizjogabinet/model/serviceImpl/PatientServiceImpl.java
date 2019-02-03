package pl.fizjogabinet.model.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.PatientDTO;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.Visit;
import pl.fizjogabinet.model.repository.PatientRepository;
import pl.fizjogabinet.model.repository.TherapistRepository;
import pl.fizjogabinet.model.repository.VisitRepository;
import pl.fizjogabinet.model.service.CrudService;

@Service("patient")
public class PatientServiceImpl implements CrudService<Object> {
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	private VisitRepository visitRepository;
//	@Autowired 
//	private TherapistRepository therapistRepository;
//	private final static String[] TYPE_OF_VISIT = new String[] { "Domowa", "Gabinet" };

	@Override
	public String addForm(Model model, Long id) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "registerpatientform";
	}

	@Override
	public String addFormConfirmation(Model model, Object o) {
		Patient patient = (Patient) o;
		patient = ifIdNullGetNewPatient_orEditExisting(patient);
		patientRepository.save(patient);
		return "redirect:/patientspage";
	}
	private Patient ifIdNullGetNewPatient_orEditExisting(Patient patient) {
		if (patient.getId() != null) {
			Patient existingPatient = patientRepository.findOne(patient.getId());
			existingPatient.setFirstName(patient.getFirstName());
			existingPatient.setLastName(patient.getLastName());
			existingPatient.setDateOfBirth(patient.getDateOfBirth());
			existingPatient.setPhoneNumber(patient.getPhoneNumber());
			return existingPatient;
		}
		return patient;
	}

	@Override
	public String editForm(Model model, Long id) {
		Patient patient = patientRepository.findOne(id);
		model.addAttribute("patient", patient);
		return "registerpatientform";
	}

	@Override
	public String deleteForm(Model model, Long id) {
		Patient patient = patientRepository.findOne(id);
		model.addAttribute("patient", patient);
		return "deleteconfirmation";
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		Patient patient = patientRepository.findOne(id);
		patientRepository.delete(patient);
		return "redirect:/patientspage";
	}

}
