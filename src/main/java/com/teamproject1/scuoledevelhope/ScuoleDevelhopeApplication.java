package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dao.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.dao.RoleDao;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.schoolDAO.SchoolDAO;
import com.teamproject1.scuoledevelhope.classes.student.dao.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ScuoleDevelhopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScuoleDevelhopeApplication.class, args);
	}


<<<<<<< HEAD
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, UserDao userDao){
		return runner ->{
/*
			User user = new User("Willo","Gattone");

			userDao.save(user);
			Classes classes = null;
			Register register = null;
			Student student = new Student(user,classes,register);
			studentDAO.save(student);
			//System.out.println(UUID.randomUUID());*/
		};

	}
=======
>>>>>>> cc768e5296049c85af2e7273597484ecb0c0a1ea
}

