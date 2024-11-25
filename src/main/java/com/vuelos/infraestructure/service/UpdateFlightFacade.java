package com.vuelos.infraestructure.service;

import com.vuelos.infraestructure.payload.FlightResponse;

public interface UpdateFlightFacade {

	public FlightResponse updateFlight(Long id);
}