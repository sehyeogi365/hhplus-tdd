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
        return store.values().stream()//애를 루프로 돌린다. 람다식 사용
                .filter(point -> point.getName().equals(name))//포인트에서 포인트.getName이 여기 파라미트로 넘어온 Name이랑 같은지 확인하는 거
                .findAny();
    }

    @Override
    public Optional<Point> findByMemberId(Long memberId) {
        return store.values().stream()
                .filter(point -> point.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    public synchronized Point charge(Point point) {
        point.setId(sequence++);
        store.put(point.getId(), point);
        return point;
    }

    @Override
    public synchronized Point use(Point point) {
        point.setId(sequence++);
        store.put(point.getId(), point);
        return point;
    }

    public void clearStore() {
        store.clear();
    }

}
