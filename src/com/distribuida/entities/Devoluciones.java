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
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_devolucion")
	private int idDevolucion;
	@Column(name = "id_IdPedido")
	private int idPedido;
	@Column(name = "id_FechaDevolucion")
	private Date fechaDevolucion;
	@Column(name = "id_Motivo")
	private String motivo;
	
public Devoluciones() {}
public Devoluciones(int idDevolucion, int idPedido, Date fechaDevolucion, String motivo) {
	super();
	this.idDevolucion = idDevolucion;
	this.idPedido = idPedido;
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