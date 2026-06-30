package com.project.sf.common.interceptor;

import com.project.sf.admin.operator.model.Admin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

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
    String adminRole = admin.getRole();

    // 권한이 없는 관리자라면? -> 안내 페이지로 이동
    if (adminRole == null || adminRole.isBlank() || !admin.isActive()) {
      response.sendRedirect("/no_permission");
      return false;
    }

    // 최고 관리자는 무조건 통과
    if (adminRole.contains("ROLE_SUPER")) {
      return true;
    }

    // 각 대시보드 메뉴별 접근 권한 체크

    // 운영자 관리 - 최고관리자가 아니면 접근 불가
    if (requestURI.startsWith("/admins/management/operator")) {
      response.sendError(403);
      return false;
    }

    // 예약 관리
    if (requestURI.startsWith("/admins/management/reserve")) {
      if (!adminRole.contains("ROLE_RESERVE")) {
        response.sendError(403); // 권한 없으면 403 에러 유도
        return false;
      }
    }

    // 문의 관리
    if (requestURI.startsWith("/admins/management/inquiry")) {
      if (!adminRole.contains("ROLE_INQUIRY")) {
        response.sendError(403);
        return false;
      }
    }

    // 블랙리스트 관리
    if (requestURI.startsWith("/admins/management/blacklist")) {
      if (!adminRole.contains("ROLE_BLACKLIST")) {
        response.sendError(403);
        return false;
      }
    }

    //

    // 모든 if문을 통과하면? -> 최고 관리자이므로 true를 반환
    return true;
  }

}
