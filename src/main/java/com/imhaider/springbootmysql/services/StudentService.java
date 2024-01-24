package com.imhaider.springbootmysql.services;
import com.imhaider.springbootmysql.entity.Student;
import com.imhaider.springbootmysql.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(final Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(final Integer id) {
        Optional<Student> student= studentRepository.findById(id);
        if (student.isEmpty()){
            throw new RuntimeException("message: "+"The user was not found");
        }
        return student.get();
    }

    public Student updateStudent(final Integer id,final Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("message"+"Student was not found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(final Integer id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            studentRepository.deleteById(id);
            return "Student Deleted Successfully";
        }
        else{
            throw new RuntimeException("Message: The student was not found!");
        }

    }
}
