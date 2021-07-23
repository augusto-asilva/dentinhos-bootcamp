package meli.bootcamp.dentinhos.domain;

import meli.bootcamp.dentinhos.dto.DiaryDTO;
import meli.bootcamp.dentinhos.dto.PatientDTO;
import meli.bootcamp.dentinhos.dto.PendingTurnDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer id;

    private LocalDate days;

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

    public Turn(LocalDate days) {
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_turm) {
        this.id = id_turm;
    }

    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
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

    public PendingTurnDTO castToPendingTurnDTO() {
        var diaryDTO = new DiaryDTO(this.diary.getStartTime(), this.diary.getEndingTime());
        var patientDTO =
                new PatientDTO(this.patient.getName(), this.patient.getLastName(), this.patient.getBirthDate(), this.patient.getPhone(), this.patient.getEmail());

        return new PendingTurnDTO(this.days, this.turnStatus.getName(),patientDTO, diaryDTO);

    }
}
