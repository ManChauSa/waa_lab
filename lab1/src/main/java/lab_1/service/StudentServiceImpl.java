package lab_1.service;

import lab_1.entity.Course;
import lab_1.entity.Student;
import lab_1.entity.dto.response.CourseDto;
import lab_1.entity.dto.response.StudentDto;
import lab_1.helper.ListMapper;
import lab_1.repo.CourseRepo;
import lab_1.repo.StudentRepo;
import lab_1.service.Interface.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepo studentRepo;
    CourseRepo courseRepo;
    StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;
    @Override
    public List<StudentDto> getAllStudent() {
        return (List<StudentDto>) listMapper.mapList(studentRepo.findAll(),new StudentDto());
    }

    @Override
    public StudentDto getStudentById(int id) {
        return modelMapper.map(studentRepo.findById(id),StudentDto.class);
    }

    @Override
    public void saveStudent(StudentDto student) {
        studentRepo.save(modelMapper.map(student,Student.class));
    }

    @Override
    public void updateStudent(StudentDto student) {
        var studentById = studentRepo.findById(student.get().getStudentId());
        if (studentById.isPresent()) {
            studentRepo.save(modelMapper.map(student,Student.class));
        }
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<CourseDto> getAllCourseOfStudentById(int studentId) {
        var result = new ArrayList<CourseDto>();
        var courseIds = studentRepo.findAllCourseOfStudentById(studentId);
        for (Course course : courseRepo.findAll()){
            if(courseIds.contains(course.getCourseId())){
                result.add(modelMapper.map(course,CourseDto.class));
            }
        }
        return result;
    }
}
