package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }


}
