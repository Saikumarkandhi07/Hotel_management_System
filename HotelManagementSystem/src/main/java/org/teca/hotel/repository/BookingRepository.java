package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.BookingInformation;

public interface BookingRepository extends JpaRepository<BookingInformation,Integer>{

//	BookingInformation findByEmailid(String email);

}
