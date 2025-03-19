package com.java.dvd_rental.Repository;

import com.java.dvd_rental.Entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    // You can define custom query methods here if needed
}