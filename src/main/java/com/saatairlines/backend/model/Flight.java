package com.saatairlines.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flights")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "flight_number")
    String flightNumber;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;

    @Column(name = "price")
    float price;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    @Column(name = "departure_time")
    Date departureTime;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    @Column(name = "arrival_time")
    Date arrivalTime;

    @Column(name = "capacity")
    int capacity;

    @Column(name = "status")
    String status;


}
