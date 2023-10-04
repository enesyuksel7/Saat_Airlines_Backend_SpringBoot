package com.saatairlines.backend.repository;

import com.saatairlines.backend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportDao extends JpaRepository<Airport, Long> {


}
