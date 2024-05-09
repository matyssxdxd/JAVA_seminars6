package lv.venta.seminars6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(name = "CourseProfessorTable",
    joinColumns = @JoinColumn(name="Idc"),
    inverseJoinColumns = @JoinColumn(name="Idp"))
    @ToString.Exclude
    private Collection<Professor> professors = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Collection<Grade> grades;

    public Course(String title, int cp, Professor ... professors) {
        setTitle(title);
        setCp(cp);
        for (Professor professor : professors) {
            addProfessor(professor);
        }
    }

    public void addProfessor(Professor professor) {
        if (!professors.contains(professor)) {
            professors.add(professor);
        }
    }

    public void deleteProfessor(Professor professor) {
        professors.remove(professor);
    }

}
