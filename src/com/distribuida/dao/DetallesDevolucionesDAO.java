package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.DetallesDevoluciones;


public interface DetallesDevolucionesDAO {

	public List<DetallesDevoluciones> findAll();

	public DetallesDevoluciones findOne(int id);

	public void add(DetallesDevoluciones detallesdevoluciones);

	public void up(DetallesDevoluciones detallesdevoluciones);

	public void del(int id);
}
