package yk.tut.Mongo_Rest.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import yk.tut.Mongo_Rest.user.User;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, Long> {

	public List<Vehicle> findByUser(User user);
}
