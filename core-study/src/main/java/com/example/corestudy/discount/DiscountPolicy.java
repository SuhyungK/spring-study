package com.example.corestudy.discount;

import com.example.corestudy.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     *
     */
    int discount(Member member, int price);
}
