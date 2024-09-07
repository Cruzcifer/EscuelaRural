package com.praxis.cursos.controlador;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.praxis.cursos.Servicio.ICursosServicio;
import com.praxis.cursos.Servicio.ImpCursosServicio;
import com.praxis.cursos.Servicio.ImpEstudianteServicio;
import com.praxis.cursos.modelo.Curso;
import com.praxis.cursos.modelo.Estudiante;
import com.praxis.cursos.vo.EstudianteVO;

import jakarta.transaction.Transactional;


@Controller
public class Controlador {
	
	@Autowired
	private ImpEstudianteServicio impEstudianteServicio;
	
	@Autowired
	private ImpCursosServicio impCursosServicio;

	
      @RequestMapping(value= "/" , method = RequestMethod.GET)
	
	public String inicio(ModelMap modelMap) {
		
	
		List<Estudiante>estudiantes = impEstudianteServicio.findAllEstudiante().getEstudiante();
		Collections.sort(estudiantes, (e1, e2) -> e1.getIdEstudiante().compareTo(e2.getIdEstudiante()));
		modelMap.addAttribute("estudiantes",estudiantes);
		
		return "inicio";
      }
      
      @RequestMapping(value = "/filtrarId", method=RequestMethod.POST)
      public ModelAndView requestMethodName(@RequestParam String txtId) {
    	  
    	  ModelAndView md =  new ModelAndView();
    	  
    	  EstudianteVO estudiantevo = impEstudianteServicio.findById(Integer.parseInt(txtId));
    	  if(estudiantevo.getCodigo().equals("1")) {
    		  md.addObject("estudiantes" , estudiantevo.getEstudiante());
    		   md.setViewName("inicio");
    	  }else {
    		 
    		  md.setViewName("error");
    	  		}
    		  
          return md;
      }
      
      @RequestMapping(value= "/preInsertar" )
    	
    	public String preGuardar() {
    		  		
    		return "insertar";
          }
      
      
      @RequestMapping(value = "/guardarEstudiante", method = RequestMethod.POST)
		public String agregarPaciente(ModelMap modelMap,@RequestParam Map<String,String>parametros) {
			 
			  Integer idEstudiante = Integer.parseInt(parametros.get("txtId"));
	          String rut = parametros.get("rut");
	          String nombre = parametros.get("nombreEstudiante");
	          String apellido = parametros.get("apellidoEstudiante");
	          String correo = parametros.get("correo");
	          String telefono = parametros.get("telefono");
	          String nombreCurso = parametros.get("nombreCurso");
	      
	          List<Estudiante>repetidos= impEstudianteServicio.findAllEstudiante().getEstudiante();
	          
	          boolean estudianteRepetido = repetidos.stream()
	        		  						.anyMatch(e->e.getRut().equals(rut)|| e.getIdEstudiante()
	        		  						.equals(idEstudiante));
	          
	          if(estudianteRepetido) {
	        	  modelMap.addAttribute("mensajeError", " estudiante o id esta repetido.");
	        	  return "error";
	        	  
	          }
	          
	          Estudiante estudiante = new Estudiante();
	          estudiante.setIdEstudiante(idEstudiante);
	          estudiante.setRut(rut);
	          estudiante.setNombreEstudiante(nombre);
	          estudiante.setApellidoEstudiante(apellido);
	          estudiante.setCorreo(correo);
	          estudiante.setTelefono(telefono);
	  
	          
	          
	          List<Curso> cursos =  impCursosServicio.findAll().getCursos();
	          Curso curso = (Curso) cursos.stream()
	        		  			.filter(c->c.getNombreCurso().equals(nombreCurso))
	          					.findFirst()
	          					.orElse(null);
	          estudiante.setCurso(curso);
	          System.out.println("cursoooooU "+curso);
	       
	         EstudianteVO estudiantevo= impEstudianteServicio.create(estudiante);
	          
	          if(estudiantevo.getCodigo().equals("1")){
	        	  
	         
	        	  	List<Estudiante> estudiantes = impEstudianteServicio.findAllEstudiante().getEstudiante();
	        	  	Collections.sort(estudiantes, (e1, e2) -> e1.getIdEstudiante().compareTo(e2.getIdEstudiante()));
	        	  	modelMap.addAttribute("estudiantes", estudiantes);
	        
	        	  	return "inicio";
	         
	          }else {
	        	  
	        	  return "error";
	          }
	
		}	
      
