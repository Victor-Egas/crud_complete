package com.dsw.cl3.control3dsw.model;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;


public class PersonDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @NotEmpty
    private String name;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @NotEmpty
    private String lastName;

    @Size(min = 8, max = 8, message = "El número de documento debe tener 8 dígitos")
    private String documentNumber;


    @Pattern(regexp = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$", message = "El formato del correo no es válido")
    private String address;

    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private LocalDate birthDate;

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
