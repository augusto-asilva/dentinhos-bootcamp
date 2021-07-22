package meli.bootcamp.dentinhos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DateTimeException;
import java.util.Date;

@Entity
public class Diarys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_diary;
    private Date start_time;
    private Date ending_time;
    private int id_dentist;


    public Diarys() {
    }

    public Diarys(Date start_time, Date ending_time) {
        this.start_time = start_time;
        this.ending_time = ending_time;
    }

    public int getId_diary() {
        return id_diary;
    }

    public void setId_diary(int id_diary) {
        this.id_diary = id_diary;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnding_time() {
        return ending_time;
    }

    public void setEnding_time(Date ending_time) {
        this.ending_time = ending_time;
    }

    public int getId_dentist() {
        return id_dentist;
    }

    public void setId_dentist(int id_dentist) {
        this.id_dentist = id_dentist;
    }
}
