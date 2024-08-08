package com.capgemini.tarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.tarea.entities.TareasEntity;
import com.capgemini.tarea.service.TareasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Tareas API", description = "Operaciones para manejar tareas")
@RestController
@RequestMapping("/tasks")
public class TareasRestController {

    @Autowired
    TareasService tareasService;

    @GetMapping
    @ApiOperation(value = "Obtener todas las tareass", notes = "Devuelvee una lista de todas las tareas.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Éxito al obtener las tareas"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> getTarea() {
        return tareasService.getTarea();    
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una tarea por ID", notes = "Devuelve una tarea específica por su ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Éxito al obtener la tarea"),
        @ApiResponse(code = 404, message = "Tarea no encontrada"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> getTarea(@ApiParam(value = "ID de la tarea a obtener", required = true) @PathVariable long id) {
        return tareasService.getTareaId(id);    
    }

    @PostMapping
    @ApiOperation(value = "Crear una nueva tarea", notes = "Crea una nueva tarea y la guarda en la base de datos.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Tarea creada con éxito"),
        @ApiResponse(code = 400, message = "Solicitud inválida"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> saveTarea(@ApiParam(value = "Detalles de la tarea a crear", required = true) @RequestBody TareasEntity tarea) {
        return tareasService.saveTarea(tarea);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar una tarea existente", notes = "Actualiza una tarea existente con la información proporcionada.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Tarea actualizada con éxito"),
        @ApiResponse(code = 404, message = "Tarea no encontrada"),
        @ApiResponse(code = 400, message = "Solicitud inválida"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> updateTarea(@ApiParam(value = "ID de la tarea a actualizar", required = true) @PathVariable long id, 
                                          @ApiParam(value = "Detalles actualizados de la tarea", required = true) @RequestBody TareasEntity tarea) {
        try {
            return tareasService.updateTarea(id, tarea);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() + ": verificar datos ingresados", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar una tarea", notes = "Elimina una tarea existente por su ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Tarea eliminada con éxito"),
        @ApiResponse(code = 404, message = "Tarea no encontrada"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> deleteTarea(@ApiParam(value = "ID de la tarea a eliminar", required = true) @PathVariable long id) {
        return tareasService.deleteTarea(id);    
    }
}
