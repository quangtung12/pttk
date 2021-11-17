package com.example.sbtickets.authentication.controller;

import com.example.sbtickets.authentication.entity.User;
import com.example.sbtickets.authentication.service.AccountService;
import com.example.sbtickets.bean.AccountBean;
import com.example.sbtickets.bean.AuthenticationBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = UrlConst.REGISTER_CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<WrapperResponse> register(@RequestBody AccountBean account){
        WrapperResponse response = new WrapperResponse();
        try {
            accountService.register(account.getUsername(), account.getPassword(), account.getCustomerPhone(), account.getMail(), account.getDiscriminator());
            response.setMsg("Created account successfully");
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setMsg("Cannot create new account");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.LOGIN_CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<AuthenticationBean> login(HttpServletRequest request, @RequestBody AccountBean account) {
        AuthenticationBean result = new AuthenticationBean();
        try {
            if(accountService.checkAccount(account.getUsername(), account.getPassword())){
                result.setToken("auth_token");
                result.setStatus(HttpStatus.OK.value());
            } else{
                result.setMessage("Your username and/or password incorrect");
                result.setStatus(HttpStatus.BAD_REQUEST.value());
            }
        } catch (Exception ex) {
            result.setMessage(ex.getMessage());
            result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<AuthenticationBean>(result, HttpStatus.OK);
    }
}
