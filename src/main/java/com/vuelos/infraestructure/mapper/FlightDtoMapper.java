package com.vuelos.infraestructure.mapper;

import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.payload.FlightDto;

public final class FlightDtoMapper {

	public static FlightDto toFlightDto(Flight flight) {		
		return FlightDto.builder()
				.id(flight.getId())
				.company(flight.getCompany())
				.chairs(flight.getChairs())
				.date(flight.getDate())
				.price(flight.getPrice())
				.build();
	}
}