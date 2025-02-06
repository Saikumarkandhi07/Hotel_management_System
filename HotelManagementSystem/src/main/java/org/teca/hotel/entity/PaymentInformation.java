package org.teca.hotel.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PaymentInformation {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;
	private String cardnumber;
	private String cardname;
	private LocalDate expiredate;
	private double price;
}
