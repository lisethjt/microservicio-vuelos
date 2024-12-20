package com.vuelos.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelos.infraestructure.payload.FlightListResponse;
import com.vuelos.infraestructure.payload.FlightResponse;
import com.vuelos.infraestructure.service.GetFlightFacade;
import com.vuelos.infraestructure.service.GetFlightListFacade;
import com.vuelos.infraestructure.service.UpdateFlightFacade;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "flight")
public class FlightController {

	private GetFlightListFacade getFlightListFacadeService;
	private GetFlightFacade getFlightFacadeService;
	private UpdateFlightFacade updateFlightFacade;

	public FlightController(GetFlightListFacade getFlightListFacadeService, GetFlightFacade getFlightFacadeService,
			UpdateFlightFacade updateFlightFacade) {
		this.getFlightListFacadeService = getFlightListFacadeService;
		this.getFlightFacadeService = getFlightFacadeService;
		this.updateFlightFacade = updateFlightFacade;
	}

	@GetMapping(value = "/getFlightList")
	ResponseEntity<FlightListResponse> getFlightList() {
		return new ResponseEntity<>(getFlightListFacadeService.getFlightList(), HttpStatus.OK);
	}

	@GetMapping(value = "/{flightId}")
	ResponseEntity<FlightResponse> getFlight(@PathVariable Long flightId) {
		return new ResponseEntity<>(getFlightFacadeService.getFlight(flightId), HttpStatus.OK);
	}

	@PutMapping(value = "/updateFlight/{flightId}")
	ResponseEntity<FlightResponse> updateFlight(@PathVariable Long flightId) {
		return new ResponseEntity<>(updateFlightFacade.updateFlight(flightId), HttpStatus.OK);
	}
}