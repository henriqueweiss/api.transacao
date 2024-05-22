package financeiro.api.transacao.controller;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.dto.UpdateAccountDto;
import financeiro.api.transacao.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<HashMap<String, String>> create(@RequestBody @Valid CreateAccountDto account) {
        HashMap<String, String> response = new HashMap<>();
        var accountId = accountService.createAccount(account);
        response.put("id", accountId);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "id", required = false) String id) {
        if (id == null || id.isEmpty()) {
            var accounts = accountService.getAllAccount();
            return ResponseEntity.ok(accounts);
        }
        var account = accountService.getById(id);
        return ResponseEntity.status(200).body(account);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam("id") String id){
        int statusCode = accountService.deleteByIdAccount(id) ? 204 : 404;
        return ResponseEntity.status(statusCode).build();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") String id, @RequestBody @Valid UpdateAccountDto account){
        int statusCode = accountService.updateAccount(id, account) ? 201 : 404;
        return ResponseEntity.status(statusCode).build();
    }
}
