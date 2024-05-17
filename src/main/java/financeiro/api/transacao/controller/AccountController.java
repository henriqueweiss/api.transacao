package financeiro.api.transacao.controller;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.dto.UpdateAccountDto;
import financeiro.api.transacao.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid CreateAccountDto account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "id", required = false) String id) {
        if (id == null || id.isEmpty()) {
            var accounts = accountService.getAllAccount();
            return ResponseEntity.ok(accounts);
        }

        var account = accountService.getById(id);
        return ResponseEntity.ok(account);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam("id") String id){
        var result = accountService.deleteByIdAccount(id);
        return ResponseEntity.ok(id + " " + result);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") String id, @RequestBody @Valid UpdateAccountDto account){
        var result = accountService.updateAccount(id, account);
        return ResponseEntity.ok(result);
    }
}
