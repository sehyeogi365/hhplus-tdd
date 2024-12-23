package io.hhplus.tdd.service;


import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.repository.MemoryPointRepository;
import io.hhplus.tdd.repository.PointRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional

public class PointServiceTest {

    PointService pointService;

    PointRepository pointRepository;

    MemoryPointRepository memoryPointRepository;

    //동작하기 전에 넣어준다 BeforeEach
    @BeforeEach
    public void beforeEach(){
        pointRepository = Mockito.mock(PointRepository.class);
        pointService = new PointService(pointRepository);
    }
    @AfterEach//테스트 돌때마다 초기화
    public void afterEach(){
        memoryPointRepository.clearStore();
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
    //음수 입력시 실패
    @Test
    public void wrongInput(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setMemberId(1L);
        point.setAmount(1000);

        //when 이거를 실행했을 떄
        pointService.chargePoint(point);

        //then 결과가 이게 나와야 돼
        if(point.getAmount() < 0){
            System.out.println("음수를 입력하면 안됩니다.");
        } else {
            System.out.println("");
        }

    }

    //최대 충전 가능 포인트(백만)보다 초과해서 충전시
    @Test
    public void overCharge(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(1000001);
        point.setMemberId(1L);
        //when 이거를 실행했을 떄
        pointService.chargePoint(point);
        //then 결과가 이게 나와야 돼

        if(point.getAmount()>1000000){
            System.out.println("한도초과입니다.");
        }
    }

    //동시에 여러 사용자가 한 사용자에게 포인트 충전할시
    @Test
    public void n_to_one_Charge(){
        //given 뭔가가 주어졌는데
        Point point1 = new Point();
        point1.setAmount(10000);
        point1.setName("spring1");

        Point point2 = new Point();
        point2.setAmount(10000);
        point2.setName("spring2");
        //when 이거를 실행했을 떄
        pointService.chargePoint(point1);

        Point result = pointService.chargePoint(point2);

        pointService.chargePoint(point1);
        Point result1 = pointService.chargePoint(point1);

        Point result2 = pointService.chargePoint(point2);

        //then 결과가 이게 나와야 돼
        //이름이 다르면 에러가 안뜸
        assertThat(result1.getName()).isNotEqualTo(result2.getName())
                .withFailMessage("두 사용자가 한 사용자에게 충전했습니다.:" + result1.getName() + result2.getName(),
                        result1.getName(), result2.getName());
    }

    // 한 사용자가 다른 사용자 계정에 포인트 충전할시
    @Test
    public void wrong_person_Charge(){
        //given 뭔가가 주어졌는데
        Point point1 = new Point();
        point1.setName("spring1");
        point1.setAmount(10000);

        Point point2 = new Point();
        point2.setName("강충모");
        point2.setAmount(10000);

        //when 이거를 실행했을 떄
        pointService.chargePoint(point1);

        Point chargedPoint = pointService.chargePoint(point2);

        //then 결과가 이게 나와야 돼
        if(!chargedPoint.equals(point1.getName())){
            System.out.println("다른 사용자 계정에 포인트 충전 할수 없습니다.");
        } else {
            System.out.println("");
        }

    }

    //10,000 포인트 단위로 충전안할시
    @Test
    public void wrong_Point_Input(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(10001);

        //when 이거를 실행했을 떄
        pointService.chargePoint(point);

        //then 결과가 이게 나와야 돼
        if (point.getAmount() % 10000 != 0) {
            System.out.println("10,000포인트 단위로 충전 해야 합니다.");
        }
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

    @Test
    public void overUse_then_charge_Point(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(10000);
        int useAmount = 15000;

        //when 이거를 실행했을 떄
        pointService.usePoint(point);

        //then 결과가 이게 나와야 돼
        // 15000 포인트 사용 시도, 충전된 금액보다 초과
        if(useAmount > point.getAmount()){
            System.out.println("충전된 금액을 초과해서 사용했습니다.");
        } else {
            System.out.println("포인트 사용 됨 나머지 포인트 : " + (point.getAmount() - useAmount));
        }

    }
    //한도 내역 초과해서 100,000 포인트 초과 사용시 실패
    @Test
    public void overUse_then_use_Limit(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(100001);
        int useAmount = 100000;
        //when 이거를 실행했을 떄
        pointService.usePoint(point);
        //then 결과가 이게 나와야 돼
        if(useAmount < point.getAmount()){
            System.out.println("한도내역 초과입니다.");
        }
    }

    //한 사용자가 다른 사용자 포인트 사용
    @Test
    public void use_another_Person_Point(){
        //given 뭔가가 주어졌는데
        Point point1 = new Point();
        point1.setName("spring1");
        point1.setAmount(10000);

        Point point2 = new Point();
        point2.setName("spring2");
        point2.setAmount(10000);

        pointService.chargePoint(point1);
        pointService.chargePoint(point2);

        int useAmount = 5000;

        //when 이거를 실행했을 떄
        Point usedPoint = pointService.usePoint(point2);//스프링1이 스프링2의 포인트를 사용한다.

        //then 결과가 이게 나와야 돼
        if(!usedPoint.getName().equals(point1.getName())){
            System.out.println("다른 사용자 포인트를 쓸수 없습니다.");
        }

    }

}
