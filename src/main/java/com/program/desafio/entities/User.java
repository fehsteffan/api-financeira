package com.program.desafio.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private LocalDateTime data; 	

	BigDecimal d0 = BigDecimal.ZERO;
	LocalDateTime d1 = LocalDateTime.now();	
			
	
	public User() {	
	}		

		


	public User(Long id, BigDecimal valor, LocalDateTime data) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		
	}

	


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	


	public BigDecimal getValor() {
		return valor;
	}




	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}




	public LocalDateTime getData() {
		return data;
	}




	public void setData(LocalDateTime data) {
		this.data = data;
	}


		
}
