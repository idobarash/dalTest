package com.cooladata.dal.model.entity.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasicEntityClassID extends BasicEntityClass {

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	protected Long id;
	
	public BasicEntityClassID(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
