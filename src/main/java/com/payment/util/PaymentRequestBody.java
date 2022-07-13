package com.payment.util;

import com.payment.models.BankPaymentMethod;
import com.payment.models.CreditCardPaymentMethod;

public class PaymentRequestBody {

	private PaymentEnum paymentType;

	public PaymentEnum getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentEnum paymentType) {
		this.paymentType = paymentType;
	}

	public BankPaymentMethod getBankPaymentMethod() {
		return bankPaymentMethod;
	}

	public void setBankPaymentMethod(BankPaymentMethod bankPaymentMethod) {
		this.bankPaymentMethod = bankPaymentMethod;
	}

	public CreditCardPaymentMethod getCreditCardPaymentMethod() {
		return creditCardPaymentMethod;
	}

	public void setCreditCardPaymentMethod(CreditCardPaymentMethod creditCardPaymentMethod) {
		this.creditCardPaymentMethod = creditCardPaymentMethod;
	}

	private BankPaymentMethod bankPaymentMethod;
	private CreditCardPaymentMethod creditCardPaymentMethod;
}
