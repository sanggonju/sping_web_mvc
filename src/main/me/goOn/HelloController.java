package me.goOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * /hello/1?name=keesun&age=25
     * @return
     */

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
    //public String hello(@PathVariable int id, @ModelAttribute User){

        return "Hello," + helloService.getName();
    }
}
