package com.majorbit.springboot_due.model.dao;

import com.majorbit.springboot_due.model.Booking;

public interface IDAOBooking {

    public void addBooking(Booking booking);
    public void deleteBooking(int bookingId);
    
}
