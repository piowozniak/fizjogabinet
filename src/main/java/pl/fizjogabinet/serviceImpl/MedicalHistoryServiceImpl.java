package pl.fizjogabinet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.dto.MedicalHistoryDTO;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.repository.MedicalHistoryRepository;
import pl.fizjogabinet.repository.PatientRepository;
import pl.fizjogabinet.service.CrudService;

@Service("medicalhistory")
public class MedicalHistoryServiceImpl implements CrudService<Object> {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
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
		medicalHistoryRepository.save(medicalHistory);
		return "redirect:/displaypatientscard/"+medicalHistory.getPatient().getId();
	}

	public static String[] getFlags() {
		return flags;
	}

}
