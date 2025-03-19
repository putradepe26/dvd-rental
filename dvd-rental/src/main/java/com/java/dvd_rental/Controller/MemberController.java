package com.java.dvd_rental.Controller;

import com.java.dvd_rental.Entity.Member;
import com.java.dvd_rental.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Show the list of members

    @GetMapping("/members")
    public String listMembers(Model model) 
    {
        List<Member> members = memberService.getAllMembers(); // Retrieve all members
        model.addAttribute("members", members); // Add members to the model
        return "members"; // Return the name of the HTML file without the .html extension
    }

    // Mapping to show the add member form
    @GetMapping("/members/add")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add_member"; // Return the add_member.html view
    }

    // Mapping to handle adding a new member
    @PostMapping("/members/add")
    public String addMember(@RequestParam String name, 
                            @RequestParam String contactInfo) {
        Member member = new Member();
        member.setName(name); // Set the member's name
        member.setContactInfo(contactInfo); // Set the member's contact info
        memberService.addMember(member); // Call the service to save the member
        return "redirect:/members"; // Redirect to the members list page after adding
    }

    // Mapping to show the edit member form
    @GetMapping("/members/edit")
    public String showEditMemberForm(@RequestParam int id, Model model) {
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "edit_member"; // Return the edit_member.html view
    }

    // Mapping to handle updating a member
    @PostMapping("/members/edit")
    public String editMember(@RequestParam int memberId, 
                             @RequestParam String name, 
                             @RequestParam String contactInfo) {
        Member member = memberService.findById(memberId); // Retrieve the member by ID
        if (member != null) {
            member.setName(name); // Update the member's name
            member.setContactInfo(contactInfo); // Update the member's contact info
            memberService.addMember(member); // Save the updated member
        }
        return "redirect:/members"; // Redirect to the members list page after updating
    }
}