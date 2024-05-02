package lv.venta.seminars6.repo;

import lv.venta.seminars6.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepo extends CrudRepository<Course, Long> {
}
