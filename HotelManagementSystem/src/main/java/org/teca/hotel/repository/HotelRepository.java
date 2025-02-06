package org.teca.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.teca.hotel.entity.HotelInformation;

public interface HotelRepository extends JpaRepository<HotelInformation, Integer>{

	@Query("select hotel from HotelInformation hotel where hotel.city like %?1% or hotel.address like %?1% or hotel.price like %?1%")
	List<HotelInformation> findByCity(String city);
	
}
