package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepo;

public class OrderServiceImpl implements OrderService {

    private final MemberRepo memberRepo;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepo memberRepo,DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepo = memberRepo;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepo.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepo getMemberRepo() {
        return memberRepo;
    }
}
