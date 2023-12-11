package com.example.corestudy.discount;

import com.example.corestudy.member.Grade;
import com.example.corestudy.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%의 할인이 적용 되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 20_000);
        assertThat(discount)
                .isEqualTo(2_000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안 된다.")
    void vip_x() {
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        int discount = discountPolicy.discount(member, 20_000);
        assertThat(discount).isEqualTo(0);
    }
}