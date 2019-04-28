package com.example.demo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByFirstName(@Param("name") String name);
	List<Person> findByLastName(@Param("name") String name);

	List<Person> findByFirstNameOrLastName(@Param("fname") String firstName,@Param("lname") String lastName);
	List<Person> findByFirstNameAndLastName(@Param("fname") String firstName,@Param("lname") String lastName);

}
