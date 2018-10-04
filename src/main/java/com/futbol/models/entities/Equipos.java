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
@Table(name="EQUIPOS")

public class Equipos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQ_ID")
	private Long eqID;
	
	@Column(name="NOMBRE")
	@NotEmpty
	private String nombre;
	
	@Column(name="NOMBRE_CORTO")
	@NotEmpty
	private String nombrecorto;
	
	@Column(name="PAIS")
	@NotEmpty
	private String pais;
	
	@Column(name="DIVISION")
	@NotEmpty
	private String division;
	
	@Column(name="F_FUNDACION")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ffundacion;
	
	@Column (name="COD_ESTADO")
	@NotNull
	private int codestado;

	public Long getEqID() {
		return eqID;
	}
	public void setEqID(Long eqID) {
		this.eqID = eqID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombrecorto() {
		return nombrecorto;
	}
	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
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
	public Date getFfundacion() {
		return ffundacion;
	}
	public void setFfundacion(Date ffundacion) {
		this.ffundacion = ffundacion;
	}
	public int getCodestado() {
		return codestado;
	}
	public void setCodestado(int codestado) {
		this.codestado = codestado;
	}
	

}