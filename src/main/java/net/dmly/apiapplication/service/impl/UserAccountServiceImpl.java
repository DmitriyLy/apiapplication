package net.dmly.apiapplication.service.impl;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.Role;
import net.dmly.apiapplication.model.UserAccount;
import net.dmly.apiapplication.repository.RoleRepository;
import net.dmly.apiapplication.repository.UserAccountRepository;
import net.dmly.apiapplication.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount createAccount(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        userAccount.setRoles(Set.of(role));
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public List<UserAccount> getAccounts() {
        return userAccountRepository.findAll();
    }
}
