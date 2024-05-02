package lv.venta.seminars6.repo;

import lv.venta.seminars6.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ICourseRepo extends CrudRepository<Course, Long> {
    ArrayList<Course> findByGradesStudentIds(long id);

    ArrayList<Course> findByProfessorIdp(long id);

    ArrayList<Course> findByCp(int cp);
}
