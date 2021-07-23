package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dentists")
public class Dentist extends User {

    @Column(name = "code_mp")
    private String codeMp;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private List<Diary> diaries;

    public Dentist() {
    }

    public Dentist(String codeMp, List<Diary> diaries) {
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public Dentist(String codeMp) {
        this.codeMp = codeMp;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String code_mp) {
        this.codeMp = code_mp;
    }

    public List<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = diaries;
    }
}
