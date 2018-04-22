/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Airport;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rayhane
 */

public class AirportService {
    
    RestTemplate restTemplate;
    Airport[] airportsList;
    
    public AirportService(){
        this.airportsList = new Airport[100];
        this.restTemplate = new RestTemplate();
    }
    
    public Airport[] getByName(String airportName) {
       
        final ResponseEntity<Airport[]> responseEntity
                = this.restTemplate.getForEntity("http://localhost:8086/api/airports/{airportName}", Airport[].class, airportName);

        return responseEntity.getBody();    
    }

    public Airport[] getAll() {
        final ResponseEntity<Airport[]> responseEntity
                = this.restTemplate.getForEntity("http://localhost:8086/api/airports", Airport[].class);

        return responseEntity.getBody();    
 
    }
    
}
