package hello.servlet.repository;

import hello.servlet.domain.Member;
import org.junit.jupiter.api.Test;

class MemberRepositoryV0Test {

  MemberRepositoryV0 repository = new MemberRepositoryV0();

  @Test
  void crud() {
    Member member = new Member("memberV0", 10000);
    repository.save(member);

  }
}