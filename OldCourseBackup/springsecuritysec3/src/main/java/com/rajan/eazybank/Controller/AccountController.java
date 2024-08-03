package com.rajan.eazybank.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "Here are teh account details from the DB";
    }
}
