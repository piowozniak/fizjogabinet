package pl.fizjogabinet.model.dto;

import java.util.List;

import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;

public class MedicalHistoryDTO {
	
	private boolean displayMedicalHistory;
	private MedicalHistory medicalHistory;
	

	public MedicalHistoryDTO(MedicalHistory medicalHistory) {
		super();
		this.medicalHistory = medicalHistory;
	}

	public MedicalHistoryDTO() {
		super();
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public boolean isDisplayMedicalHistory() {
		return displayMedicalHistory;
	}

	public void setDisplayMedicalHistory(boolean displayMedicalHistory) {
		this.displayMedicalHistory = displayMedicalHistory;
	}

}