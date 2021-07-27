package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Data Access Object(DAO) pattern is a structural pattern that allows us to isolate
// the application/business layer from the persistence layer(usually relational DB)
// using an abstract API
public interface PersonDao {

    // insert person with id
    int insertPerson(UUID id, Person person);

    // insert person without id, and id randomly generated
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
