/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Airport;
import com.miage.bookingclient.models.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Tamer
 */
public class BookingService {

    RestTemplate restTemplate;

    public BookingService() {
        this.restTemplate = new RestTemplate();
    }

    public Booking createBooking(Booking b) {
        Booking booking = restTemplate.postForObject("http://localhost:8086/api/book/create", b, Booking.class);
        return booking;
    }
}
