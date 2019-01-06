package pl.fizjogabinet.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.fizjogabinet.entity.User;

@Service
public interface AdminService {
	
	String displayUsers(Model model); 
	String dislayUserToActivateOrDeactivate(Model model, long id);
	String confirmUser(Model model, User user);
	String editUser(Model model, long id ) ;
	String editUserConfirmation(Model model, User user);
	String giveOrganizerRole(Model model, long id);

}
