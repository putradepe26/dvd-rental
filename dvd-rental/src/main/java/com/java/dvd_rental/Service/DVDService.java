package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.DVD;
import java.util.List;

public interface DVDService 
{
    void addDvd(DVD dvd);
    void updateDvd(DVD dvd);
    void deleteDvd(int id);
    DVD getDvdById(int id);
    List<DVD> getAllDvds();
}