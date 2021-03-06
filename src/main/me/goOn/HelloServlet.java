package me.goOn;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

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


        //이런식으로  써야한다면 ROOT구조로 만들겠지만 최근에는
        //모두 DispatcherServlet에 모든걸 처리한다.
        ApplicationContext context = (ApplicationContext)getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        HelloService helloService = context.getBean(HelloService.class);

        System.out.println("doGet");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        //resp.getWriter().write("<h1>Hello, "+getServletContext().getAttribute("name")+"</h1>");
        resp.getWriter().write("<h1>Hello, "+helloService.getName()+"</h1>");
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