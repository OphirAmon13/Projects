package edu.yu.intro;

import java.util.Objects;
import java.util.UUID;

public class Patron {
	private String firstName;
	private String lastName;
	private String address;
	private UUID id;

	public Patron(String firstName, String lastName, String address) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new RuntimeException("First name cannot be null or empty.");
		}
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new RuntimeException("Last name cannot be null or empty.");
		}
		if (address == null || address.trim().isEmpty()) {
			throw new RuntimeException("Address cannot be null or empty.");
		}


		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = UUID.randomUUID();
		}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id.toString();
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}

		if(obj == null){
			return false;
		}

		if(getClass() != obj.getClass()){
			return false;
		}

		Patron otherPatron = (Patron) obj;

		return id.equals(otherPatron.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
	
