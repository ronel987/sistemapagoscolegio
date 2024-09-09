package pe.mil.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="grados")
public class Grado implements Serializable {

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
	@JoinColumn(name="codigo_ae", nullable = false, foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(codigo_ae) references ano_escolares(id)"))
	private Ano_Escolar ano_escolar;
	
	@OneToMany(mappedBy="grado",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Seccion> itemsSeccion = new ArrayList<>();
	
	public Grado() {		
	}

	public Grado(Integer id, String nombre, String estado) {
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
	

	public Ano_Escolar getAno_escolar() {
		return ano_escolar;
	}


	public void setAno_escolar(Ano_Escolar ano_escolar) {
		this.ano_escolar = ano_escolar;
	}


	public Collection<Seccion> getItemsSeccion() {
		return itemsSeccion;
	}


	public void setItemsSeccion(Collection<Seccion> itemsSeccion) {
		this.itemsSeccion = itemsSeccion;
	}
	
	

}
