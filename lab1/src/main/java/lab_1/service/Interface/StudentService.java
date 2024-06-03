package lab_1.service.Interface;

import lab_1.entity.Course;
import lab_1.entity.dto.response.CourseDto;
import lab_1.entity.dto.response.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent();
    StudentDto getStudentById(int id);
    void saveStudent(StudentDto student);
    void updateStudent(StudentDto student);
    void deleteStudent(int id);
    List<CourseDto> getAllCourseOfStudentById(int studentId);

}
