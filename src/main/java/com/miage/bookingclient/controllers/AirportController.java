/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

/**
 *
 * @author Rayhane
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.miage.bookingclient.models.Airport;
import com.miage.bookingclient.models.Flight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Rayhane
 */
@Controller
public class AirportController {
    
    AirportService service = new AirportService();
    
    @GetMapping("/home")
    public String allAirports(Model model) {
        
        List<Airport> airports = new ArrayList<>();
        
        Airport [] list = new Airport[50];
        list = service.getAll();
        
        airports = Arrays.asList(list);
        for (Airport ar: list){
            System.out.println("" + ar.getName());

        }
        model.addAttribute("airports", airports);
        return "airports";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        getByName(restTemplate, "Ataturk");
        
    }
    
    private void getByName(RestTemplate restTemplate, String airportName) {
        

        final ResponseEntity<Airport> responseEntity
                = restTemplate.getForEntity("http://localhost:8081/api/airports/{airportName}", Airport.class, airportName);

        printAirport(responseEntity.getBody());
    }

    private void getAll(RestTemplate restTemplate) {
        final ResponseEntity<Airport[]> responseEntity
                = restTemplate.getForEntity("http://localhost:8081/api/airports", Airport[].class);

        System.out.println("Status code =" + responseEntity.getStatusCode());
        for (Airport airport : responseEntity.getBody()) {
            printAirport(airport);
        }
    }

    private void printAirport(Airport airport) {
        System.out.println("Customer:");
        System.out.println("    IATA = " + airport.getIata());
        System.out.println("    Name = " + airport.getName());
        System.out.println("    Country = " + airport.getCountry());
    }*/
    
}
