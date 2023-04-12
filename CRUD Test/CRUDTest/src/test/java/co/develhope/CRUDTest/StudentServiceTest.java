package co.develhope.CRUDTest;

import co.develhope.CRUDTest.entities.Student;
import co.develhope.CRUDTest.repositories.StudentRepository;
import co.develhope.CRUDTest.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Ho creato la classe StudentServiceTest e l'ho annotata come @SpringBootTest per far capire che faro dei test.
 * Ho importato StudentService e StudentRepository.
 */
@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Nel metodo checkStudentWorking ho creato un nuovo studente, ho creato poi il secondo studente salvandolo nella
     * repository e controllando che sia l'oggetto e l'id non siano nulli, ho creato il terzo studente uguale al
     * metodo setWorkingStudent a cui ho passato l'id dello studente e la condizione true, ho controllato che il terzo
     * non sia nullo, che il suo id non sia nullo e che la condizione sia True, ho creato infine il quarto studente
     * cercandolo nel database attraverso l'id, ho controllato che l'oggetto e l'id non siano nulli, e che il suo id
     * fosse uguale all'id del secondo studente e che la condizione si vera.
     * @throws Exception
     */
    @Test
    void checkStudentWorking() throws Exception {
        Student student = new Student();
        student.setWorking(true);
        student.setName("Alma");
        student.setSurname("Caciula");

        Student studentFromDB = studentRepository.save(student);
        assertThat(studentFromDB).isNotNull();
        assertThat(studentFromDB.getId()).isNotNull();

        Student studentFromService = studentService.setWorkingStudent(student.getId(), true);
        assertThat(studentFromService).isNotNull();
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.isWorking()).isTrue();

        Student studentFromFind = studentRepository.findById(studentFromDB.getId()).get();
        assertThat(studentFromFind).isNotNull();
        assertThat(studentFromFind.getId()).isNotNull();
        assertThat(studentFromFind.getId()).isEqualTo(studentFromDB.getId());
        assertThat(studentFromFind.isWorking()).isTrue();
    }
}
