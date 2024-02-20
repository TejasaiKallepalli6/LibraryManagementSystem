package com.cis.librarymanagement.demo.service;

import com.cis.librarymanagement.demo.member.Member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final Map<Integer,Member> memberMap= new HashMap<>();

    public Member createMember(Member member) {
        member.setMemberID(Math.abs(new Random().nextInt()));
        memberMap.put(member.getMemberID(), member);
        return member;
    }
    public Member deleteMember(int memberId) {
        Member member= new Member();
        memberMap.remove(member.getMemberID());
        return member;
    }
    public Member getMember(int memberID) {
        return memberMap.get(memberID);

    }
    public Collection<Member> getAllMember() {
        return memberMap.values();
    }

    public Member updateMemberData(int memberId, Member updatedMember) {
        System.out.println(memberMap);
        if(memberMap.containsKey(memberId)) {
            Member member = memberMap.get(memberId);
            if(!member.getFirstName().isEmpty()) {
                member.setFirstName(updatedMember.getFirstName());
            }
            if(!member.getLastName().isEmpty()) {
                member.setLastName(updatedMember.getLastName());
            }
            if(!member.getEmailId().isEmpty()) {
                member.setEmailId(updatedMember.getEmailId());
            }
            if(!member.getPhoneNo().isEmpty()) {
                member.setPhoneNo(updatedMember.getPhoneNo());
            }
            memberMap.put(memberId, member);
            System.out.println("updated successfully");
            return member;
        }
        return null;
    }

}
