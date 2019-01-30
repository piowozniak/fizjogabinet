package pl.fizjogabinet.model.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.fizjogabinet.model.entity.Role;
import pl.fizjogabinet.model.entity.User;
import pl.fizjogabinet.model.repository.RoleRepository;
import pl.fizjogabinet.model.repository.UserRepository;
import pl.fizjogabinet.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);		
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
