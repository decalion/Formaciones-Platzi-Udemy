package com.icaballero.javatest.payments;

public interface PaymentsGateway {


    PaymentResponse requestPayment(PaymentRequest request);
}
