package com.java.dvd_rental.Repository;

import com.java.dvd_rental.Entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {
    // You can define custom query methods here if needed
}
