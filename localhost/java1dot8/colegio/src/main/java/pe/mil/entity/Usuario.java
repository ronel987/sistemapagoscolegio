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
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
    @Column
	private String apellidos;
    
    @Column(unique=true)
	private String user;
    
    @Column
	private String clave;
       
    @Column
	private String estado;
    
    @Column(unique=true)
	private String dni;
    
    public Usuario() {
	}
    
    @OneToMany(mappedBy="usuari",cascade = CascadeType.ALL, orphanRemoval = true)         //envio el lazo:la referencia=obj q representa la clase
	private Set<Pago> itemsUsuPa=new HashSet<>(); //cada Usuario puede tener varios Pagos

	public Usuario(Integer id, String nombre, String apellidos, String user, String clave, String estado,
			String dni) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
		this.clave = clave;
		this.estado = estado;
		this.dni = dni;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set<Pago> getItemsUsuPa() {
		return itemsUsuPa;
	}

	public void setItemsUsuPa(Set<Pago> itemsUsuPa) {
		this.itemsUsuPa = itemsUsuPa;
	}
	
	//cada Usuario puede tener una lista de Pagos:
		public void addUsuPago(Pago pago) {
			itemsUsuPa.add(pago);
		}
	
	
}
