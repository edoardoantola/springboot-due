package com.majorbit.springboot_due;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.majorbit.springboot_due.model.Booking;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    //visualizzazione di tutte le prenotazioni effettuate dagli utenti
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    //inserimento di una prenotazione
    @PostMapping("/book")
    public void bookFlight(@RequestBody Booking booking) {
        bookingService.bookFlight(booking);
    }
    //cancellazione di una prenotazione
    @DeleteMapping("/cancel/{id}")
    public void cancelBooking(@PathVariable int id) {
        bookingService.cancelBooking(id);
    }
}
