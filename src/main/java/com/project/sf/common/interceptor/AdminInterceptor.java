package com.project.sf.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import com.project.sf.admin.Admin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    // 세션에 로그인한 관리자가 있는지 먼저 판별
    HttpSession session = request.getSession();
    Admin admin = (Admin) session.getAttribute("logined_admin");

    // 관리자가 아닌 일반 사용자라면?
    if (admin == null) {
      // 브라우저에게 403 오류를 보냄 -> 타임리프에서 error/403.html 을 띄우게 전달
      response.sendError(403);
      return false;
    }

    // 참고
    // https://somnote.tistory.com/103
    // https://nuvgw2810.tistory.com/394
    // https://hwivelop.tistory.com/104

    // 사용자가 접근하려는 URL 주소 가져오기
    String requestURI = request.getRequestURI();

    // 최고 관리자만 접근할 수 있는 경로
    if (requestURI.startsWith("/admins/management/operator")) {
      // 일반 관리자라면 접근 불가 -> 403 오류 페이지
      // 타임리프 쪽에서 로그인한 관리자라면 관리자 대시보드 페이지로 이동
      if (admin.getRole().equals("BASIC")) {
        response.sendError(403);
        return false;
      }
    }

    // 모든 if문을 통과하면? -> 최고 관리자이므로 true를 반환
    return true;
  }

}
