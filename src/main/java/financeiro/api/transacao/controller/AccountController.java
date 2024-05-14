package financeiro.api.transacao.controller;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountDto createAccount){
        accountService.createAccount(createAccount);
        return ResponseEntity.ok("ok");
    }
}
