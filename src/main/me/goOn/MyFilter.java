package me.goOn;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Filter Init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter");
        //FilterChain filterChain 반드시 다음 필터로 연결 시켜줘야하고 마지막 필터인 경우에는
        //servlet으로 연결될것

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter Destroy");
    }
}
/*
Connected to server
Filter Init
init
Filter
doGet
destroy
Filter Destroy
contextDestroyed
Disconnected from server


 */