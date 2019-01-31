package pl.fizjogabinet.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.repository.HypothesisRepository;
import pl.fizjogabinet.model.repository.MedicalHistoryRepository;
import pl.fizjogabinet.model.service.CrudService;

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
		hypothesis = ifIdNullGetNewHypothesis_orEditExisting(hypothesis);
		hypothesisRepository.save(hypothesis);
		return "redirect:/displaypatientscard/"+medicalHistory.getPatient().getId();
	}

	@Override
	public String editForm(Model model, Long id) {
		Hypothesis hypothesis = hypothesisRepository.findOne(id);
		model.addAttribute("hypothesis", hypothesis);
		return "addhypothesis";
	}
	private Hypothesis ifIdNullGetNewHypothesis_orEditExisting(Hypothesis hypothesis) {
		if (hypothesis.getId() != null) {
			Hypothesis existingHypothesis= hypothesisRepository.findOne(hypothesis.getId());
			existingHypothesis.setDescription(hypothesis.getDescription());
			return existingHypothesis;
		}
		return hypothesis;
	}

	@Override
	public String deleteForm(Model model, Long id) {
		Hypothesis hypothesis = hypothesisRepository.findOne(id);
		model.addAttribute("hypothesis", hypothesis);
		return "deleteconfirmation";
	}

	@Override
	public String deleteFormConfirmation(Model model, Long id) {
		Hypothesis hypothesis = hypothesisRepository.findOne(id);
		hypothesisRepository.delete(hypothesis);
		return "redirect:/displaypatientscard/"+hypothesis.getMedicalHistory().getPatient().getId();
	}

}
