package ainalyp.kein.emaena;

import ainalyp.kein.emaena.Student.Student;
import ainalyp.kein.emaena.Student.StudentRepositary;
import ainalyp.kein.emaena.Student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableReactiveWebApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EmaenaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void studentGetParamChecker() {
        Student s = new Student("Beigut", "beisenkhan1@gmail.com");

        Assertions.assertEquals("Beigut", s.getName());
    }

    @Test
    void studentSetParamChecker() {
        Student s = new Student();
        s.setEmail("hello@world.com");

        Assertions.assertEquals("hello@world.com", s.getEmail());
    }

}
