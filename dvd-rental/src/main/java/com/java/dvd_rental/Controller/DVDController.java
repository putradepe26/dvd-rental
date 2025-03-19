package com.java.dvd_rental.Controller;

import com.java.dvd_rental.Entity.DVD; // Import your DVD entity
import com.java.dvd_rental.Service.DVDService; // Import your DVDService

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DVDController {

    @Autowired
    private DVDService dvdService; // Inject the DVD service

    // Show the list of DVDs
    @GetMapping("/error")
    public String viewDvds(Model model) {
        List<DVD> dvds = dvdService.getAllDvds(); // Ensure this returns a valid list
        model.addAttribute("dvds", dvds);
        return "error"; // Return the name of the HTML file without the .html extension
    }

    // Show the form to add a new DVD
    @GetMapping("/dvds/add")
    public String showAddDvdForm() {
        return "add_dvd"; // Return the name of the HTML file for adding a DVD
    }

    // Handle the form submission to add a new DVD
    @PostMapping("/dvds/add")
    public String addDvd(@RequestParam String title,
                         @RequestParam String director,
                         @RequestParam String genre,
                         @RequestParam String rating,
                         @RequestParam boolean isNew,
                         @RequestParam String releaseDate) {
        DVD dvd = new DVD();
        dvd.setTitle(title);
        dvd.setDirector(director);
        dvd.setGenre(genre);
        dvd.setRating(rating);
        dvd.setNew(isNew);
        dvd.setReleaseDate(LocalDate.parse(releaseDate)); // Parse the release date

        dvdService.addDvd(dvd); // Call the service to save the new DVD
        return "redirect:/dvds"; // Redirect to the DVDs list page after adding
    }

    // Show the form to edit an existing DVD
    @GetMapping("/dvds/edit")
    public String showEditDvdForm(@RequestParam int id, Model model) {
        DVD dvd = dvdService.getDvdById(id); // Retrieve the DVD by ID
        if (dvd != null) {
            model.addAttribute("dvd", dvd); // Add the DVD to the model
            return "edit_dvd"; // Return the name of the HTML file for editing a DVD
        } else {
            return "redirect:/dvds"; // Redirect to the DVDs list if DVD not found
        }
    }

    // Handle the form submission to update an existing DVD
    @PostMapping("/dvds/edit")
    public String editDvd(@RequestParam int id,
                          @RequestParam String title,
                          @RequestParam String director,
                          @RequestParam String genre,
                          @RequestParam String rating,
                          @RequestParam boolean isNew,
                          @RequestParam String releaseDate) {
        DVD dvd = dvdService.getDvdById(id); // Retrieve the DVD by ID
        if (dvd != null) {
            dvd.setTitle(title);
            dvd.setDirector(director);
            dvd.setGenre(genre);
            dvd.setRating(rating);
            dvd.setNew(isNew);
            dvd.setReleaseDate(LocalDate.parse(releaseDate)); // Parse the release date

            dvdService.addDvd(dvd); // Call the service to save the updated DVD
        }
        return "redirect:/dvds"; // Redirect to the DVDs list page after updating
    }

    // Handle the request to delete a DVD
    @GetMapping("/dvds/delete")
    public String deleteDvd(@RequestParam int id) {
        dvdService.deleteDvd(id); // Call the service to delete the DVD
        return "redirect:/dvds"; // Redirect to the DVDs list page after deleting
    }
}