package yk.tut.Mongo_Rest.vehicle;

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
import yk.tut.Mongo_Rest.user.User;
import yk.tut.Mongo_Rest.user.UserSrv;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleCtrl {

	private VehicleSrv vehicleSrv;
	private UserSrv userSrv;
	
	public VehicleCtrl(VehicleSrv vehicleSrv, UserSrv userSrv) {
		this.vehicleSrv = vehicleSrv;
		this.userSrv = userSrv;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id){
		Vehicle vehicle = vehicleSrv.findById(id);
		if(vehicle==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(20, "Vehicle not found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		List<Vehicle> vehicles = vehicleSrv.findAll();
		if( vehicles.isEmpty() ) {
			return new ResponseEntity<ResponseError>(new ResponseError(21, "Vehicle collection is empty."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> findByUser(@PathVariable Long userId){
		User user = userSrv.findById(userId);
		if(user==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(10, "User not found."), HttpStatus.NOT_FOUND);
		}
		Vehicle vehicle = vehicleSrv.findByUser(user);
		if(vehicle==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(20, "Vehicle not found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Vehicle vehicle){
		if(vehicle==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(22, "Request error, null object."), HttpStatus.BAD_REQUEST);
		}
		vehicleSrv.update(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	} 
	
	@PutMapping("user/{userId}/{vehicleId}")
	public ResponseEntity<?> setUserOnVehicle(@PathVariable Long vehicleId, @PathVariable Long userId) {
		User user = userSrv.findById(userId);
		if(user==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(10, "User not found."), HttpStatus.NOT_FOUND);
		}
		Vehicle vehicle = vehicleSrv.findById(vehicleId);
		if(vehicle==null) {
			return new ResponseEntity<ResponseError>(new ResponseError(20, "Vehicle not found."), HttpStatus.NOT_FOUND);
		}
		vehicle.setUser(user);
		vehicleSrv.update(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
}
