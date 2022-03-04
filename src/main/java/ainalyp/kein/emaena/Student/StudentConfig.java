package ainalyp.kein.emaena.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepositary repositary) {
        return args -> {
            Student Beigut = new Student(
                1L,
                "Beigut",
                "beisenkhan1@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 25)
            );
            Student Samal = new Student(
                    "Samal",
                    "samal@gmail.com",
                    LocalDate.of(1997, Month.AUGUST, 18)
            );

            repositary.saveAll(
                    List.of(Beigut, Samal)
            );
        };
    }
}
