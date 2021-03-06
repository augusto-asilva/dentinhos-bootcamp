package meli.bootcamp.dentinhos.domain;
import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer id;
    private String street;
    private String district;

    public Address() {
    }

    public Address(String street, String district) {
        this.street = street;
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id_address) {
        this.id = id_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
