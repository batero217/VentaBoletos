package com.futbol.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="ESTADIOS")
public class Estadio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EST_ID")
	private Long estid;
	
	@Column(name="EQ_ID")
	@NotEmpty
	private Long eqID;
	
	@Column(name="NOMBRE")
	@NotEmpty
	private String nombre;
	
	@Column(name="PAIS")
	@NotEmpty
	private String pais;
	
	@Column(name="DIVISION")
	@NotEmpty
	private String division;
	
	@Column(name="DIRECCION")
	@NotEmpty
	private String direccion;
	
	@Column(name="F_FUNDACION")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ffundacion;
	
	@Column (name="CAPACIDAD_ASIENT")
	@NotNull
	private Long capasiento;
	
	@Column (name="COD_ESTADO")
	@NotNull
	private String codestado;
	
	
	public Long getEstid() {
		return estid;
	}
	public void setEstid(Long estid) {
		this.estid = estid;
	}
	
	public Long getEqid() {
		return eqID;
	}
	public void setEqid(Long eqID) {
		this.eqID = eqID;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFfundacion() {
		return ffundacion;
	}
	public void setFfundacion(Date ffundacion) {
		this.ffundacion = ffundacion;
	}
	public Long getCapasiento() {
		return capasiento;
	}
	public void setCapasieto(Long capasiento) {
		this.capasiento = capasiento;
	}
	public String getCodestado() {
		return codestado;
	}
	public void setCodestado(String codestado) {
		this.codestado = codestado;
	}

	
}
