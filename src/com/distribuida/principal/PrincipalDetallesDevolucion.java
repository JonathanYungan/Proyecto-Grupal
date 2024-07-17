package com.distribuida.principal;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.DetallesDevolucionesDAO;
  



import com.distribuida.entities.DetallesDevoluciones;

public class PrincipalDetallesDevolucion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC Inversion de Control 
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	DetallesDevolucionesDAO DetallesDevolucionesDAO = context.getBean("detallesDevolucionesDAOImpl",DetallesDevolucionesDAO.class);
	
	//CRUD : CREATE, READ, UPDATE, DELETE 
	//
	
	//add
	DetallesDevoluciones DetallesDevoluciones = new DetallesDevoluciones(10,10,10,0, 20.1);
	//DetallesDevolucionesDAO.add(DetallesDevoluciones);
	
	//up
	DetallesDevoluciones DetallesDevoluciones2  = new DetallesDevoluciones(10,1,20, 0, 50.25);
	//DetallesDevolucionesDAO.up(DetallesDevoluciones2);
	
	//del
	DetallesDevolucionesDAO.del(10);
	System.out.println("**********************DEL***********************"+DetallesDevolucionesDAO.findOne(1));
	//finAll
	//List<> DetallesDevoluciones = DetallesDevolucionesDAO.findAll();
	
	
	DetallesDevolucionesDAO.findAll().forEach(item -> {System.out.println(item.toString());});
	
	context.close();
			

	}

}