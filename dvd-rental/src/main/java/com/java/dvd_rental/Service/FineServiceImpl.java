package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.Fine;

import com.java.dvd_rental.Repository.FineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineServiceImpl implements FineService 
{

    @Autowired
    private FineRepository fineRepository;

    @Override
    public List<Fine> getAllFines() 
    {
        return fineRepository.findAll(); // Retrieve all fines
    }

    @Override
    public void addFine(Fine fine) 
    {
        fineRepository.save(fine); // Save the new fine
    }

    @Override
    public void updateFine(Fine fine) 
    {
        fineRepository.save(fine); // Update the existing fine
    }

    @Override
    public void deleteFine(int id) 
    {
        fineRepository.deleteById(id); // Delete the fine by ID
    }

    @Override
    public Fine getFineById(int id) 
    {
        return fineRepository.findById(id).orElse(null); // Retrieve fine by ID
    }

}