package pe.mil.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="apoderados")
public class Apoderado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	private Integer Dni;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column
	private String sexo;
	
	@Column(unique=true)
	private String correo;
	
	@Column(unique=true)
	private Integer celular;
	
	@Column
	private String direccion;
	
	@OneToMany(mappedBy = "apoderado",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Alumno>itemsAlum=new HashSet<>();	

	public Apoderado() {
	}	
   

	public Apoderado(Integer dni, String nombres, String apellidos, String sexo, String correo, Integer celular,
			String direccion) {
		this.Dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
	}

	public Integer getDni() {
		return Dni;
	}

	public void setDni(Integer dni) {
		Dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Alumno> getItemsAlum() {
		return itemsAlum;
	}

	public void setItemsAlum(Set<Alumno> itemsAlum) {
		this.itemsAlum = itemsAlum;
	}
	
	public void addApoAlumno(Alumno alumno) {
		itemsAlum.add(alumno);
	}



}
