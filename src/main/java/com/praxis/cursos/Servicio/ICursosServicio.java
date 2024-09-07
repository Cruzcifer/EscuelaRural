package com.praxis.cursos.Servicio;

import com.praxis.cursos.vo.CursosVO;

public interface ICursosServicio {
	
	
	public CursosVO  findAllId(Integer id);

	public CursosVO findAll();
	

}
