package com.distribuida.entities;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="devoluciones")
public class Devoluciones {
	
	
	// id_devolucion, IdPedido, FechaDevolucion, Motivo


	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_devolucion")
	private int idDevolucion;
	
	 @Column(name = "IdPedido")
	 private int idPedido;
	
	@Column(name = "FechaDevolucion")
	private Date fechaDevolucion;
	@Column(name = "Motivo")
	private String motivo;
	
	
//	@JoinColumn(name = "IdPedido")
//	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
//	private Pedido pedido;

	
public Devoluciones() {}
public Devoluciones(int idDevolucion, Date fechaDevolucion, String motivo) {
	
	this.idDevolucion = idDevolucion;
	//this.idPedido = idPedido;
	this.fechaDevolucion = fechaDevolucion;
	this.motivo = motivo;
}
public int getIdDevolucion() {
	return idDevolucion;
}
public void setIdDevolucion(int idDevolucion) {
	this.idDevolucion = idDevolucion;
}
public int getIdPedido() {
	return idPedido;
}
public void setIdPedido(int idPedido) {
	this.idPedido = idPedido;
}
public Date getFechaDevolucion() {
	return fechaDevolucion;
}
public void setFechaDevolucion(Date fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
}
public String getMotivo() {
	return motivo;
}
public void setMotivo(String motivo) {
	this.motivo = motivo;
}



@Override
public String toString() {
	return "Devoluciones [idDevolucion=" + idDevolucion + ", idPedido=" + idPedido + ", fechaDevolucion="
			+ fechaDevolucion + ", motivo=" + motivo + "]";
};


	

}