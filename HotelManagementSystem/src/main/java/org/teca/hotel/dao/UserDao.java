package org.teca.hotel.dao;

import org.teca.hotel.entity.UserInformation;

public interface UserDao {

	UserInformation userRegistration(UserInformation userInformation);
	UserInformation userLogin(String emailid,String password);
	
}
