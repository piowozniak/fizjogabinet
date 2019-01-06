package pl.fizjogabinet.service;

import org.springframework.stereotype.Service;

import pl.fizjogabinet.entity.User;

@Service
public interface UserService {

	public void save(User user);
	public User findByUserName(String username);

}
