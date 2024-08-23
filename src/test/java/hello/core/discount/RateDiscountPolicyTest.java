package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void discount() {
        //given
        Member member = new Member(1L, "jenny", Grade.VIP);
        //when
        int dis = rateDiscountPolicy.discount(member,30000);
        //then
        Assertions.assertThat(dis).isEqualTo(3000);
    }
    @Test
    @DisplayName("VIP는 할인이 적용되면 안된다.")
    void noDiscount() {
        //given
        Member member = new Member(1L, "jisoo", Grade.BASIC);
        //when
        int dis = rateDiscountPolicy.discount(member,30000);
        //then
        Assertions.assertThat(dis).isEqualTo(0);
    }
}