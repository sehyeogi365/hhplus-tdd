package io.hhplus.tdd.service;


import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;

import io.hhplus.tdd.repository.PointRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Transactional
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
    //포인트 충전 요구사항 분석 참고하기
    public synchronized Point chargePoint(Point point){//이것도 id, amount로 수정
        // 1. 유저의 현재 포인트 조회 given
        if(point.getAmount() < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
//        Point currentPoint = pointRepository.findByMemberId(point.getMemberId())
//                        .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + point.getMemberId()));
//
//        // 2. 포인트 확인(이것도 요구 사항대로 로직 작성)
//
//        if (currentPoint.getAmount() < point.getAmount()) {
//            throw new IllegalStateException("Insufficient points");
//        }
        // 3. 포인트 충전 then
        return pointRepository.charge(point);
    }


    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */

    //포인트 사용 요구사항 분석 참고하기
    public synchronized Point usePoint(Point point){//id, amount로 수정
        // 1. 유저의 현재 포인트 조회 given
        if(point.getAmount() < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        //Point currentPoint = pointRepository.findByMemberId(point.getMemberId()).orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + point.getMemberId()));

        // 2. 포인트 부족 여부 확인 현재 포인트가 쓰는포인트보다 더 적은지(이것도 요구 사항대로 로직 작성)
//        if (currentPoint.getAmount() < point.getAmount()) {
//            throw new IllegalStateException("Insufficient points");
//        }

        // 3. 포인트 차감
        return pointRepository.use(point);
    }


}
