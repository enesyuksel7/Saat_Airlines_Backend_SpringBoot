package com.saatairlines.backend.repository;

import com.saatairlines.backend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteDao extends JpaRepository<Route, Long> {
}
