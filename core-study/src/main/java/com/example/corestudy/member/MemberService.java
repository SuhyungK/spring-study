package com.example.corestudy.member;

public interface MemberService {
    public void join(Member member);

    public Member findMember(Long memberId);
}
