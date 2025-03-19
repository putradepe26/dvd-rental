package com.java.dvd_rental.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String name;
    private String contactInfo;

    // Getters and Setters
    public int getMemberId() 
    {
        return memberId;
    }
    public void setMemberId(int memberId) 
    {
        this.memberId = memberId;
    }
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public String getContactInfo() 
    {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }
}
