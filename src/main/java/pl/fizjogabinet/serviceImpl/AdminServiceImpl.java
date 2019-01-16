package pl.fizjogabinet.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.dto.PatientDTO;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.Role;
import pl.fizjogabinet.entity.Therapist;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.entity.Visit;
import pl.fizjogabinet.enums.StatusE;
import pl.fizjogabinet.repository.PatientRepository;
import pl.fizjogabinet.repository.RoleRepository;
import pl.fizjogabinet.repository.TherapistRepository;
import pl.fizjogabinet.repository.UserRepository;
import pl.fizjogabinet.repository.VisitRepository;
import pl.fizjogabinet.service.AdminService;
import pl.fizjogabinet.service.ModelService;

@Service
public class AdminServiceImpl implements AdminService, ModelService {

	private final PatientRepository patientRepository;
	private final TherapistRepository therapistRepository;
	private final VisitRepository visitRepository;
	private List<Patient> allPatients = new ArrayList<>();
	private Patient patient;
	private String[] typeOfVisit = new String[] { "Domowa", "Gabinet" };
	private List<MedicalHistoryDTO> listOfMedicalHistory = new ArrayList<>();

	@Autowired
	public AdminServiceImpl(PatientRepository patientRepository, TherapistRepository therapistRepository,
			VisitRepository visitRepository) {
		super();
		this.patientRepository = patientRepository;
		this.therapistRepository = therapistRepository;
		this.visitRepository = visitRepository;
	}

	@Override
	public String displayPatients(Model model) {
		allPatients = patientRepository.findAll();
		addAttributesToModel(model);
		return "patientspage";
	}

	@Override
	public String addPatient(Model model) {
		PatientDTO patient = new PatientDTO(new Patient(), new Visit());
		List<Therapist> therapists = therapistRepository.findAll();
		model.addAttribute("therapists", therapists);
		model.addAttribute("typeOfVisit", typeOfVisit);
		model.addAttribute("patient", patient);
		return "registerpatientform";
	}

	@Override
	public String confirmPatient(Model model, PatientDTO patientDTO) {
		Patient patient = patientDTO.getPatient();
		patient.setVisits(new ArrayList<>());
		patient.getVisits().add(patientDTO.getVisit());
		patientRepository.save(patient);
		Visit visit = patientDTO.getVisit();
		visit.setPatient(patient);
		visitRepository.save(visit);
		return "redirect:/patientspage";
	}

	@Override
	public String displayPatientsCard(Long id, Model model) {
		patient = patientRepository.findOne(id);
		PatientDTO patientDTO = new PatientDTO(patient);
		System.out.println(model.containsAttribute("listOfMedicalHistory"));
		listOfMedicalHistory.clear();
		patient.getMedicalHistory().forEach(m -> listOfMedicalHistory.add(new MedicalHistoryDTO(m)));
		model.addAttribute("patient", patientDTO);
		model.addAttribute("listOfMedicalHistory", listOfMedicalHistory);
		return "patientscard";
	}

	@Override
	public String displayMedicalHistory(Model model, Long id) {
		listOfMedicalHistory.forEach(m -> setToDisplayMedicalHistory(m,id));
		model.addAttribute("listOfMedicalHistory", listOfMedicalHistory);
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
	public String editPatient(Model model, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editPatientConfirmation(Model model, Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttributesToModel(Model model) {
		model.addAttribute("allPatients", allPatients);
		model.addAttribute("patient", patient);
	}

}
