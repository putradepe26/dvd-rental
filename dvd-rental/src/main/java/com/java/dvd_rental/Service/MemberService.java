package com.java.dvd_rental.Service;

import com.java.dvd_rental.Entity.Member;
import java.util.List;

public interface MemberService {
    void addMember(Member member);
    void updateMember(Member member);
    void deleteMember(int id);
    Member getMemberById(int id);
    List<Member> getAllMembers();
    Member findById(int memberId);//
}
