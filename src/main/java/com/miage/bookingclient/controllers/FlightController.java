/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Airport;
import com.miage.bookingclient.models.Flight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rayhane
 */
@Controller
public class FlightController {

    FlightService service = new FlightService();

    @GetMapping("/flights")
    public String getFlights(String origin, String destination, String date, Model model) {

        List<Flight> list = new ArrayList<Flight>();
        list = service.getFlights(origin, destination, date);
        model.addAttribute("flights", list);
        return "flights";
    }
}
