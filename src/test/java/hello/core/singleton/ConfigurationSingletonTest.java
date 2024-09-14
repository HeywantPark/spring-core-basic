package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepo;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest{
    @Test
    public void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepo memberRepo = ac.getBean("memberRepo", MemberRepo.class);

        MemberRepo memberRepo1 = memberService.getMemberRepo();
        MemberRepo memberRepo2 = orderService.getMemberRepo();

        System.out.println("memberService -> memberRepo " + memberRepo1);
        System.out.println("orderService -> memberRepo " + memberRepo2);
        System.out.println("memberRepo -> memberRepo " + memberRepo);

        Assertions.assertThat(memberService.getMemberRepo()).isSameAs(memberRepo);
        Assertions.assertThat(orderService.getMemberRepo()).isSameAs(memberRepo1);
    }
    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean -> " + bean.getClass());
    }
}
