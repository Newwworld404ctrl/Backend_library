package com.example.demo2.dto;

import java.time.LocalDate;

public class AuthorDTO {

    private String name;
    private String nationality;
    private LocalDate birthDate;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}