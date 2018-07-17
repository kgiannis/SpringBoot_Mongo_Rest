package yk.tut.Mongo_Rest.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yk.tut.Mongo_Rest.errors.ResponseError;

@RestController
@RequestMapping("/api/user")
public final class UserCtrl {

	private UserSrv userSrv;
	
	public UserCtrl(UserSrv userSrv) {
		this.userSrv = userSrv;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id){
		User user = userSrv.findById(id);
		if(user == null) {
			return new ResponseEntity<ResponseError>(new ResponseError(10, "User not found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		List<User> users = userSrv.findAll();
		if(users == null) {
			return new ResponseEntity<ResponseError>(new ResponseError(11, "User collection is empty."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody User user){
		if(user == null) {
			return new ResponseEntity<ResponseError>(new ResponseError(12, "Request error, null object."), HttpStatus.BAD_REQUEST);
		}
		userSrv.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
