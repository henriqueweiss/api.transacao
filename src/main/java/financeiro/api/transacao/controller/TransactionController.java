package financeiro.api.transacao.controller;
import financeiro.api.transacao.dto.CreateTransactionDto;
import financeiro.api.transacao.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid CreateTransactionDto transaction) {
        int statusCode = transactionService.createTransaction(transaction) ? 201 : 400;
        return ResponseEntity.status(statusCode).build();
    }

}
