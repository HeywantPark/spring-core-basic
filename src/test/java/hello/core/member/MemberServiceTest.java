package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L,"jisoo",Grade.VIP);
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        //then
        Assertions.assertThat(member1).isEqualTo(member);
    }

    @Test
    void findMember() {
    }
}