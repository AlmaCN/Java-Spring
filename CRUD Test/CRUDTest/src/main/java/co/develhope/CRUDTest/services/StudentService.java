package co.develhope.CRUDTest.services;

import co.develhope.CRUDTest.entities.Student;
import co.develhope.CRUDTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Ho creato la classe StudentService annotandola con Service
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Ho creato il metodo setWorkingStudent per settare se stia lavorando o meno
     * @param id id dello studente
     * @param isWorking boleano che setteremo
     * @return ritorna lo studente salvato nel database
     */
    public Student setWorkingStudent(Long id, boolean isWorking){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) return null;
        student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }
}
