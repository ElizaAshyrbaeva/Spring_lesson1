package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    private peaksoft.enams.Country country;
    @OneToMany(mappedBy = "country",cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.EAGER)
    List<Address> addressList;

    public Country(String description, peaksoft.enams.Country country, List<Address> addressList) {
        this.description = description;
        this.country = country;
        this.addressList = addressList;
    }

    public Country(String description, peaksoft.enams.Country country) {
        this.description = description;
        this.country = country;
    }
}
