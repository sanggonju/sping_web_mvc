package me.goOn;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            IOException {
        System.out.println("doGet");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h1>Hello, "+getServletContext().getAttribute("name")+"</h1>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

/*
    init()은 최초 요청시에만 호출됨.(init-doget)
    2번째 부터는 doGet만 호출됨.
    서버종료시  destroy() 가 호출된다.

Connected to server
contextInitialized
init
doGet
destroy
contextDestroyed
Disconnected from server


*/