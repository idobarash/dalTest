package com.cooladata.dal.dao.common;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.cooladata.dal.base.exceptions.NotValidDataException;
import com.cooladata.dal.model.entity.common.BasicEntityID;


public abstract class BasicDao<T  extends BasicEntityID>{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	//can throw "org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException"
	public void save(T t)
	{
		
		Session session = sessionFactory.getCurrentSession();
		if(t.getId() == null)
		{
			session.persist(t);
		}
		else
		{
			T dbT = this.get(t.getId());
			if(dbT == null)
				throw new NotValidDataException("cant update object - not exist") ;
			
			if(t.getVersion() == null)
			{
				t.setVersion(dbT.getVersion());
			}
			session.merge(t);
		}

	}
	
	public T get(long id)
	{

		Session session = sessionFactory.getCurrentSession();
		T o = (T)session.get(getPersistentClass(),id);
		return o;
	}

	public void update(T t)
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}
	
	public boolean delete(long id)
	{
		Session session = sessionFactory.getCurrentSession();
		T object = (T) session.get(getPersistentClass(),id);
		if(object == null)
			return false;
		session.delete(object);
		return true;
	}
	
	public abstract Class<T> getPersistentClass();
	
	public List<T> getAll()
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getPersistentClass());
		return (List<T>)criteria.list();
	}

	
	public List<T> getAll(int max, int offset, boolean asc)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getPersistentClass());
		criteria.setMaxResults(max);
		criteria.setFirstResult(offset*max);
		if (asc)
			criteria.addOrder(Order.asc("id"));
		else
			criteria.addOrder(Order.desc("id"));
		return (List<T>)criteria.list();
	}
	
}
