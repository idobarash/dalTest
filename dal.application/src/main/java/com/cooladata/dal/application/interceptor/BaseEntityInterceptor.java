package com.cooladata.dal.application.interceptor;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.cooladata.dal.model.entity.common.BasicEntityClass;

public class BaseEntityInterceptor extends EmptyInterceptor  {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub

		if(entity instanceof BasicEntityClass)
		{
			int index = getIndexOfElementInArray(BasicEntityClass.MODIFIED_DATE_FIELD_NAME,propertyNames);
			currentState[index] = new Date();
			
			return true;
		}
		
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);

	}


	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		if(entity instanceof BasicEntityClass)
		{
			int index = getIndexOfElementInArray(BasicEntityClass.CREATED_DATE_FIELD_NAME,propertyNames);
			state[index] = new Date();
			
			index = getIndexOfElementInArray(BasicEntityClass.MODIFIED_DATE_FIELD_NAME,propertyNames);
			state[index] = new Date();
			
			return true;
			
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	
	
	private int getIndexOfElementInArray(String element,String[] arr)
	{
		if(element == "" || arr == null)
			return -1;
		
		for (int i = 0; i < arr.length; i++) {
			if(element.equals(arr[i]))
				return i;
		}
		
		return -1;
	}

	
}
