package com.lab2;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/lab2/welcome.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("i am in LoginFilter--doFilter()-- request before chain");
        if(httpRequest.getSession(false)==null) {
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/lab2/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
