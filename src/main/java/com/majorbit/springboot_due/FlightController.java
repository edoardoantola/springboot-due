package com.majorbit.springboot_due;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.majorbit.springboot_due.model.Flight;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    
    @Autowired
    private FlightService flightService;

    //ricerca di tutti i voli disponibili
    @GetMapping("/available")
    public List<Flight> getAvailableFlights() {
        return flightService.getAvailableFlights();
    }

    //visualizzazione delle informazioni di un volo
    @GetMapping("/{id}")
    public Flight getFlightDetails(@PathVariable int id) {
        return flightService.getFlightById(id);
    }
}
