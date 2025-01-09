package io.hhplus.tdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

    //포인트 조회
    @GetMapping("/select")
    public String select(){
        return "point/select";
    }

    //포인트 충전/이용 내역 조회
    @GetMapping("/histories")
    public String histories(){
        return "point/histories";
    }

    //포인트 충전
    @GetMapping("/charge")
    public String chargePage(){
        return "point/charge";
    }

    //구매
    @GetMapping("/buy")
    public String buyPage(){
        return "point/buy";
    }

    //로그인
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    //회원가입
    @GetMapping("/join")
    public String joinPage(){
        return "join";
    }


}
