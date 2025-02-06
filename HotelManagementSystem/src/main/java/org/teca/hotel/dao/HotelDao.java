package org.teca.hotel.dao;

import java.util.List;

import org.teca.hotel.entity.HotelInformation;

public interface HotelDao {

	HotelInformation hotelRegistration(HotelInformation hotelInformation);
	List<HotelInformation> getAllHotelDetails();
	List<HotelInformation> getHotelDetailsByCity(String city);
	HotelInformation getHotelById(int hotelid);
}
