package com.example.corestudy.order;

import com.example.corestudy.AppConfig;
import com.example.corestudy.member.Grade;
import com.example.corestudy.member.Member;
import com.example.corestudy.member.MemberService;
import com.example.corestudy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10_000);
        assertThat(order.getDiscountPrice())
                  .isEqualTo(1_000);
    }
}