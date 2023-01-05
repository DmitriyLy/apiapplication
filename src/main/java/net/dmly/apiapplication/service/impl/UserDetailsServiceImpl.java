package net.dmly.apiapplication.service.impl;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.UserAccount;
import net.dmly.apiapplication.service.UserAccountService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountService.findByUsername(username);

        if (userAccount == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        if (CollectionUtils.isEmpty(userAccount.getRoles())) {
            throw new RuntimeException("User has no roles");
        }

        Collection<GrantedAuthority> authorities = userAccount.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.isEnabled(),
                !userAccount.isExpired(),
                !userAccount.isCredentialExpired(),
                !userAccount.isLocked(),
                authorities
        );
    }
}