      @RequestMapping(value ="/preActualizar", method=RequestMethod.GET)
      public String up(ModelMap modelMap, @RequestParam String txtId) {
    	  EstudianteVO estudiantevo=impEstudianteServicio.findById(Integer.parseInt(txtId));
  	      modelMap.addAttribute("estudianteUp",estudiantevo.getEstudiante().get(0));  	     	
  	      return "estudiantes";
    	  
         
      }
      
      @RequestMapping(value = "/actualizar", method=RequestMethod.POST)
      
      public String actualizar(ModelMap modelMap, @RequestParam Map<String,String>parametros) {
       
    	  Integer idEstudiante = Integer.parseInt(parametros.get("txtId"));
          String rut = parametros.get("rut");
          String nombre = parametros.get("nombreEstudiante");
          String apellido = parametros.get("apellidoEstudiante");
          String correo = parametros.get("correo");
          String telefono = parametros.get("telefono");
          String nombreCurso = parametros.get("nombreCurso");
          
          
       
       
          Estudiante estudiante = new Estudiante();
          estudiante.setIdEstudiante(idEstudiante);
          estudiante.setRut(rut);
          estudiante.setNombreEstudiante(nombre);
          estudiante.setApellidoEstudiante(apellido);
          estudiante.setCorreo(correo);
          estudiante.setTelefono(telefono);
        //  estudiante.setCurso(Curso curso);
          
          
          List<Curso> cursos =  impCursosServicio.findAll().getCursos();
          Curso curso = (Curso) cursos.stream()
        		  			.filter(c->c.getNombreCurso().equals(nombreCurso))
          					.findFirst()
          					.orElse(null);
          estudiante.setCurso(curso);
         
       
         EstudianteVO estudiantevo= impEstudianteServicio.actualizar(estudiante);
       
         if(estudiantevo.getCodigo().equals("1")){       	  
                   
        	 	List<Estudiante> estudiantes = impEstudianteServicio.findAllEstudiante().getEstudiante();       	      
        	 	Collections.sort(estudiantes, (e1, e2) -> e1.getIdEstudiante().compareTo(e2.getIdEstudiante()));
        	 	modelMap.addAttribute("estudiantes", estudiantes);       
       	  		return "inicio";
         }
         List<Estudiante> estudiantes = impEstudianteServicio.findAllEstudiante().getEstudiante();
        
         modelMap.addAttribute("estudiantes", estudiantes); 
         return "inicio";
      }
      
      @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
      public String eliminar(Model model, @RequestParam String txtId) {
    	  	
    	    	 Estudiante estudiante = new Estudiante();
    	    	 
    	    	 impEstudianteServicio.delete(Integer.parseInt(txtId));
    	    	 List<Estudiante>estudiantes = impEstudianteServicio.findAllEstudiante().getEstudiante();
    	    	 Collections.sort(estudiantes, (e1, e2) -> e1.getIdEstudiante().compareTo(e2.getIdEstudiante()));
    	    	 model.addAttribute("estudiantes", estudiantes);
    	 		    	        	
    	  return "inicio";
      }
      
      @RequestMapping(value= "/verCursos" , method = RequestMethod.GET)
  	
  	public String filtrarCursos(ModelMap modelMap) {
  		
  	
  		List<Curso>cursos = impCursosServicio.findAll().getCursos();
  		
  		
  		modelMap.addAttribute("cursos",cursos);
  		
  		return "cursos";
        }
      
}
