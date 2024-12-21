
  ### **커밋 링크**
 서비스 테스트 완료 836256e7 <br>
 리포지터리 테스트 완료 e98b8dbb <br>
 동시에 여러 사용자가 한 사용자에게 포인트 충전할시, 한 사용자가 다른 사용자 계정에 포인트 충전할시 dc6e101f <br>
 테스트케이스 : 충전된 금액보다 초과해서 포인트 사용 해결됨 2903303e <br>
<!-- 
좋은 피드백을 받기 위해 가장 중요한 것은 코드를 작성할 때 커밋을 작업 단위로 잘 쪼개는 것입니다.
모든 작업을 하나의 커밋에 진행하고 PR을 하면 구조 파악에 많은 시간을 소모하기 때문에 절대로
좋은 피드백을 받을 수 없습니다.


필수 양식)
커밋 이름 : 커밋 링크

예시)
동시성 처리 : c83845
동시성 테스트 코드 : d93ji3
-->

---
### **리뷰 포인트(질문)**
- 리뷰 포인트 1 충전된 금액보다 초과해서 포인트 사용 로직이 적절한지 검토 부탁드립니다.
- 리뷰 포인트 2 동시성 제어를 위한 서비스 메서드가 적절한지 검토 부탁드립니다.
<!-- - 리뷰어가 특히 확인해야 할 부분이나 신경 써야 할 코드가 있다면 명확히 작성해주세요.(최대 2개)
  
  좋은 예:
  - `ErrorMessage` 컴포넌트의 상태 업데이트 로직이 적절한지 검토 부탁드립니다.
  - 추가한 유닛 테스트(`LoginError.test.js`)의 테스트 케이스가 충분한지 확인 부탁드립니다.

  나쁜 예:
  - 개선사항을 알려주세요.
  - 코드 전반적으로 봐주세요.
  - 뭘 질문할지 모르겠어요. -->
### **이번주 KPT 회고**

### Keep
<!-- 유지해야 할 좋은 점 -->
테스트 케이스라던가 JPA이해도는 어느정도 생긴거 같다. 
요구사항 분석에 따른 테스트 케이스 작성?
### Problem
<!--개선이 필요한 점-->
동시성, 이해도 STUB, MOCK 적용이 안됨
### Try
<!-- 새롭게 시도할 점 -->
??
