package pl.fizjogabinet.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AttachementService {
	String upload(Model model, Long id, MultipartFile file) throws SerialException, SQLException;
	void download(Model model, Long id,HttpServletResponse response) throws IOException, SQLException;
	String remove(Model model, Long id);
	String removeConfirm(Model model, Long id);
}
