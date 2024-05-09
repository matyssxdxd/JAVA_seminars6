package lv.venta.seminars6.service.impl;

import lv.venta.seminars6.model.Grade;
import lv.venta.seminars6.repo.ICourseRepo;
import lv.venta.seminars6.repo.IGradeRepo;
import lv.venta.seminars6.repo.IStudentRepo;
import lv.venta.seminars6.service.IGradeFilterService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService {

    private static final String ERROR_MSG = "ID should be positive";

    private final IStudentRepo studentRepo;
    private final IGradeRepo gradeRepo;
    private final ICourseRepo courseRepo;

    @Autowired
    public GradeFilterServiceImpl(IStudentRepo studentRepo, IGradeRepo gradeRepo, ICourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.gradeRepo = gradeRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
        if (id <= 0) throw new ObjectNotFoundException(id, ERROR_MSG);
        if (!studentRepo.existsById(id)) throw new ObjectNotFoundException(id, ERROR_MSG);

        ArrayList<Grade> result = gradeRepo.findByStudentIds(id);

        if (result.isEmpty()) throw new ObjectNotFoundException(id, "There are no grades with this student ID");

        return result;
    }

    @Override
    public ArrayList<Grade> selectFailedGrades() throws Exception {
        ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);

        if (result.isEmpty()) throw new ObjectNotFoundException(result, "There are no failed grades");

        return result;
    }

    @Override
    public float calculateAVGGradeInCourseId(long id) throws Exception {
        if (id <= 0) throw new ObjectNotFoundException(id, ERROR_MSG);
        if (!courseRepo.existsById(id)) throw new ObjectNotFoundException(id, ERROR_MSG);

        return gradeRepo.calculateAVGGradeByCourseId(id);
    }
}
