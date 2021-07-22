package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private int id;

    private Date days;

    @Column(name = "id_diary")
    private int idDiary;

    @Column(name = "id_turn_status")
    private int idTurnStatus;

    @Column(name = "id_patient")
    private int idPatient;

    public Turn() {
    }

    public Turn(Date days) {
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_turm) {
        this.id = id_turm;
    }

    public Date getDays() {
        return days;
    }

    public void setDays(Date days) {
        this.days = days;
    }

    public int getIdDiary() {
        return idDiary;
    }

    public void setIdDiary(int id_diary) {
        this.idDiary = id_diary;
    }

    public int getIdTurnStatus() {
        return idTurnStatus;
    }

    public void setIdTurnStatus(int id_turn_status) {
        this.idTurnStatus = id_turn_status;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int id_patient) {
        this.idPatient = id_patient;
    }
}
