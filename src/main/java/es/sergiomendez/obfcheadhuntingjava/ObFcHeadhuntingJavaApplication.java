package es.sergiomendez.obfcheadhuntingjava;

import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.entities.User;
import es.sergiomendez.obfcheadhuntingjava.repositories.StudentRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.TagRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class ObFcHeadhuntingJavaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObFcHeadhuntingJavaApplication.class, args);

		TagRepository tagRepository = context.getBean(TagRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		/*Tag tag1 = new Tag(null, "html&css");
		Tag tag2 = new Tag(null, "javascript");
		tagRepository.save(tag1);
		tagRepository.save(tag2);

		Student student1 = new Student(null,
				"Nombre1 Apellido1",
				"España",
				"Madrid",
				"+34 123 456 789",
				"nombre1@prueba.com",
				"Remota",
				false,
				"",
				"");

		User user1 = new User(null,
				"username1",
				"12345",
				"user1@gmail.es",
				"user1 apellido1");

		userRepository.save(user1);

		student1.setUser(user1);
		student1.getTags().add(tag1);
		student1.getTags().add(tag2);
		studentRepository.save(student1);

		Optional<Student> studentOpt = studentRepository.findById(1L);
		if(studentOpt.isPresent()) {
			student1 = studentOpt.get();
			System.out.println(student1.getUser());
		}*/

	}

}
