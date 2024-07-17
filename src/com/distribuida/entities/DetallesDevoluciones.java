package com.distribuida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="detallesdevoluciones")
public class DetallesDevoluciones {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_detalle_devolucion")
private int idDetalleDevolucion;
	@Column(name = "idDevolucion")
private int idDevolucion;
	@Column(name = "idProducto")
private int idProducto;
	@Column(name = "Cantidad")
private int cantidad;
	@Column(name = "PrecioUnitario")
private Double precioUnitario;
	
//	@JoinColumn(name = "IdDevolucion")
//	@JoinColumn(name = "idProducto")
//	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
//	private Pedido pedido;
	//private Producto producto:

	public DetallesDevoluciones() {}


	public DetallesDevoluciones(int idDetalleDevolucion, int idDevolucion, int idProducto, int cantidad,
			Double precioUnitario) {
		super();
		this.idDetalleDevolucion = idDetalleDevolucion;
		this.idDevolucion = idDevolucion;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}


	public int getIdDetalleDevolucion() {
		return idDetalleDevolucion;
	}


	public void setIdDetalleDevolucion(int idDetalleDevolucion) {
		this.idDetalleDevolucion = idDetalleDevolucion;
	}


	public int getIdDevolucion() {
		return idDevolucion;
	}


	public void setIdDevolucion(int idDevolucion) {
		this.idDevolucion = idDevolucion;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	@Override
	public String toString() {
		return "DetallesDevoluciones [idDetalleDevolucion=" + idDetalleDevolucion + ", idDevolucion=" + idDevolucion
				+ ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
	
}
