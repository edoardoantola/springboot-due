package com.majorbit.springboot_due;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorbit.springboot_due.model.Flight;
import com.majorbit.springboot_due.model.dao.DAOFlight;

@Service
public class FlightService {

    @Autowired(required=true)
    private DAOFlight dao;

    public List<Flight> getAvailableFlights() {
        return dao.getAvailableFlights();
    }

    public Flight getFlightById(int flightId) {
        return dao.getFlightById(flightId);
    }
}

