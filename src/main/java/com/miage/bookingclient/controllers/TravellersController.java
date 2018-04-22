/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.bookingclient.controllers;

import com.miage.bookingclient.models.Flight;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Rayhane
 */
@Controller
public class TravellersController {
    

    @PostMapping("/travel")
    public String addTravelers() {
        return "travellers";
    }
    
    @GetMapping("/travel")
    public String getPage() {
        return "travellers";
    }
}
