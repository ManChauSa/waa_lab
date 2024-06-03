package lab_1.controller;

import lab_1.entity.dto.response.CourseDto;
import lab_1.entity.dto.response.StudentDto;
import lab_1.service.Interface.StudentService;
import lab_1.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @GetMapping
    public List<StudentDto> getAll(){
        return  studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable int id){
        return  studentService.getStudentById(id);
    }

    @GetMapping("/{id}/course")
    public List<CourseDto> getAllCourseOfStudent(@PathVariable int id){
        return  studentService.getAllCourseOfStudentById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping// POST api/v1/products
    public void save(@RequestBody StudentDto p){
    studentService.saveStudent(p);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody StudentDto p) {
        studentService.update(id,p);
    }

}
