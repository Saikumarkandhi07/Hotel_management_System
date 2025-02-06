package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.repository.BookingRepository;

@Component
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public BookingInformation getBookingInfo(BookingInformation bookingInformation) {
		
		return bookingRepository.save(bookingInformation);
	}

//	@Override
//	public boolean isEmailExist(String email, BookingInformation bookinfo) {
//		
//		    return bookingRepository.findByEmailid(email).equals(bookinfo.getEmailid());
//		
//	}
}
