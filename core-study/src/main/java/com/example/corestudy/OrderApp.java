package com.example.corestudy;

import com.example.corestudy.member.Grade;
import com.example.corestudy.member.Member;
import com.example.corestudy.member.MemberService;
import com.example.corestudy.member.MemberServiceImpl;
import com.example.corestudy.order.Order;
import com.example.corestudy.order.OrderService;
import com.example.corestudy.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10_000);
        System.out.println("order = " + order);
    }
}
