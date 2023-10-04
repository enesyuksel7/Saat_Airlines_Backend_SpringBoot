package com.saatairlines.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="routes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_airport_id")
    Airport source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport_id")
    Airport destination;

    @Column(name = "distanceinmiles")
    int distanceinmiles;

}
