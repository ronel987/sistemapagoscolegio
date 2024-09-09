package pe.mil.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column(unique=true)
	private Integer celular;
	
	@Column(unique=true)
	private Integer dni;
	
	@Column
	private String sexo;
	
	@Column
	private String estado;
	
	@ManyToOne 
	@Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Dniapo",foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(Dniapo) references apoderados(Dni)"))
	private Apoderado apoderado;
	
	@OneToMany(mappedBy = "alumno",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Matricula>itemsMat=new ArrayList<>();

	public Alumno() {
	}

	public Alumno(Integer id, String nombres, String apellidos, Integer celular, Integer dni, String sexo,
			String estado) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.celular = celular;
		this.dni = dni;
		this.sexo = sexo;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public Collection<Matricula> getItemsMat() {
		return itemsMat;
	}

	public void setItemsMat(Set<Matricula> itemsMat) {
		this.itemsMat = itemsMat;
	}
	
	public void addMatAlumno(Matricula mat) {
		itemsMat.add(mat);
	}


}
