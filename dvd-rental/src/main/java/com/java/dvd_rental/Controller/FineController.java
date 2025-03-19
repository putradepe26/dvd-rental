package com.java.dvd_rental.Controller;

import com.java.dvd_rental.Entity.Fine;
import com.java.dvd_rental.Service.FineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FineController {

    @Autowired
    private FineServiceImpl fineService;

    // Mapping to view all fines
    @GetMapping("/fines")
    public String viewFines(Model model) {
        List<Fine> fines = fineService.getAllFines();
        model.addAttribute("fines", fines);
        return "fines"; // Return the fines.html view
    }

    // Mapping to show the add fine form
    @GetMapping("/fines/add")
    public String showAddFineForm(Model model) {
        model.addAttribute("fine", new Fine());
        return "add_fine"; // Return the add_fine.html view
    }

    // Mapping to handle adding a new fine
    @PostMapping("/fines/add")
    public String addFine(@RequestParam double amount, 
                          @RequestParam int rentalId, 
                          @RequestParam String reason) {
        Fine fine = new Fine();
        fine.setAmount(amount); // Set the fine's amount
        fine.setRentalId(rentalId); // Set the rental ID
        fine.setReason(Fine.FineReason.valueOf(reason)); // Set the reason using the enum
        fineService.addFine(fine); // Call the service to save the fine
        return "redirect:/fines"; // Redirect to the fines page after adding
    }

    // Mapping to show the edit fine form
    @GetMapping("/fines/edit")
    public String showEditFineForm(@RequestParam int id, Model model) {
        Fine fine = fineService.getFineById(id);
        model.addAttribute("fine", fine);
        return "edit_fine"; // Return the edit_fine.html view
    }

    // Mapping to handle updating a fine
    @PostMapping("/fines/edit")
    public String editFine(@RequestParam int fineId, 
                           @RequestParam double amount, 
                           @RequestParam int rentalId, 
                           @RequestParam String reason) {
        Fine fine = fineService.getFineById(fineId); // Retrieve the fine by ID
        if (fine != null) {
            fine.setAmount(amount); // Update the fine's amount
            fine.setRentalId(rentalId); // Update the rental ID
            fine.setReason(Fine.FineReason.valueOf(reason)); // Update the reason using the enum
            fineService.addFine(fine); // Call the service to save the updated fine
        }
        return "redirect:/fines"; // Redirect to the fines list page after updating
    }

    // Mapping to handle deleting a fine

    @GetMapping("/fines/delete")
    public String deleteFine(@RequestParam int id) 
    {
        fineService.deleteFine(id);
        return "redirect:/fines"; // Redirect to the fines page after deleting
    }
}