package pl.fizjogabinet.model.serviceImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.fizjogabinet.model.service.SecurityContextService;
@Service
public class SecurityContextServiceImpl implements SecurityContextService {

	@Override
	public String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();		
	}

}
