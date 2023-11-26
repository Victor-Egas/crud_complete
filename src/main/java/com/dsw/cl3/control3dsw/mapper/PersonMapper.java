package com.dsw.cl3.control3dsw.mapper;

import com.dsw.cl3.control3dsw.model.Person;
import com.dsw.cl3.control3dsw.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);

}
