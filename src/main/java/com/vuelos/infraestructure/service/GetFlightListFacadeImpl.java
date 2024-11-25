package com.vuelos.infraestructure.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vuelos.application.usercase.GetFlightList;
import com.vuelos.infraestructure.mapper.FlightDtoMapper;
import com.vuelos.infraestructure.payload.FlightDto;
import com.vuelos.infraestructure.payload.FlightListResponse;
import com.vuelos.infraestructure.payload.MessageResponse;

@Service
public class GetFlightListFacadeImpl implements GetFlightListFacade {

	private GetFlightList getFlightListService;

	public GetFlightListFacadeImpl(GetFlightList getFlightListService) {
		this.getFlightListService = getFlightListService;
	}

	public FlightListResponse getFlightList() {
		FlightListResponse flightListResponse = new FlightListResponse();
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setCode("10");
		messageResponse.setMessage("Exito");

		List<FlightDto> flightList = getFlightListService.execute()
				.stream()
				 .map(FlightDtoMapper::toFlightDto)
				.collect(Collectors.toList());
		if (flightList.size() > 0) {
			flightListResponse.setFlightList(flightList);
			flightListResponse.setMessage(messageResponse);
			return flightListResponse;
		}

		messageResponse.setCode("20");
		messageResponse.setMessage("Error");
		flightListResponse.setMessage(messageResponse);
		return flightListResponse;
	}
}