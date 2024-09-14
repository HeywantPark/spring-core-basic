package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepo memberRepo;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public void join(Member member) {
        memberRepo.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepo.findById(memberId);
    }

    //테스트 용도
    public MemberRepo getMemberRepo() {
        return memberRepo;
    }
}
