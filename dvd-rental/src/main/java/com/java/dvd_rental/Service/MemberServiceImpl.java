package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.Member;
import com.java.dvd_rental.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() 
    {
        return memberRepository.findAll(); // Retrieve all members
    }

    public Member findById(int memberId) 
    {
        return memberRepository.findById(memberId).orElse(null); // Return the Member or null if not found
    }

    @Override
    public void addMember(Member member) 
    {
        memberRepository.save(member); // Save the new member
    }

    @Override
    public void updateMember(Member member) 
    {
        memberRepository.save(member); // Update the existing member
    }

    @Override
    public void deleteMember(int id) 
    {
        memberRepository.deleteById(id); // Delete the member by ID
    }

    @Override
    public Member getMemberById(int id) 
    {
        return memberRepository.findById(id).orElse(null); // Retrieve member by ID
    }
}
