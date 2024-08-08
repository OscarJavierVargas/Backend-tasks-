package com.capgemini.tarea.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class TareasEntity {
	
	public TareasEntity() {
		super();
	}
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String title;
	    private String description;
	    private Date createdAt;  
	    @Enumerated(EnumType.STRING)
	    private Status estatus;
	    
	    public enum Status {
	    	PENDING,
	    	COMPLETED
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Status getEstatus() {
			return estatus;
		}

		public void setEstatus(Status estatus) {
			this.estatus = estatus;
		}
	    
	    
		
}
