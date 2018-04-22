/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Airport;
import com.miage.bookingclient.models.Flight;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rayhane
 */
public class FlightService {

    RestTemplate restTemplate;
    Flight[] flightsList;

    public FlightService() {
        this.flightsList = new Flight[100];
        this.restTemplate = new RestTemplate();
    }

    public List<Flight> getFlights(String origin, String destination, String departure) {
        System.out.println("" + origin);
        //final ResponseEntity<Flight[]> responseEntity                = this.restTemplate.getForEntity("http://localhost:8086/api/flights/{origin}/{destination}", Flight[].class, origin, destination);

        ResponseEntity<List<Flight>> flightResponse
                = restTemplate.exchange("http://localhost:8086/api/flights/" + origin + "/" + destination,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {
                });
        return flightResponse.getBody();
    }

}
