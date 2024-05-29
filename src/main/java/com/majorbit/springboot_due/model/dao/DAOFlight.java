package com.majorbit.springboot_due.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.majorbit.springboot_due.model.Flight;

@Repository
public class DAOFlight implements IDAOFlight {
    
    public List<Flight> getAvailableFlights() {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Flight> flights = new ArrayList<>();
        
        try {
            c = DB.getConnection();
            p = c.prepareStatement("SELECT * FROM `Flight` WHERE available_seats > 0");
            rs = p.executeQuery();
            
            while (rs.next()) {
                Flight flight = new Flight(
                    rs.getInt("flight_id"),
                    rs.getString("flight_number"),
                    rs.getString("departure_airport"),
                    rs.getString("arrival_airport"),
                    rs.getDate("departure_time"),
                    rs.getDate("arrival_time"),
                    rs.getInt("seat_capacity"),
                    rs.getInt("available_seats"),
                    rs.getDouble("price")
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, p, rs);
        }
        return flights;
    }

    public Flight getFlightById(int flightId) {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Flight f = null;
        
        try {
            c = DB.getConnection();
            p = c.prepareStatement("SELECT * FROM `Flight` WHERE flight_id = ?");
            p.setInt(1, flightId);
            rs = p.executeQuery();
            
            if (rs.next()) {
                f = new Flight(
                    rs.getInt("flight_id"),
                    rs.getString("flight_number"),
                    rs.getString("departure_airport"),
                    rs.getString("arrival_airport"),
                    rs.getDate("departure_time"),
                    rs.getDate("arrival_time"),
                    rs.getInt("seat_capacity"),
                    rs.getInt("available_seats"),
                    rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, p, rs);
        }
        return f;
    }

    private void closeResources(Connection c, PreparedStatement p, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (p != null) p.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

