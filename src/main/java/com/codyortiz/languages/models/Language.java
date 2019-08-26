package com.codyortiz.languages.models;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="language")
public class Language {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Size(min = 2, max = 20)
	    private String name;
	    @Size(min = 2, max = 20)
	    private String creator;
	    @Size(min = 3, max = 40)
	    private String version;
	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Calendar createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Calendar updatedAt;
		
	    
	    public Language() {
			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCreator() {
			return creator;
		}


		public void setCreator(String creator) {
			this.creator = creator;
		}


		public String getVersion() {
			return version;
		}


		public void setVersion(String version) {
			this.version = version;
		}
	    
	    
		  public Calendar getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Calendar createdAt) {
			this.createdAt = createdAt;
		}


		public Calendar getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Calendar updatedAt) {
			this.updatedAt = updatedAt;
		}


		@PrePersist
	    protected void onCreate(){
			this.createdAt = Calendar.getInstance();
	    }
		@PreUpdate
    	protected void onUpdate(){
			this.updatedAt = Calendar.getInstance();
	    }
	    
}
	    
