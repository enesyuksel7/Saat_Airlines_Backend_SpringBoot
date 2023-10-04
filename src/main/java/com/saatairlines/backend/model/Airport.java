package com.saatairlines.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="airports")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "code")
    String code;

    @Column(name = "city")
    String city;

    @Column(name = "country")
    String country;
}
