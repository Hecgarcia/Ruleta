package com.ibm.academia.apirest.models.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ruletas")
public class Ruleta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Positive(message = "El numero debe ser mayor a cero")
	@Column(name = "numero_ruletas", nullable = false, unique = true)
	@Size(min = 1, max = 5 )
	private Long numeroRuleta;
	
	@NotNull(message = "El nombre no puede ser Nulo")
	@NotEmpty(message = "El nombre no puede ser vacio")
	@Size(min = 5, max = 50)
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	private void antesPersistir() {
		this.fechaCreacion = new Date();
	}
	
	private static final long serialVersionUID = -3911335293183766322L;
	
}
