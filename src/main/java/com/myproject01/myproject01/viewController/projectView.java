package com.myproject01.myproject01.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class projectView {

    @RequestMapping("/home")
    public String HomePgae(){
        return "myhome";
    }

    @RequestMapping("/shop")
    public String Shop(){
        return "shop";
    }


    @RequestMapping("/admin")
    public String Admin(){
        return "AdminPage";
    }

    @RequestMapping("/about")
    public String About(){
        return "about";
    }

    @RequestMapping("contact")
    public String Contact(){
        return "contact";
    }

}
