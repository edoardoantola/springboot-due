package com.majorbit.springboot_due.model.dao;

import java.util.List;

import com.majorbit.springboot_due.model.Flight;

public interface IDAOFlight {

    public List<Flight> getAvailableFlights();
    public Flight getFlightById(int flightId);
    
}
