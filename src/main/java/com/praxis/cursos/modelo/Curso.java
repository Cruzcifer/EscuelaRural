package com.praxis.cursos.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "curso")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Curso {
	@Id
	private  Integer idCurso;
	private String nombreCurso;
	private String descripcion;
	private Integer cantidadEstudiantes;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER )
	private List<Estudiante> estudiantes;

	

	

	

	

	
	

}
