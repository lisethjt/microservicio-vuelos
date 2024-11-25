package com.vuelos.infraestructure.service;

import org.springframework.stereotype.Service;

import com.vuelos.application.outport.FlightRepositoryPort;
import com.vuelos.application.usercase.GetFlight;
import com.vuelos.domain.model.Flight;

@Service
public class GetFlightService implements GetFlight {

	private FlightRepositoryPort flightRepositoryPort;

	public GetFlightService(FlightRepositoryPort flightRepositoryPort) {
		this.flightRepositoryPort = flightRepositoryPort;
	}

	@Override
	public Flight execute(Long id) {		
		return this.flightRepositoryPort.getFlight(id);
	}	
}