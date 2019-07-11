package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Booking;
import com.thamarai.p6.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;	
	
	public List<Booking> getAllBookings() {
		List<Booking> bookings = new ArrayList<>();
		bookingRepository.findAll()
		.forEach(bookings::add);
		return bookings;
	}
	
	public Optional<Booking> getBooking(Long id) {
		return bookingRepository.findById(id);
	}
	
	public void addBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public void updateBooking(Long id, Booking booking) {
		bookingRepository.save(booking);
	}
	
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}
