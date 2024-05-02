package lv.venta.seminars6.service.impl;

import lv.venta.seminars6.model.Course;
import lv.venta.seminars6.model.Grade;
import lv.venta.seminars6.repo.ICourseRepo;
import lv.venta.seminars6.repo.IGradeRepo;
import lv.venta.seminars6.repo.IStudentRepo;
import lv.venta.seminars6.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService {

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IGradeRepo gradeRepo;

    @Autowired
    private ICourseRepo courseRepo;

    @Override
    public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
        if (id <= 0) throw new Exception("ID should be positive");
        if (!studentRepo.existsById(id)) throw new Exception("Student with ID " + id + " does not exist");

        ArrayList<Grade> result = gradeRepo.findByStudentIds(id);

        if (result.isEmpty()) throw new Exception("There are no grades with this student ID");

        return result;
    }

    @Override
    public ArrayList<Grade> selectFailedGrades() throws Exception {
        ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);

        if (result.isEmpty()) throw new Exception("There are no failed grades");

        return result;
    }

    @Override
    public float calculateAVGGradeInCourseId(long id) throws Exception {
        if (id <= 0) throw new Exception("ID should be positive");
        if (!courseRepo.existsById(id)) throw new Exception("Course with ID " + id + " does not exist");

        return gradeRepo.calculateAVGGradeByCourseId(id);
    }
}
