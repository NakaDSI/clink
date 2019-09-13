package app.clinkApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.clinkApi.model.User;
import app.clinkApi.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser() {

		return (List<User>) userRepository.findAll();
	}

	public User save(User user) {

		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	public User findUserByEmailPassword(String email, String password) {
	
		User u=userRepository.findUserByEmailPassword(email,password);
		return u;
	}

}
