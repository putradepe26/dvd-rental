package com.java.dvd_rental.Service;

//Import file dari Entity(Database)
import com.java.dvd_rental.Entity.DVD;
import com.java.dvd_rental.Entity.Member;
import com.java.dvd_rental.Entity.Rental;

//Import file dari Repository
import com.java.dvd_rental.Repository.DVDRepository;
import com.java.dvd_rental.Repository.MemberRepository;
import com.java.dvd_rental.Repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService 
{

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private DVDRepository dvdRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void rentDVD(int dvdId, int memberId, int rentalDuration) 
    {
        DVD dvd = dvdRepository.findById(dvdId)
                .orElseThrow(() -> new RuntimeException("DVD not found"));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Rental rental = new Rental();
        rental.setDvd(dvd);
        rental.setMember(member);
        rental.setRentalDuration(rentalDuration);
        rental.setRentalDate(LocalDateTime.now());

        rentalRepository.save(rental);
    }

    @Override
    public void returnDVD(int rentalId, boolean isDamaged, boolean isLost) 
    {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental record not found"));

        rental.setReturnDate(LocalDateTime.now());
        double fine = calculateFine(rentalId, isLost, isDamaged);
        rental.setFine(fine);

        rentalRepository.save(rental);
    }

    @Override
    public double calculateRentalPrice(int dvdId, int rentalDuration, boolean isMember)
    {
        DVD dvd = dvdRepository.findById(dvdId)
                .orElseThrow(() -> new RuntimeException("DVD not found"));

        double pricePerDay = dvd.isNew() ? 20000 : 10000; // Rp 20,000 for new, Rp 10,000 for old
        double totalPrice = pricePerDay * rentalDuration;

        if (isMember) {
            totalPrice *= 0.9; // 10% discount for members
        }

        return totalPrice;
    }

    @Override
    public double calculateFine(int rentalId, boolean isLost, boolean isDamaged) 
    {
        double fine = 0;

        if (isLost) {
            fine += 100000; // Fine for lost DVD
        } else if (isDamaged) {
            fine += 60000; // Fine for minor damage
        }

        return fine;
    }

    @Override
    public Rental findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    // Method to add a rental

    public void addRental(Rental rental) 
    {
        rentalRepository.save(rental); // Save the rental to the database
    }

    public void editRental(Rental rental) 
    {
        rentalRepository.save(rental); // Save the rental to the database
    }

     // Additional CRUD methods

     public List<Rental> getAllRentals() 
    {
        return rentalRepository.findAll(); // Retrieve all rentals
    }


    public Optional<Rental> getRentalById(int rentalId) 
    {
        return rentalRepository.findById(rentalId); // Retrieve rental by ID
    }


    public void deleteRental(int rentalId) 
    {
        rentalRepository.deleteById(rentalId); // Delete rental by ID
    }

    public void returnRental(int rentalId) 
    {
        rentalRepository.findById(rentalId); // Delete rental by ID
    }
    
}