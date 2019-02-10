package pl.fizjogabinet.model.service;

import org.springframework.stereotype.Service;

import pl.fizjogabinet.model.entity.User;

@Service
public interface UserService {

	public void save(User user);
	public User findByUserName(String username);
	public void changePassword(User user);

}
