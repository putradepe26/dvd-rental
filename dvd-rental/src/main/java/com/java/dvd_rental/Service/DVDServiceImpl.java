package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.DVD;

import com.java.dvd_rental.Repository.DVDRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DVDServiceImpl implements DVDService {

    @Autowired
    private DVDRepository dvdRepository;

    @Override
    public List<DVD> getAllDvds() 
    {
        return dvdRepository.findAll(); // Retrieve all DVDs
    }
    
    @Override
    public void addDvd(DVD dvd) {
        dvdRepository.save(dvd); // Save the new DVD
    }

    @Override
    public void updateDvd(DVD dvd) {
        dvdRepository.save(dvd); // Update the existing DVD
    }

    @Override
    public void deleteDvd(int id) {
        dvdRepository.deleteById(id); // Delete the DVD by ID
    }

    @Override
    public DVD getDvdById(int id) {
        return dvdRepository.findById(id).orElse(null); // Retrieve DVD by ID
    }

}
