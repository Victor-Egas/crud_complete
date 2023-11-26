package com.dsw.cl3.control3dsw.repository;

import com.dsw.cl3.control3dsw.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "Select * from tb_person where document_number = :documentNumber", nativeQuery = true)
    Person getPersonbyDocumentNumber(String documentNumber);

}
