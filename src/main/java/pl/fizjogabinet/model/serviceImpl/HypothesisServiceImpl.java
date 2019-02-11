package pl.fizjogabinet.model.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.dto.FizjoGabinetObject;
import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.enums.FizjoGabinetFactoryE;
import pl.fizjogabinet.model.repository.HypothesisRepository;
import pl.fizjogabinet.model.repository.MedicalHistoryRepository;
import pl.fizjogabinet.model.service.CrudService;

@Service("hypothesis")
public class HypothesisServiceImpl implements CrudService<Hypothesis> {
	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	@Autowired
	private HypothesisRepository hypothesisRepository;
	private MedicalHistory medicalHistory;
	private static final String HYPOTHESIS = "hypothesis";

	@Override
	public String addForm(Model model, Long id) {
		FizjoGabinetObject<Hypothesis> hypothesisObject = new FizjoGabinetObject<Hypothesis>(new Hypothesis());
		Hypothesis hypothesis = hypothesisObject.getFizjoObject();	
		this.medicalHistory = medicalHistoryRepository.findOne(id);
		hypothesis.setMedicalHistory(medicalHistory);
		model.addAttribute("hypothesis", hypothesis);
		return "addhypothesis";
	}

	@Override
	public String addFormConfirmation(Model model, Hypothesis hypothesis) {
		hypothesis = ifIdNullGetNewHypothesis_orEditExisting(hypothesis);
		hypothesisRepository.save(hypothesis);
		Long patientId = medicalHistoryRepository.findOne(hypothesis.getMedicalHistory().getId()).getPatient().getId();
		return "redirect:/displaypatientscard/"+patientId;
	}

	@Override
	public String editForm(Model model, Long id) {
		Hypothesis hypothesis = hypothesisRepository.findOne(id);
		model.addAttribute("hypothesis", hypothesis);
		return "addhypothesis";
	}
	private Hypothesis ifIdNullGetNewHypothesis_orEditExisting(Hypothesis hypothesis) {
		Optional<Long> hypothesisId = Optional.ofNullable(hypothesis.getId());
		if (hypothesisId.isPresent()) {
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
//		MedicalHistory medicalHistory = medicalHistoryRepository.findOne(hypothesis.getMedicalHistory().getId());
//		medicalHistory.getHypothesis().remove(hypothesis);
//		medicalHistoryRepository.save(medicalHistory);
		hypothesisRepository.delete(hypothesis);
		return "redirect:/displaypatientscard/"+hypothesis.getMedicalHistory().getPatient().getId();
	}

}
