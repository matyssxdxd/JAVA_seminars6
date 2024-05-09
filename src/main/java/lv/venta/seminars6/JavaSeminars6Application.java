package lv.venta.seminars6;

import lv.venta.seminars6.model.*;
import lv.venta.seminars6.repo.ICourseRepo;
import lv.venta.seminars6.repo.IGradeRepo;
import lv.venta.seminars6.repo.IProfessorRepo;
import lv.venta.seminars6.repo.IStudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSeminars6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminars6Application.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(ICourseRepo courseRepo, IGradeRepo gradeRepo,
											   IProfessorRepo professorRepo, IStudentRepo studentRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Karlis", "Kalmars");
				Student s3 = new Student("Daniels", "Kalvans");
				Professor p1 = new Professor("Rudolfs", "Sniedzins", Degree.other);
				Professor p2 = new Professor("Kurts", "Kobeins", Degree.phd);
				Professor p3 = new Professor("Vilmars", "Bobers", Degree.bsc);
				Course c1 = new Course("Matematika", 4, p1);
				Course c2 = new Course("Anglu valoda", 2, p2);
				Course c3 = new Course("Dzive", 10, p3);
				Grade g1 = new Grade(10, c1, s1);
				Grade g2 = new Grade(4, c2, s2);
				Grade g3 = new Grade(6, c3, s3);
				studentRepo.save(s1);
				studentRepo.save(s2);
				studentRepo.save(s3);
				professorRepo.save(p1);
				professorRepo.save(p2);
				professorRepo.save(p3);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				gradeRepo.save(g1);
				gradeRepo.save(g2);
				gradeRepo.save(g3);
			}
		};
	}

}
