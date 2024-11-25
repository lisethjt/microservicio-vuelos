package com.vuelos.application.usercase;

import com.vuelos.domain.model.Flight;

public interface GetFlight {

	public Flight execute(Long id);
}