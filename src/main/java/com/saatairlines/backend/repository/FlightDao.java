package com.saatairlines.backend.repository;

import com.saatairlines.backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDao extends JpaRepository<Flight, Long> {

}
