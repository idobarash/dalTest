package com.cooladata.dal.model.entity.common;

import java.io.Serializable;

public interface BasicEntityID extends Serializable {

	public Long getId();
	public Long getVersion();
	public void setVersion(Long version);
}
