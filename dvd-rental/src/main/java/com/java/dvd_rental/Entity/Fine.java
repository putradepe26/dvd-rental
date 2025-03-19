package com.java.dvd_rental.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private int rentalId; // Rental ID field

    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    private FineReason reason; // Change to enum type

    // Enum for Fine Reasons
    public enum FineReason {
        LATE_RETURN("Late Return"),
        DAMAGED("Damaged"),
        LOST("Lost"),
        OTHER("Other");

        private final String displayName;

        FineReason(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public FineReason getReason() {
        return reason;
    }

    public void setReason(FineReason reason) {
        this.reason = reason;
    }
}