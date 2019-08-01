package com.icaballero.javatest.payments;

public class PaymentProcessor {

    private PaymentsGateway paymentGateway;

    public PaymentProcessor(PaymentsGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){

        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if(response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }else{
            return false;
        }
    }


}


