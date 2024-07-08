package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Devoluciones;

public interface DevolucionesDAO {

		public List<Devoluciones> findAll();
		public Devoluciones findOne(int id);
		public void add(Devoluciones devoluciones);
		public void up(Devoluciones devoluciones);
		
		public void del(int id);
		
	}