package pl.fizjogabinet.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.fizjogabinet.entity.Hypothesis;
import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.Role;
import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.entity.Visit;
import pl.fizjogabinet.enums.StatusE;
import pl.fizjogabinet.repository.HypothesisRepository;
import pl.fizjogabinet.repository.MedicalHistoryRepository;
import pl.fizjogabinet.repository.PatientRepository;
import pl.fizjogabinet.repository.RoleRepository;
import pl.fizjogabinet.repository.TherapistRepository;
import pl.fizjogabinet.repository.UserRepository;
import pl.fizjogabinet.repository.VisitRepository;
import pl.fizjogabinet.service.AdminService;
import pl.fizjogabinet.service.MedicalHistoryService;
import pl.fizjogabinet.service.ModelService;
import pl.fizjogabinet.service.CrudService;

@Service
public class AdminServiceImpl implements AdminService, ModelService {

	private final PatientRepository patientRepository;
	private List<Patient> allPatients = new ArrayList<>();
	private Patient patient;
	private List<MedicalHistoryDTO> listOfMedicalHistory = new ArrayList<>();
	private boolean displayVisits = false;

	@Autowired
	public AdminServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public String displayPatients(Model model) {
		allPatients = patientRepository.findAll();
		addAttributesToModel(model);
		return "patientspage";
	}

	@Override
	public String displayPatientsCard(Long id, Model model) {
		patient = patientRepository.findOne(id);
//		PatientDTO patientDTO = new PatientDTO(patient);
		listOfMedicalHistory.clear();
		patient.getMedicalHistory().forEach(m -> listOfMedicalHistory.add(new MedicalHistoryDTO(m)));
		model.addAttribute("patient", patient);
		model.addAttribute("listOfMedicalHistory", listOfMedicalHistory);
		return "patientscard";
	}

	@Override
	public String displayMedicalHistory(Model model, Long id) {
		listOfMedicalHistory.forEach(m -> setToDisplayMedicalHistory(m,id));
		model.addAttribute("listOfMedicalHistory", listOfMedicalHistory);
		model.addAttribute("patient", patient);
		return "patientscard";
	}

	private void setToDisplayMedicalHistory(MedicalHistoryDTO medicalHistory, Long id) {
		if (medicalHistory.getMedicalHistory().getId().equals(id)) {
			medicalHistory.setDisplayMedicalHistory(true);
			} else {
				medicalHistory.setDisplayMedicalHistory(false);
			}
	}
	
	@Override
	public String displayVisits(Model model) {
		displayVisits = displayVisits ? false : true;
		model.addAttribute("displayVisits", displayVisits);
		model.addAttribute("listOfMedicalHistory", listOfMedicalHistory);
		model.addAttribute("patient", patient);
		return "patientscard";
	}

	@Override
	public void addAttributesToModel(Model model) {
		model.addAttribute("allPatients", allPatients);
		model.addAttribute("patient", patient);
	}

	public boolean isDisplayVisits() {
		return displayVisits;
	}

	public void setDisplayVisits(boolean displayVisits) {
		this.displayVisits = displayVisits;
	}


}
