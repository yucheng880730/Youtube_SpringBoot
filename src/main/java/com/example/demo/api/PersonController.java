package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// define the path
@RequestMapping("api/v1/person")
@RestController
// controller層負責具體業務模塊流程控制，此層要調用service層的接口來控制業務流程
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    // @RequestBody will turn the postman json object into a person
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    // the actual method that will serve as the get request
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    // for actual id in the path
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }

}
