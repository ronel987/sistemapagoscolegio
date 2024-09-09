package pe.mil.entity;
import java.io.Serializable;
import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import pe.mil.entity.Pago;

@Entity
@Table(name="calendarios")
public class Calendario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String concepto;
	
    @Column
	private String mes;
       
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate flimite;
	
	@Column
	private Integer monto;
	
	public Calendario() {
	}
	
	@OneToMany(mappedBy="calendario",cascade = CascadeType.ALL, orphanRemoval = true)         //envio el lazo:la referencia
	private Set<Pago> itemsCalPa=new HashSet<>(); //cada Calendario puede tener varios Pagos

	public Calendario(Integer id, String concepto, String mes, LocalDate flimite, Integer monto) {
		this.id = id;
		this.concepto = concepto;
		this.mes = mes;
		this.flimite = flimite;
		this.monto = monto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public LocalDate getFlimite() {
		return flimite;
	}

	public void setFlimite(LocalDate flimite) {
		this.flimite = flimite;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Set<Pago> getItemsCalPa() {
		return itemsCalPa;
	}

	public void setItemsCalPa(Set<Pago> itemsCalPa) {
		this.itemsCalPa = itemsCalPa;
	}
	
	//cada Calen puede tener una lista de Pagos:
	public void addCalenPago(Pago pago) {
		itemsCalPa.add(pago);
	}
	
}
