package meli.bootcamp.dentinhos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class turms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turm;
    private Date days;
    private int id_diary;
    private int id_turn_status;
    private int id_patient;

    public turms() {
    }

    public turms(Date days) {
        this.days = days;
    }

    public int getId_turm() {
        return id_turm;
    }

    public void setId_turm(int id_turm) {
        this.id_turm = id_turm;
    }

    public Date getDays() {
        return days;
    }

    public void setDays(Date days) {
        this.days = days;
    }

    public int getId_diary() {
        return id_diary;
    }

    public void setId_diary(int id_diary) {
        this.id_diary = id_diary;
    }

    public int getId_turn_status() {
        return id_turn_status;
    }

    public void setId_turn_status(int id_turn_status) {
        this.id_turn_status = id_turn_status;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }
}
