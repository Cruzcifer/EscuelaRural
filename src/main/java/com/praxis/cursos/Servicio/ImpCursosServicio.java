package com.praxis.cursos.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxis.cursos.Dao.CursosDao;
import com.praxis.cursos.modelo.Curso;
import com.praxis.cursos.modelo.Estudiante;
import com.praxis.cursos.vo.CursosVO;
import com.praxis.cursos.vo.EstudianteVO;

@Service
public class ImpCursosServicio  implements ICursosServicio {
	
	@Autowired
	private CursosDao cursosDao;
	@Override
	public CursosVO findAll() {
		// TODO Auto-generated method stub
		CursosVO cursosVO =new CursosVO();
		List<Curso> cursos =(List<Curso>) cursosDao.findAll();
		try {
			if(cursos.size()== 0) {
				cursosVO.setCodigo("0");
				cursosVO.setCodigo("na hay datos en la tabla");
				cursosVO.setCursos(cursos);
			}else {
				cursosVO.setCodigo("1");
				cursosVO.setMensaje("La cantidad de datos devueltos");
				cursosVO.setCursos(cursos);
			}
		} catch (Exception e) {
			// TODO: handle exception
			cursosVO.setCodigo("10");
			cursosVO.setMensaje(String.format("Error al intentar conectar al servidor BD (findAllProduct, ImpProductServicio): %s", e));
			cursosVO.setCursos(new ArrayList<Curso>());
		}
		return cursosVO;
	}
	@Override
	public CursosVO findAllId(Integer txtId) {
		// TODO Auto-generated method stub
		CursosVO cursosVO =new CursosVO();
		List<Curso>cursos = new ArrayList<Curso>();
		try {
		Curso curso= cursosDao.findById(txtId).orElse(null);
		if(curso == null) {
				cursosVO.setCodigo("0");
				cursosVO.setMensaje("El product que buscar no existe");
				cursos.add(curso);
				cursosVO.setCursos(cursos);
			}else {
				cursosVO.setCodigo("1");
				cursosVO.setMensaje(String.format("El product con id %d se encontró", txtId));
				cursos.add(curso);
				cursosVO.setCursos(cursos);
			}
		} catch (Exception e) {
			// TODO: handle exception
			cursosVO.setCodigo("10");
			cursosVO.setMensaje(String.format("Error al intentar conectar al servidor BD (findById, ImpProductServicio): %s", e));
			cursosVO.setCursos(new ArrayList<Curso>());
		}
		return cursosVO;
	}
	
	
	
}
