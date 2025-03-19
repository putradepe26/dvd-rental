package com.java.dvd_rental.Repository;

import com.java.dvd_rental.Entity.DVD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Integer> 
{
    // You can define custom query methods here if needed
}
