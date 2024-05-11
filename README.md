# 영화 예매️ 🎫
---
### 안드로이드
- [x] 영화 목록 페이지
    - [x] 영화들이 목록에서 보인다.
        - [x] 포스터, 제목, 상영일, 러닝타임을 보여준다.
    - [x] '지금 예매' 버튼을 누르면 극장을 선택할 수 있다.
      - [x] 각 극장은 이름을 가진다.
      - [x] 극장 별로 상영하는 영화와 상영시간은 달라질 수 있다.

- [x] 영화 상세 정보 페이지
    - [x] 뒤로 가기 버튼을 누르면 영화 목록 페이지로 이동한다.
    - [x] 포스터, 제목, 상영일, 러닝타임, 시놉시스를 보여준다.
    - [x] '-' 버튼을 누르면 예약 인원이 감소한다.
        - [x] 예약 인원이 1명일 경우 감소시키지 않는다.
    - [x] '+' 버튼을 누르면 예약 인원이 증가한다.
        - [x] 예약 인원이 50명일 경우 증가시키지 않는다.
    - [X] 날짜와 시간은 기본값으로 초기화되어있다.
    - [x] 날짜를 선택할 수 있다.
        - [x] 각 영화의 상영일은 각자의 범위를 갖는다.
    - [x] 시간을 선택할 수 있다.
      - [x] 극장 별 상영 시간 중 하나를 선택할 수 있다.
    - [x] "좌석 선택" 버튼을 누르면 좌석 선택 페이지로 이동한다.

- [x] 좌석 선택 페이지
    - [x] 뒤로 가기 버튼을 누르면 영화 예매 페이지로 이동한다.
    - [x] 좌석은 총 5행 4열로 구성되어 있고 각 행은 알파벳, 열은 숫자로 표현한다.
        - [x] 1, 2행은 B등급, 보라색 글자로 표시한다.
        - [x] 3, 4행은 S등급, 초록색 글자로 표시한다.
        - [x] 5행은 A등급, 파란색 글자로 표시한다.
    - [x] 좌석을 선택하면 배경색이 바뀐다.
    - [x] 좌석을 선택하면 최종 가격이 표시된다.
    - [x] 좌석을 선택하면 버튼의 배경색이 바뀐다.
    - [x] 좌석을 재선택하면 선택이 해제된다.
        - [x] 배경색이 돌아온다.
        - [x] 최종가격에 반영된다.
    - [x] 확인 버튼을 누르면 최종 예매를 확인하는 다이얼로그가 표시된다.
        - [x] 배경을 터치해도 사라지지 않는다.
        - [x] '예매 완료'를 누르면 영화 예매 완료 페이지로 이동한다.

- [x] 영화 예매 완료 페이지
    - [x] 뒤로 가기 버튼을 누르면 영화 목록 페이지로 이동한다.
    - [x] 안내 문구, 제목, 상영 날짜, 상영 시간, 예매 인원, 좌석 번호, 가격 그리고 극장 이름을 보여준다.
    - [x] 극장 이름이 길 경우 말줄임표로 표시되어야 한다.

- [x] 영화 예매 내역 페이지
    - [x] 예매한 영화들의 목록을 확인할 수 있다.
    - [x] 예매 내역 클릭 시 예매 완료(예매 정보) 화면으로 이동한다.

- [x] 설정 페이지
    - [x] 알림을 받을지의 여부를 설정할 수 있다.
    - [x] 알림을 받지 않겠다고 하면, 30분 전 알림을 받지 않는다.
    - [x] 알림 클릭 시, 영화 예매 완료 화면으로 이동한다.

---
### domain ⚒️
- [x] 기본/최소 예약 인원은 1명이다.
- [x] 최대 예약 인원은 50명이다.
- [x] 영화 티켓 가격
    - [x] S등급은 15,000이다.
    - [x] A등급은 12,000이다.
    - [x] B등급은 10,000이다.
