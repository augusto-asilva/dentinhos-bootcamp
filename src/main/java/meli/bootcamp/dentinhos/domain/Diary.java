package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private int id;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "ending_time")
    private Date endingTime;

    @Column(name = "id_dentist")
    private int idDentist;


    public Diary() {
    }

    public Diary(Date startTime, Date endingTime) {
        this.startTime = startTime;
        this.endingTime = endingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_diary) {
        this.id = id_diary;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date start_time) {
        this.startTime = start_time;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date ending_time) {
        this.endingTime = ending_time;
    }

    public int getIdDentist() {
        return idDentist;
    }

    public void setIdDentist(int id_dentist) {
        this.idDentist = id_dentist;
    }
}
