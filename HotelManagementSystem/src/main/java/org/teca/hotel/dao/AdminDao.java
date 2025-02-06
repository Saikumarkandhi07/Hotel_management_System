package org.teca.hotel.dao;


import java.util.List;

import org.teca.hotel.entity.AdminInformation;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.PaymentInformation;
import org.teca.hotel.entity.UserInformation;

public interface AdminDao {

	AdminInformation adminLogin(String emailid,String password);
	
	List<UserInformation> getAllUser();
	
	List<HotelInformation> getAllHotel();
	
	List<PaymentInformation> getAllPayment();
	
	UserInformation getUserById(int id);
	
	UserInformation updateUserDetails(UserInformation information);
	
	void deleteUserInformation(int id);
	
	HotelInformation getHotelById(int id);
	
	HotelInformation updateHotelDetails(HotelInformation information);
	
	void deleteHotelInformation(int id);
}
