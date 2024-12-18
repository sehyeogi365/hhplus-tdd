package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.dto.PointMemberDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryPointRepository implements PointRepository{

    private Map<Long, Point> store = new HashMap<>();
    private static long sequence = 0L;//0,1,2 이렇게 키값을 생성해주는 애

    @Override
    public Optional<Point> findByName(String name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public Optional<Point> findByMemberId(Long memberId) {
        return Optional.ofNullable(store.get(memberId));
    }

    @Override
    public Point save(Point point) {
        point.setId(sequence++);
        //point.setAmount(po);//포인트 충전 & 사용
        store.put(point.getId(), point);
        return point;
    }



}
