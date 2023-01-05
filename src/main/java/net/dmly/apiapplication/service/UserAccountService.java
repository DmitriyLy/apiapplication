package net.dmly.apiapplication.service;

import net.dmly.apiapplication.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount createAccount(UserAccount userAccount);

    UserAccount findByUsername(String username);

    List<UserAccount> getAccounts();

}
