package com.praxis.cursos.Servicio;

import com.praxis.cursos.modelo.Estudiante;
import com.praxis.cursos.vo.EstudianteVO;

public interface IEstudianteServicio {
	
	public EstudianteVO findAllEstudiante();
	
	public EstudianteVO findById(Integer id);
	
	public EstudianteVO create(Estudiante estudiante);
	
	public EstudianteVO actualizar(Estudiante estudiante);
	
	public EstudianteVO delete(Integer id);
	
	
	

}
