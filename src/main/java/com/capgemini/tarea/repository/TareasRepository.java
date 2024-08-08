package com.capgemini.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.tarea.entities.TareasEntity;

@Repository
public interface TareasRepository extends JpaRepository<TareasEntity, Long>{

}
