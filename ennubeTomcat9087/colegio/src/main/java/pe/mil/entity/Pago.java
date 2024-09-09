package pe.mil.entity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="pagos")
public class Pago implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha;
	
	@Column
	private Integer monto;
	
	@Column
	private String estado;
	
    @ManyToOne
    @Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="calendario_id",nullable = false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(calendario_id) references calendarios(id)"))
	private Calendario calendario;
	
    @ManyToOne
    @Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="usuario_id",nullable=false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(usuario_id) references usuarios(id)"))
	private Usuario usuari;    //llega el obj
    
    @ManyToOne
    @Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="matricula_id",nullable=false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(matricula_id) references matriculas(id)"))
	private Matricula matricula;
	
	public Pago() {		
	}
    
	public Pago(Integer id, LocalDate fecha, Integer monto, String estado) {
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	

	public Usuario getUsuari() {
		return usuari;
	}


	public void setUsuari(Usuario usuari) {
		this.usuari = usuari;
	}


	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
