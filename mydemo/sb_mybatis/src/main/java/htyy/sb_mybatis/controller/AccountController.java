package htyy.sb_mybatis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htyy.sb_mybatis.domain.Account;
import htyy.sb_mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public String findbyid(@PathVariable("id") Integer id){
        System.out.println(id);
        Account account = accountService.findAccountByid(id);
        System.out.println(account);
        return account.toString();
    }

    @GetMapping("/all_lazy")
    @ResponseBody
    public String findAllLazy() throws JsonProcessingException {
        List<Account> allLazy = accountService.findAllLazy();
        System.out.println(allLazy);
        ObjectMapper objectMapper = new ObjectMapper();
        String allJson = objectMapper.writeValueAsString(allLazy);
        System.out.println(allJson);
        return allJson;
    }

    @GetMapping("/all")
    @ResponseBody
    public String findAll() throws JsonProcessingException {
        List<Account> all = accountService.findAll();
        System.out.println(all);
        ObjectMapper objectMapper = new ObjectMapper();
        String allJson = objectMapper.writeValueAsString(all);
        System.out.println(allJson);
        return allJson;
    }



}
