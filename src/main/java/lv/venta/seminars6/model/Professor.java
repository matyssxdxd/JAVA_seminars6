package lv.venta.seminars6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z]+")
    @Column(name = "Name")
    private String name;

    @NotNull
    @Size(min = 2, max = 40)
    @Pattern(regexp = "[A-Z]{1}[a-z]+")
    @Column(name = "Surname")
    private String surname;

    @NotNull
    @Column(name = "Degree")
    private Degree degree;

    @OneToOne(mappedBy = "professor")
    @ToString.Exclude
    private Course course;

    public Professor(String name, String surname, Degree degree) {
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }
}
