package com.liveamonth.liveamonth.intercepter;

import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SuppressWarnings("deprecation")
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);

        if(session != null) {
            return true;
        }else {
            ((ServletResponse) request).setContentType("text/html;charset=utf-8"); // 어떤 타입으로 출력할것인지 명시하였다.
            PrintWriter out= ((ServletResponse) request).getWriter(); //getWriter() 출력스트림. 응답할 정보를 갖고 있는 객체에 출력스트림을 써서 out 객체에 담았다.
            out.println("alert('세션 만료');");
            out.close();
            response.sendRedirect("main");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
                                               Object handler) throws Exception {
    }

}
