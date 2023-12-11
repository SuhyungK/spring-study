package com.example.corestudy.order;

import com.example.corestudy.discount.DiscountPolicy;
import com.example.corestudy.member.Member;
import com.example.corestudy.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

//    private MemberRepository memberRepository = new MemoryMemberRepository();
//    private DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
