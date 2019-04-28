package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
    private PersonRepository personRepository;
	
	@ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/showAllPerson'>Show All Person</a></li>";
        html += " <li><a href='/searchPerson'>Search Person Name = 'David'</a></li>";
        html += " <li><a href='/insertPerson'>Insert Person Name = 'Kim Jisoo'</a></li>";
        html += " <li><a href='/deletePerson'>Delete Person Name = 'Jack Bauer'</a></li>";
        html += "</ul>";
        return html;
    }
	
	@ResponseBody
    @RequestMapping("/showAllPerson")
    public String showAllPerson() {
 
        Iterable<Person> person = this.personRepository.findAll();
 
        String html = "";
        if (person != null) {
        	for (Person emp : person) {
                html += emp + "<br>";
            }
		}
        
        html += "<br><a href='/'>Back To Home Page</a>";
        
        return html;
    }
	
	@ResponseBody
    @RequestMapping("/searchPerson")
    public String searchPerson() {
 
		String html = "Test Search Person Name = 'David'<br>";
        List<Person> person = this.personRepository.findByFirstNameOrLastName("David", "David");
 
        if (person != null) {
        	for (Person emp : person) {
                html += emp + "<br>";
            }
		}
        
        html += "<br><a href='/'>Back To Home Page</a>";
        
        return html;
    }
	
	@ResponseBody
    @RequestMapping("/insertPerson")
    public String insertPerson() {
		String html = "Test Insert Person Name = 'Kim Jisoo'<br>";
		Person person = new Person("Kim", "Jisoo");
        this.personRepository.save(person);
        html += "Inserted: " + person + "<br><br><a href='/'>Back To Home Page</a>";
        return html;
    }
	
	@ResponseBody
    @RequestMapping("/deletePerson")
    public String deletePerson() {
		String html = "Test delete Person Name = 'Jack Bauer'<br>";
		List<Person> person = this.personRepository.findByFirstNameAndLastName("Jack", "Bauer");
		if (person != null && !person.isEmpty()) {
			//this.personRepository.deleteById(person.get(0).getId());
			this.personRepository.delete(person.get(0));
		}
        html += "Deleted: 'Jack Bauer' <br><br><a href='/'>Back To Home Page</a> <br><br>";       
        return html;
    }
}
