package pl.fizjogabinet.model.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.MedicalHistoryDTO;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.repository.HypothesisRepository;
import pl.fizjogabinet.model.repository.MedicalHistoryRepository;
import pl.fizjogabinet.model.repository.PatientRepository;
import pl.fizjogabinet.model.service.CrudService;

@Service("medicalhistory")
public class MedicalHistoryServiceImpl implements CrudService<Object> {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	@Autowired
	private HypothesisRepository hypothesisRepository;
	private static final String[] flags = new String[] {"G", "Y", "R"};

	@Override
	public String addForm(Model model, Long id) {
		Patient patient = patientRepository.findOne(id);
		MedicalHistory medicalHistory = new MedicalHistory();
		medicalHistory.setPatient(patient);
		model.addAttribute("medicalHistory", medicalHistory);
		model.addAttribute("flags", flags);
		return "addmedicalhistory";
	}

	@Override
	public String addFormConfirmation(Model model, Object o) {
		MedicalHistory medicalHistory = (MedicalHistory) o;
		medicalHistory = ifIdNullGetNewMedicalHistory_orEditExisting(medicalHistory);
		medicalHistoryRepository.save(medicalHistory);
		return "redirect:/displaypatientscard/"+medicalHistory.getPatient().getId();
	}

	public static String[] getFlags() {
		return flags;
	}

	@Override
	public String editForm(Model model, Long id) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findOne(id);
		model.addAttribute("medicalHistory", medicalHistory);
		model.addAttribute("flags", flags);
		return "addmedicalhistory";
	}
	private MedicalHistory ifIdNullGetNewMedicalHistory_orEditExisting(MedicalHistory medicalHistory) {
		Optional<Long> medicalHistoryId = Optional.ofNullable(medicalHistory.getId());
		if (medicalHistoryId.isPresent()) {
			MedicalHistory existingMedicalHistory = medicalHistoryRepository.findOne(medicalHistory.getId());
			existingMedicalHistory.setDate(medicalHistory.getDate());
			existingMedicalHistory.setFlag(medicalHistory.getFlag());
			existingMedicalHistory.setMedication(medicalHistory.getMedication());
			existingMedicalHistory.setTreatment(medicalHistory.getTreatment());
			return existingMedicalHistory;
		}
		return medicalHistory;
	}

	@Override
	public String deleteForm(Model model, Long id) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findOne(id);
		model.addAttribute("medicalHistory", medicalHistory);
		return "deleteconfirmation";
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findOne(id);
//		medicalHistory.getHypothesis().stream().forEach(h -> hypothesisRepository.delete(h.getId()));
		medicalHistoryRepository.delete(medicalHistory.getId());
		return "redirect:/displaypatientscard/" + medicalHistory.getPatient().getId();
	}

}
