/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Booking;

/**
 *
 * @author shafiq
 */
public class Booking {

    private String bookingId;
    private String flightId;
    private String passengerId;
    private PaymentStatus paymentStatus;

    // Constructor
    public Booking(String bookingId, String flightId, String passengerId, PaymentStatus paymentStatus) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "FlightBooking{"
                + "bookingId='" + bookingId + '\''
                + ", flightId='" + flightId + '\''
                + ", passengerId='" + passengerId + '\''
                + ", paymentStatus=" + paymentStatus
                + '}';
    }
}

enum PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED
}
