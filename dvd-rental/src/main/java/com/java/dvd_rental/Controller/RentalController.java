package com.java.dvd_rental.Controller;

import com.java.dvd_rental.Entity.DVD;
import com.java.dvd_rental.Entity.Member;
import com.java.dvd_rental.Entity.Rental;

import com.java.dvd_rental.Service.MemberService;
import com.java.dvd_rental.Service.RentalService;
import com.java.dvd_rental.Service.DVDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private MemberService memberService;// Service to handle member logic

    @Autowired
    private DVDService dvdService; 

    // Mapping for renting a DVD
    @GetMapping("/rent")
    public String showRentForm(Model model) {
        // You can add any necessary attributes to the model here
        return "rent"; // Return the rent.html view
    }

    @PostMapping("/rent")
    public String rentDVD(@RequestParam int dvdId, @RequestParam int memberId, @RequestParam int rentalDuration) {
        rentalService.rentDVD(dvdId, memberId, rentalDuration);
        return "redirect:/rentals"; // Redirect to the rentals page after renting
    }

    // Show the form to add a new rental

    @GetMapping("/rentals/add")
    public String showAddRentalForm(Model model) {
        return "add_rental"; // Return the name of the HTML file without the .html extension
    }

    // Handle the form submission to add a new rental
    @PostMapping("/rentals/add")
    public String addRental(@RequestParam int memberId, 
                            @RequestParam int dvdId, 
                            @RequestParam String rentalDate, 
                            @RequestParam(required = false) String returnDate) {
        Rental rental = new Rental();

        // Retrieve the Member object using the memberId
        Member member = memberService.findById(memberId); // Retrieve the Member object
        rental.setMember(member); // Set the Member object

        // Retrieve the DVD object using the dvdId
        DVD dvd = dvdService.getDvdById(dvdId); // Retrieve the DVD object
        rental.setDvd(dvd); // Set the DVD object
        //rental.setMember(memberId);
        //rental.setDvdId(dvdId);
        try {
            // Convert rentalDate from String to LocalDate
            rental.setRentalDate(LocalDateTime.parse(rentalDate));

            // Convert returnDate from String to LocalDate if provided
            if (returnDate != null && !returnDate.isEmpty()) {
                rental.setReturnDate(LocalDateTime.parse(returnDate));
            } else {
                rental.setReturnDate(null); // Set to null if not provided

            }
        } catch (DateTimeParseException e) {
            // Handle the exception (e.g., log it, return an error message, etc.)
            // You can redirect to an error page or return an error message
            return "redirect:/error"; // Example redirect to an error page
        }
        rentalService.addRental(rental); // Call the service to save the rental
        return "redirect:/rentals"; // Redirect to the rentals list page after adding
    }

    @GetMapping("/rentals/edit")
    public String showEditRentalForm(Model model) {
        return "edit_rental";
    }


    @PostMapping("/rentals/edit")
    public String editRental(@RequestParam int id,
                            @RequestParam int memberId,
                            @RequestParam int dvdId,
                            @RequestParam LocalDateTime rentalDate,
                            @RequestParam(required = false) LocalDateTime returnDate) {
        Rental rental = rentalService.findById(id); // Retrieve the rental by ID
        if (rental != null) {
            //rental.setMemberId(memberId);
            rental.setDvdId(dvdId);
            rental.setRentalDate(rentalDate);
            rental.setReturnDate(returnDate); // This can be null if not provided
            rentalService.editRental(rental); // Update the rental in the database
        }
        return "redirect:/rentals"; // Redirect to the rentals list page after updating

    }


    // Mapping to view all rentals
    @GetMapping("/rentals")
    public String viewRentals(Model model) {
        List<Rental> rentals = (List<Rental>) rentalService.getAllRentals();
        model.addAttribute("rentals", rentals); // Add rentals to the model
        return "rentals"; // Return the rentals.html view
    }

     // Show the form to return a DVD
     @GetMapping("/rentals/return")
     public String showReturnForm(@RequestParam int id, Model model) {
         Rental rental = rentalService.findById(id); // Retrieve the rental by ID
         model.addAttribute("rental", rental); // Add the rental to the model
         return "return_dvd"; // Return the name of the HTML file for returning a DVD
     }
 
     // Handle the return of a DVD
     @PostMapping("/rentals/return")
     public String returnRental(@RequestParam int id) {
         Rental rental = rentalService.findById(id); // Retrieve the rental by ID
         if (rental != null) {
             rental.setReturnDate(LocalDateTime.now()); // Set the return date to today
             rentalService.editRental(rental); // Update the rental in the database
         }
         return "redirect:/rentals"; // Redirect to the rentals list page after returning
     }
}