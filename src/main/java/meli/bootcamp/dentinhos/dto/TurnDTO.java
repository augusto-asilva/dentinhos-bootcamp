package meli.bootcamp.dentinhos.dto;

import meli.bootcamp.dentinhos.domain.TurnStatus;
import meli.bootcamp.dentinhos.domain.User;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class TurnDTO {

    private Integer id;

    private LocalDate days;

    private TurnStatus turnStatus;

    private UserDTO patient;

    public TurnDTO() {
    }

    public TurnDTO(Integer id, LocalDate days, TurnStatus turnStatus, UserDTO patient) {
        this.id = id;
        this.days = days;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
        this.days = days;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public UserDTO getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = new ModelMapper().map(patient, UserDTO.class);
    }
}
