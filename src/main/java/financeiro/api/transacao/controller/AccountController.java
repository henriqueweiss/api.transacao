package financeiro.api.transacao.controller;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.models.Account;
import financeiro.api.transacao.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody @Valid CreateAccountDto createAccount) {
        accountService.createAccount(createAccount);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        var accounts = accountService.getAll();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccountById(@RequestParam("id") String id){
        var result = accountService.deleteById(id);
        return ResponseEntity.ok(id + " " + result);
    }
}
