package ainalyp.kein.emaena.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepositary studentRepositary;

    @Autowired
    public StudentService(StudentRepositary studentRepositary) {
        this.studentRepositary = studentRepositary;
    }

    public List<Student> getStudents() {
        return studentRepositary.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepositary
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already in database");
        }
        studentRepositary.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepositary.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("No such Student");
        }
        studentRepositary.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepositary.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("No Such Student!"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepositary.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("Email is already in use!");
            }
            student.setEmail(email);
        }
    }
}
