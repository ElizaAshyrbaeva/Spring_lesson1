package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "region_name")
    private String regionName;
    private String street;
    private String homeNumber;
    @OneToOne(mappedBy = "address")
    private Programmer programmer;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;

    public Address(String regionName, String street, String homeNumber, Programmer programmer, Country country) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;
        this.programmer = programmer;
        this.country = country;
    }

    public Address(String regionName, String street, String homeNumber) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;
    }
}
