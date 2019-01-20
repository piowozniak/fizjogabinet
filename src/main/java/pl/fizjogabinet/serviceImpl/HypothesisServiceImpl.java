package pl.fizjogabinet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.Hypothesis;
import pl.fizjogabinet.entity.MedicalHistory;
import pl.fizjogabinet.service.CrudService;
import pl.fizjogabinet.repository.HypothesisRepository;
import pl.fizjogabinet.repository.MedicalHistoryRepository;

@Service("hypothesis")
public class HypothesisServiceImpl implements CrudService<Object> {
	
	@Autowired 
	private MedicalHistoryRepository medicalHistoryRepository;
	@Autowired
	private HypothesisRepository hypothesisRepository;
	private MedicalHistory medicalHistory;

	@Override
	public String addForm(Model model, Long id) {
		Hypothesis hypothesis = new Hypothesis();	
		this.medicalHistory = medicalHistoryRepository.findOne(id);
		hypothesis.setMedicalHistory(medicalHistory);
		model.addAttribute("hypothesis", hypothesis);
		return "addhypothesis";
	}

	@Override
	public String addFormConfirmation(Model model, Object o) {
		Hypothesis hypothesis = (Hypothesis) o;
		hypothesisRepository.save(hypothesis);
		return "redirect:/displaypatientscard/"+medicalHistory.getPatient().getId();
	}

}
