package by.myfirstweb.test.domain.to;

public class Payment {
    private double resultPrice;
    private int orderId;
    private int userId;
    private int paymentId;

    public Payment() {}

    public double getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(double resultPrice) {
        this.resultPrice = resultPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
