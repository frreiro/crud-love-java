package com.crud_love.api.model;

import com.crud_love.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

	public Car(CarDTO carDTO) {
		this.modelo = carDTO.modelo();
		this.fabricante = carDTO.fabricante();
		this.dataFabricacao = carDTO.dataFabricacao();
		this.valor = carDTO.valor();
		this.anoModelo = carDTO.anoModelo();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String modelo;

	@Column(length = 50, nullable = false)
	private String fabricante;

	@Column(length = 10, nullable = false)
	private String dataFabricacao;

	@Column(length = 50, nullable = false)
	private int valor;

	@Column(length = 50, nullable = false)
	private int anoModelo;

}
