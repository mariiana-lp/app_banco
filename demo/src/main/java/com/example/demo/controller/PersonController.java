package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/persons")
public class PersonController {
    @Autowired
    private  PersonService personService;

    @GetMapping()
    public List<Person> getAll(){
        return personService.getPersons();
    }

    @GetMapping("/{personId}")
    public Optional<Person> geyById(@PathVariable("personId") Long personId){
        return personService.getPersonById(personId);
    }

    @PostMapping()
    public void savePerson(@RequestBody Person person){
        personService.saveOrUpdatePerson(person);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }
}
