// 외부 자바스크립트 파일에서 타임리프 값을 사용하려면
// HTML의 <script> 태그 속성에 th:inline="javascript"와 th:src를 함께 선언하고,
// JS 파일 내부에서는 /*[[ ${변수} ]]*/ 주석 문법을 활용해야 한다.
// -> 변수를 받을 때 타임리프 주석(/*[[ ... ]]*/)과 기본값을 함께 작성
// --> 이렇게 해야 타임리프가 없는 일반 환경에서 JS 파일을 열었을 때 구문 오류가 없다고 함.

// 참고
// https://maenco.tistory.com/entry/Thymeleaf-JavaScript-Inlining-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8
// https://velog.io/@tilkoas35/JavaScript%EC%97%90%EC%84%9C-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
// https://kloong.tistory.com/entry/Spring-Boot-Thymeleaf-14-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8Javascript-Inline
