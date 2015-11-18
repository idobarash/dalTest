package com.cooladata.dal.model.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BasicEntityClass implements BasicEntityID{

	public static final long serialVersionUID = 1L;
	
	public static final String CREATED_DATE_FIELD_NAME = "created";
	public static final String MODIFIED_DATE_FIELD_NAME = "modified";


	@Version
	@JsonIgnore
	protected Long version;
	
	@Column(updatable =false)
	protected Date created;

	protected Date modified;
	
	//private transient String href;
	@JsonIgnore
	public abstract String getBaseURI();
	public abstract  Long getId();
	
	@JsonIgnore
	public String getHref() {
		return getBaseURI()+"/"+getId();
	}
	
	public void postLoad() {}

//	public void setHref(String href) {
//		this.href = href;
//	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}


	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
