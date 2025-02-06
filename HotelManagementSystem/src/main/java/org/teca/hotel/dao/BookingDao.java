package org.teca.hotel.dao;

import org.teca.hotel.entity.BookingInformation;

public interface BookingDao {

	BookingInformation getBookingInfo(BookingInformation bookingInformation);
//	boolean isEmailExist(String email, BookingInformation bookinfo);
}
