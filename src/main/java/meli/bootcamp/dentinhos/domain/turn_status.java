package meli.bootcamp.dentinhos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class turn_status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turn_status;
    private String name;
    private String description;

    public turn_status() {
    }

    public turn_status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId_turn_status() {
        return id_turn_status;
    }

    public void setId_turn_status(int id_turn_status) {
        this.id_turn_status = id_turn_status;
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



