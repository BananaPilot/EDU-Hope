package com.teamproject1.scuoledevelhope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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

