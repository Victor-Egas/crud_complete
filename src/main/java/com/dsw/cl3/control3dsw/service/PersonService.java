package com.dsw.cl3.control3dsw.service;

import com.dsw.cl3.control3dsw.model.Person;
import com.dsw.cl3.control3dsw.model.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO savePerson(PersonDTO personToSave);

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO getPersonByDocumentNumber(String docuemntNumber);

    boolean deletePersonById(Long id);
}
