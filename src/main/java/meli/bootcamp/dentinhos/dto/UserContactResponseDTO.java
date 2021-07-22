package meli.bootcamp.dentinhos.dto;

import meli.bootcamp.dentinhos.domain.User;

import javax.persistence.Column;
import java.time.LocalDate;

public class UserContactResponseDTO {
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthDate;
    private String phone;
    private String email;

    public UserContactResponseDTO() {
    }

    public UserContactResponseDTO(String name, String lastName, String dni, LocalDate birthDate, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public UserContactResponseDTO(User user) {
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.dni = user.getDni();
        this.birthDate = user.getBirthDate();
        this.phone = user.getPhone();
        this.email = user.getEmail();
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
