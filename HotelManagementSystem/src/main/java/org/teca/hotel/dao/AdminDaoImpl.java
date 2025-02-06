package org.teca.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.AdminInformation;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.PaymentInformation;
import org.teca.hotel.entity.UserInformation;
import org.teca.hotel.repository.AdminRepository;
import org.teca.hotel.repository.HotelRepository;
import org.teca.hotel.repository.PaymentRepository;
import org.teca.hotel.repository.UserRepository;

@Component
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public AdminInformation adminLogin(String emailid, String password) {
	
		return adminRepository.findByAdminemailidAndAdminpassword(emailid,password);
	}

	@Override
	public List<UserInformation> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public List<HotelInformation> getAllHotel() {
		
		return hotelRepository.findAll();
	}

	@Override
	public List<PaymentInformation> getAllPayment() {
		
		return paymentRepository.findAll();
	}

	@Override
	public UserInformation getUserById(int id) {
		
		return userRepository.findById(id).orElse(new UserInformation());
	}

	@Override
	public UserInformation updateUserDetails(UserInformation information) {
		
	 return	userRepository.save(information);		
	}

	@Override
	public void deleteUserInformation(int id) {
		
		 userRepository.deleteById(id);
	}
	
	@Override
	public HotelInformation getHotelById(int id) {
		
		return hotelRepository.findById(id).orElse(new HotelInformation());
	}
	
	@Override
	public HotelInformation updateHotelDetails(HotelInformation information) {
		
		return hotelRepository.save(information);
	}

	@Override
	public void deleteHotelInformation(int id) {
		hotelRepository.deleteById(id);
		
	}
	
}
