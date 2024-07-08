package com.distribuida.principal;

import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.DevolucionesDAO;
import com.distribuida.entities.Devoluciones;



public class PrincipalDevoluciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC Inversion de Control 
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	DevolucionesDAO DevolucionesDAO = context.getBean("devolucionesDAOImpl",DevolucionesDAO.class);
	
	//CRUD : CREATE, READ, UPDATE, DELETE 
	//
	
	//add
	Devoluciones Devoluciones = new Devoluciones(0,5,new Date(),"Destrozado");
	//DevolucionesDAO.add(Devoluciones);
	
	//up
	Devoluciones Devoluciones2 = new Devoluciones(0,1,new Date(),"roto");	
	//Devoluciones.up(Devoluciones2);
	
	
	//del
	//DevolucionesDAO.del(1);
	System.out.println("**********************DEL***********************"+DevolucionesDAO.findOne(1));
	//finAll
	//List<> Devoluciones = DevolucionesDAO.findAll();
	
	
	DevolucionesDAO.findAll().forEach(item -> {System.out.println(item.toString());});
	
	context.close();
			

	}

}