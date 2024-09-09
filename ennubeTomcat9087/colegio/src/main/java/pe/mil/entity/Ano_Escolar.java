package pe.mil.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="ano_escolares")
public class Ano_Escolar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true,nullable=false)
	private String nombre;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha_inicio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha_fin;
	
	@Column
	private String estado;
	
	@OneToMany(mappedBy="ano_escolar",cascade = CascadeType.ALL, orphanRemoval = true)    //Grado debe recibir ese obj
	private Collection<Grado> itemsGrado = new ArrayList<>();
	
	@OneToMany(mappedBy="ano",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Matricula> itemsMatricula = new ArrayList<>();

	public Ano_Escolar() {		
	}
		

	public Ano_Escolar(int id, String nombre, LocalDate fecha_inicio, LocalDate fecha_fin, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<Grado> getItemsGrado() {
		return itemsGrado;
	}

	public void setItemsGrado(Collection<Grado> itemsGrado) {
		this.itemsGrado = itemsGrado;
	}

	public Collection<Matricula> getItemsMatricula() {
		return itemsMatricula;
	}

	public void setItemsMatricula(Collection<Matricula> itemsMatricula) {
		this.itemsMatricula = itemsMatricula;
	}
	
	
}







