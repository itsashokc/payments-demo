package com.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.Exception.NoSuchAccountExistsException;
import com.payment.models.CreditCardPaymentMethod;
import com.payment.repositories.CreditCardPaymentMethodRepository;

@Service
public class CreditCardPaymentMethodService {

	@Autowired
	private CreditCardPaymentMethodRepository creditCardPaymentMethodRepository;

	public CreditCardPaymentMethod saveCreditCardPaymentMethod(CreditCardPaymentMethod creditCardPaymentMethod) {
		return creditCardPaymentMethodRepository.save(creditCardPaymentMethod);
	}

	public CreditCardPaymentMethod findByCreditCardNo(String creditCardNo) {
		try {
			return creditCardPaymentMethodRepository.findByCreditCardNo(creditCardNo);
		} catch (Exception e) {
			throw new NoSuchAccountExistsException(
					"No Credit Card Account with  number " + creditCardNo + " is present");

		}
	}

	public CreditCardPaymentMethod updateCreditCardPaymentMethod(CreditCardPaymentMethod creditCardPaymentMethod) {
		deleteByCreditCardNo(creditCardPaymentMethod.getCreditCardNo());
		return saveCreditCardPaymentMethod(creditCardPaymentMethod);
	}

	public String deleteByCreditCardNo(String creditCardNo) {
		try {
			creditCardPaymentMethodRepository
					.delete(creditCardPaymentMethodRepository.findByCreditCardNo(creditCardNo));
			return "DELETED";
		} catch (Exception e) {
			throw new NoSuchAccountExistsException(
					"No Credit Card Account with  number " + creditCardNo + " is present");

		}
	}
}
