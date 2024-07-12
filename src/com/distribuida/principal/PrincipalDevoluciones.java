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
	DevolucionesDAO devolucionesDAO = context.getBean("devolucionesDAOImpl",DevolucionesDAO.class);
	//PedidoDAO PedidoDAO = context.getBean("pedidoDAOImpl",PedidoDAO.class);
	
	//CRUD : CREATE, READ, UPDATE, DELETE 
	//
	
	//add
	Devoluciones devoluciones = new Devoluciones(0,new Date(),"Destrozado");
	//devoluciones.setPedido(pedidoDAO.findOne(2));
	devoluciones.setIdDevolucion(3);
	devolucionesDAO.add(devoluciones);
	
	//up
	Devoluciones Devoluciones2 = new Devoluciones(0,new Date(),"roto");	
	//Devoluciones.up(Devoluciones2);
	//1212dsadsa
	
	//del
	//DevolucionesDAO.del(1);
	System.out.println("**********************DEL***********************"+devolucionesDAO.findOne(1));
	//finAll
	//List<> Devoluciones = DevolucionesDAO.findAll();
	
	
	devolucionesDAO.findAll().forEach(item -> {System.out.println(item.toString());});
	
	context.close();
			

	}

}