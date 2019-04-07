package pl.fizjogabinet.model.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.FizjoGabinetObject;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.enums.FizjoGabinetFactoryE;
import pl.fizjogabinet.model.repository.PatientRepository;
import pl.fizjogabinet.model.repository.VisitRepository;
import pl.fizjogabinet.model.service.CrudService;

@Service("patient")
public class PatientServiceImpl implements CrudService<Patient> {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private VisitRepository visitRepository;
	private static final String PATIENT = "Patient";
	private static final String[] GENDERS = new String[] {"M", "F"};

	@Override
	public String addForm(Model model, Long id) {
		FizjoGabinetObject<Patient> patientObject = new FizjoGabinetObject<Patient>(new Patient());
		Patient patient = patientObject.getFizjoObject();
		model.addAttribute("patient", patient);
		model.addAttribute("genders", GENDERS);
		return "registerpatientform";
	}

	@Override
	public String addFormConfirmation(Model model, Patient patient) {
		patient.setFullName(patient.getFirstName() + " " + patient.getLastName());
		patient = ifIdNullGetNewPatient_orEditExisting(patient);
		patientRepository.save(patient);
		return "redirect:/patientspage";
	}
	
	private Patient ifIdNullGetNewPatient_orEditExisting(Patient patient) {
		if (Optional.ofNullable(patient.getId()).isPresent()) {
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
