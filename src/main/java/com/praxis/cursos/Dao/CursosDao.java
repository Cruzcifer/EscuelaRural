package com.praxis.cursos.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praxis.cursos.modelo.Curso;
@Repository
public interface CursosDao extends CrudRepository<Curso,Integer>{
	

}
