package pl.fizjogabinet.service;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.Visit;

@Service
public interface CrudService<T> {
	
	String addForm(Model model, Long id);
	String addFormConfirmation(Model model, T t) throws SerialException, SQLException;

	
}
