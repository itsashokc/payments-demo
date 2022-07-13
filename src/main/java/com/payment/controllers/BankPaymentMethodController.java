package com.payment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.models.BankPaymentMethod;
import com.payment.services.BankPaymentMethodService;
import com.payment.util.PaymentEnum;
import com.payment.util.PaymentRequestBody;

@CrossOrigin
@RestController
@RequestMapping("/bank")
public class BankPaymentMethodController {

	@Autowired
	private BankPaymentMethodService bankPaymentMethodService;

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BankPaymentMethod saveBankPaymentMethod(@RequestBody PaymentRequestBody paymentMethod) {
		if (paymentMethod.getPaymentType() == PaymentEnum.BANK) {
			return bankPaymentMethodService
					.saveBankPaymentMethod((BankPaymentMethod) paymentMethod.getBankPaymentMethod());
		}
		return null;
	}

	@GetMapping("/{accNo}")
	public BankPaymentMethod findByBankAccountNo(@PathVariable("accNo") String bankAccountNo) {
		return bankPaymentMethodService.findByBankAccountNo(bankAccountNo);
	}

	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BankPaymentMethod updateBankPaymentMethod(@RequestBody PaymentRequestBody paymentMethod) {
		if (paymentMethod.getPaymentType() == PaymentEnum.BANK) {
			return bankPaymentMethodService
					.updateBankPaymentMethod((BankPaymentMethod) paymentMethod.getBankPaymentMethod());
		}
		return null;
	}

	@DeleteMapping("/{accNo}")
	public String deleteByBankAccountNo(@PathVariable("accNo") String bankAccountNo) {
		return bankPaymentMethodService.deleteByBankAccountNo(bankAccountNo);
	}
}
