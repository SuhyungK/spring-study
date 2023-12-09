package com.example.corestudy;

import com.example.corestudy.member.Grade;
import com.example.corestudy.member.Member;
import com.example.corestudy.member.MemberService;
import com.example.corestudy.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        // 멤버 회원 가입
        MemberService memberService = appConfig.memberService(); // AppConfig를 통해 생성하고 반환 받음
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 가입한 회원 조회
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
