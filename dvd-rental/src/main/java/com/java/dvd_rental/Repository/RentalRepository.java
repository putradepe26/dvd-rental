package com.java.dvd_rental.Repository;


import com.java.dvd_rental.Entity.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // You can define custom query methods here if needed
}

