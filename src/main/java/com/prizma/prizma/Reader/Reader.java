package com.prizma.prizma.Reader;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String email;
    private String author;
    private String book;

    private String subscription;
    private double amount;
    @Column(name = "payment_method") // Ensure column name matches the database
    private String paymentMethod;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime timestamp;
    public Reader(){

    }

    public Reader(int id, String email, String author, String book, String subscription, double amount, String paymentMethod, LocalDateTime timestamp) {
        this.id = id;
        this.email = email;
        this.author = author;
        this.book = book;
        this.subscription = subscription;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.timestamp = timestamp;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
