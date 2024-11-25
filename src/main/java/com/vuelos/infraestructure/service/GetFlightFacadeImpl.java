package com.vuelos.infraestructure.service;

import org.springframework.stereotype.Service;

import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.mapper.FlightDtoMapper;
import com.vuelos.infraestructure.payload.FlightResponse;
import com.vuelos.infraestructure.payload.MessageResponse;

@Service
public class GetFlightFacadeImpl implements GetFlightFacade {

	private GetFlightService getFlightService;

	public GetFlightFacadeImpl(GetFlightService getFlightService) {
		this.getFlightService = getFlightService;
	}

	@Override
	public FlightResponse getFlight(Long id) {
		FlightResponse flightResponse = new FlightResponse();
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setCode("10");
		messageResponse.setMessage("Exito");

		Flight flight = getFlightService.execute(id);
		if (flight != null) {
			flightResponse.setFlight(FlightDtoMapper.toFlightDto(flight));
			flightResponse.setMessage(messageResponse);
			return flightResponse;
		}

		messageResponse.setCode("20");
		messageResponse.setMessage("Error");
		flightResponse.setMessage(messageResponse);
		return flightResponse;

	}
}