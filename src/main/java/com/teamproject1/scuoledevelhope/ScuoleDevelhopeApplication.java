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


}

