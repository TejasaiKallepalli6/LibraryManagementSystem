package com.cis.librarymanagement.demo.controller;

import com.cis.librarymanagement.demo.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.cis.librarymanagement.demo.service.MemberService;

import java.util.Collection;

@RestController
public class MemberController {
    // Creating a member
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public Member create(@RequestBody Member member){

        return memberService.createMember(member);
    }
    @RequestMapping(value = "/member", method = RequestMethod.DELETE)
    public Member delete(@RequestBody Member member){

        return null;

    }
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public Member  getMember(@RequestParam int memberID){

        return memberService.getMember(memberID);

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Member> getAllMembers() {
        return memberService.getAllMember();
    }
    @RequestMapping(value = "/member/update", method = RequestMethod.PUT)
    public Member update(@RequestParam int memberID,
                         @RequestBody Member member) {
        return memberService.updateMemberData(memberID, member);
    }

}
