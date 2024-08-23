package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member memberA = new Member(1L, "rose", Grade.VIP);
        memberService.join(memberA);

        Order order1 = orderService.createOrder(1L, "item1", 20000);
        System.out.println("order1 = " + order1);
        System.out.println(order1.calculatePrice());

    }
}
