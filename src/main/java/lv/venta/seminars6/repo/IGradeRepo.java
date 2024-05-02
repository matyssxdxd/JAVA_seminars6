package lv.venta.seminars6.repo;

import lv.venta.seminars6.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface IGradeRepo extends CrudRepository<Grade, Long> {
}
