package yk.tut.Mongo_Rest.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String surname;
	private String name;
	private Gender gender;
	
	public User() {}
	
	public User(Long id, String surname, String name, Gender gender) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.gender = gender;
	}
	
	public User(Long id, String surname, String name) {
		this.id = id;
		this.surname = surname;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", surname=" + surname + ", name=" + name + ", gender=" + gender + "]";
	}
	
	enum Gender{
		MALE, FEMALE;
	}

}
