package co.develhope.CRUDTest.controllers;

import co.develhope.CRUDTest.entities.Student;
import co.develhope.CRUDTest.repositories.StudentRepository;
import co.develhope.CRUDTest.services.StudentService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Ho creato la classe StudentController annotandola con RestController, ho importato StudentRepository e StudentService
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * Ho creato il metodo create per creare un nuovo studente
     * @param student come parametro avra un oggetto di tipo Student
     * @return ritorna uno studente salvato nel database attraverso repository
     */
    @PostMapping
    public @ResponseBody Student create(@RequestBody Student student){
        return studentRepository.save(student);
    }

    /**
     * Ho creato il metodo getList
     * @return ritorna la lista si tutti gli studenti presenti nel database
     */
    @GetMapping("/")
    public @ResponseBody List<Student> getList(){
        return studentRepository.findAll();
    }

    /**
     * Ho creato il metodo getSingle per prendere solo uno studente specifico dal database
     * @param id prende come PathVariable un id
     * @return se e presente nel database ritornera lo studente, altrimenti ritornera null.
     */
    @GetMapping("/{id}")
    public @ResponseBody Student getSingle(@PathVariable long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        } else {
            return null;
        }
    }

    /**
     * Ho creato il metodo update, per modificare uno studente
     * @param id PathVariable un id
     * @param student e un oggetto di tipo Student non nullo
     * @return dopo aver modificato l'oggetto lo ritorna salvandolo nel database attraverso la repository.
     */
    @PutMapping("/{id}")
    public @ResponseBody Student update(@PathVariable long id, @RequestBody @NotNull Student student){
        student.setId(id);
        return studentRepository.save(student);
    }

    /**
     * Ho creato il metodo setWorkingStudent per settare se lo studente stia lavorando o meno
     * @param id PathVariable un id
     * @param working un boleano che sara true o false
     * @return ritornera il metodo presente in studentService, ovvero setWorkingStudent
     */
    @PutMapping("/{id}/working")
    public @ResponseBody Student setWorkingStudent(@PathVariable long id, @RequestParam("working") boolean working){
        return studentService.setWorkingStudent(id, working);
    }

    /**
     * Ho creato il metodo delete per cancellare uno studente specifico dal database
     * @param id prende come parametro un PathVariable id
     *
     * Ed attraverso la repository cancellero lo studente dal database
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        studentRepository.deleteById(id);
    }
}
