package com.crud_love.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_love.api.dto.CarDTO;
import com.crud_love.api.model.Car;
import com.crud_love.api.repository.CarRepository;

import jakarta.validation.Valid;

@RequestMapping("/car")
@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@PostMapping
	public void createCar(@Valid @RequestBody CarDTO carDTO) {
		Car car = new Car(carDTO);
		carRepository.save(car);
	}

	@GetMapping
	public List<Car> getCars() {
		return carRepository.findAll();
	}

	@PutMapping("/{id}")
	public void updateCar(@Valid @RequestBody CarDTO carDTO, @PathVariable Long id) {
		carRepository.findById(id).map(user -> {
			user.setAnoModelo(carDTO.anoModelo());
			user.setDataFabricacao(carDTO.dataFabricacao());
			user.setFabricante(carDTO.fabricante());
			user.setModelo(carDTO.modelo());
			user.setValor(carDTO.valor());

			return carRepository.save(user);
		});
	}

	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable Long id) {
		carRepository.deleteById(id);
	}
}
