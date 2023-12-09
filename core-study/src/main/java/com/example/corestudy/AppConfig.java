package com.example.corestudy;

import com.example.corestudy.discount.DiscountPolicy;
import com.example.corestudy.discount.FixDiscountPolicy;
import com.example.corestudy.discount.RateDiscountPolicy;
import com.example.corestudy.member.MemberRepository;
import com.example.corestudy.member.MemberService;
import com.example.corestudy.member.MemberServiceImpl;
import com.example.corestudy.member.MemoryMemberRepository;
import com.example.corestudy.order.OrderService;
import com.example.corestudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    private static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
