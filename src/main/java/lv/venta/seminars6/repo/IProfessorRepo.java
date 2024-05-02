package lv.venta.seminars6.repo;

import lv.venta.seminars6.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface IProfessorRepo extends CrudRepository<Professor, Long> {
}
