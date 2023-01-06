package net.dmly.apiapplication.controller;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.UserAccount;
import net.dmly.apiapplication.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.dmly.apiapplication.utils.ControllerUtils.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount newUserAccount = userAccountService.createAccount(userAccount);
        return ResponseEntity.created(getLocation(newUserAccount.getId())).body(newUserAccount);
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getUserAccounts() {
        return ResponseEntity.ok(userAccountService.getAccounts());
    }
}
