package com.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.models.BankPaymentMethod;

@Repository
public interface BankPaymentMethodRepository extends JpaRepository<BankPaymentMethod, Long> {

	BankPaymentMethod findByBankAccountNo(String bankAccountNo);

}
