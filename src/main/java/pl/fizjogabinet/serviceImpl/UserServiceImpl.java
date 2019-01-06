package pl.fizjogabinet.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.fizjogabinet.entity.Role;
import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.repository.RoleRepository;
import pl.fizjogabinet.repository.UserRepository;
import pl.fizjogabinet.service.UserService;

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
		user.setStatus("N");
        userRepository.save(user);		
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
