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
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Estudiante {
	@Id
	private Integer idEstudiante;
	private String rut;
	private String nombreEstudiante;
	private String apellidoEstudiante;
	private String correo;
	private String telefono;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCurso")
	private Curso curso;

	@Override
	public String toString() {
		return "Estudiante [idEstudiante=" + idEstudiante + ", rut=" + rut + ", nombreEstudiante=" + nombreEstudiante
				+ ", apellidoEstudiante=" + apellidoEstudiante + ", correo=" + correo + ", telefono=" + telefono
				+ ", curso=" + curso + "]";
	}

	
	
	
	
	

}
