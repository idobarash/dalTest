package com.cooladata.dal.application.interceptor.listeners;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.springframework.stereotype.Component;

import com.cooladata.dal.model.entity.common.BasicEntityClass;

@Component
public class BasicEntityPostLoadEventListener implements PostLoadEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void onPostLoad(PostLoadEvent event) {
		onLoad(event.getEntity());
	}
	
	private void onLoad(Object entity) {
		if (entity != null) {
			if (entity instanceof BasicEntityClass) {
				((BasicEntityClass)entity).postLoad();
			}
		}
	}

}