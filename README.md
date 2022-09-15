<div align="center">
<br>

# 🌿Innovation_cloneProject_2조 - 오설록 🌿
<br>

### <b>오설록 사이트 클론코딩</b>

https://osulloc.vercel.app

[오설록 프로젝트 시연영상](https://www.youtube.com/watch?v=qCpXsTa6xEY)

[오설록 API 설계](https://www.notion.so/d47ec36a42a047a68b435ad6a53eab61)

[오설록 기능 및 페이지](https://www.notion.so/2405717aea934a5d9babba16b7d43921)
<br>

## 💻 &nbsp; <b>github</b> &nbsp; 💻

<br>

[Front-end](https://github.com/k-gardn/osulloc_FE)

[Back-end](https://github.com/Jeeyeonn/innovation_clone_2_BE)

<br>

## 👩🏻‍💻 <b>Contributors</b> 🧑🏻‍💻

<br>

| [김정원](https://github.com/k-gardn) | [문이슬](https://github.com/Leeseul-Moon) | [차혜인](https://github.com/hyeincha) | [박지연](https://github.com/Jeeyeonn) | [전선향](https://github.com/petal416) |
| :----------------------------------: | :---------------------------------------: | :-----------------------------------: | :-----------------------------------: | :-----------------------------------: |
|                  FE                  |                    FE                     |                  FE                   |                  BE                   |                  BE                   |
|              상세페이지              |                메인페이지                 |                로그인                 |            전체상품페이지             |                로그인                 |
|               장바구니               |              전체상품페이지               |               회원가입                |              상세페이지               |               회원가입                |
|                                      |                                           |                                       |               장바구니                |              메인페이지               |

<br>

## 📆 프로젝트 기간

<br>

### 2022년 9월 9일 ~ 2022년 9월 15일 (총 7일)

<br>

## ⚙️ <b>Tech Stack</b> 🛠

<br>

<img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/Java-green?style=flat-square&logo=java&logoColor=white"/> <img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/Spring-green?style=flat-square&logo=Spring&logoColor=white"/> <img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/javascript-yellow?style=flat-square&logo=javascript&logoColor=white"/><img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/React-blue?style=flat-square&logo=React&logoColor=white"/> <img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/Redux-purple?style=flat-square&logo=Redux&logoColor=white"/> <img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/AWS-232f3e?style=flat-square&logo=amazon&logoColor=white"/>
<img style="margin:5px; border: 2px solid white; border-radius: 20px" src="https://img.shields.io/badge/vercel-black?style=flat-square&logo=vercel&logoColor=white"/> <br /><br />


## 📚 구현 기능
<div align="left">
<br>
    
1. **메인페이지**
    - [x]  베스트 상품 → 장바구니 담은 수 상위 10개
    
    <br>
    
2. **로그인/회원가입**
    - [x]  이메일, 비밀번호(비밀번호 확인), 이름, 구독 여부
    - [x]  카카오톡 소셜 로그인
    
    <br>
    
3. **구독하기**
    - [x]  오설록을 구독한 유저에게 정해진 날짜에 메일 보내는 기능
    
    <br>
    
4. **장바구니**
    - [x]  로그인 시 담아주기
    - [x]  모든 페이지에서 로그인 한 정보가 있으면 그 회원에 맞는 장바구니 수 보여주기
    - [x]  장바구니에 이미 담겨진 물품이면 알럿 띄우기
    - [x]  장바구니 페이지 안에서 물품 전체 삭제, 일부 삭제 기능
    - [x]  장바구니 페이지 안에서 수량 변경 가능
    
    <br>
    
5. **제품 상세페이지**
    - [x]  제품 이미지, 가격, 수량 선택, 장바구니

<div align="center">

<br>

## 🎈 Trouble Shooting 🎈

<br>
    <div align="left">

- **2022 / 09 / 09**
    - 오류 : 포스트맨으로 CRUD를 할 때 API가 실행되지 않고 Authentication을 입력하라는 창이 계속 떴다.
    - 문제점 : 초기 설정에 스프링 시큐리티의 의존성을 추가해놓고 config를 구현하지 않았기 때문.
    - 해결법 : 일단 스프링 시큐리티 의존성 부분을 주석처리 하고 나중에 로그인 구현할 때 사용하기로 함.
   
    <br>
    
- **2022 / 09 / 12**
    - 오류 : 구현한 대로 잘 돌아갔지만, ResponseEntity가 나오지 않았고 404 Not Found 오류가 떴음.
    - 문제점 : @RestController를 사용하지 않고, @Controller 어노테이션을 사용했기 때문에 인식을 못했다.
    - 해결법 : @RestController 사용
    
     <br>
     
- **2022 / 09 / 13**
    - 오류 : 카카오 로그인 KOE320 에러
    - 문제점 : 프론트에서 보내준 유저 정보인 code를 재사용해서 나는 오류인 줄 알았는데, 프론트 서버에만 Redirect Url를 설정해주었기 때문
    - 해결법 : 프론트 서버와 백 서버 둘 다 Redirect Url로 추가하였다.

<br>

## 📁 Directory Structure 📂 </div>

<details>
<summary> Front-end </summary>
<div markdown="1">

```
📦src
 ┣ 📂components
 ┃ ┣ 📂cart
 ┃ ┃ ┣ 📜Cart.jsx
 ┃ ┃ ┗ 📜Cart.module.css
 ┃ ┣ 📂cart_item
 ┃ ┃ ┣ 📜CartItem.jsx
 ┃ ┃ ┗ 📜CartItem.module.css
 ┃ ┣ 📂common
 ┃ ┃ ┣ 📂Footer
 ┃ ┃ ┃ ┣ 📜Footer.jsx
 ┃ ┃ ┃ ┗ 📜Footer.module.css
 ┃ ┃ ┣ 📂Header
 ┃ ┃ ┃ ┣ 📜Header.jsx
 ┃ ┃ ┃ ┗ 📜Header.module.css
 ┃ ┃ ┣ 📜LayoutPage.jsx
 ┃ ┃ ┗ 📜LayoutPage.module.css
 ┃ ┣ 📂detail
 ┃ ┃ ┣ 📜Detail.jsx
 ┃ ┃ ┗ 📜Detail.module.css
 ┃ ┣ 📂join
 ┃ ┃ ┣ 📜Join.jsx
 ┃ ┃ ┗ 📜Join.module.css
 ┃ ┣ 📂login
 ┃ ┃ ┣ 📜KakaoLogin.jsx
 ┃ ┃ ┣ 📜KakaoRedirect.jsx
 ┃ ┃ ┣ 📜Login.jsx
 ┃ ┃ ┗ 📜Login.module.css
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂banner
 ┃ ┃ ┃ ┣ 📜Banner.jsx
 ┃ ┃ ┃ ┣ 📜Banner.module.css
 ┃ ┃ ┃ ┗ 📜arrowForward.png
 ┃ ┃ ┣ 📂bestProducts
 ┃ ┃ ┃ ┣ 📜BestProducts.jsx
 ┃ ┃ ┃ ┗ 📜BestProducts.module.css
 ┃ ┃ ┣ 📂eventBanner
 ┃ ┃ ┃ ┣ 📜EventBanner.jsx
 ┃ ┃ ┃ ┗ 📜EventBanner.module.css
 ┃ ┃ ┣ 📂subscription
 ┃ ┃ ┃ ┣ 📜Subscription.jsx
 ┃ ┃ ┃ ┗ 📜Subscription.module.css
 ┃ ┃ ┗ 📂subscriptionItem
 ┃ ┃ ┃ ┣ 📜SubscriptionItem.jsx
 ┃ ┃ ┃ ┗ 📜SubscriptionItem.module.css
 ┃ ┣ 📂productItem
 ┃ ┃ ┣ 📜ProductItem.jsx
 ┃ ┃ ┗ 📜Productitem.module.css
 ┃ ┗ 📂productList
 ┃ ┃ ┣ 📜ProductList.jsx
 ┃ ┃ ┗ 📜ProductList.module.css
 ┣ 📂hooks
 ┃ ┣ 📜useBrowerEvent.jsx
 ┃ ┗ 📜useInput.js
 ┣ 📂network
 ┃ ┗ 📜request.js
 ┣ 📂pages
 ┃ ┣ 📜CartPage.jsx
 ┃ ┣ 📜DetailPage.jsx
 ┃ ┣ 📜MainPage.jsx
 ┃ ┗ 📜ProductListPage.jsx
 ┣ 📂redux
 ┃ ┣ 📂modules
 ┃ ┃ ┣ 📜cartSlice.js
 ┃ ┃ ┣ 📜detailSlice.js
 ┃ ┃ ┣ 📜productSlice.js
 ┃ ┃ ┗ 📜usersSlice.js
 ┃ ┗ 📜configStore.js
 ┣ 📂utils
 ┃ ┗ 📜moneyForm.js
 ┣ 📜App.css
 ┣ 📜App.js
 ┣ 📜index.css
 ┗ 📜index.js
```

</div>
</details>


<details>
<summary> Back-end </summary>
<div markdown="1">

```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂innovation
 ┃ ┃ ┃ ┃ ┗ 📂innovation_clone_be
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Cart
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartUpdateRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Cart.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Error
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Enum
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Member
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Member.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RefreshToken.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RefreshTokenRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDetailsImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDetailsServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccessDeniedHandlerException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationEntryPointException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenProvider.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂shared
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Authority.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂OAuth
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuthController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuthResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OauthUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDetailsImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Product
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductDetailResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Product.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CorsConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtSecurityConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailScheduler.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜InnovationCloneBeApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┗ 📜Test.http
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂innovation
 ┃ ┃ ┃ ┃ ┗ 📂innovation_clone_be
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Cart
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartTest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜InnovationCloneBeApplicationTests.java
```

</div>
</details>


## 📚 ERD 설계 📚

<br>

![image](<https://postimagestorage.s3.amazonaws.com/innovation_clone+(1).png>)

<div align="center">

## 💊 Error-Code 💊

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
