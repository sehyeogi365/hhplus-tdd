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
}
