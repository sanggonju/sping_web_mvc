package me.goOn;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
//        /context.refresh();

//        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app =
                servletContext.addServlet("app", new DispatcherServlet(context));
        app.addMapping("/app/*");

    }

}

//web.xml을 사용하지 않고 WebApplicationInitializer을 이용해서 dispatcherServlet을 등록하는 방법
