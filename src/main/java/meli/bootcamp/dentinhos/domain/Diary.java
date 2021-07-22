package meli.bootcamp.dentinhos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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


    public Diary() {
    }

    public Diary(LocalDateTime startTime, LocalDateTime endingTime) {
        this.startTime = startTime;
        this.endingTime = endingTime;
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
}
