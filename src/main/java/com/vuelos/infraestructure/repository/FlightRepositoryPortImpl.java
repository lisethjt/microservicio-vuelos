package com.vuelos.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.vuelos.application.outport.FlightRepositoryPort;
import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.mapper.FlightDboMapper;

@Repository
public class FlightRepositoryPortImpl implements FlightRepositoryPort {

	private FlightRepository flightRepository;

	public FlightRepositoryPortImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public List<Flight> getFlightList() {		
		return flightRepository.findAll().stream()
			.map(FlightDboMapper::toFlight)
			.collect(Collectors.toList());
	}

	@Override
	public Flight getFlight(Long id) {
		return FlightDboMapper.toFlight(flightRepository.findById(id));
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return FlightDboMapper.toFlight(flightRepository.save(FlightDboMapper.toFlightEntity(flight)));
	}
}