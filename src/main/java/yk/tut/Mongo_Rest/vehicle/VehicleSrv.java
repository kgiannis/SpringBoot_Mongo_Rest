package yk.tut.Mongo_Rest.vehicle;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import yk.tut.Mongo_Rest.user.User;

@Service
public class VehicleSrv {

	private VehicleRepository vehicleRepo;
	
	public VehicleSrv(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	public Vehicle findById(Long id) {
		return vehicleRepo.findById(id).orElse(null);
	}

	public List<Vehicle> findAll(){
		return vehicleRepo.findAll();
	}
	
	public Vehicle findByUser(User user) {
		return vehicleRepo.findByUser(user);
	}
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}
	
	public Vehicle update(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}
	
	public Page<Vehicle> getPageResults(int fromPage, int toPage){
		return vehicleRepo.findAll(PageRequest.of(fromPage, toPage));
	}
}
