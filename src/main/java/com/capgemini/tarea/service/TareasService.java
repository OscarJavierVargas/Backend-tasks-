package com.capgemini.tarea.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.tarea.entities.TareasEntity;
import com.capgemini.tarea.repository.TareasRepository;

@Service
public class TareasService {
	

	
	@Autowired
	TareasRepository tareasRepository;
	@Autowired

	


	public ResponseEntity<?> getTarea(){
		try {
			return  ResponseEntity.ok(tareasRepository.findAll());	
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> getTareaId(long id){
		try {
			return  ResponseEntity.ok(tareasRepository.findById(id));	
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<?> saveTarea(TareasEntity tarea){
		Date ahora = new Date();
		try {
			tarea.setCreatedAt(ahora);
			tareasRepository.save(tarea);
			return new ResponseEntity<>("tarea creada con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> updateTarea(long id, TareasEntity tarea){
		try {
			
			if(tareasRepository.findById(id) != null) {
				TareasEntity actualizar=tareasRepository.findById(id).get();
				actualizar.setEstatus(tarea.getEstatus());
				actualizar.setTitle(tarea.getTitle());
				actualizar.setDescription(tarea.getDescription());
				tareasRepository.save(actualizar);
			}
			return new ResponseEntity<>("tarea modificada con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> deleteTarea(long id ){
		try {
			
			if(tareasRepository.findById(id) != null) {;	
			tareasRepository.deleteById(id);;
			}
			return new ResponseEntity<>("tickets eliminado con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}


	

}
