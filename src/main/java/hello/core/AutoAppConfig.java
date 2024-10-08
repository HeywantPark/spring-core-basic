package hello.core;

import hello.core.member.MemberRepo;
import hello.core.member.MemoryMemberRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepo")
//    public MemberRepo memoryMemberRepo() {
//        return new MemoryMemberRepo();
//    }
}
