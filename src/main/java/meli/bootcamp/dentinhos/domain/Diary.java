package meli.bootcamp.dentinhos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private Integer id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "ending_time")
    private LocalDateTime endingTime;

    @ManyToOne
    @JoinColumn(name = "id_dentist")
    @JsonBackReference
    private Dentist dentist;

    @OneToMany(mappedBy = "diary")
    private List<Turn> turns;


    public Diary() {
    }

    public Diary(Integer id, LocalDateTime startTime, LocalDateTime endingTime, Dentist dentist, List<Turn> turns) {
        this.id = id;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
        this.turns = turns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_diary) {
        this.id = id_diary;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime start_time) {
        this.startTime = start_time;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime ending_time) {
        this.endingTime = ending_time;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}
