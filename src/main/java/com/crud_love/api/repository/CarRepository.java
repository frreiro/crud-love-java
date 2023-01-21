package com.crud_love.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_love.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
