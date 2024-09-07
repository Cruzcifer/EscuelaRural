package com.praxis.cursos.vo;

import java.util.List;
import com.praxis.cursos.modelo.Estudiante;

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

public class EstudianteVO {
 private String codigo;
 private String mensaje;
 private List<Estudiante>estudiante;
	

}
