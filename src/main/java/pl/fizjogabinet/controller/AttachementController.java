package pl.fizjogabinet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.fizjogabinet.model.service.AttachementService;

@Controller
@ComponentScan(basePackages="pl.fizjogabinet")
public class AttachementController {
	
	private final AttachementService attachementService;
	
	public AttachementController(@Qualifier("attachement") AttachementService attachementService) {
		this.attachementService = attachementService;
	}
	
	@PostMapping(path="/uploadFile/{id}")
	public String uploadFile(Model model, @PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws SerialException, SQLException {
	    return attachementService.upload(model, id, file);
	}
	
	@RequestMapping(path="/downloadFile/{id}")
	public void downloadFile(Model model, @PathVariable("id") Long id, HttpServletResponse response) throws IOException, SQLException {
		attachementService.download(model, id, response);
	}
	
	@GetMapping(path="/removeFile/{id}")
	public String removeFile(Model model, @PathVariable("id") Long id) {
		return attachementService.remove(model, id);
	}
	
	@PostMapping(path="/removeFile/{id}")
	public String removeFileConfirm(Model model, @PathVariable("id") Long id) {
		return attachementService.removeConfirm(model, id);
	}

}
