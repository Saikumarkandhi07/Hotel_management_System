package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.PaymentInformation;

public interface PaymentRepository extends JpaRepository<PaymentInformation, Integer>{

}
