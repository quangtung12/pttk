package com.example.sbtickets.authentication.service;

public interface AccountIn {
    public void register(String username, String password, String phoneNum, String mail, String discriminator);
    public boolean checkAccount(String username, String password);
}
