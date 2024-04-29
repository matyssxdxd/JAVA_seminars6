package lv.venta.seminars6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idc")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idc;

    @NotNull
    @Size(min = 4, max = 50)
    @Pattern(regexp = "[A-Za-z :]+")
    @Column(name = "Title")
    private String title;

    @Min(value = 0)
    @Max(value = 20)
    @Column(name = "Cp")
    private int cp;

    @OneToOne
    @JoinColumn(name = "Idp")
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private Collection<Grade> grades;

    public Course(String title, int cp, Professor professor) {
        setTitle(title);
        setCp(cp);
        setProfessor(professor);
    }

}
