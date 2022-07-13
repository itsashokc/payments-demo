package com.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.Exception.NoSuchAccountExistsException;
import com.payment.models.BankPaymentMethod;
import com.payment.repositories.BankPaymentMethodRepository;

@Service
public class BankPaymentMethodService {

	@Autowired
	private BankPaymentMethodRepository bankPaymentMethodRepository;

	public BankPaymentMethod saveBankPaymentMethod(BankPaymentMethod bankPaymentMethod) {
		return bankPaymentMethodRepository.save(bankPaymentMethod);
	}

	public BankPaymentMethod findByBankAccountNo(String bankAccountNo) {
		try {
		return bankPaymentMethodRepository.findByBankAccountNo(bankAccountNo);}
		catch(Exception e) {
			throw new NoSuchAccountExistsException("No Bank Account with account number " + bankAccountNo +" is present");
		}
	}

	public String deleteByBankAccountNo(String bankAccountNo) {
		try {
			bankPaymentMethodRepository.delete(bankPaymentMethodRepository.findByBankAccountNo(bankAccountNo));
			return "DELETED";
		} catch (Exception e) {
			throw new NoSuchAccountExistsException("No Bank Account with account number " + bankAccountNo +" is present");
		}
	}
	
	public BankPaymentMethod updateBankPaymentMethod(BankPaymentMethod bankPaymentMethod) {
		deleteByBankAccountNo(bankPaymentMethod.getBankAccountNo());
		return saveBankPaymentMethod(bankPaymentMethod);
	}

}
