package yk.tut.Mongo_Rest.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public final class UserSrv {

	private UserRepository userRepo;
	
	public UserSrv(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
}
