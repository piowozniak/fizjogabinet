package pl.fizjogabinet.model.serviceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import pl.fizjogabinet.model.dto.AttachementDTO;
import pl.fizjogabinet.model.dto.FizjoGabinetObject;
import pl.fizjogabinet.model.entity.Attachement;
import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.Visit;
import pl.fizjogabinet.model.enums.FizjoGabinetFactoryE;
import pl.fizjogabinet.model.repository.AttachementRepository;
import pl.fizjogabinet.model.repository.PatientRepository;
import pl.fizjogabinet.model.service.AttachementService;
import pl.fizjogabinet.model.service.CrudService;

@Service("attachement")
public class AttachementServiceImpl implements AttachementService{

	@Autowired
	private PatientRepository patientRepository; 
	@Autowired
	private AttachementRepository attachementRepository;
	private static final String ATTACHMENT = "attachment";

	@Override
	public String upload(Model model, Long id, MultipartFile file) throws SerialException, SQLException {
		Patient patient = patientRepository.findOne(id);
		FizjoGabinetObject<Attachement> fileObject = new FizjoGabinetObject<Attachement>(new Attachement());
		Attachement attachement = fileObject.getFizjoObject();
		attachement.setPatient(patient);
		attachement.setContentType(file.getContentType());
		attachement.setFileName(file.getOriginalFilename());
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Blob blob = new SerialBlob(bytes);
			attachement.setFile(blob);
			attachementRepository.save(attachement);			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return "redirect:/displaypatientscard/"+patient.getId();
	}

	@Override
	public void download(Model model, Long id, HttpServletResponse response) throws IOException, SQLException {
		Attachement file = attachementRepository.findOne(id);
	    try {
	    	int blobLength = (int) file.getFile().length();  
	    	byte[] blobAsBytes = file.getFile().getBytes(1, blobLength);
	        response.setContentType(file.getContentType());
	        response.setHeader("Content-Disposition", "attachment; filename=\""+ file.getFileName() +"\"");
	        response.setContentLength(blobAsBytes.length);
	        FileCopyUtils.copy(blobAsBytes, response.getOutputStream());

	    } catch (SQLException e) {
	        System.out.println(e.toString());
	    } catch (IOException e) {
	        System.out.println(e.toString());
	    }
//        response.setContentType("APPLICATION/OCTET-STREAM");
//        response.addHeader("Content-Disposition", "attachment; filename=" + file.getFileName());
//        OutputStream out = response.getOutputStream();
//        out.write(file.getFile().getBytes(1, (int) file.getFile().length()));
    }

	@Override
	public String remove(Model model, Long id) {
		Attachement file = attachementRepository.findOne(id);
		model.addAttribute("file", file);
		return "deleteconfirmation";
	}

	@Override
	public String removeConfirm(Model model, Long id) {
		Attachement file = attachementRepository.findOne(id);
		attachementRepository.delete(file);
		return "redirect:/displaypatientscard/"+file.getPatient().getId();
	}

}
