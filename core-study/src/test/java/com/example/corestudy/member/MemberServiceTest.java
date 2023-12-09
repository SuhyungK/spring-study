package com.example.corestudy.member;

import com.example.corestudy.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void 회원가입_성공_테스트() {
        // 회원 가입 후
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 해당 회원을 찾아서
        Member findMember = memberService.findMember(1L);

        // 일치 여부 확인
        Assertions.assertThat(member)
                  .isEqualTo(findMember);
    }
}