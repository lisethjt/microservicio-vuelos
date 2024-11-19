package com.vuelos.infraestructure.mapper;

import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.entities.FlightEntity;

public final class FlightDboMapper {

	public static Flight toFlight(FlightEntity flight) {		
		return Flight.builder()
				.id(flight.getId())
				.company(flight.getCompany())
				.chairs(flight.getChairs())
				.date(flight.getDate())
				.price(flight.getPrice())
				.build();
	}
}