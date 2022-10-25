package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="Sucursales")
public class Sucursales {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "Sucursales", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private String nombre;

	public Sucursales() {
		super();
	}
	
	public Sucursales(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
