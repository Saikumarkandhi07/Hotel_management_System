package org.teca.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelid;
	private  String hotelname;
	@Column(length=10)
	private String contactnumber;
	private double price;
	private String city;
	private String address;
	
}
