package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentitst")
    private int id;

    @OneToOne
    private User user;

    @Column(name = "code_mp")
    private String codeMp;

    @OneToMany
    List<Diary> diaries;

    public Dentist() {
    }

    public Dentist(User user, String codeMp, List<Diary> diaries) {
        this.user = user;
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public Dentist(User user, String codeMp) {
        this.user = user;
        this.codeMp = codeMp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_dentist) {
        this.id = id_dentist;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String code_mp) {
        this.codeMp = code_mp;
    }

    public List<Diary> getDiarys() {
        return diaries;
    }

    public void setDiarys(List<Diary> diaries) {
        this.diaries = diaries;
    }
}
