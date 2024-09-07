package com.praxis.cursos.vo;

import java.util.List;

import com.praxis.cursos.modelo.Curso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CursosVO {
	
	private String codigo;
	private String mensaje;
	private List<Curso>cursos;

}
