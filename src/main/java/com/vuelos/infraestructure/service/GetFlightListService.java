package com.vuelos.infraestructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vuelos.application.outport.FlightRepositoryPort;
import com.vuelos.application.usercase.GetFlightList;
import com.vuelos.domain.model.Flight;

@Service
public class GetFlightListService implements GetFlightList {

	private FlightRepositoryPort flightRepositoryPort;

	public GetFlightListService(FlightRepositoryPort flightRepositoryPort) {
		this.flightRepositoryPort = flightRepositoryPort;
	}

	@Override
	public List<Flight> execute() {
		return flightRepositoryPort.getFlightList();
	}
}