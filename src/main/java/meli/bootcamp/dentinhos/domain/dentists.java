package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class dentists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dentist;

    @OneToOne
    private Users users;

    private String code_mp;

    @OneToMany
    List<Diarys> diarys;

    public dentists() {
    }

    public dentists(Users users, String code_mp, List<Diarys> diarys) {
        this.users = users;
        this.code_mp = code_mp;
        this.diarys = diarys;
    }

    public dentists(Users users, String code_mp) {
        this.users = users;
        this.code_mp = code_mp;
    }

    public int getId_dentist() {
        return id_dentist;
    }

    public void setId_dentist(int id_dentist) {
        this.id_dentist = id_dentist;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCode_mp() {
        return code_mp;
    }

    public void setCode_mp(String code_mp) {
        this.code_mp = code_mp;
    }

    public List<Diarys> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diarys> diarys) {
        this.diarys = diarys;
    }
}
