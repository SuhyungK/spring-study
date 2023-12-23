package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * @return null 이면 로그인 실패
     * 핵심 비즈니스 로그인 -> 로그인 가능 여부 확인
     */
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                               .filter(m -> m.getPassword()
                                             .equals(password))
                               .orElse(null);
    }
}
