package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    //회원가입
    Member save(Member member);

    //중복확인
    Optional<Member> findByName(String name);//

}
