package lv.venta.seminars6.service.impl;

import lv.venta.seminars6.model.Course;
import lv.venta.seminars6.repo.ICourseRepo;
import lv.venta.seminars6.repo.IProfessorRepo;
import lv.venta.seminars6.repo.IStudentRepo;
import lv.venta.seminars6.service.ICourseFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService {

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IProfessorRepo professorRepo;

    @Override
    public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
        if (id <= 0) throw new Exception("ID should be positive");
        if (!studentRepo.existsById(id)) throw new Exception("Student with ID " + id + " does not exist");

        ArrayList<Course> result = courseRepo.findByGradesStudentIds(id);

        if (result.isEmpty()) throw new Exception("There are no courses with this student ID");

        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
        if (id <= 0) throw new Exception("ID should be positive");
        if (!professorRepo.existsById(id)) throw new Exception("Student with ID " + id + " does not exist");

        ArrayList<Course> result = courseRepo.findByProfessorIdp(id);

        if (result.isEmpty()) throw new Exception("There are no courses with this student ID");

        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
        if (cp < 0 || cp > 20) throw new Exception("CP must be between 0 and 20");

        ArrayList<Course> result = courseRepo.findByCp(cp);

        if (result.isEmpty()) throw new Exception("There are no courses with " + cp + " CP");

        return result;
    }
}
