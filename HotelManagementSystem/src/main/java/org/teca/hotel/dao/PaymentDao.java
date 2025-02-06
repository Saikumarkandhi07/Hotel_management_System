package org.teca.hotel.dao;

import org.teca.hotel.entity.PaymentInformation;

public interface PaymentDao {

	PaymentInformation getPaymentDetails(PaymentInformation payment);
}
