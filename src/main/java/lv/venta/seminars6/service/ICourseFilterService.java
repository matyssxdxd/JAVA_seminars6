package lv.venta.seminars6.service;

import lv.venta.seminars6.model.Course;

import java.util.ArrayList;

public interface ICourseFilterService {

    ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;

    ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;

    ArrayList<Course> selectCoursesByCP(int cp) throws Exception;

}
