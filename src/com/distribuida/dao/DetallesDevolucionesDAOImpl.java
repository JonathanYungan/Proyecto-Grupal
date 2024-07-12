package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.DetallesDevoluciones;
import com.distribuida.entities.Devoluciones;

@Repository
public class DetallesDevolucionesDAOImpl implements DetallesDevolucionesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
    @Transactional
	public List<DetallesDevoluciones> findAll() {
		// TODO Auto-generated method stub
    	
		
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from detallesdevoluciones",DetallesDevoluciones.class).getResultList();
	}

	@Override
	@Transactional
	public DetallesDevoluciones findOne(int id) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				return session.get(DetallesDevoluciones.class, id);
}
	@Override
	@Transactional

	public void add(DetallesDevoluciones detallesdevoluciones) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(detallesdevoluciones);

	}

	@Override
	@Transactional

	public void up(DetallesDevoluciones detallesdevoluciones ) {

		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(detallesdevoluciones);

	}

	@Override
	@Transactional

	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));

	}

}