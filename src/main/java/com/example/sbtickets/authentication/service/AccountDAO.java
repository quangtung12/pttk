package com.example.sbtickets.authentication.service;

public interface AccountDAO {
    public void register(String username, String password, String phoneNum, String mail, String discriminatorm);
    public boolean checkAccount(String username, String password);
}
