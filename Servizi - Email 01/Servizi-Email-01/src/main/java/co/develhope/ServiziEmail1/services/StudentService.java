package co.develhope.ServiziEmail1.services;

import co.develhope.ServiziEmail1.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Ho poi creato lo Student service in cui ho creato una List di 4 studenti per simulare un db ed ho creato il metodo
 * getStudentById
 */
@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Alma", "Caciula", "almacaciulanegrea@gmail.com"),
            new Student("2", "Dave", "Nick", "davenickdailyobj@gmail.com"),
            new Student("3", "Giulio", "Verdi", "giulio@gmail.com"),
            new Student("4", "Giovanna", "Gialli", "giovanna@gmail.com")
    );

    public Student getStudentById(String userId) {
        Optional<Student> studentsFromDB = students.stream().filter(user -> user.getId().equals(userId)).findAny();
        if(studentsFromDB.isPresent()) return studentsFromDB.get();
        return null;
    }
}
