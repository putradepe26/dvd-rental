package com.java.dvd_rental.Service;

import java.util.List;
import com.java.dvd_rental.Entity.Rental;


public interface RentalService 
{
    void rentDVD(int dvdId, int memberId, int rentalDuration);
    void returnDVD(int rentalId, boolean isDamaged, boolean isLost);
    double calculateRentalPrice(int dvdId, int rentalDuration, boolean isMember);
    double calculateFine(int rentalId, boolean isLost, boolean isDamaged);
    List<Rental> getAllRentals();
    void addRental(Rental rental);
    void editRental(Rental rental);
    void returnRental(int rentalId);
    Rental findById(int id);
}