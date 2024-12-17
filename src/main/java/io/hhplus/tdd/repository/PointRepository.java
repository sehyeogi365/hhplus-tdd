package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.dto.PointMemberDTO;

import java.util.List;
import java.util.Optional;

public interface PointRepository {

    //Member save(Member member);

    // 특정 유저의 이름으로 조회
    List<PointMemberDTO> findByName(String name);

    // 특정 멤버 ID로 조회
    Optional<PointMemberDTO> findByMemberId(Long memberId);


}
