package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member member = em.find(Member.class, name);
        return Optional.ofNullable(member);
    }
}
