package com.majorbit.springboot_due;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorbit.springboot_due.model.Booking;
import com.majorbit.springboot_due.model.dao.DAOBooking;

@Service
public class BookingService {
    
    @Autowired
    private DAOBooking dao;

    public void bookFlight(Booking booking) {
        dao.addBooking(booking);
    }

    public void cancelBooking(int bookingId) {
        dao.deleteBooking(bookingId);
    }

    public List<Booking> getAllBookings() {
        return dao.getAllBookings();
    }
}

