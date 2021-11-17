package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountBean {
    private String username;
    private String password;
    private String customerPhone;
    private String mail;
    private String discriminator;

    public AccountBean() {
    }

    public AccountBean(String username, String password, String customerPhone, String mail, String discriminator) {
        this.username = username;
        this.password = password;
        this.customerPhone = customerPhone;
        this.mail = mail;
        this.discriminator = discriminator;
    }
}
