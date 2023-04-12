package co.develhope.CRUDTest;

import co.develhope.CRUDTest.controllers.StudentController;
import co.develhope.CRUDTest.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Ho creato la classe StudentControllerTest annotandola con SpringBootTest per far capire a spring che all'interno
 * di questa classe vorro effettuare dei test, in questo caso sui metodi presenti nel controller.
 * Ho importato StudentController, MockMvc e ObjectMapper
 */
@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private StudentController studentController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Nel metodo studentControllerLoads ho controllaro che studentController non sia nullo
	 */
	@Test
	void studentControllerLoads() {
		assertThat(studentController).isNotNull();
	}

	/**
	 * Nel metodo getStudentFromId ho preso uno studente per il suo id
	 * @param id id di tipo long
	 * @return attraverso MvcResult ho potuto controllare che la get passasse per la path giusta, che la stampasse,
	 * che si aspetti OK ed infine che la ritorni.
	 * Ho poi salvato il risultato della risposta in un JSON per poterlo poi ritornare come Student
	 * @throws Exception in caso di eccezzione ritornera Null;
	 */
	private Student getStudentFromId(long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/student/"+id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		try{
			String studentJSON = result.getResponse().getContentAsString();
			return objectMapper.readValue(studentJSON, Student.class);
		} catch (Exception e){
			return null;
		}
	}

	/**
	 * Nel metodo createAStudent creo semplicemente uno studente
	 * @return ritorno lo studente
	 * @throws Exception
	 */
	private Student createAStudent() throws Exception {
		Student student = new Student();
		student.setWorking(true);
		student.setName("Alma");
		student.setSurname("Caciula");

		return createAStudent(student);
	}

	/**
	 * Questo metodo e una specia di costruttore con parametri per il metodo precedente
	 * @param student
	 * @return
	 * @throws Exception
	 */
	private Student createAStudent(Student student) throws Exception {
		MvcResult result = createAStudentRequest(student);
		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		return studentFromResponse;
	}

	/**
	 * Nel metodo createAStudentRequest creo una richiesta post per la creazione di uno studente
	 * @param student e richiesto un oggetto di tipo student
	 * @return ritorna il risultato sotto forma di JSON
	 * @throws Exception nel caso lo studente sia nullo, il risultato sara null;
	 */
	private MvcResult createAStudentRequest(Student student) throws Exception {
		if(student == null) return null;
		String studentJSON = objectMapper.writeValueAsString(student);
		return this.mockMvc.perform(post("/student")
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	/**
	 * Nel metodo createAStudentTest ho richiamato il metodo createAStudent ed ho controllato che non sia nullo
	 * @throws Exception nel caso lo studente sia nullo, il risultato sara null;
	 */
	@Test
	void createAStudentTest() throws Exception {
		Student studentFromResponse = createAStudent();
		assertThat(studentFromResponse.getId()).isNotNull();
	}

	/**
	 * Nel metodo readStudentList richiamo il metodo createAStudent. Creo un MvcResult per effettuare la get.
	 * Creo una lista per salvare la risposta attraverso objectMapper e controllo che la lista non sia vuota.
	 * @throws Exception nel caso lo studente sia nullo, il risultato sara null;
	 */
	@Test
	void readStudentList() throws Exception {
		createAStudent();

		MvcResult result = this.mockMvc.perform(get("/student/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<Student> studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("Students in database are: " + studentFromResponse.size());
		assertThat(studentFromResponse.size()).isNotZero();
	}

	/**
	 * Nel metodo readSingleStudent richiamo il metodo createAStudent e controllo che il suo id non sia nullo,
	 * poi creo un altro studente in cui chiamo il metodo getStudentFromId e controllo che l'id dei due studenti siano
	 * uguali.
	 * @throws Exception nel caso lo studente sia nullo, il risultato sara null;
	 */
	@Test
	void readSingleStudent() throws Exception {
		Student student = createAStudent();
		assertThat(student.getId()).isNotNull();
		Student studentFromResponse = getStudentFromId(student.getId());
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
	}

	/**
	 * Nel metodo updateStudent richiamo il metodo createAStudent e controllo che il suo id non sia nullo,
	 * Creo poi un newSurname e setto allo studente. Creo uno studente sotto forma di JSON e creo il MvcResult con
	 * la put.
	 * Creo poi uno studente e lo setto uguale alla risposta e contrllo che non sia nullo, che abbi alo stesso id
	 * del primo studente e che il surname sia uguale a newSurname.
	 * Creo ulteriormente un altro studente che lo prendo da getStudentFromId ed anche qui controllo che non sia nullo,
	 * che abbia lo stesso id del primo studente e che il surname si uguale al newSurname.
	 * @throws Exception nel caso lo studente sia nullo, il risultato sara null;
	 */
	@Test
	void updateStudent() throws Exception {
		Student student = createAStudent();
		assertThat(student.getId()).isNotNull();

		String newSurname = "Danciu";

		student.setSurname(newSurname);
		String studentJSON = objectMapper.writeValueAsString(student);
		MvcResult result = this.mockMvc.perform(put("/student/"+student.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse).isNotNull();
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.getSurname()).isEqualTo(newSurname);

		Student studentFromResponseGet = getStudentFromId(student.getId());
		assertThat(studentFromResponseGet).isNotNull();
		assertThat(studentFromResponseGet.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponseGet.getSurname()).isEqualTo(newSurname);
	}

	/**
	 * Nel metodo deleteStudent richiamo il metodo createAStudent e controllo che non sia nullo, poi attraverso mvc
	 * faccio la delete. Creo un altro studente e lo metto uguale a getStudentFromId e controllo che sia nullo.
	 * @throws Exception
	 */
	@Test
	void deleteStudent() throws Exception {
		Student student = createAStudent();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/student/"+student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = getStudentFromId(student.getId());
		assertThat(studentFromResponse).isNull();
	}

	/**
	 * Nel metodo workingStudent richiamo il metodo createAStudent e controllo che non sia nullo, creo poi un MvcResult
	 * per modificare il bolleano e mttero uguale a true.
	 * Creo poi due studenti, uno uguale al risultato e l'altro uguale a getStudentFromId e controllo che non sia nullo,
	 * che gli id siano uguali al primo studente e che la condizione working sia true.
	 * @throws Exception
	 */
	@Test
	void workingStudent() throws Exception {
		Student student = createAStudent();
		assertThat(student.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(put("/student/"+student.getId()+"/working?working=true"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse).isNotNull();
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.isWorking()).isEqualTo(true);

		Student studentFromResponseGet = getStudentFromId(student.getId());
		assertThat(studentFromResponseGet).isNotNull();
		assertThat(studentFromResponseGet.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponseGet.isWorking()).isEqualTo(true);
	}

}
