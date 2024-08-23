package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepo;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepo());
    }

    private static MemoryMemberRepo MemberRepo() {
        return new MemoryMemberRepo();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepo(), discountPolicy());
    }

    private static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
