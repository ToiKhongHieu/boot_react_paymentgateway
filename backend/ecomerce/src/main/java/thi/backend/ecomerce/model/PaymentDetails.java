package thi.backend.ecomerce.model;

public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;
    private String razopayPaymentLinkId;
    private String razopayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;
    private String razorpayPaymentId;

    public PaymentDetails() {
    }

    public PaymentDetails(String paymentMethod, String status, String paymentId, String razopayPaymentLinkId, String razopayPaymentLinkReferenceId, String razorpayPaymentLinkStatus, String razorpayPaymentId) {
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentId = paymentId;
        this.razopayPaymentLinkId = razopayPaymentLinkId;
        this.razopayPaymentLinkReferenceId = razopayPaymentLinkReferenceId;
        this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRazopayPaymentLinkId() {
        return razopayPaymentLinkId;
    }

    public void setRazopayPaymentLinkId(String razopayPaymentLinkId) {
        this.razopayPaymentLinkId = razopayPaymentLinkId;
    }

    public String getRazopayPaymentLinkReferenceId() {
        return razopayPaymentLinkReferenceId;
    }

    public void setRazopayPaymentLinkReferenceId(String razopayPaymentLinkReferenceId) {
        this.razopayPaymentLinkReferenceId = razopayPaymentLinkReferenceId;
    }

    public String getRazorpayPaymentLinkStatus() {
        return razorpayPaymentLinkStatus;
    }

    public void setRazorpayPaymentLinkStatus(String razorpayPaymentLinkStatus) {
        this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }
}
