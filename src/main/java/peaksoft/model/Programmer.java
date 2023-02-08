package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enams.Status;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "programmers")
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "date_of_berth")
    private LocalDate dateOfBirth;
    private Status status;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH })
    private List<Project> project;
    @OneToOne(mappedBy = "programmer",cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Address location;

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status, List<Project> project, Address location) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.project = project;
        this.location = location;
    }

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }
}
