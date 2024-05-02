package lv.venta.seminars6.repo;

import lv.venta.seminars6.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Long> {
}
