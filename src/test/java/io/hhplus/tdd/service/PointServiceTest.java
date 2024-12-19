package io.hhplus.tdd.service;


import io.hhplus.tdd.repository.MemoryPointRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

public class PointServiceTest {

    PointService pointService;

    MemoryPointRepository pointRepository;

    //동작하기 전에 넣어준다 BeforeEach
    @BeforeEach
    public void beforeEach(){
        pointRepository = new MemoryPointRepository();
        pointService = new PointService(pointRepository);
    }
    @AfterEach//테스트 돌때마다 초기화
    public void afterEach(){
        pointRepository.clearStore();
    }

    @Test
    public void charge(){
        //요구사항 분석대로 테스트
//        1. 음수 입력시 실패
//        2. 충전 하고도 최대 보유 내역 초과일시 실패
//                -  990,000 보유 상태에서 10,000 포인트 초과해서 충전했을시에
//        3. 최대 충전 가능 포인트보다 초과해서 충전시
//        - 1회충전시 최대 1,000,000 포인트 충전 가능한데 더 입력한다거나
//        4. 동시에 여러 사용자가 한 사용자에게 포인트 충전할시
//        5. 한 사용자가 다른 사용자 계정에 포인트 충전할시
//        6. 10,000 포인트 단위로 충전안할시

        //given 뭔가가 주어졌는데
        //when 이거를 실행했을 떄
        //then 결과가 이게 나와야 돼

    }

    @Test
    public void getUserPoint(){

    }

    @Test
    public void getUserPointHistory(){

    }


    @Test
    public void chargePoint(){
        //given 뭔가가 주어졌는데
        //when 이거를 실행했을 떄
        //then 결과가 이게 나와야 돼
    }
    @Test
    public void usePoint(){
        //given 뭔가가 주어졌는데
        //when 이거를 실행했을 떄
        //then 결과가 이게 나와야 돼

    }

    @Test
    public void use(){
        //요구사항 분석대로 테스트
//        1. 충전된 금액보다 초과해서 포인트 사용시
//                - 10,000포인트 보유상태에서 10,000 초과 포인트 사용시
//        2. 한도 내역 초과해서 사용시 실패
//                - 100,000 포인트 초과 사용시 실패
//        3. 한 사용자가 다른 사용자 포인트 사용시


        //given 뭔가가 주어졌는데
        //when 이거를 실행했을 떄
        //then 결과가 이게 나와야 돼

    }
}
