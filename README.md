# hansung-university

한성대학교 수업 실습 모음입니다. 학기와 과목별로 폴더를 나눴습니다. 폴더 이름 앞의 `24-1`은 2024년 1학기를 뜻합니다.

| 폴더 | 학기 | 과목 | 내용 |
|---|---|---|---|
| [`24-1-programming-c`](24-1-programming-c) | 24-1 | 컴퓨터프로그래밍 | C 실습 코드 |
| [`26-2-webdev-js`](26-2-webdev-js) | 26-2 | 웹프로그래밍 | 주차별 HTML·CSS·JavaScript 실습 (DOM, 이벤트, 캔버스, 웹 스토리지, Map) |
| [`26-2-bigdata-py`](26-2-bigdata-py) | 26-2 | 빅데이터기초 | Python 실습 노트북 1~4, pandas |
| [`26-2-datacomm-py`](26-2-datacomm-py) | 26-2 | 데이터통신 | Python 소켓 TCP·UDP 클라이언트/서버 |
| [`26-2-oop-java`](26-2-oop-java) | 26-2 | 객체지향언어 | Java 실습 (명품자바 3~12장 예제, 과제) |

## 웹프로그래밍 폴더 구조

```
26-2-webdev-js/
├─ tree.jpg          여러 주차가 같이 쓰는 이미지
├─ 1-html/           HTML·CSS 기초
├─ 2-jsbasic/        JavaScript 기초 (카운터, 반복문, 계산)
├─ 3-function/       함수·객체 (시계, 식물 키우기)
├─ 4-dom/            DOM 선택·생성·삭제
├─ 5-events/         마우스 휠, 키보드 이벤트
├─ 6-canvas/         캔버스 그리기, 타이머
├─ 7-webstorage/     쿠키, localStorage, Web Worker
├─ 9-map/            DOM 탐색, Map 객체
├─ 10-server/        Node.js 서버 (http, Express)
└─ 11-router/        Express 라우팅 (query, params, body)
```

HTML 파일을 브라우저로 열면 바로 확인할 수 있습니다. `10-server`와 `11-router`는 해당 폴더에서 `npm install` 후 `node server.js`, `node user.js`(또는 `node board.js`)로 실행합니다. 과제 제출용 PDF(`26-2-webdev-js/pdf/`)는 올리지 않습니다.

## 객체지향언어 폴더 구조

```
26-2-oop-java/
├─ src/
│  ├─ ch03_looparray/    반복문, 배열, 예외 처리
│  ├─ ch04_class/        클래스와 객체, static
│  ├─ ch05_inheritance/  상속
│  ├─ ch06_package/      Math, StringBuffer, StringTokenizer
│  ├─ ch07_collection/   컬렉션, 제네릭
│  ├─ ch08_io/           파일 입출력
│  ├─ ch09_gui/          스윙 프레임, 배치관리자
│  ├─ ch10_event/        마우스·키 이벤트
│  ├─ ch11_component/    스윙 컴포넌트
│  ├─ ch12_graphics/     그래픽
│  └─ report/            과제 (Report6: 공학용 계산기, Hangman 등)
├─ data/                 ch08 예제가 읽고 쓰는 파일
└─ images/               ch11 예제 이미지
```

Eclipse에서 File → Import → Existing Projects into Workspace로 이 폴더를 불러온 뒤, 파일을 우클릭해 Run As → Java Application으로 실행합니다. 예제가 `data/`, `images/`를 상대경로로 읽기 때문에 프로젝트 폴더에서 실행해야 합니다. 빌드 결과물(`bin/`)과 교수님 배포 실행 파일(`data/*.class`)은 올리지 않습니다.

## 원래 저장소

`24-1-programming-c`는 `hsu-programming-c` 저장소를 커밋 기록 그대로 옮겨 왔습니다.
