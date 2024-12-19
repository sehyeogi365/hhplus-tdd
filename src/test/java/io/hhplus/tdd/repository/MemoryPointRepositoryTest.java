package io.hhplus.tdd.repository;

import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemoryPointRepositoryTest {

    MemoryPointRepository repository = new MemoryPointRepository();
    @AfterEach //테스트 돌때마다 초기화
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void findByName(){

    }

    @Test
    public void findByMemberId(){

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
        point.setAmount(-1);

        //when 이거를 실행했을 떄
        repository.charge(point);

        //then 결과가 이게 나와야 돼
        if(point.getAmount() < 0){
            System.out.println("음수로 입력하면 안됩니다.");
        }
    }

    //충전 하고도 최대 보유 내역 초과일시 실패

    //최대 충전 가능 포인트보다 초과해서 충전시
    @Test
    public void overCharge(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(1000001);

        //when 이거를 실행했을 떄
        repository.charge(point);

        //then 결과가 이게 나와야 돼

        if(point.getAmount() > 1000000){
            System.out.println("1000000원 초과해서 충전할수 없습니다.");
        } else {
            System.out.println("충전이 완료 되었습니다." + point.getAmount() + "원");
        }

    }
    //동시에 여러 사용자가 한 사용자에게 포인트 충전할시
    @Test
    public void n_to_one_Charge(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setName("spring1");

        //when 이거를 실행했을 떄
        repository.charge(point);
        //then 결과가 이게 나와야 돼
    }

    // 한 사용자가 다른 사용자 계정에 포인트 충전할시
    @Test
    public void wrong_person_Charge(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setName("spring1");

        Member member = new Member();
        member.setName("강충모");
        //when 이거를 실행했을 떄
        repository.charge(point);

        //then 결과가 이게 나와야 돼

    }

    //10,000 포인트 단위로 충전안할시
    @Test
    public void wrong_Point_Input(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(10001);

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

    //충전된 금액보다 초과해서 포인트 사용
    @Test
    public void overUse_then_charge_Point(){
        //given 뭔가가 주어졌는데
        Point point = new Point();
        point.setAmount(10000);
        int useAmount = 15000;

        //when 이거를 실행했을 떄
        repository.use(point);

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
        repository.use(point);

        //then 결과가 이게 나와야 돼
        if(useAmount < point.getAmount()){
            System.out.println("한도내역 초과입니다.");
        }

    }

    //한 사용자가 다른 사용자 포인트 사용(보류)
    @Test
    public void use_another_Person_Point(){
        //given 뭔가가 주어졌는데
        Point point1 = new Point();
        point1.setName("spring1");
        point1.setAmount(10000);

        Point point2 = new Point();
        point2.setName("spring2");
        point2.setAmount(10000);

        repository.charge(point1);
        repository.charge(point2);

        int useAmount = 5000;

        //when 이거를 실행했을 떄
        Point usedPoint = repository.use(point2);//스프링1이 스프링2의 포인트를 사용한다.


        //then 결과가 이게 나와야 돼
        Assertions.assertThat(usedPoint).isNull(); // 사용 불가 시 null 반환 (가정)

        // spring2의 포인트는 변경되지 않아야 함
        Point result2 = repository.findByName("spring2").get();
        Assertions.assertThat(result2.getAmount()).isEqualTo(10000);

        // spring1의 포인트도 여전히 10000이어야 함
        Point result1 = repository.findByName("spring1").get();
        Assertions.assertThat(result1.getAmount()).isEqualTo(10000);
    }

}
