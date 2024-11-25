package com.vuelos.domain.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

	private Long id;
	private String company;
	private Instant date;
	private double price;
	private int chairs;
}