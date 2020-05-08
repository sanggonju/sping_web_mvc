package me.goOn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
        sce.getServletContext().setAttribute("name","sangGon");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}

/*
ServeltContext의 LifeCycle을 감지할 수있는 interface를 구현 중
 web.xml에 등록하면 된다.
 */