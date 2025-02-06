package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.PaymentInformation;
import org.teca.hotel.repository.PaymentRepository;

@Component
public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public PaymentInformation getPaymentDetails(PaymentInformation payment) {

		return paymentRepository.save(payment);
	}

}
