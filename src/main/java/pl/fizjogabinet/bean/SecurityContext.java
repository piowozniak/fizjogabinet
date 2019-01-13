package pl.fizjogabinet.bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pl.fizjogabinet.entity.Role;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.repository.UserRepository;

//@Component
public class SecurityContext {
		
//	private static UserRepository userRepository;
//	private final static String ADMIN = "ROLE_ADMIN";
//	private final static String ORGANIZER= "ROLE_ORGANIZER";
//	private final static String USER = "ROLE_USER";
//	
//	@Autowired	
//	private SecurityContext(UserRepository userRepository) {
//		super();
//		SecurityContext.userRepository = userRepository;
//	}
//
//	public static String getUsername() {
//		return SecurityContextHolder.getContext().getAuthentication().getName();
//	}
//	
//	public static User getUser() {
//		return userRepository.findByUsername(getUsername());
//	}
//
//	public static Set<Role> getUserRoles() {
//		return getUser().getRoles();
//	}
//	
//	public static long getUserId() {
//		return getUser().getId();
//	}
//	
//	public static String loggedUserByRole() {
//		if(getUserRoles().stream().anyMatch(r -> r.getName().equals(ADMIN))) {
//			return ADMIN;
//		} else if (getUserRoles().stream().anyMatch(r -> r.getName().equals(ORGANIZER))) {
//			return ORGANIZER;
//		}
//		return USER;
//	}
	

}
