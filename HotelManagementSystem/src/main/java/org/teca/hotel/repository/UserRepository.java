package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.UserInformation;

public interface UserRepository extends JpaRepository<UserInformation, Integer>{

   UserInformation findByEmailidAndPassword(String emailid,String password);	
}

