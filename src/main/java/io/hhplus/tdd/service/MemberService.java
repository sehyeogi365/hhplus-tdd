package io.hhplus.tdd.service;

import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.repository.MemberRepository;

public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member){

        duplicateName(member);

        memberRepository.save(member);

        return member;
    }

    //중복확인
    public void duplicateName(Member member){

        if(memberRepository.findByName(member.getName()).isPresent()){
            System.out.println("중복되는 아이디 입니다.");
        }
    }

}
