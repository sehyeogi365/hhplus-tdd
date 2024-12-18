package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.dto.PointMemberDTO;

import java.util.List;
import java.util.Optional;

public interface PointRepository {

    // 특정 유저의 이름으로 조회
    Optional <Point> findByName(String name);

    // 포인트 조회
    Optional <Point> findByMemberId(Long memberId);

    //충전 & 사용
    Point charge(Long memberId);
    Point use(Long memberId);//파라미터 memberId, 가격 ,타입이렇게 변경하기

}
