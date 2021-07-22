package meli.bootcamp.dentinhos.domain;

import javax.persistence.*;

@Entity
public class TurnStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn_status")
    private int id;
    private String name;
    private String description;

    public TurnStatus() {
    }

    public TurnStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_turn_status) {
        this.id = id_turn_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



