package meli.bootcamp.dentinhos.dto;

import java.time.LocalDate;

public class PatientDTO {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String email;

    public PatientDTO() {
    }

    public PatientDTO(String name, String lastName, LocalDate birthDate, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
