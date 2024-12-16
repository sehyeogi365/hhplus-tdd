package io.hhplus.tdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    //포인트 조회
    @GetMapping("/select/view")
    public String select(){
        return "point/select";
    }

    //포인트 충전/이용 내역 조회
    @GetMapping("/histories/view")
    public String histories(){
        return "point/histories";
    }

    //포인트 충전
    @GetMapping("/charge/view")
    public String chargePage(){
        return "point/charge";
    }

    //구매
    @GetMapping("/buy/view")
    public String buyPage(){
        return "point/buy";
    }


}
