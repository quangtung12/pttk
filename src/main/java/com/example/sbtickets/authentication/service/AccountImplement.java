package com.example.sbtickets.authentication.service;

import com.example.sbtickets.authentication.entity.Account;
import com.example.sbtickets.authentication.entity.Customer;
import com.example.sbtickets.authentication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountImplement implements AccountDAO {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void register(String username, String password, String phoneNum, String mail, String discriminator) {
        accountRepository.save(new Account(username, password, new Customer(phoneNum, mail, discriminator)));
    }

    @Override
    public boolean checkAccount(String username, String password) {
        List<Account> listAccount = accountRepository.findAll();
        for(int i = 0; i < listAccount.size(); i++){
            Account curAcc = listAccount.get(i);
            if(curAcc.getUsername().equals(username) && curAcc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
