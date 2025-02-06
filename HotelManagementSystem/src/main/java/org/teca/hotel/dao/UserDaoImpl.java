package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.UserInformation;
import org.teca.hotel.repository.HotelRepository;
import org.teca.hotel.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserInformation userRegistration(UserInformation userInformation) {
		
		// UserInformation information=userRepository.save(userInformation);
       // return information;
		return userRepository.save(userInformation);
	}

	@Override
	public UserInformation userLogin(String emailid, String password) {
		
		return userRepository.findByEmailidAndPassword(emailid, password);
	}
	

}

