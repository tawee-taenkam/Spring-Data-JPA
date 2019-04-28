package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter @Setter
	private String firstName;
	
	@Getter @Setter
	private String lastName;

	protected Person() {}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
    public String toString() {
		/*
		 * return String.format( "Person[id=%d, firstName='%s', lastName='%s']", id,
		 * firstName, lastName);
		 */
        return String.format(
                "%d = %s %s",
                id, firstName, lastName);
    }
}
