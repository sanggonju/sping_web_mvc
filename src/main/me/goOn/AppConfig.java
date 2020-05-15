package me.goOn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
/*@ComponentScan(excludeFilters = @ComponentScan.Filter(Controller.class)) // Controller는 Bean으로 등록하지 않게 설정.*/
public class AppConfig {
}
