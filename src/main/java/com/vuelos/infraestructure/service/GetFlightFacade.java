package com.vuelos.infraestructure.service;

import com.vuelos.infraestructure.payload.FlightResponse;

public interface GetFlightFacade {

	public FlightResponse getFlight(Long id);
}