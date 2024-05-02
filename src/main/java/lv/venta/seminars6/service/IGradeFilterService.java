package lv.venta.seminars6.service;

import lv.venta.seminars6.model.Grade;
import lv.venta.seminars6.model.Student;

import java.util.ArrayList;

public interface IGradeFilterService {

    ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;

    ArrayList<Grade> selectFailedGrades() throws Exception;

    float calculateAVGGradeInCourseId(long id) throws Exception;
}
