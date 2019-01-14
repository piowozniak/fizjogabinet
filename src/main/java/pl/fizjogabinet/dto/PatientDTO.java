package pl.fizjogabinet.dto;

import pl.fizjogabinet.entity.Patient;
import pl.fizjogabinet.entity.Visit;

public class PatientDTO {
	
	private Patient patient;
	private Visit visit;
	
	public PatientDTO() {
		super();
	}
	
	public PatientDTO(Patient patient) {
		super();
		this.patient = patient;
	}

	public PatientDTO(Patient patient, Visit visit) {
		super();
		this.patient = patient;
		this.visit = visit;		
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}
