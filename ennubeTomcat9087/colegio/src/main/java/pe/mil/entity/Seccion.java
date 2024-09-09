package pe.mil.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="secciones")
public class Seccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String estado;
	
	@ManyToOne 
	@Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="codigo_grado",nullable = false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(codigo_grado) references grados(id)"))
	private Grado grado;

	public Seccion() {		
	}
	
	public Seccion(Integer id, String nombre, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	
	

}
