package com.praxis.cursos.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxis.cursos.Dao.EstudianteDao;
import com.praxis.cursos.modelo.Curso;
import com.praxis.cursos.modelo.Estudiante;
import com.praxis.cursos.vo.CursosVO;
import com.praxis.cursos.vo.EstudianteVO;

@Service
public class ImpEstudianteServicio  implements IEstudianteServicio{
		
		@Autowired
		private EstudianteDao estudianteDao;
	@Override
	public EstudianteVO findAllEstudiante() {
		// TODO Auto-generated method stub
		EstudianteVO estudianteVO =new EstudianteVO();
		List<Estudiante>estudiantes= (List<Estudiante>) estudianteDao.findAll();
		try {
			if(estudiantes.size()== 0) {
				estudianteVO.setCodigo("0");
				estudianteVO.setCodigo("na hay datos en la tabla");
				estudianteVO.setEstudiante(estudiantes);
			}else {
				estudianteVO.setCodigo("1");
				estudianteVO.setMensaje("La cantidad de datos devueltos");
				estudianteVO.setEstudiante(estudiantes);
			}
		} catch (Exception e) {
			// TODO: handle exception
			estudianteVO.setCodigo("10");
			estudianteVO.setMensaje(String.format("Error al intentar conectar al servidor BD (findAllProduct, ImpProductServicio): %s", e));
			estudianteVO.setEstudiante(new ArrayList<Estudiante>());
		}
		return estudianteVO;
		
	
	}

	@Override
	public EstudianteVO findById(Integer id) {
		EstudianteVO estudianteVO =new EstudianteVO();
		List<Estudiante>estudiantes = new ArrayList<Estudiante>();
		try {
		Estudiante estudiante= estudianteDao.findById(id).orElse(null);
		if(estudiante == null ) {
				estudianteVO.setCodigo("0");
				estudianteVO.setMensaje("El product que buscar no existe");
				estudiantes.add(estudiante);
				estudianteVO.setEstudiante(estudiantes);
			}else {
				estudianteVO.setCodigo("1");
				estudianteVO.setMensaje(String.format("El product con id %d se encontró", id));
				estudiantes.add(estudiante);
				estudianteVO.setEstudiante(estudiantes);
			}
			
		
			
		
		} catch (Exception e) {
			// TODO: handle exception
			estudianteVO.setCodigo("10");
			estudianteVO.setMensaje(String.format("Error al intentar conectar al servidor BD (findById, ImpEstudiantesServicio): %s", e));
			estudianteVO.setEstudiante(new ArrayList<Estudiante>());
		}
		
		
		
		return estudianteVO;
	}
	

	@Override
	public EstudianteVO create(Estudiante estudiante) {
		
		EstudianteVO estudiantevo = new EstudianteVO();
		
		try {
			Estudiante estudianteAll = estudianteDao.save(estudiante);
			List<Estudiante> estudiantes = new ArrayList<Estudiante>();
			if(estudianteAll== null) {
				
				estudiantevo.setCodigo("0");
				estudiantevo.setMensaje("no se encuetra");
				estudiantevo.setEstudiante(new ArrayList<Estudiante>());
			}else {
				
				estudiantevo.setCodigo("1");
				estudiantevo.setMensaje("se inserto correctamente");
				estudiantes.add(estudianteAll);
				estudiantevo.setEstudiante(estudiantes);
			}
			
		}catch(Exception e) {
			estudiantevo.setCodigo("10");
			estudiantevo.setMensaje("servidor caido");
			estudiantevo.setEstudiante(new ArrayList<Estudiante>());
		}
		
		return estudiantevo;
	}

	

	@Override
	public EstudianteVO delete(Integer id) {
		// TODO Auto-generated method stub
		EstudianteVO estudiantevo = new EstudianteVO();
		try {
			estudianteDao.deleteById(id);;
			Boolean existe = estudianteDao.existsById(id);
			List<Estudiante> estudiantes = new ArrayList<Estudiante>();
			if(existe) {
				estudiantevo.setCodigo("0");
				estudiantevo.setMensaje(String.format("No se realizó la eliminación del product: %d", id));
				estudiantevo.setEstudiante(new ArrayList<Estudiante>());
			}else {
				estudiantevo.setCodigo("1");
				estudiantevo.setMensaje(String.format("Se eliminó correctamente el product: %d", id));
				estudiantevo.setEstudiante(new ArrayList<Estudiante>());
			}
		} catch (Exception e) {
			// TODO: handle exception
			estudiantevo.setCodigo("10");
			estudiantevo.setMensaje(String.format("Error al intentar conectar al servidor BD (delete, ImpProductServicio): %s", e));
			estudiantevo.setEstudiante(new ArrayList<Estudiante>());
		}
		return estudiantevo;
	}

	@Override
	public EstudianteVO actualizar(Estudiante estudiante) {
		EstudianteVO estudiantevo = new EstudianteVO();
		try {
			Estudiante estudianteActualizado = estudianteDao.save(estudiante);
			System.out.println("esssssssssssssssss " + estudianteActualizado);
			List<Estudiante>estudiantes = new ArrayList<Estudiante>();
			if(estudianteActualizado == null) {
				
				estudiantevo.setCodigo("0");
				estudiantevo.setMensaje("no se realiza la actualizacion");
				estudiantevo.setEstudiante(new ArrayList<Estudiante>());
			}else {
				
				estudiantevo.setCodigo("1");
				estudiantevo.setMensaje("Se actualizó correctamente el product");
				estudiantes.add(estudianteActualizado);
				estudiantevo.setEstudiante(estudiantes);;
			}
		}catch(Exception e) {
		estudiantevo.setCodigo("10");
		estudiantevo.setMensaje(String.format("Error al intentar conectar al servidor BD (update, ImpEstudianteServicio): %s", e));
		estudiantevo.setEstudiante(new ArrayList<Estudiante>());
	  }
		return estudiantevo;
	}
}	





	

