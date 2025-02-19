package de.adorsys.xs2a.gateway.service;

public interface PaymentInitiationService {
    PaymentInitiationRequestResponse initiateSinglePayment(String paymentProduct, Object body, Headers headers);

    SinglePaymentInitiationInformationWithStatusResponse getSinglePaymentInformation(String paymentProduct, String paymentId, Headers headers);

    PaymentInitiationScaStatusResponse getPaymentInitiationScaStatus(String paymentService, String paymentProduct, String paymentId, String authorisationId, Headers headers);

    PaymentInitiationStatus getSinglePaymentInitiationStatus(String paymentProduct, String paymentId, Headers headers);

    PaymentInitiationAuthorisationResponse getPaymentInitiationAuthorisation(String paymentService, String paymentProduct, String paymentId, Headers headers);
}
