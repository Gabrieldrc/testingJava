package com.gdrc.testingJava.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
