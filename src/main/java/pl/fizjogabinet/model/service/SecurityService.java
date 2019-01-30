package pl.fizjogabinet.model.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	
	public String findLoggedInUserName();
	public void autologin(String username, String password );

}
