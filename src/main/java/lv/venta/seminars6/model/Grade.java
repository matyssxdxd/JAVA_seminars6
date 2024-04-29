package lv.venta.seminars6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idg")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idg;

    @Column(name = "Grvalue")
    @Min(value = 0)
    @Max(value = 10)
    private int grvalue;

    @ManyToOne
    @JoinColumn(name = "Idc")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "Ids")
    private Student student;

    public Grade(int grvalue, Course course, Student student) {
        setGrvalue(grvalue);
        setCourse(course);
        setStudent(student);
    }
}
