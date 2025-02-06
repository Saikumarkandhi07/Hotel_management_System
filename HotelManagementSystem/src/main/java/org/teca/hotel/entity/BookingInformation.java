package org.teca.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Setters,@getters,@toString,@hashCode all are present inside in one annotation - @Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	private String firstname;
	private String lastname;
	@Column(unique = true,nullable = false)
	private String emailid;
	@Column(unique = true,nullable = false,length = 10)
	private String mobilenumber;
	private LocalDate bookingdate;
	private String hotelname;
	private int noofdays;
	private int noofpersons;
	private int noofrooms;
	private double price;
}
