# 🌿Innovation_cloneProject_2조 - 오설록 🌿

## 🧑🏻‍💻 팀원 정보

### 박지연 [(GitHub)](https://github.com/Jeeyeonn)

### 전선향 [(GitHub)](https://github.com/petal416)

## 📆 프로젝트 기간

### 2022년 9월 9일 ~ 2022년 9월 15일 (총 7일)

## 📚 구현 기능

1. **메인페이지**
    - [x]  베스트 상품 → 장바구니 담은 수 상위 10개
2. **로그인/회원가입**
    - [x]  이메일, 비밀번호(비밀번호 확인), 이름, 구독 여부
    - [x]  카카오톡 소셜 로그인
3. **구독하기**
    - [x]  오설록을 구독한 유저에게 정해진 날짜에 메일 보내는 기능
4. **장바구니**
    - [x]  로그인 시 담아주기
    - [x]  모든 페이지에서 로그인 한 정보가 있으면 그 회원에 맞는 장바구니 수 보여주기
    - [x]  장바구니에 이미 담겨진 물품이면 알럿 띄우기
    - [x]  장바구니 페이지 안에서 물품 전체 삭제, 일부 삭제 기능
    - [x]  장바구니 페이지 안에서 수량 변경 가능
5. **제품 상세페이지**
    - [x]  제품 이미지, 가격, 수량 선택, 장바구니


[팀전체 To - do](https://www.notion.so/93c9a7fab2d54686ad90e48a52d1825b)

[오설록 API 설계](https://www.notion.so/d47ec36a42a047a68b435ad6a53eab61)

[오설록 기능 및 페이지](https://www.notion.so/2405717aea934a5d9babba16b7d43921)


## 📚 ERD 설계

![innovation_clone.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/47a856dc-d45f-4337-a7fd-4cd489c7b740/innovation_clone.png)


# 6. Error-Code

| 코드 | 메시지 |
| --- | --- |
| ———— 로그인(토큰) 관련 오류 | ————————————————————————— |
| NULL_TOKEN | "토큰값이 없습니다." |
| INVALID_TOKEN | "Token이 유효하지 않습니다." |
| EXPIRED_TOKEN | "만료된 토큰입니다." |
| MEMBER_NOT_FOUND | "사용자를 찾을 수 없습니다." |
|  |  |
| ———— 회원가입 관련 오류 | ————————————————————————— |
| DUPLICATE_EMAIL | "중복된 이메일 입니다." |
|  |  |
| ————  상품 관련 오류 | ————————————————————————— |
| INVAILD_PRODUCT | "해당하는 상품을 찾을 수 없습니다." |
| INVALID_MEMBER | "사용자가 일치하지 않습니다." |
|  |  |
| ———— 장바구니 관련 오류  | ————————————————————————- |
| INVALID_CART | “해당하는 제품이 해당하는 유저 장바구니에 없습니다” |
| DUPLICATE_CART | “해당하는 제품이 해당 유저 장바구니에 이미 있습니다” |
