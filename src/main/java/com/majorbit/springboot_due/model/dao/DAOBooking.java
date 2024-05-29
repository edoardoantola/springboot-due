package com.majorbit.springboot_due.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.majorbit.springboot_due.model.Booking;

@Repository
public class DAOBooking implements IDAOBooking {
    
    public List<Booking> getAllBookings() {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            c = DB.getConnection();
            p = c.prepareStatement("SELECT * FROM `Booking`");
            rs = p.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("flight_id"),
                    rs.getString("passenger_name"),
                    rs.getString("passenger_email"),
                    rs.getDate("booking_date"),
                    rs.getString("seat_number"),
                    rs.getString("status")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, p, rs);
        }
        return bookings;
    }
    public void addBooking(Booking booking) {
        Connection c = null;
        PreparedStatement p = null;
        
        try {
            c = DB.getConnection();
            p = c.prepareStatement("INSERT INTO `Booking` (flight_id, passenger_name, passenger_email, booking_date, seat_number, status) VALUES (?, ?, ?, ?, ?, ?)");
            p.setInt(1, booking.getFlightId());
            p.setString(2, booking.getPassengerName());
            p.setString(3, booking.getPassengerEmail());
            p.setDate(4, new java.sql.Date(booking.getBookingDate().getTime()));
            p.setString(5, booking.getSeatNumber());
            p.setString(6, booking.getStatus());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, p, null);
        }
    }

    public void deleteBooking(int bookingId) {
        Connection c = null;
        PreparedStatement p = null;
        
        try {
            c = DB.getConnection();
            p = c.prepareStatement("DELETE FROM `Booking` WHERE booking_id = ?");
            p.setInt(1, bookingId);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, p, null);
        }
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
