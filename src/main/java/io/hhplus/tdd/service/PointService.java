package io.hhplus.tdd.service;

import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.dto.PointMemberDTO;
import io.hhplus.tdd.point.PointHistory;
import io.hhplus.tdd.point.UserPoint;
import io.hhplus.tdd.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


public class PointService {

    PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }
    /**
     * TODO - 특정 유저의 포인트를 조회하는 기능을 작성해주세요.
     */
    public Optional<Point> getUserPoint(Long memberId){

        return pointRepository.findByMemberId(memberId);
    }
    /**
     * TODO - 특정 유저의 포인트 충전/이용 내역을 조회하는 기능을 작성해주세요.
     */
    public Optional<Point> getUserPointHistory(Member member){

        return pointRepository.findByName(member.getName());
    }

    /**
     * TODO - 특정 유저의 포인트를 충전하는 기능을 작성해주세요.
     */
    //포인트 충전



    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */

    //포인트 사용
    public Point usePoint(long memberId, long amount){
        // 1. 유저의 현재 포인트 조회
        Point currentPoint = pointRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));;

        // 2. 포인트 부족 여부 확인 현재 포인트가
        if (currentPoint.getAmount() < amount) {
            throw new IllegalStateException("Insufficient points");
        }

        // 3. 포인트 차감
        return pointRepository.use(memberId);
    }




}
