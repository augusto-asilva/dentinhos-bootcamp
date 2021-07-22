package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer id;

    private Date days;

    @ManyToOne
    @JoinColumn(name = "id_diary")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_turn_status")
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private User patient;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }
}
