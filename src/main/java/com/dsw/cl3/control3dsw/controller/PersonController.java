package com.dsw.cl3.control3dsw.controller;

import com.dsw.cl3.control3dsw.model.Person;
import com.dsw.cl3.control3dsw.model.PersonDTO;
import com.dsw.cl3.control3dsw.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonService service;
    @PostMapping
    public ResponseEntity<PersonDTO> savePerson( @Validated @RequestBody PersonDTO personToSave) {
        PersonDTO savedPerson = service.savePerson(personToSave);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> persons = service.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return Optional.ofNullable(service.getPersonById(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<PersonDTO> getPersonByDocumentNumber(@RequestParam String documentNumber) {
        return Optional.ofNullable(service.getPersonByDocumentNumber(documentNumber))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        return service.deletePersonById(id)
                ? ResponseEntity.ok("User deleted successfully")
                : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @Validated @RequestBody PersonDTO updatedPerson) {
        return Optional.ofNullable(service.getPersonById(id))
                .map(existingPerson -> {
                    existingPerson.setName(updatedPerson.getName());
                    existingPerson.setLastName(updatedPerson.getLastName());
                    existingPerson.setDocumentNumber(updatedPerson.getDocumentNumber());
                    existingPerson.setAddress(updatedPerson.getAddress());
                    existingPerson.setBirthDate(updatedPerson.getBirthDate());

                    PersonDTO updated = service.savePerson(existingPerson);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
