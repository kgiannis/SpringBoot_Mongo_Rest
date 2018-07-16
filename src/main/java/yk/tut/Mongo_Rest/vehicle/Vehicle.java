package yk.tut.Mongo_Rest.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import yk.tut.Mongo_Rest.user.User;

@Document(collection = "vehicle")
public class Vehicle {

	@Id
	private Long id;
	private String plateNumber;
	private String manufacturer;
	
	@DBRef
	private User user;
	
	public Vehicle() {}
	
	public Vehicle(Long id, String plateNumber, String manufacturer) {
		this.id = id;
		this.plateNumber = plateNumber;
		this.manufacturer = manufacturer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", plateNumber=" + plateNumber + ", manufacturer=" + manufacturer + "]";
	}
	
}
