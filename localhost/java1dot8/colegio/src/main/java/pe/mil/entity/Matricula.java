package pe.mil.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CascadeType.*;
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
import org.hibernate.annotations.Cascade.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="matriculas")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha_matricula;
	
	@Column
	private String estado;
	
	@ManyToOne 
	@Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="codigo_alum",nullable=false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(codigo_alum) references alumnos(id)"))
	private Alumno alumno;	
	
	@ManyToOne 	
	@Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "codigo_ae",nullable=false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(codigo_ae) references ano_escolares(id)"))
	private Ano_Escolar ano;
	
	@OneToMany(mappedBy = "matricula",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Pago>itemsPago=new ArrayList<>();		
	
    public Matricula() {		
	}

	public Matricula(Integer id, LocalDate fecha_matricula, String estado) {
		this.id = id;
		this.fecha_matricula = fecha_matricula;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha_matricula() {
		return fecha_matricula;
	}

	public void setFecha_matricula(LocalDate fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Ano_Escolar getAno() {
		return ano;
	}

	public void setAno(Ano_Escolar ano) {
		this.ano = ano;
	}

	public Collection<Pago> getItemsPago() {
		return itemsPago;
	}

	public void setItemsPago(Set<Pago> itemsPago) {
		this.itemsPago = itemsPago;
	}

	public void addMatPago(Pago pago) {
		itemsPago.add(pago);
	}
    
    
    
}
