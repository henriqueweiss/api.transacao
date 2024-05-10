package financeiro.api.transacao.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @GetMapping
    public ResponseEntity<String> GetAccount() {
        return ResponseEntity.ok("account");
    }
}
