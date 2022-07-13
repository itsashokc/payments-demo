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

import com.payment.models.CreditCardPaymentMethod;
import com.payment.services.CreditCardPaymentMethodService;
import com.payment.util.PaymentEnum;
import com.payment.util.PaymentRequestBody;

@CrossOrigin
@RestController
@RequestMapping("/creditcard")
public class CreditCardPaymentMethodController {

	@Autowired
	private CreditCardPaymentMethodService creditCardPaymentMethodService;

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CreditCardPaymentMethod saveCreditCardPaymentMethod(@RequestBody PaymentRequestBody paymentMethod) {
		if (paymentMethod.getPaymentType() == PaymentEnum.CREDITCARD) {
			return creditCardPaymentMethodService
					.saveCreditCardPaymentMethod((CreditCardPaymentMethod) paymentMethod.getCreditCardPaymentMethod());
		}
		return null;
	}

	@GetMapping("/{creditCardNo}")
	public CreditCardPaymentMethod findByCreditCardNo(@PathVariable("creditCardNo") String creditCardNo) {
		return creditCardPaymentMethodService.findByCreditCardNo(creditCardNo);
	}

	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CreditCardPaymentMethod updateCreditCardPaymentMethod(@RequestBody PaymentRequestBody paymentMethod) {
		if (paymentMethod.getPaymentType() == PaymentEnum.CREDITCARD) {
			return creditCardPaymentMethodService.updateCreditCardPaymentMethod(
					(CreditCardPaymentMethod) paymentMethod.getCreditCardPaymentMethod());
		}
		return null;
	}

	@DeleteMapping("/{creditCardNo}")
	public String deleteByCreditCardNo(@PathVariable("creditCardNo") String creditCardNo) {
		return creditCardPaymentMethodService.deleteByCreditCardNo(creditCardNo);
	}

}
