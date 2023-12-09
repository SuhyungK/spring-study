package com.example.corestudy.order;

import com.example.corestudy.discount.DiscountPolicy;
import com.example.corestudy.discount.FixDiscountPolicy;
import com.example.corestudy.discount.RateDiscountPolicy;
import com.example.corestudy.member.Member;
import com.example.corestudy.member.MemberRepository;
import com.example.corestudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private MemberRepository memberRepository = new MemoryMemberRepository();
//    private DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
