package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.dto.PointMemberDTO;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaPointRepository implements PointRepository {

    private final EntityManager em;//빌드 그래들에서 jpa라이브러리 받음 entity manager라는 걸 생성을 해줌 현재 데이터베이스랑 다 연결까지 해가지고 애를만들어줌 그래서 이 만들어진것을 인젝션 받으면 된다.

    public JpaPointRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Point> findByName(String name){
        List <Point> result = em.createQuery("select m from Member where m.name = :name", Point.class)
                                .setParameter("name", name)
                                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Point> findByMemberId(Long memberId) {
        Point point = em.find(Point.class, memberId);

        return Optional.ofNullable(point);
    }

    @Override
    public Point save(Point point) {//포인트 충전 & 사용

        em.persist(point);

        return point;
    }




}
