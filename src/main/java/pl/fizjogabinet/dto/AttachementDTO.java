package pl.fizjogabinet.dto;

import org.springframework.web.multipart.MultipartFile;

public class AttachementDTO {
	
	private MultipartFile file;
	private Long patientId;
	
	public AttachementDTO(MultipartFile file, Long patientId) {
		this.file = file;
		this.patientId = patientId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public Long getPatientId() {
		return patientId;
	}	

}
