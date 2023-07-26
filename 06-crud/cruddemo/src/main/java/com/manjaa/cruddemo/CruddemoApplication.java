package com.manjaa.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.manjaa.cruddemo.dao.StudentDAO;
import com.manjaa.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Heloo JPA!!!");
			//createStudent(studentDAO);
			//createMultiStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryByLastName(studentDAO);
			//update(studentDAO);
			//delete(studentDAO);
			
		};

	}

	

	private void delete(StudentDAO studentDAO) {
		int id = 5;
		System.out.println("Removing the ");
		studentDAO.delete(id);
	}

	private void update(StudentDAO studentDAO) {
		
		int id = 1;
		// retrieve the student
		System.out.println("Retreving ID record from db...");
		Student student = studentDAO.findById(id);

		// Modifying the email
		System.out.println("Modifying...");
		student.setEmail("variavar@vairavar.com");

		// update
		System.out.println("Updating...");
		studentDAO.update(student);

		// display
		System.out.println("Modified ..."+student);

	}

	private void queryByLastName(StudentDAO studentDAO) {
		// get the list of students

		List<Student> students = studentDAO.findByLastname("mentor");

		// display the list
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student student:theStudents){
			System.out.println(student);

		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a new student
		Student student = new Student("Perumal", "Mentor", "perumal@mayura.com");
		// Save the student
		studentDAO.save(student);
		// Display id of the student
		System.out.println("id "+ student.getId());
		// read the student by using the id
		System.out.println("Retriving...");
		System.out.println(studentDAO.findById(student.getId()));
			
	}

	private void createMultiStudent(StudentDAO studentDAO) {

		// Create students
		Student student1 = new Student("Vairavar", "Sivam", "vairavar@mayura.com");
		Student student2 = new Student("indrajith", "Raavanan", "indrajith@mayura.com");
		Student student3 = new Student("Murugan", "vel", "murugan@mayura.com");
		
		// Save students

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	
		// display students

		System.out.print("Multiple records added");
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// create the sudent obj
		System.out.println("Creating the new Student");
		Student theStudent = new Student("Mayura", "Selvarajah	", "manjaa@mayura.com");
		// save the student obj
		System.out.println("Save the student");
		studentDAO.save(theStudent);
		// display the id of the saved student
		System.out.println("Generated Id "+ theStudent.getId());
	}

}
