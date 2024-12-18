요구사항 분석

PATCH/point/{id}/charge : 포인트를 충전한다. <br>

성공 시나리오<br>
1. 음수나, 한글, 영어, 특수문자 미 입력시 성공
2. 충전 하고도 최대 보유 가능 내역 이하일시 성공
-최대 1,000,000 포인트 보유 가능하고 990,000 보유 상태에서 10,000 포인트 미만으로 충전했을시에
3. 최대 충전 가능 포인트 이하로 충전시 
- 1회충전시 최대 1,000,000 포인트 이하 충전 가능
4. 동시에 여러 사용자가 각자 계정에게 포인트 충전할시
5. 한 사용자가 본인계정에 포인트 충전할시
6. 10,000 포인트 단위로 충전할시
  
실패 시나리오<br>
1. 음수나, 한글, 영어, 특수문자  입력시 실패
2. 충전 하고도 최대 보유 내역 초과일시 실패
-  990,000 보유 상태에서 10,000 포인트 초과해서 충전했을시에
3. 최대 충전 가능 포인트보다 초과해서 충전시 
- 1회충전시 최대 1,000,000 포인트 충전 가능한데 더 입력한다거나
4. 동시에 여러 사용자가 한 사용자에게 포인트 충전할시
5. 한 사용자가 다른 사용자 계정에 포인트 충전할시
6. 10,000 포인트 단위로 충전안할시


PATCH /point/{id}/use : 포인트를 사용한다.<br>
성공 시나리오<br>
1. 충전된 금액보다 적게 포인트 사용시 
- 10,000포인트 보유상태에서 10,000 이하 포인트 사용시
2. 한도 내역 이내로 사용 
- 100,000 포인트 이하 사용
3. 한 사용자가 본인 포인트 사용시


실패 시나리오<br>
1. 충전된 금액보다 초과해서 포인트 사용시 
- 10,000포인트 보유상태에서 10,000 초과 포인트 사용시
2. 한도 내역 초과해서 사용시 실패
- 100,000 포인트 초과 사용시 실패
3. 한 사용자가 다른 사용자 포인트 사용시
