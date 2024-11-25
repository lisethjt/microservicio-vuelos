package com.vuelos.infraestructure.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vuelos.application.outport.FlightRepositoryPort;
import com.vuelos.application.usercase.UpdateFlight;
import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.util.FlightConstant;
import com.vuelos.infraestructure.util.exception.FlightException;

@Service
public class UpdateFlightService implements UpdateFlight {

	private FlightRepositoryPort flightRepository;

	public UpdateFlightService(FlightRepositoryPort flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public Flight execute(Long id) {
		Flight flight = flightRepository.getFlight(id);
		if (flight != null) {
			flight.setChairs(flight.getChairs()-1);
			
		}else {
			new FlightException(HttpStatus.BAD_REQUEST, FlightConstant.FLIGTH_NOT_FOUND_MESSAGE_ERROR);
		}
		
		 return flightRepository.updateFlight(flight);
	}
}