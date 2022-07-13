package com.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.models.CreditCardPaymentMethod;

@Repository
public interface CreditCardPaymentMethodRepository extends JpaRepository<CreditCardPaymentMethod, Long> {

	CreditCardPaymentMethod findByCreditCardNo(String creditCardNo);

}
