package com.dsw.cl3.control3dsw.service;

import com.dsw.cl3.control3dsw.mapper.PersonMapper;
import com.dsw.cl3.control3dsw.model.Person;
import com.dsw.cl3.control3dsw.model.PersonDTO;
import com.dsw.cl3.control3dsw.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public PersonDTO savePerson(PersonDTO personToSave) {

        Person personEntity = PersonMapper.INSTANCE.personDTOToPerson(personToSave);
        return PersonMapper.INSTANCE.personToPersonDTO(repository.save(personEntity));
    }

    @Override
    public List<PersonDTO> getAllPersons() {

        return repository.findAll().stream()
                .map(person -> PersonMapper.INSTANCE.personToPersonDTO(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Optional<PersonDTO> optionalPerson = repository.findById(id)
                .map(person -> PersonMapper.INSTANCE.personToPersonDTO(person));
        return optionalPerson.orElse(null);
    }

    @Override
    public PersonDTO getPersonByDocumentNumber(String documentNumber) {
        Optional<PersonDTO> optionalPerson = Optional.ofNullable(repository.getPersonbyDocumentNumber(documentNumber))
                .map(person -> PersonMapper.INSTANCE.personToPersonDTO(person));
        return optionalPerson.orElse(null);
    }

    @Override
    public boolean deletePersonById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
