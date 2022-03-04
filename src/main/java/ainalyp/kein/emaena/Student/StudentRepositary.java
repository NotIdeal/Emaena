package ainalyp.kein.emaena.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositary
        extends JpaRepository<Student, Long> {

    //@Query("SELECT s FROM Student s WHERE s.email = ?1");
    Optional<Student> findStudentByEmail(String email);

}
