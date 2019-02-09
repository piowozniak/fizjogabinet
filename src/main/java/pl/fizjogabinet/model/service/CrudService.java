package pl.fizjogabinet.model.service;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.model.entity.Visit;

@Service
public interface CrudService<T> {
	
	String addForm(Model model, Long id);
	String addFormConfirmation(Model model, T t) throws SerialException, SQLException;
	String editForm(Model model, Long id);
	String deleteForm(Model model, Long id);
	String deleteFormConfirmation(Model model, Long id);
	
}
