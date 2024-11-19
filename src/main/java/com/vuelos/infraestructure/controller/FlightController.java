package com.vuelos.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelos.infraestructure.payload.FlightListResponse;
import com.vuelos.infraestructure.service.GetFlightListFacade;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "flight")
public class FlightController {

	private GetFlightListFacade getFlightListFacadeService;

	public FlightController(GetFlightListFacade getFlightListFacadeService) {
		this.getFlightListFacadeService = getFlightListFacadeService;
	}

	@GetMapping(value = "/getFlightList")
	ResponseEntity<FlightListResponse> getFlightList() {
		return new ResponseEntity<>(getFlightListFacadeService.getFlightList(), HttpStatus.OK);
	}
}