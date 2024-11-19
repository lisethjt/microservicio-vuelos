package com.vuelos.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuelos.infraestructure.entities.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

}