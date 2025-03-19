package com.java.dvd_rental.Entity;

//import com.java.dvd_rental.Entity.DVD;
//import com.java.dvd_rental.Entity.Member;

//import javax.persistence.*;

import jakarta.persistence.*;

//import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    @ManyToOne
    @JoinColumn(name = "dvd_id", nullable = false)
    private DVD dvd; // Ensure DVD class is imported

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // Ensure DVD class is imported
    
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private int rentalDuration;
    private double cost;
    private double fine;

    // Getters and Setters
    public int getRentalId() 
    {
        return rentalId;
    }
    public void setRentalId(int rentalId) 
    {
        this.rentalId = rentalId;
    }
    public DVD getDvd() {
        return dvd;
    }
    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public LocalDateTime getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
    
    public int getRentalDuration() {
        return rentalDuration;
    }
    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getFine() {
        return fine;
    }
    public void setFine(double fine) {
        this.fine = fine;
    }
    public void setDvdId(int dvdId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDvdId'");
    }
    
}
