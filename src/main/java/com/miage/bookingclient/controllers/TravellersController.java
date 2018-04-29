/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Traveller;
import com.miage.bookingclient.models.Booking;
import com.miage.bookingclient.models.Flight;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Rayhane
 */
@Controller
public class TravellersController {

    FlightService service = new FlightService();
    BookingService bookingService = new BookingService();

    @GetMapping("/travel")
    public String getPage(String flightId, Model model) {
        Flight flight = service.getFlightById(flightId);
        System.out.println("" + flight);
        model.addAttribute("flight", flight);
        return "travellers";
    }

    @PostMapping("/travel")
    public String addTravelers(@ModelAttribute("flightId") String flightId, @ModelAttribute("traveller") Traveller traveller, BindingResult result, Model model) {
        Flight flight = service.getFlightById(flightId);
        Booking b = new Booking();

        b.setBookingDate(new Date());

        List<Flight> list = new ArrayList<Flight>();
        list.add(flight);
        b.setFlights(list);

        List<Traveller> listTravellers = new ArrayList<Traveller>();
        listTravellers.add(traveller);
        b.setTravellers(listTravellers);

        Booking bCreated = bookingService.createBooking(b);
        System.out.println("" + bCreated);
        model.addAttribute("booking", bCreated);
        return "booking";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }
}
