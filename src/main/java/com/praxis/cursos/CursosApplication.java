package com.praxis.cursos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.praxis.cursos.Dao.EstudianteDao;
import com.praxis.cursos.modelo.Estudiante;


@SpringBootApplication
public class CursosApplication {

	public static void main(String[] args) {
	SpringApplication.run(CursosApplication.class, args);
		
	}

}
