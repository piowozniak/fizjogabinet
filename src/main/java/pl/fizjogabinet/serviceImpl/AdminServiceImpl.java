package pl.fizjogabinet.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	private String[] typeOfVisit = new String[] {"Domowa", "Gabinet"};
	
	
	
	@Autowired
	public AdminServiceImpl(PatientRepository patientRepository, TherapistRepository therapistRepository, VisitRepository visitRepository) {
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

//
//	@Override
//	public String displayUsers(Model model) {
//		allUsers = userRepository.findAll();
//		displayUserConfirmation=false;
//		addAttributesToModel(model);
//		return "adminpage";	
//		
//	}
//	@Override
//	public String dislayUserToActivateOrDeactivate(Model model, long id) {
//		user = userRepository.findOne(id);
//		displayUserConfirmation = true;
//		addAttributesToModel(model);
//		return "edituser";
//	}
//
//	@Override
//	public String confirmUser(Model model, User user) {
//		//TO DO refactor
//		
//		User userFromAllUsers = allUsers.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
//		if (StatusE.ACTIVEUSER.getValue().equals(userFromAllUsers.getStatus())) {
//			userFromAllUsers.setStatus(StatusE.NONACTIVEUSER.getValue());
//		} else if (StatusE.NONACTIVEUSER.getValue().equals(userFromAllUsers.getStatus())) {
//			userFromAllUsers.setStatus(StatusE.ACTIVEUSER.getValue());
//			userFromAllUsers.setRoles(setUserRole(userFromAllUsers));
//		}
//		userRepository.saveAndFlush(userFromAllUsers);
//		displayUserConfirmation = false;
//		this.user = userRepository.findOne(user.getId());
//		addAttributesToModel(model);
//		return "redirect:/edituser/"+user.getId();
//	}
//	private Set<Role> setUserRole(User user) {
//		Role role = roleRepository.findOne(ROLE_USER);
//		Set<Role> userRole = new HashSet<>();
//		userRole.add(role);
//		return userRole;
//	}
//	@Override
//	public String editUser(Model model, long id) {
//		this.user = userRepository.findOne(id);
//		addAttributesToModel(model);
//		return "edituser";
//	}
//	
//	@Override
//	public String editUserConfirmation(Model model, User user) {
//		this.user.setEmail(user.getEmail());
//		this.user.setUsername(user.getUsername());
//		this.user.setFirstName(user.getFirstName());
//		this.user.setLastName(user.getLastName());
//		this.user.setPhoneNumber(user.getPhoneNumber());
//		userRepository.saveAndFlush(this.user);
//		allUsers.clear();
//		allUsers = userRepository.findAll();		
//		addAttributesToModel(model);
//		return "redirect:/edituser/"+user.getId();
//	}
//	
//	@Override
//	public String giveOrganizerRole(Model model, long id) {
//		User user = userRepository.findOne(id);
//		Role role = roleRepository.findOne(ROLE_ORGANIZER);
//		user.getRoles().add(role);
//		userRepository.save(user);
//		addAttributesToModel(model);
//		return "redirect:/edituser/" + id;
//	}

	








}
