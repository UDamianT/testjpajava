package com.example.demo.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Ordenes")
public class Ordenes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "Ordenes", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private int sucursal_id;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;
	
	@Column(name="total")
	private double total;
	
	public Ordenes() {
		super();
	}

	public Ordenes(int sucursal_id, Date fecha, double total) {
		super();
		this.sucursal_id = sucursal_id;
		this.fecha = fecha;
		this.total = total;
	}
	
	public Ordenes(Long id, int sucursal_id, Date fecha, double total) {
		super();
		this.id = id;
		this.sucursal_id = sucursal_id;
		this.fecha = fecha;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public int getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
