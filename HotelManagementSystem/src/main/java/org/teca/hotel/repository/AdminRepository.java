package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.AdminInformation;

public interface AdminRepository extends JpaRepository<AdminInformation, Integer>{

	AdminInformation findByAdminemailidAndAdminpassword(String emailid,String password);
}
