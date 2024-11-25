package com.vuelos.application.outport;

import java.util.List;

import com.vuelos.domain.model.Flight;

public interface FlightRepositoryPort {

	public List<Flight> getFlightList();
	
	public Flight getFlight(Long id);
	
	public Flight updateFlight(Flight flight);
}