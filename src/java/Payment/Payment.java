import java.math.BigDecimal;
import java.sql.Timestamp;

public class Payment {
    private int paymentId;
    private int bookingId;
    private String paymentMethod;
    private BigDecimal amount;
    private Timestamp transactionDatetime;

    // Constructors
    public Payment() {
    }

    public Payment(int bookingId, BigDecimal amount) {
        this.bookingId = bookingId;
        this.amount = amount;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(Timestamp transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", bookingId=" + bookingId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", transactionDatetime=" + transactionDatetime +
                '}';
    }
}
