package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.Fine;
import java.util.List;

public interface FineService 
{
    void addFine(Fine fine);
    void updateFine(Fine fine);
    void deleteFine(int id);
    Fine getFineById(int id);
    List<Fine> getAllFines();
}