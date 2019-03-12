package pl.fizjogabinet.model.dto;

import java.util.List;

import pl.fizjogabinet.model.entity.Hypothesis;
import pl.fizjogabinet.model.entity.MedicalHistory;

public class MedicalHistoryDTO {
	
	private String flagColor;
	private boolean displayMedicalHistory;
	private MedicalHistory medicalHistory;
	

	public MedicalHistoryDTO(MedicalHistory medicalHistory) {
		super();
		this.medicalHistory = medicalHistory;
		this.flagColor = setColor(medicalHistory);
	}
	
	private String setColor(MedicalHistory medicalHistory) {
		if (medicalHistory.getFlag().equals("R")) {
			return "alert alert-danger";
		} else if (medicalHistory.getFlag().equals("Y")) {
			return "alert alert-warning";
		} else {
			return "alert alert-success";
		}

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

	public String getFlagColor() {
		return flagColor;
	}
	

}
