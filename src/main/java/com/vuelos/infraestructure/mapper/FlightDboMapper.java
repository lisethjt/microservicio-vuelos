package com.vuelos.infraestructure.mapper;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.vuelos.domain.model.Flight;
import com.vuelos.infraestructure.entities.FlightEntity;
import com.vuelos.infraestructure.util.FlightConstant;
import com.vuelos.infraestructure.util.exception.FlightException;

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
	
	public static Flight toFlight(Optional<FlightEntity> flight) {		
		if(!flight.isPresent()) {
			flight.orElseThrow(
					() -> new FlightException(HttpStatus.BAD_REQUEST, FlightConstant.FLIGTH_NOT_FOUND_MESSAGE_ERROR )
			);
		}
		return toFlight(flight.get());
		
	}
	
	public static FlightEntity toFlightEntity(Flight flight) {		
		return FlightEntity.builder()		
				.id(flight.getId())
				.company(flight.getCompany())
				.chairs(flight.getChairs())
				.date(flight.getDate())
				.price(flight.getPrice())
				.build();
	}
}