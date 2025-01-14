package io.hhplus.tdd.service;


import io.hhplus.tdd.database.PointHistoryTable;
import io.hhplus.tdd.database.UserPointTable;

import io.hhplus.tdd.point.PointHistory;
import io.hhplus.tdd.point.TransactionType;
import io.hhplus.tdd.point.UserPoint;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Transactional
@Service
@RequiredArgsConstructor
public class PointService {

    private final UserPointTable userPointTable;
    private final PointHistoryTable pointHistoryTable;
    private final ConcurrentHashMap<Long, ReentrantLock> lockMap = new ConcurrentHashMap<>();  // 사용자 ID별로 ReentrantLock 관리

    private static final long MAX_POINT_LIMIT = 1000000;//최대 충전가능 금액 100만포인트

    /**
     * TODO - 특정 유저의 포인트를 조회하는 기능을 작성해주세요.
     */
    public UserPoint getUserPoint(Long id){
        //user가 없을시 예외 처리 userPointTable 호출
        UserPoint user = userPointTable.selectById(id);

        if(user == null){
            throw new IllegalArgumentException("User Not Available!");
        }

        return user;
    }
    /**
     * TODO - 특정 유저의 포인트 충전/이용 내역을 조회하는 기능을 작성해주세요.
     */
    public List<PointHistory> getUserPointHistory(long id){

        if(id <= 0){
            throw new IllegalArgumentException("Invalid User!");
        }
        //user가 없을시 예외 처리 userPointTable 호출
        UserPoint user = userPointTable.selectById(id);

        if(user == null){
            throw new IllegalArgumentException("User Not Available!");
        }

        return pointHistoryTable.selectAllByUserId(id);//리턴은 pointHistoryTable
    }

    /**
     * TODO - 특정 유저의 포인트를 충전하는 기능을 작성해주세요.
     */
    //포인트 충전 요구사항 분석 참고하기
    public UserPoint chargePoint(long id, long amount){//이것도 id, amount로 수정
        // 충전 요구사항
        chargeValidation(id, amount);

        // 2. 유저 확인(이것도 요구 사항대로 로직 작성)
        UserPoint userPoint = userPointTable.selectById(id);
        if(userPoint == null){
            throw new IllegalArgumentException("UserPoint Not Available!");
        }

        long currentPoint = userPoint.point(); //현재포인트 userPoint 호출

        //실제 포인트 충전
        pointHistoryTable.insert(id, amount, TransactionType.CHARGE, System.currentTimeMillis());

        // 3. 포인트 충전 then
        return userPointTable.insertOrUpdate(id, currentPoint+amount);
    }

    //void 함수 하나 충전 관련 해서 충전 요구사항
    private void chargeValidation(long id, long amount){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid User!");
        }

        if(amount <= 0){
            throw new IllegalArgumentException("Amount Not Available!");
        }

        if(amount > MAX_POINT_LIMIT){
            throw new IllegalArgumentException("Maximum Limit!");
        }

        if(amount % 10000 != 0){
            throw new IllegalArgumentException("It must be in increments of 10,000 points.");
        }
    }

    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */

    //포인트 사용 요구사항 분석 참고하기
    public UserPoint usePoint(long id, long amount){//id, amount로 수정
        //1. 포인트 사용 요구사항 id < 0 인지 사용포인트 0 미만인지
        usePointValidation(id, amount);

        lockMap.putIfAbsent(id, new ReentrantLock());//id별로 락 생성
        ReentrantLock lock = lockMap.get(id);//락 가져오기
        lock.lock();//락 획득

        UserPoint userPoint = userPointTable.selectById(id);

        long currentPoint = userPoint.point(); //현재포인트 userPoint 호출
        // 2. 포인트 부족 여부 확인 현재 포인트가 쓰는포인트보다 더 적은지(이것도 요구 사항대로 로직 작성)
        if(currentPoint < amount){
            throw new IllegalArgumentException("Invalid Limit!");
        }

        if(userPoint == null){
            throw new IllegalArgumentException("User Not Available!");
        }

        pointHistoryTable.insert(id, amount, TransactionType.USE, System.currentTimeMillis());//히스토리 저장
        // 3. 포인트 차감
        return userPointTable.insertOrUpdate(id, currentPoint-amount);
    }

    //void 메서드 하나 만들기 사용 관련 해서
    private void usePointValidation(long id, long amount){

        if(id <= 0){
            throw new IllegalArgumentException("Invalid User!");
        }

        if(amount <= 0 ){
            throw  new IllegalArgumentException("Amount is not Available!");
        }
    }


}
